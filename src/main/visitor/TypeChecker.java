package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.statement.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.single.BoolType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrors.typeErrors.ConditionNotBool;
import main.compileErrors.typeErrors.UnsupportedTypeForPrint;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;

import java.util.Stack;

public class TypeChecker extends Visitor<Void> {
	public static Stack<FunctionDeclaration> funcDeclarations = new Stack<>();
	private final ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker(this);

	@Override
	public Void visit(Program program) {
		program.getMain().accept(this);
        program.getFunctions().forEach(functionDeclaration -> functionDeclaration.accept(this));
		return null;
	}

	@Override
	public Void visit(FunctionDeclaration funcDeclaration) {
		funcDeclarations.push(funcDeclaration);
		if (TypeInference.funcCalls.contains(funcDeclaration.getFunctionName().getName())) {
			printInfo(funcDeclaration);
			funcDeclaration.getArgs().forEach(identifier -> identifier.accept(expressionTypeChecker));
			funcDeclaration.getBody().accept(this);
		}
		funcDeclarations.pop();
		return null;
	}

	private static void printInfo(FunctionDeclaration funcDeclaration) {
		FunctionSymbolTableItem functionSymbolTableItem;
		try {
			functionSymbolTableItem = ((FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDeclaration.getFunctionName().getName()));
			System.out.println(funcDeclaration.getFunctionName().getName());
			System.out.println(functionSymbolTableItem.getArgTypes());
			System.out.println(functionSymbolTableItem.getReturnType());
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Void visit(MainDeclaration mainDeclaration) {
		mainDeclaration.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(BlockStmt blockStmt) {
		blockStmt.getStatements().forEach(statement -> statement.accept(this));
		return null;
	}

	@Override
	public Void visit(ConditionalStmt conditionalStmt) {
		Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);

		if (!(condType instanceof BoolType || condType instanceof NoType)) {
			ConditionNotBool error = new ConditionNotBool(conditionalStmt.getLine());
			conditionalStmt.addError(error);
		}
		conditionalStmt.getThenBody().accept(this);

		if(conditionalStmt.getElseBody() != null) {
			conditionalStmt.getElseBody().accept(this);
		}

		return null;
	}

	@Override
	public Void visit(FunctionCallStmt funcCallStmt) {
		funcCallStmt.getFunctionCall().setInFuncCallStmt(true);
		funcCallStmt.getFunctionCall().accept(expressionTypeChecker);
		funcCallStmt.getFunctionCall().setInFuncCallStmt(false);
		return null;
	}

	@Override
	public Void visit(PrintStmt print) {
		Type argType = print.getArg().accept(expressionTypeChecker);

		if(!(argType instanceof IntType || argType instanceof StringType || argType instanceof BoolType || argType instanceof NoType)) {
			UnsupportedTypeForPrint error = new UnsupportedTypeForPrint(print.getLine());
			print.addError(error);
		}

		return null;
	}

	@Override
	public Void visit(ReturnStmt returnStmt) {
		returnStmt.getReturnedExpr().accept(expressionTypeChecker);
		return null;
	}
}