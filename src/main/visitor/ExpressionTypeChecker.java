package main.visitor;

import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.VoidValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
import main.ast.types.*;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListType;
import main.ast.types.single.BoolType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrors.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.stream.Collectors;

import static main.visitor.Utility.isFirstSubTypeOfSecond;
import static main.visitor.Utility.areFirstsSubTypeOfSeconds;

public class ExpressionTypeChecker extends Visitor<Type> {
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
		else if (operator.equals(BinaryOperator.add) || operator.equals(BinaryOperator.sub) || operator.equals(BinaryOperator.mult) || operator.equals(BinaryOperator.div)) {
			if (tl instanceof IntType && tr instanceof IntType)
				return new IntType();

			if ((tl instanceof NoType || tl instanceof IntType) && (tr instanceof NoType || tr instanceof IntType))
				return new NoType();
		}
		else if (operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)) {
			if (tl instanceof IntType && tr instanceof IntType)
				return new BoolType();

			if ((tl instanceof NoType || tl instanceof IntType) && (tr instanceof NoType || tr instanceof IntType))
				return new NoType();
		}
		else if (operator.equals(BinaryOperator.eq) || operator.equals(BinaryOperator.neq)) {
			if (!(tl instanceof ListType || tr instanceof ListType)) {

				if (tl instanceof NoType || tr instanceof NoType)
					return new NoType();

				if (isFirstSubTypeOfSecond(tl, tr) && isFirstSubTypeOfSecond(tr, tl))
					return new BoolType();

				if ((tl instanceof FptrType && tr instanceof VoidType) || (tl instanceof VoidType && tr instanceof FptrType))
					return new BoolType();
			}
		}
		else if (operator.equals(BinaryOperator.append)) {
			if (tl instanceof ListType) {
				if (tr instanceof NoType)
					return tl;

				ListType listType = (ListType) tl;
				if (listType.getType() instanceof NoType)
					listType.setType(tr);

				if (isFirstSubTypeOfSecond(tr, listType.getType()) || isFirstSubTypeOfSecond(listType.getType(), tr))
					return new ListType(listType.getType());
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
		Expression left = unaryExpression.getOperand();

		Type type = left.accept(this);
		UnaryOperator operator =  unaryExpression.getOperator();

		if (operator.equals(UnaryOperator.not)) {
			if (type instanceof BoolType)
				return new BoolType();

			if (type instanceof NoType)
				return new NoType();
		}
		else if (operator.equals(UnaryOperator.minus)) {
			if (type instanceof IntType)
				return new IntType();

			if (type instanceof NoType)
				return new NoType();
		}

		UnsupportedOperandType error = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
		unaryExpression.addError(error);
		return new NoType();
	}

	@Override
	public Type visit(AnonymousFunction anonymousFunction) {
		anonymousFunction.getArgs().forEach(identifier -> identifier.accept(this));
		anonymousFunction.getBody().accept(this);
		return new FptrType(anonymousFunction.getName());
	}

	@Override
	public Type visit(Identifier identifier) {
		FunctionDeclaration currentFunctionDeclaration;
		try {
			try {
				currentFunctionDeclaration = TypeChecker.funcDeclarations.peek();
			} catch (EmptyStackException e) {
				throw new ItemNotFoundException();
			}

			FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + currentFunctionDeclaration.getFunctionName().getName());
			VariableSymbolTableItem variableSymbolTableItem = (VariableSymbolTableItem) functionSymbolTableItem.getFunctionSymbolTable().getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			int thisIdIndex = -1;
			ArrayList<Identifier> args = currentFunctionDeclaration.getArgs();

			for (int i = 0; i < args.size(); i++) {
				if (args.get(i).getName().equals(variableSymbolTableItem.getName())) {
					thisIdIndex = i;
					break;
				}
			}

			variableSymbolTableItem.setType(functionSymbolTableItem.getArgTypes().get(thisIdIndex));
			return variableSymbolTableItem.getType();
		} catch (ItemNotFoundException e) {
			return new FptrType(identifier.getName());
		}
	}

	@Override
	public Type visit(ListAccessByIndex listAccessByIndex) {
		Type instanceType = listAccessByIndex.getInstance().accept(this);
		Type indexType = listAccessByIndex.getIndex().accept(this);
		if (instanceType instanceof ListType || instanceType instanceof NoType) {
			if (indexType instanceof IntType) {
				return ((ListType)instanceType).getType();
			}
			else if (!(indexType instanceof NoType)) {
				ListIndexNotInt error = new ListIndexNotInt(listAccessByIndex.getLine());
				listAccessByIndex.addError(error);
			}
		}
		else {
			ListAccessByIndexOnNoneList error = new ListAccessByIndexOnNoneList(listAccessByIndex.getLine());
			listAccessByIndex.addError(error);
		}

		return new NoType();
	}

	@Override
	public Type visit(ListSize listSize) {
		Type instanceType = listSize.getInstance().accept(this);
		if (instanceType instanceof ListType) {
			return new IntType();
		}
		else if(!(instanceType instanceof NoType)) {
			GetSizeOfNoneList error = new GetSizeOfNoneList(listSize.getLine());
			listSize.addError(error);
		}

		return new NoType();
	}

	@Override
	public Type visit(FunctionCall funcCall) {
		Type instanceType = funcCall.getInstance().accept(this);

		if (instanceType instanceof NoType)
			return new NoType();

		String funcName;
		if (instanceType instanceof FptrType) {
			funcName = ((FptrType) instanceType).getFunctionName();
		}
		else {
			CallOnNoneFptrType error = new CallOnNoneFptrType(funcCall.getLine());
			funcCall.addError(error);
			return new NoType();
		}

		FunctionSymbolTableItem functionSymbolTableItem;
		try {
			functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcName);
			boolean typesMatch = true;

			if (!funcCall.getArgs().isEmpty())
				typesMatch &= areFirstsSubTypeOfSeconds(funcCall.getArgs().stream().map(expression -> expression.accept(this)).collect(Collectors.toCollection(ArrayList::new)), functionSymbolTableItem.getArgTypes());
			else if (!funcCall.getArgsWithKey().isEmpty())
				typesMatch &= areFirstsSubTypeOfSeconds(functionSymbolTableItem.getFuncDeclaration().getArgs().stream().map(identifier -> funcCall.getArgsWithKey().get(identifier).accept(this)).collect(Collectors.toCollection(ArrayList::new)), functionSymbolTableItem.getArgTypes());

			if ((funcCall.getArgs().isEmpty() && funcCall.getArgsWithKey().isEmpty() && !functionSymbolTableItem.getFuncDeclaration().getArgs().isEmpty())
					|| ((!funcCall.getArgs().isEmpty() || !funcCall.getArgsWithKey().isEmpty()) && functionSymbolTableItem.getFuncDeclaration().getArgs().isEmpty())
					|| !typesMatch) {
				FunctionCallNotMatchDefinition error = new FunctionCallNotMatchDefinition(funcCall.getLine());
				funcCall.addError(error);
				return new NoType();
			}

			if (!funcCall.isInFuncCallStmt() && functionSymbolTableItem.getReturnType() instanceof VoidType) {
				CantUseValueOfVoidFunction error = new CantUseValueOfVoidFunction(funcCall.getLine());
				funcCall.addError(error);
				return new NoType();
			}

			return functionSymbolTableItem.getReturnType();
		} catch (ItemNotFoundException e) {
			// Unreachable.
			e.printStackTrace();
		}

		return new NoType();
	}

	@Override
	public Type visit(ListValue listValue) {
		ArrayList<Expression> elements = listValue.getElements();

		if (elements.isEmpty())
			return new ListType(new NoType());

		Type firstType = new NoType();

		for (int i = 0; i < elements.size(); i++) {
			Type elementType = elements.get(i).accept(this);

			if (firstType instanceof NoType && !(elementType instanceof NoType)) {
				firstType = elementType;
				continue;
			}
			else if (elementType instanceof NoType) {
				continue;
			}

			if (!(isFirstSubTypeOfSecond(firstType, elementType) && isFirstSubTypeOfSecond(elementType, firstType))) {
				ListElementsTypeNotMatch error = new ListElementsTypeNotMatch(listValue.getLine());
				listValue.addError(error);
				return new NoType();
			}
		}

		return new ListType(firstType);
	}

	@Override
	public Type visit(IntValue intValue) {
		return new IntType();
	}

	@Override
	public Type visit(BoolValue boolValue) {
		return new BoolType();
	}

	@Override
	public Type visit(StringValue stringValue) {
		return new StringType();
	}

	@Override
	public Type visit(VoidValue voidValue) {
		return new VoidType();
	}
}