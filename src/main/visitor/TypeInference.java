package main.visitor;

import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.types.*;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListType;
import main.ast.types.single.*;
import main.compileErrors.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import java.util.*;

public class TypeInference extends Visitor<Type> {
	@Override
	public Type visit(BinaryExpression binaryExpression) {
		Expression left = binaryExpression.getFirstOperand();
		Expression right = binaryExpression.getSecondOperand();

		Type tl = left.accept(this);
		Type tr = right.accept(this);
		BinaryOperator operator =  binaryExpression.getBinaryOperator();

		if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or)) {
			if (tl instanceof BoolType && tr instanceof BoolType)
				return new BoolType();

			if ((tl instanceof NoType || tl instanceof BoolType) && (tr instanceof BoolType || tr instanceof NoType))
				return new NoType();
		}
		else if (operator.equals(BinaryOperator.add) || operator.equals(BinaryOperator.sub) || operator.equals(BinaryOperator.mult) || operator.equals(BinaryOperator.div) || operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)) {
			if (tl instanceof IntType && tr instanceof IntType)
				return new IntType();

			if ((tl instanceof NoType || tl instanceof IntType) && (tr instanceof IntType || tr instanceof NoType))
				return new NoType();
		}
		else if (operator.equals(BinaryOperator.eq) || operator.equals(BinaryOperator.neq)) {
			if (!(tl instanceof ListType || tr instanceof ListType)) {

				if (tl instanceof NoType || tr instanceof NoType)
					return new NoType();

				if (tl.getClass().equals(tr.getClass()))
					return new BoolType();

				if ((tl instanceof FptrType && tr instanceof VoidType) || (tl instanceof VoidType && tr instanceof FptrType))
					return new BoolType();
			}
		}
		else if (operator.equals(BinaryOperator.append)) {
			if (tl instanceof ListType) {
				if (tr instanceof NoType)
					return new NoType();

				if (tr.getClass().equals(((ListType)tl).getType()))
					return new ListType(((ListType)tl).getType());

				if (tr instanceof FptrType && tl instanceof VoidType)
					return new ListType(((ListType)tl).getType());
			}
			else if (tl instanceof NoType) {
				return new NoType();
			}
		}

		UnsupportedOperandType error = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
		binaryExpression.addError(error);
		return new NoType();
	}

	@Override
	public Type visit(UnaryExpression unaryExpression) {
		//TODO
		return null;
	}

	@Override
	public Type visit(AnonymousFunction anonymousFunction) {
		//TODO
		return null;
	}

	@Override
	public Type visit(Identifier identifier) {
		//TODO
		return null;
	}

	@Override
	public Type visit(ListAccessByIndex listAccessByIndex) {
		//TODO
		return null;
	}

	@Override
	public Type visit(ListSize listSize) {
		//TODO
		return null;
	}

	@Override
	public Type visit(FunctionCall funcCall) {
		//TODO
		return null;
	}

	@Override
	public Type visit(ListValue listValue) {
		//TODO
		return null;
	}

	@Override
	public Type visit(IntValue intValue) {
		//TODO
		return null;
	}

	@Override
	public Type visit(BoolValue boolValue) {
		//TODO
		return null;
	}

	@Override
	public Type visit(StringValue stringValue) {
		//TODO
		return null;
	}

	@Override
	public Type visit(VoidValue voidValue) {
		//TODO
		return null;
	}
}
