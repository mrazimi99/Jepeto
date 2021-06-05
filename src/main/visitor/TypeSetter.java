package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.FunctionCall;
import main.ast.nodes.statement.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.functionPointer.FptrType;
import main.compileErrors.typeErrors.ReturnValueNotMatchFunctionReturnType;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static main.visitor.Utility.isFirstSubTypeOfSecond;

public class TypeSetter extends Visitor<Void> {
    public static Stack<FunctionDeclaration> funcDeclarations = new Stack<>();
    public static Map<String, String> retDependency = new HashMap<>();
    private final TypeInference typeInference = new TypeInference(this);

    private static void setMissedTypes() {
        for (Map.Entry pair : retDependency.entrySet()) {
            try {
                FunctionSymbolTableItem missed = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + pair.getKey());
                FunctionSymbolTableItem found = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + pair.getValue());

                if (found.getReturnType() == null)
                    found.setReturnType(new NoType());

                missed.setReturnType(found.getReturnType());
            } catch (ItemNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        setMissedTypes();
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
            if (functionSymbolTableItem.getReturnType() == null || functionSymbolTableItem.getReturnType() instanceof NoType) {
                functionSymbolTableItem.setReturnType(type);
                if (type == null && returnStmt.getReturnedExpr() instanceof FunctionCall) {
                    Type funcType = ((FunctionCall) returnStmt.getReturnedExpr()).getInstance().accept(typeInference);
                    if (funcType instanceof FptrType)
                        retDependency.put(functionSymbolTableItem.getName(), ((FptrType) funcType).getFunctionName());
                }
            }
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
