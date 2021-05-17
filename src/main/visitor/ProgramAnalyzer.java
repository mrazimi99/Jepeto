package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.VoidValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.FunctionSymbolTableItem;

public class ProgramAnalyzer extends Visitor<Void> {
	private int numberOfErrors;

	public ProgramAnalyzer() {
		numberOfErrors = 0;
	}

	public int getNumberOfErrors() {
		return numberOfErrors;
	}

	@Override
	public Void visit(Program program) {
		SymbolTable.root = new SymbolTable();
		SymbolTable.push(SymbolTable.root);

		for (FunctionDeclaration functionDeclaration : program.getFunctions())
			functionDeclaration.accept(this);

		program.getMain().accept(this);
		return null;
	}

	@Override
	public Void visit(FunctionDeclaration functionDeclaration) {
		FunctionSymbolTableItem functionSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);

		try {
			SymbolTable.root.put(functionSymbolTableItem);
		} catch (ItemAlreadyExistsException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Void visit(MainDeclaration mainDeclaration) {
		return null;
	}

	@Override
	public Void visit(BlockStmt blockStmt) {
		return null;
	}

	@Override
	public Void visit(ConditionalStmt conditionalStmt) {
		return null;
	}

	@Override
	public Void visit(FunctionCallStmt methodCallStmt) {
		return null;
	}

	@Override
	public Void visit(PrintStmt print) {
		return null;
	}

	@Override
	public Void visit(ReturnStmt returnStmt) {
		return null;
	}

	@Override
	public Void visit(BinaryExpression binaryExpression) {
		return null;
	}

	@Override
	public Void visit(UnaryExpression unaryExpression) {
		return null;
	}

	@Override
	public Void visit(Identifier identifier) {
		return null;
	}

	@Override
	public Void visit(ListAccessByIndex listAccessByIndex) {
		return null;
	}

	@Override
	public Void visit(FunctionCall methodCall) {
		return null;
	}

	@Override
	public Void visit(AnonymousFunction anonymousFunction) {
		return null;
	}

	@Override
	public Void visit(ListValue listValue) {
		return null;
	}

	@Override
	public Void visit(IntValue intValue) {
		return null;
	}

	@Override
	public Void visit(BoolValue boolValue) {
		return null;
	}

	@Override
	public Void visit(StringValue stringValue) {
		return null;
	}

	@Override
	public Void visit(VoidValue voidValue) {
		return null;
	}

	@Override
	public Void visit(ListSize listSize) {
		return null;
	}
}
