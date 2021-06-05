package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.FunctionCall;
import main.ast.nodes.statement.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.compileErrors.typeErrors.ReturnValueNotMatchFunctionReturnType;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.Stack;

import static main.visitor.Utility.isFirstSubTypeOfSecond;

public class TypeSetter extends Visitor<Void> {
    public static Stack<FunctionDeclaration> funcDeclarations = new Stack<>();
    private final TypeInference typeInference = new TypeInference(this);

    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration funcDeclaration) {
        funcDeclarations.push(funcDeclaration);
        funcDeclaration.getArgs().forEach(identifier -> identifier.accept(typeInference));
        funcDeclaration.getBody().accept(this);
        funcDeclarations.pop();
        return null;
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
        conditionalStmt.getCondition().accept(typeInference);
        conditionalStmt.getThenBody().accept(this);

        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        FunctionCall functionCall = funcCallStmt.getFunctionCall();
        functionCall.accept(typeInference);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        print.getArg().accept(typeInference);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        try {
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDeclarations.peek().getFunctionName().getName());

            Type type = returnStmt.getReturnedExpr().accept(typeInference);
            if (functionSymbolTableItem.getReturnType() == null || functionSymbolTableItem.getReturnType() instanceof NoType) // todo is notype
                functionSymbolTableItem.setReturnType(type);
            else if (!isFirstSubTypeOfSecond(type, functionSymbolTableItem.getReturnType())) {
                ReturnValueNotMatchFunctionReturnType error = new ReturnValueNotMatchFunctionReturnType(returnStmt.getLine());
                returnStmt.addError(error);
            }
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
