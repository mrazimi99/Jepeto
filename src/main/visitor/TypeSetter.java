package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.single.BoolType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrors.typeErrors.ConditionNotBool;
import main.compileErrors.typeErrors.ReturnValueNotMatchFunctionReturnType;
import main.compileErrors.typeErrors.UnsupportedTypeForPrint;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;
import java.util.*;

public class TypeSetter  extends Visitor<Void> {
    public static FunctionDeclaration lastFuncDeclaration;
    private final TypeInference typeInference = new TypeInference();

    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        program.getFunctions().forEach(functionDeclaration -> functionDeclaration.accept(this));
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration funcDeclaration) {
        lastFuncDeclaration = funcDeclaration;
        funcDeclaration.getArgs().forEach(identifier -> identifier.accept(typeInference));
        funcDeclaration.getBody().accept(this);
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
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);

        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        funcCallStmt.getFunctionCall().accept(typeInference);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(typeInference);

        if(!(argType instanceof IntType || argType instanceof StringType || argType instanceof BoolType || argType instanceof NoType)) {
            UnsupportedTypeForPrint error = new UnsupportedTypeForPrint(print.getLine());
            print.addError(error);
        }

        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        try {
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + lastFuncDeclaration.getFunctionName().getName());
            functionSymbolTableItem.setReturnType(returnStmt.getReturnedExpr().accept(typeInference));
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
