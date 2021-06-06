package main.visitor;

import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.types.*;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListType;
import main.ast.types.single.*;
import main.compileErrors.typeErrors.CantUseValueOfVoidFunction;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import java.util.*;
import java.util.stream.Collectors;

import static main.visitor.Utility.isFirstSubTypeOfSecond;
import static main.visitor.Utility.areFirstsSubTypeOfSeconds;

public class TypeInference extends Visitor<Type> {
	public static ArrayList<String> funcCalls = new ArrayList<>();
	private final TypeSetter typeSetter;

	public TypeInference(TypeSetter typeSetter) {
		this.typeSetter = typeSetter;
	}

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

		return new NoType();
	}

	@Override
	public Type visit(AnonymousFunction anonymousFunction) {
		return new FptrType(anonymousFunction.getName());
	}

	@Override
	public Type visit(Identifier identifier) {
		FunctionDeclaration currentFunctionDeclaration;
		try {
			try {
				currentFunctionDeclaration = TypeSetter.funcDeclarations.peek();
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
		if (instanceType instanceof ListType) {
			if (indexType instanceof IntType) {
				return ((ListType)instanceType).getType();
			}
		}

		return new NoType();
	}

	@Override
	public Type visit(ListSize listSize) {
		Type instanceType = listSize.getInstance().accept(this);
		if (instanceType instanceof ListType) {
			return new IntType();
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
			funcCalls.add(funcName);
		}
		else {
			return new NoType();
		}

		FunctionSymbolTableItem functionSymbolTableItem;
		try {
			functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcName);
			boolean typesMatch = true;
			boolean cancel = false;

			if (!functionSymbolTableItem.getTypeSet()) {
				ArrayList<Identifier> mainArgs = functionSymbolTableItem.getFuncDeclaration().getArgs();

				if (!funcCall.getArgs().isEmpty()) {
					for (int i = 0; i < mainArgs.size(); i++) {
						if (i < funcCall.getArgs().size()) {
							Type argType = funcCall.getArgs().get(i).accept(this);

							if (functionSymbolTableItem.getTypeSet()) {
								cancel = true;
								break;
							}
							functionSymbolTableItem.addArgType(argType);
						}
						else {
							functionSymbolTableItem.addArgType(new NoType());
							typesMatch = false;
						}
					}

					typesMatch &= funcCall.getArgs().size() == functionSymbolTableItem.getFuncDeclaration().getArgs().size();
				}
				else if (!funcCall.getArgsWithKey().isEmpty()) {
					for (Identifier identifier : mainArgs) {
						if (funcCall.getArgsWithKey().containsKey(identifier)) {
							Type argType = funcCall.getArgsWithKey().get(identifier).accept(this);

							if (functionSymbolTableItem.getTypeSet()) {
								cancel = true;
								break;
							}

							functionSymbolTableItem.addArgType(argType);
						}
						else {
							functionSymbolTableItem.addArgType(new NoType());
							typesMatch = false;
						}
					}

					typesMatch &= funcCall.getArgsWithKey().size() == functionSymbolTableItem.getFuncDeclaration().getArgs().size();
				}

				if (!cancel) {
					functionSymbolTableItem.setTypeSet();
					functionSymbolTableItem.getFuncDeclaration().accept(typeSetter);
				}
			}
			else {
				if (!funcCall.getArgs().isEmpty())
					typesMatch &= areFirstsSubTypeOfSeconds(funcCall.getArgs().stream().map(expression -> expression.accept(this)).collect(Collectors.toCollection(ArrayList::new)), functionSymbolTableItem.getArgTypes());
				else if (!funcCall.getArgsWithKey().isEmpty())
					typesMatch &= areFirstsSubTypeOfSeconds(functionSymbolTableItem.getFuncDeclaration().getArgs().stream().map(identifier -> funcCall.getArgsWithKey().get(identifier).accept(this)).collect(Collectors.toCollection(ArrayList::new)), functionSymbolTableItem.getArgTypes());
			}

			if ((funcCall.getArgs().isEmpty() && funcCall.getArgsWithKey().isEmpty() && !functionSymbolTableItem.getFuncDeclaration().getArgs().isEmpty())
					|| ((!funcCall.getArgs().isEmpty() || !funcCall.getArgsWithKey().isEmpty()) && functionSymbolTableItem.getFuncDeclaration().getArgs().isEmpty())
					|| !typesMatch) {
				return new NoType();
			}

			if (!funcCall.isInFuncCallStmt() && functionSymbolTableItem.getReturnType() instanceof VoidType) {
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
