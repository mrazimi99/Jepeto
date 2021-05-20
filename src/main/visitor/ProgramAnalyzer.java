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
import main.compileErrors.nameErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProgramAnalyzer extends Visitor<Void> {
	private int numberOfErrors;

	public ProgramAnalyzer() {
		numberOfErrors = 0;
	}

	public int getNumberOfErrors() {
		return numberOfErrors;
	}

	public void printException(Exception exception) {
		System.out.println(exception.getMessage());
	}

	private void checkDeclareError(Expression expression) {
		if (expression.getClass() == Identifier.class) {
			Identifier identifier = (Identifier) expression;

			try {
				SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				try {
					SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
				} catch (ItemNotFoundException itemNotFoundException) {
					printException(new VariableNotDeclared(expression.getLine(), identifier.getName()));
					numberOfErrors++;
				}
			}
		}
	}

	@Override
	public Void visit(Program program) {
		SymbolTable.root = new SymbolTable();
		SymbolTable.push(SymbolTable.root);

		for (FunctionDeclaration functionDeclaration : program.getFunctions()) {
			FunctionSymbolTableItem functionSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);

			try {
				SymbolTable.root.put(functionSymbolTableItem);
			} catch (ItemAlreadyExistsException e) {
				numberOfErrors++;
				DuplicateFunction error = new DuplicateFunction(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName());
				String newName = "func@" + numberOfErrors;
				functionDeclaration.setFunctionName(new Identifier(newName));
				functionSymbolTableItem.setName(newName);
				functionSymbolTableItem.error = error;

				try {
					SymbolTable.root.put(functionSymbolTableItem);
				} catch (ItemAlreadyExistsException itemAlreadyExistsException) {
					itemAlreadyExistsException.printStackTrace();
				}
			}
		}

		program.getMain().accept(this);

		for (FunctionDeclaration functionDeclaration : program.getFunctions())
			functionDeclaration.accept(this);

		return null;
	}

	@Override
	public Void visit(FunctionDeclaration functionDeclaration) {
		FunctionSymbolTableItem functionSymbolTableItem = null;
		try {
			functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName());

			if (functionSymbolTableItem.error != null) {
				printException(functionSymbolTableItem.error);
			}
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}

		SymbolTable symbolTable = new SymbolTable();
		functionSymbolTableItem.setFunctionSymbolTable(symbolTable);
		SymbolTable.push(symbolTable);
		functionDeclaration.getFunctionName().accept(this);

		for (Identifier arg : functionDeclaration.getArgs()) {
			VariableSymbolTableItem variableSymbolTableItem = new VariableSymbolTableItem(arg);

			try {
				symbolTable.put(variableSymbolTableItem);
			} catch (ItemAlreadyExistsException e) {
				printException(new DuplicateArgument(arg.getLine(), arg.getName()));
				numberOfErrors++;
			}

			try {
				SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + arg.getName());
				printException(new NameConflict(arg.getLine(), arg.getName()));
				numberOfErrors++;
			} catch (ItemNotFoundException e) {
			}

			arg.accept(this);
		}

		functionDeclaration.getBody().accept(this);
		SymbolTable.pop();
		return null;
	}

	@Override
	public Void visit(MainDeclaration mainDeclaration) {
		mainDeclaration.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(BlockStmt blockStmt) {
		for (Statement statement : blockStmt.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(ConditionalStmt conditionalStmt) {
		conditionalStmt.getCondition().accept(this);
		conditionalStmt.getThenBody().accept(this);

		if (conditionalStmt.getElseBody() != null)
			conditionalStmt.getElseBody().accept(this);

		return null;
	}

	@Override
	public Void visit(FunctionCallStmt methodCallStmt) {
		methodCallStmt.getFunctionCall().accept(this);
		return null;
	}

	@Override
	public Void visit(PrintStmt print) {
		checkDeclareError(print.getArg());
		print.getArg().accept(this);
		return null;
	}

	@Override
	public Void visit(ReturnStmt returnStmt) {
		if (returnStmt.getReturnedExpr().getClass() == Identifier.class) {
			Identifier identifier = (Identifier) returnStmt.getReturnedExpr();

			try {
				SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				try {
					SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
				} catch (ItemNotFoundException itemNotFoundException) {
					printException(new VariableNotDeclared(returnStmt.getLine(), identifier.getName()));
					numberOfErrors++;
				}
			}
		}
		returnStmt.getReturnedExpr().accept(this);
		return null;
	}

	@Override
	public Void visit(BinaryExpression binaryExpression) {
		if (binaryExpression.getFirstOperand().getClass() == Identifier.class) {
			Identifier identifier = (Identifier) binaryExpression.getFirstOperand();

			try {
				SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				try {
					SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
				} catch (ItemNotFoundException itemNotFoundException) {
					printException(new VariableNotDeclared(binaryExpression.getLine(), identifier.getName()));
					numberOfErrors++;
				}
			}
		}

		if (binaryExpression.getSecondOperand().getClass() == Identifier.class) {
			Identifier identifier = (Identifier) binaryExpression.getSecondOperand();

			try {
				SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				try {
					SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
				} catch (ItemNotFoundException itemNotFoundException) {
					printException(new VariableNotDeclared(binaryExpression.getLine(), identifier.getName()));
					numberOfErrors++;
				}
			}
		}

		binaryExpression.getFirstOperand().accept(this);
		binaryExpression.getSecondOperand().accept(this);
		return null;
	}

	@Override
	public Void visit(UnaryExpression unaryExpression) {
		if (unaryExpression.getOperand().getClass() == Identifier.class) {
			Identifier identifier = (Identifier) unaryExpression.getOperand();

			try {
				SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				try {
					SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
				} catch (ItemNotFoundException itemNotFoundException) {
					printException(new VariableNotDeclared(unaryExpression.getLine(), identifier.getName()));
					numberOfErrors++;
				}
			}
		}
		unaryExpression.getOperand().accept(this);
		return null;
	}

	@Override
	public Void visit(Identifier identifier) {
		return null;
	}

	@Override
	public Void visit(ListAccessByIndex listAccessByIndex) {
		checkDeclareError(listAccessByIndex.getInstance());
		checkDeclareError(listAccessByIndex.getIndex());
		listAccessByIndex.getInstance().accept(this);
		listAccessByIndex.getIndex().accept(this);
		return null;
	}

	@Override
	public Void visit(FunctionCall methodCall) {
		methodCall.getInstance().accept(this);

		if (methodCall.getInstance().getClass() == Identifier.class) {
			Identifier identifier = (Identifier) methodCall.getInstance();

			try {
				SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
			} catch (ItemNotFoundException e) {
				printException(new FunctionNotDeclared(methodCall.getLine(), identifier.getName()));
				numberOfErrors++;
			}
		}

		if (methodCall.getArgs() != null) {
			for (Expression expression : methodCall.getArgs()) {
				checkDeclareError(expression);
				expression.accept(this);
			}
		}

		if (methodCall.getArgsWithKey() != null) {
			for (Map.Entry<Identifier, Expression> entry : methodCall.getArgsWithKey().entrySet()) {
				if (methodCall.getInstance().getClass() == Identifier.class) {
					Identifier identifier = (Identifier) methodCall.getInstance();

					try {
						FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
						boolean has = false;

						for (Identifier id : functionSymbolTableItem.getFuncDeclaration().getArgs())
							if (id.getName().equals(entry.getKey().getName()))
								has = true;

						if (!has)
						{
							printException(new ArgumentNotDeclared(entry.getKey().getLine(), entry.getKey().getName(), identifier.getName()));
							numberOfErrors++;
						}

					} catch (ItemNotFoundException e) {
					}
				}

				if (entry.getValue().getClass() == Identifier.class) {
					Identifier identifier = (Identifier) entry.getValue();

					try {
						SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
					} catch (ItemNotFoundException e) {
						try {
							SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
						} catch (ItemNotFoundException itemNotFoundException) {
							printException(new VariableNotDeclared(entry.getValue().getLine(), identifier.getName()));
							numberOfErrors++;
						}
					}
				}
				entry.getKey().accept(this);
				entry.getValue().accept(this);
			}
		}
		return null;
	}

	@Override
	public Void visit(AnonymousFunction anonymousFunction) {
		SymbolTable symbolTable = new SymbolTable();
		SymbolTable.push(symbolTable);

		for (Identifier arg : anonymousFunction.getArgs()) {
			VariableSymbolTableItem variableSymbolTableItem = new VariableSymbolTableItem(arg);

			try {
				symbolTable.put(variableSymbolTableItem);
			} catch (ItemAlreadyExistsException e) {
				printException(new DuplicateArgument(arg.getLine(), arg.getName()));
				numberOfErrors++;
			}

			try {
				SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + arg.getName());
				printException(new NameConflict(arg.getLine(), arg.getName()));
				numberOfErrors++;
			} catch (ItemNotFoundException e) {
			}

			arg.accept(this);
		}

		anonymousFunction.getBody().accept(this);
		SymbolTable.pop();
		return null;
	}

	@Override
	public Void visit(ListValue listValue) {
		for (Expression expression : listValue.getElements()) {
			checkDeclareError(expression);
			expression.accept(this);
		}
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
		checkDeclareError(listSize.getInstance());
		listSize.getInstance().accept(this);
		return null;
	}
}
