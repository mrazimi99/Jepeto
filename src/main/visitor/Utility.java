package main.visitor;

import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.VoidType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListType;
import main.ast.types.single.BoolType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrors.typeErrors.ReturnValueNotMatchFunctionReturnType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;

import java.util.ArrayList;
import java.util.List;

public class Utility {
	public static boolean areFirstsSubTypeOfSeconds(ArrayList<Type> first, ArrayList<Type> second) {
		if(first.size() != second.size())
			return false;

		for(int i = 0; i < first.size(); i++) {
			if(!isFirstSubTypeOfSecond(first.get(i), second.get(i)))
				return false;
		}

		return true;
	}

	public static boolean isFirstSubTypeOfSecond(Type first, Type second) {
		if(first instanceof NoType || second instanceof NoType) //todo
			return true;

		if(first instanceof IntType || first instanceof BoolType || first instanceof StringType)
			return first.toString().equals(second.toString());

		if (first instanceof VoidType)
			return second instanceof FptrType;

		if (first instanceof ListType) {
			if (!(second instanceof ListType))
				return false;
			if (((ListType) first).getType() instanceof NoType || ((ListType) second).getType() instanceof NoType)
				return true;
			return isFirstSubTypeOfSecond(((ListType) first).getType(), ((ListType) second).getType());
		}

		if (first instanceof FptrType) {
			if(!(second instanceof FptrType))
				return false;

			Type firstRetType = null;
			Type secondRetType = null;
			ArrayList<Type> firstArgsTypes = null;
			ArrayList<Type> secondArgsTypes = null;

			try {
				String firstName = ((FptrType) first).getFunctionName();
				String secondName = ((FptrType) second).getFunctionName();
				FunctionSymbolTableItem firstFunctionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + firstName);
				FunctionSymbolTableItem secondFunctionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + secondName);

				firstRetType = firstFunctionSymbolTableItem.getReturnType();
				secondRetType = secondFunctionSymbolTableItem.getReturnType();

				firstArgsTypes = firstFunctionSymbolTableItem.getArgTypes();
				secondArgsTypes = secondFunctionSymbolTableItem.getArgTypes();
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}

			if(!isFirstSubTypeOfSecond(firstRetType, secondRetType))
				return false;

			return areFirstsSubTypeOfSeconds(secondArgsTypes, firstArgsTypes);
		}
		return true;
	}
}
