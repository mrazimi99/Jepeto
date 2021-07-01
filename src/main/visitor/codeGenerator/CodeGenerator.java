package main.visitor.codeGenerator;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.functionPointer.*;
import main.ast.types.list.*;
import main.ast.types.single.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CodeGenerator extends Visitor<String> {
	private final String outputPath;
	private final Set<String> visited;
	private FileWriter mainFile;
	private final ExpressionTypeChecker expressionTypeChecker;
	private FunctionDeclaration curFuncDec;
	private int labelCounter;
	private int tempVars;

	public CodeGenerator(ExpressionTypeChecker expressionTypeChecker, Set<String> visited) {
		this.expressionTypeChecker = expressionTypeChecker;
		this.visited = visited;
		outputPath = "./output/";
		prepareOutputFolder();
		resetParameters();
	}

	private void prepareOutputFolder() {
		String jasminPath = "utilities/jarFiles/jasmin.jar";
		String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
		String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
		try{
			File directory = new File(this.outputPath);
			File[] files = directory.listFiles();
			if(files != null)
				for (File file : files)
					file.delete();
			directory.mkdir();
		}
		catch(SecurityException e) {//unreachable
		}
		copyFile(jasminPath, this.outputPath + "jasmin.jar");
		copyFile(listClassPath, this.outputPath + "List.j");
		copyFile(fptrClassPath, this.outputPath + "Fptr.j");

		try {
			String path = outputPath + "Main.j";
			File file = new File(path);
			file.createNewFile();
			mainFile = new FileWriter(path);
		} catch (IOException e) {//unreachable
		}
	}

	private void copyFile(String toBeCopied, String toBePasted) {
		try {
			File readingFile = new File(toBeCopied);
			File writingFile = new File(toBePasted);
			InputStream readingFileStream = new FileInputStream(readingFile);
			OutputStream writingFileStream = new FileOutputStream(writingFile);
			byte[] buffer = new byte[1024];
			int readLength;
			while ((readLength = readingFileStream.read(buffer)) > 0)
				writingFileStream.write(buffer, 0, readLength);
			readingFileStream.close();
			writingFileStream.close();
		} catch (IOException e) {//never reached
		}
	}

	private void addCommand(String command) {
		try {
			command = String.join("\n\t\t", command.split("\n"));
			if(command.startsWith("Label_"))
				mainFile.write("\t" + command + "\n");
			else if(command.startsWith("."))
				mainFile.write(command + "\n");
			else
				mainFile.write("\t\t" + command + "\n");
			mainFile.flush();
		} catch (IOException e) {//unreachable

		}
	}

	private String getExpectedType(Type t) {
		String type = null;
		if (t instanceof IntType)
			type = "java/lang/Integer";
		if (t instanceof BoolType)
			type = "java/lang/Boolean";
		if (t instanceof StringType)
			type = "java/lang/String";
		if (t instanceof FptrType)
			type = "Fptr";
		if (t instanceof ListType)
			type = "List";
		if (t instanceof VoidType)
			type = "V";

		return type;
	}

	private String castPrimitiveToClass(Type t) {
		if (t instanceof IntType)
			return "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
		if (t instanceof BoolType)
			return "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;";

		return null;
	}

	private String castClassToPrimitive(Type t) {
		if (t instanceof IntType)
			return "invokevirtual java/lang/Integer/intValue()I";
		else if (t instanceof BoolType)
			return "invokevirtual java/lang/Boolean/booleanValue()Z";

		return null;
	}

	private String getFreshLabel() {
		return "LABEL_" + (labelCounter++);
	}

	private String makeTypeSignature(Type t) {
		String signature = null;
		if (t instanceof IntType)
			signature = "Ljava/lang/Integer;";
		if (t instanceof BoolType)
			signature = "Ljava/lang/Boolean;";
		if (t instanceof StringType)
			signature = "Ljava/lang/String;";
		if (t instanceof FptrType)
			signature = "LFptr;";
		if (t instanceof ListType)
			signature = "LList;";
		if (t instanceof VoidType)
			signature = "V";

		return signature;
	}

	private void resetParameters() {
		labelCounter = 0;
		tempVars = -1;
	}

	private void addMainConstructor(Program program) {
		addCommand(".method public <init>()V\n" +
				".limit stack 128\n" +
				".limit locals 128\n" +
				"aload_0");

		addCommand("invokespecial java/lang/Object/<init>()V");

		program.getMain().accept(this);

		addCommand("return\n" +
				".end method");
	}

	private void addStaticMainMethod() {
		addCommand(".method public static main([Ljava/lang/String;)V\n" +
				".limit stack 128\n" +
				".limit locals 128\n" +
				"new Main\n" +
				"invokespecial Main/<init>()V\n" +
				"return\n" +
				".end method");
	}

	private int slotOf(String identifier) {
		if (identifier.equals("")) {
			if (curFuncDec == null) {
				if (tempVars < 0)
					tempVars = 0;
				tempVars++;
				return tempVars;
			}
			else {
				if (tempVars < 0)
					tempVars = curFuncDec.getArgs().size();
				tempVars++;
				return tempVars;
			}
		}

		if (curFuncDec == null)
			return -1;

		int result = 1;
		ArrayList<Identifier> args = curFuncDec.getArgs();

		for (Identifier arg : args) {
			if (arg.getName().equals(identifier))
				return result;
			result++;
		}

		return -1;
	}

	private FunctionSymbolTableItem findFuncSymbolTableItem(FunctionDeclaration functionDeclaration) {
		try {
			FunctionSymbolTableItem func = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName());
			return func;
		} catch (ItemNotFoundException e){
			return null;
		}

	}

	private FunctionSymbolTableItem findFuncSymbolTableItem(String name) {
		try {
			FunctionSymbolTableItem func = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + name);
			return func;
		} catch (ItemNotFoundException e){
			return null;
		}
	}

	private void addPrint(String str) {
		addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
		addCommand("ldc \"" + str + "\"");
		addCommand("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
	}

	private void addPrintln(String str) {
		addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
		addCommand("ldc \"" + str + "\"");
		addCommand("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
	}

	@Override
	public String visit(Program program) {
		addCommand(".class public Main");
		addCommand(".super java/lang/Object");
		addStaticMainMethod();
		addMainConstructor(program);

		for (FunctionDeclaration functionDeclaration : program.getFunctions()) {
			if (visited.contains(functionDeclaration.getFunctionName().getName())) {
				curFuncDec = functionDeclaration;
				expressionTypeChecker.setCurFunction(findFuncSymbolTableItem(functionDeclaration));
				functionDeclaration.accept(this);
			}
		}

		return null;
	}

	@Override
	public String visit(FunctionDeclaration funcDeclaration) {
		String signature  = ".method public " + funcDeclaration.getFunctionName().getName() + "(";
		FunctionSymbolTableItem funcSymbolTableItem = findFuncSymbolTableItem(funcDeclaration);

		for (Identifier arg : funcDeclaration.getArgs())
			signature += makeTypeSignature(funcSymbolTableItem.getArgTypes().get(arg.getName()));
		signature += ")" + makeTypeSignature(funcSymbolTableItem.getReturnType());
		addCommand(signature);
		addCommand(".limit stack 128");
		addCommand(".limit locals 128");
		funcDeclaration.getBody().accept(this);
		addCommand(".end method");
		return null;
	}

	@Override
	public String visit(MainDeclaration mainDeclaration) {
		mainDeclaration.getBody().accept(this);
		return null;
	}


	@Override
	public String visit(BlockStmt blockStmt) {
		for (Statement stmt : blockStmt.getStatements()) {
			stmt.accept(this);
		}
		return null;
	}

	@Override
	public String visit(ConditionalStmt conditionalStmt) {
		addCommand(conditionalStmt.getCondition().accept(this));

		String ELSE = getFreshLabel();
		String AFTER = getFreshLabel();

		addCommand("ifeq " + ELSE);

		conditionalStmt.getThenBody().accept(this);
		addCommand("goto " + AFTER);

		addCommand(ELSE + ":");
		if (conditionalStmt.getElseBody() != null)
			conditionalStmt.getElseBody().accept(this);

		addCommand(AFTER + ":");
		return null;
	}

	@Override
	public String visit(FunctionCallStmt funcCallStmt) {
		expressionTypeChecker.setFunctioncallStmt(true);
		addCommand(funcCallStmt.getFunctionCall().accept(this));
		addCommand("pop");
		expressionTypeChecker.setFunctioncallStmt(false);
		return null;
	}

	@Override
	public String visit(PrintStmt print) {
		Type argType = print.getArg().accept(expressionTypeChecker);
		String primitiveType = null;

		if (argType instanceof IntType)
			primitiveType = "I";
		else if (argType instanceof BoolType)
			primitiveType = "Z";
		else if (argType instanceof StringType)
			primitiveType = "Ljava/lang/String;";



		if (argType instanceof ListType) {
			addCommand(print.getArg().accept(this));
			addPrint("[");
			String Before = getFreshLabel();
			String AFTER = getFreshLabel();
			String AFTER2 = getFreshLabel();
			String AFTER3 = getFreshLabel();
			int index = slotOf("");
			addCommand("ldc 0");
			addCommand("istore " + index);
			int slot = slotOf("");

			addCommand(Before + ":");
			addCommand("dup");
			addCommand("dup");
			addCommand("invokevirtual List/getSize()I");
			addCommand("iload " + index);
			addCommand("if_icmpeq " + AFTER2);

			addCommand("iload " + index);
			addCommand("invokevirtual List/getElement(I)Ljava/lang/Object;");
			addCommand("checkcast " + getExpectedType(new IntType()));
			addCommand(castClassToPrimitive(new IntType()));
			addCommand("istore " + slot);
			addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
			addCommand("iload " + slot);
			addCommand("invokevirtual java/io/PrintStream/print(I)V");

			addCommand("ldc 1");
			addCommand("iload " + index);
			addCommand("iadd");
			addCommand("istore " + index);

			addCommand("dup");
			addCommand("invokevirtual List/getSize()I");
			addCommand("iload " + index);
			addCommand("if_icmpeq " + AFTER3);
			addPrint(",");
			addCommand(AFTER3 + ":");

			addCommand("goto " + Before);
			addCommand(AFTER2 + ":");
			addCommand("pop");
			addCommand(AFTER + ":");
			addCommand("pop");
			addPrintln("]");
		}
		else {
			addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
			addCommand(print.getArg().accept(this));
			addCommand("invokevirtual java/io/PrintStream/println(" + primitiveType + ")V");
		}

		return null;
	}

	@Override
	public String visit(ReturnStmt returnStmt) {
		Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
		if (returnType instanceof VoidType)
			addCommand("return");
		else {
			addCommand(returnStmt.getReturnedExpr().accept(this));
			if (returnType instanceof IntType)
				addCommand(castPrimitiveToClass(returnType));
			if (returnType instanceof BoolType)
				addCommand(castPrimitiveToClass(returnType));
			addCommand("areturn");
		}
		return null;
	}

	@Override
	public String visit(BinaryExpression binaryExpression) {
		BinaryOperator operator = binaryExpression.getBinaryOperator();
		String commands = "";

		if (operator == BinaryOperator.add) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);
			commands += "\niadd";
		}
		else if (operator == BinaryOperator.sub) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);
			commands += "\nisub";
		}
		else if (operator == BinaryOperator.mult) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);
			commands += "\nimul";
		}
		else if (operator == BinaryOperator.div) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);
			commands += "\nidiv";
		}
		else if ((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);

			String TRUE = getFreshLabel();
			String AFTER = getFreshLabel();

			if (operator == BinaryOperator.gt)
				commands += "\nif_icmpgt " + TRUE;
			else
				commands += "\nif_icmplt " + TRUE;

			commands += "\nldc 0" +
					"\ngoto " + AFTER +
					"\n" + TRUE + ":" +
					"\nldc 1" +
					"\n" + AFTER + ":";
		}
		else if ((operator == BinaryOperator.eq) || (operator == BinaryOperator.neq)) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);

			String FALSE = getFreshLabel();
			String AFTER = getFreshLabel();

			Type type = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
			if (type instanceof IntType || type instanceof BoolType)
				commands += "\nif_i";
			else
				commands += "\nif_a";

			if (operator == BinaryOperator.eq)
				commands += "cmpne " + FALSE;
			else
				commands += "cmpeq " + FALSE;

			commands += "\nldc 1" +
					"\ngoto " + AFTER +
					"\n" + FALSE + ":" +
					"\nldc 0" +
					"\n" + AFTER + ":";
		}
		else if (operator == BinaryOperator.and) {
			String TRUE = getFreshLabel();
			String FALSE = getFreshLabel();
			String AFTER = getFreshLabel();
			// todo pop

			commands += "\n" + binaryExpression.getFirstOperand().accept(this) +
					"\nifeq " + FALSE +
					"\n" + binaryExpression.getSecondOperand().accept(this) +
					"\nifeq " + FALSE +
					"\n" + TRUE + ":" +
					"\nldc 1" +
					"\ngoto " + AFTER +
					"\n" + FALSE + ":" +
					"\nldc 0" +
					"\n" + AFTER + ":";
		}
		else if (operator == BinaryOperator.or) {
			String TRUE = getFreshLabel();
			String FALSE = getFreshLabel();
			String AFTER = getFreshLabel();
			// todo pop

			commands += "\n" + binaryExpression.getFirstOperand().accept(this) +
					"\nifne " + TRUE +
					"\n" + binaryExpression.getSecondOperand().accept(this) +
					"\nifeq " + FALSE +
					"\n" + TRUE + ":" +
					"\nldc 1" +
					"\ngoto " + AFTER +
					"\n" + FALSE + ":" +
					"\nldc 0" +
					"\n" + AFTER + ":";
		}
		else if (operator == BinaryOperator.append) {
			commands += binaryExpression.getFirstOperand().accept(this);
			commands += "\ndup";
			commands += "\n" + binaryExpression.getSecondOperand().accept(this);
			commands += "\n" + castPrimitiveToClass(new IntType());
			commands += "\ninvokevirtual List/addElement(Ljava/lang/Object;)V";
		}

		return commands;
	}

	@Override
	public String visit(UnaryExpression unaryExpression) {
		UnaryOperator operator = unaryExpression.getOperator();
		String commands = "";

		if (operator == UnaryOperator.minus) {
			commands += unaryExpression.getOperand().accept(this) + "\n";
			commands += "ineg";
		}
		else if (operator == UnaryOperator.not) {
			String TRUE = getFreshLabel();
			String AFTER = getFreshLabel();
			commands += unaryExpression.getOperand().accept(this) + "\n";
			commands += "ifne " + TRUE + "\n";
			commands += "ldc 1\n";
			commands += "goto " + AFTER + "\n";
			commands += TRUE + ":\n";
			commands += "ldc 0\n";
			commands += AFTER + ":";
		}

		return commands;
	}

	@Override
	public String visit(AnonymousFunction anonymousFunction) {
		//todo
		return null;
	}

	@Override
	public String visit(Identifier identifier) {
		int slot = slotOf(identifier.getName());

		if (slot == -1) {
			return "new Fptr\n" +
					"dup\n" +
					"aload_0\n" +
					"ldc \"" + identifier.getName() + "\"" + "\n" +
					"invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V";
		}

		String commands = "aload " + slot + "\n";
		String castPrimitiveCommand = castClassToPrimitive(identifier.accept(expressionTypeChecker));

		if (castPrimitiveCommand != null)
			commands += castPrimitiveCommand;

		return commands;
	}

	@Override
	public String visit(ListAccessByIndex listAccessByIndex) {
		String commands = "";
		commands += listAccessByIndex.getInstance().accept(this) + "\n" +
				listAccessByIndex.getIndex().accept(this) + "\n" +
				"invokevirtual List/getElement(I)Ljava/lang/Object;\n";

		commands += "checkcast " + getExpectedType(listAccessByIndex.accept(expressionTypeChecker)) + "\n";

		String castPrimitiveCommand = castClassToPrimitive(listAccessByIndex.accept(expressionTypeChecker));
		if (castPrimitiveCommand != null)
			commands += castPrimitiveCommand;

		return commands;
	}

	@Override
	public String visit(ListSize listSize) {
		return listSize.getInstance().accept(this) + "\n" +
				"invokevirtual List/getSize()I\n";
	}

	@Override
	public String visit(FunctionCall funcCall) {
		String commands = "";
		commands += funcCall.getInstance().accept(this) + "\n" +
				"new java/util/ArrayList\n" +
				"dup\n" +
				"invokespecial java/util/ArrayList/<init>()V\n";

		for (Expression arg : funcCall.getArgs()) {
			commands += "dup\n" +
					arg.accept(this) + "\n";

			Type type = arg.accept(expressionTypeChecker);
			String castPrimitiveClassCmd = castPrimitiveToClass(type);

			if (castPrimitiveClassCmd != null)
				commands += castPrimitiveClassCmd + "\n";

			commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n" +
					"pop\n";
		}

		Type instanceType = funcCall.getInstance().accept(expressionTypeChecker);
		FunctionSymbolTableItem funcSymbolTableItem = findFuncSymbolTableItem(((FptrType) instanceType).getFunctionName());

		if (!funcCall.getArgsWithKey().isEmpty()) {
			for (Identifier decArg : funcSymbolTableItem.getFuncDeclaration().getArgs()) {
				Expression arg = null;
				for (Map.Entry<Identifier, Expression> pair : funcCall.getArgsWithKey().entrySet()) {
					if (pair.getKey().toString().equals(decArg.toString()))
						arg = pair.getValue();
				}
				commands += "dup\n" +
						arg.accept(this) + "\n";

				Type type = arg.accept(expressionTypeChecker);
				String castPrimitiveClassCmd = castPrimitiveToClass(type);
				if (castPrimitiveClassCmd != null)
					commands += castPrimitiveClassCmd + "\n";

				commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n" +
						"pop\n";
			}
		}

		commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";

		Type returnType = funcCall.accept(expressionTypeChecker);
		if (!(returnType instanceof VoidType))
			commands += "checkcast " + getExpectedType(returnType) + "\n";

		String primitiveCastCmd = castClassToPrimitive(returnType);
		if (primitiveCastCmd != null)
			commands += "\n" + primitiveCastCmd;

		return commands;
	}

	@Override
	public String visit(ListValue listValue) {
//		addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");     //todo check no problem
		String commands = "";
		commands += "new List\n" +
				"dup\n" +
				"new java/util/ArrayList\n" +
				"dup\n" +
				"invokespecial java/util/ArrayList/<init>()V\n";

		for (Expression element : listValue.getElements()) {
			Type type = element.accept(expressionTypeChecker);
			commands += "\ndup\n" +
					element.accept(this) + "\n";
			String castPrimitiveClassCmd = castPrimitiveToClass(type);

			if (castPrimitiveClassCmd != null)
				commands += castPrimitiveClassCmd + "\n";

			commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n" +
					"pop\n";
		}

		commands += "invokespecial List/<init>(Ljava/util/ArrayList;)V";
		return commands;
	}

	@Override
	public String visit(IntValue intValue) {
		String commands = "";
		commands += "ldc " + intValue.getConstant();
		return commands;
	}

	@Override
	public String visit(BoolValue boolValue) {
		String commands = "";
		if (boolValue.getConstant())
			commands += "ldc 1";
		else
			commands += "ldc 0";
		return commands;
	}

	@Override
	public String visit(StringValue stringValue) {
		String commands = "";
		commands += "ldc \"" + stringValue.getConstant() + "\"";
		return commands;
	}

	@Override
	public String visit(VoidValue voidValue) {
		return null;
	}
}
