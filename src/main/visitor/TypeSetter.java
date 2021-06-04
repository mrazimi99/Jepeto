package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.statement.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.Stack;

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
        print.getArg().accept(typeInference);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        try {
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDeclarations.peek().getFunctionName().getName());

            if (functionSymbolTableItem.getReturnType() == null)
                functionSymbolTableItem.setReturnType(returnStmt.getReturnedExpr().accept(typeInference));
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
