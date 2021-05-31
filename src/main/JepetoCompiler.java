package main;

import main.ast.nodes.Program;
import main.visitor.ASTTreePrinter;
import main.visitor.ProgramAnalyzer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.*;

public class JepetoCompiler {
    public void compile(CharStream textStream) {
        JepetoLexer jepetoLexer = new JepetoLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(jepetoLexer);
        JepetoParser jepetoParser = new JepetoParser(tokenStream);
        Program program = jepetoParser.jepeto().jepetoProgram;

        ASTTreePrinter astTreePrinter = new ASTTreePrinter();

        ProgramAnalyzer programAnalyzer = new ProgramAnalyzer();
        programAnalyzer.visit(program);

        if (programAnalyzer.getNumberOfErrors() == 0)
            astTreePrinter.visit(program);

    }

}
