// Generated from D:/Documents/University/CECM/CPL/CAs/jepeto/src/main/grammar\Jepeto.g4 by ANTLR 4.9.1
package parsers;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;

    import java.util.ArrayList;
    import java.util.LinkedHashMap;
    import java.util.Map;

    import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JepetoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNC=1, MAIN=2, SIZE=3, PRINT=4, RETURN=5, VOID=6, IF=7, ELSE=8, PLUS=9, 
		MINUS=10, MULT=11, DIVIDE=12, EQUAL=13, NOT_EQUAL=14, GREATER_THAN=15, 
		LESS_THAN=16, AND=17, OR=18, NOT=19, APPEND=20, TRUE=21, FALSE=22, ARROW=23, 
		ASSIGN=24, LPAR=25, RPAR=26, LBRACK=27, RBRACK=28, LBRACE=29, RBRACE=30, 
		COMMA=31, DOT=32, COLON=33, SEMICOLLON=34, INT_VALUE=35, IDENTIFIER=36, 
		STRING_VALUE=37, COMMENT=38, WS=39;
	public static final int
		RULE_jepeto = 0, RULE_program = 1, RULE_functionDeclaration = 2, RULE_functionArgumentsDeclaration = 3, 
		RULE_body = 4, RULE_main = 5, RULE_functionCall = 6, RULE_functionArguments = 7, 
		RULE_splitedExpressionsWithComma = 8, RULE_splitedExpressionsWithCommaAndKey = 9, 
		RULE_functionCallStatement = 10, RULE_returnStatement = 11, RULE_ifStatement = 12, 
		RULE_ifStatementWithReturn = 13, RULE_printStatement = 14, RULE_statement = 15, 
		RULE_singleStatement = 16, RULE_block = 17, RULE_conditionBody = 18, RULE_expression = 19, 
		RULE_andExpression = 20, RULE_equalityExpression = 21, RULE_relationalExpression = 22, 
		RULE_additiveExpression = 23, RULE_multiplicativeExpression = 24, RULE_preUnaryExpression = 25, 
		RULE_appendExpression = 26, RULE_accessExpression = 27, RULE_otherExpression = 28, 
		RULE_anonymousFunction = 29, RULE_sizeExpression = 30, RULE_values = 31, 
		RULE_listValue = 32, RULE_boolValue = 33, RULE_voidValue = 34, RULE_identifier = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"jepeto", "program", "functionDeclaration", "functionArgumentsDeclaration", 
			"body", "main", "functionCall", "functionArguments", "splitedExpressionsWithComma", 
			"splitedExpressionsWithCommaAndKey", "functionCallStatement", "returnStatement", 
			"ifStatement", "ifStatementWithReturn", "printStatement", "statement", 
			"singleStatement", "block", "conditionBody", "expression", "andExpression", 
			"equalityExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"preUnaryExpression", "appendExpression", "accessExpression", "otherExpression", 
			"anonymousFunction", "sizeExpression", "values", "listValue", "boolValue", 
			"voidValue", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'size'", "'print'", "'return'", "'void'", 
			"'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'is'", "'not'", "'>'", 
			"'<'", "'and'", "'or'", "'~'", "'::'", "'true'", "'false'", "'->'", "'='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "MAIN", "SIZE", "PRINT", "RETURN", "VOID", "IF", "ELSE", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
			"LESS_THAN", "AND", "OR", "NOT", "APPEND", "TRUE", "FALSE", "ARROW", 
			"ASSIGN", "LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", 
			"DOT", "COLON", "SEMICOLLON", "INT_VALUE", "IDENTIFIER", "STRING_VALUE", 
			"COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Jepeto.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JepetoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class JepetoContext extends ParserRuleContext {
		public Program jepetoProgram;
		public ProgramContext prog;
		public TerminalNode EOF() { return getToken(JepetoParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public JepetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jepeto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterJepeto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitJepeto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitJepeto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JepetoContext jepeto() throws RecognitionException {
		JepetoContext _localctx = new JepetoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_jepeto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((JepetoContext)_localctx).prog = program();
			setState(73);
			match(EOF);
			((JepetoContext)_localctx).jepetoProgram =  ((JepetoContext)_localctx).prog.prog;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program prog;
		public FunctionDeclarationContext funcDec1;
		public MainContext mainDec;
		public FunctionDeclarationContext funcDec2;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).prog =  new Program(); _localctx.prog.setLine(1);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(77);
				((ProgramContext)_localctx).funcDec1 = functionDeclaration();
				_localctx.prog.addFunction(((ProgramContext)_localctx).funcDec1.funcDec);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(85);
			((ProgramContext)_localctx).mainDec = main();
			_localctx.prog.setMain(((ProgramContext)_localctx).mainDec.mainDec);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(88);
				((ProgramContext)_localctx).funcDec2 = functionDeclaration();
				_localctx.prog.addFunction(((ProgramContext)_localctx).funcDec2.funcDec);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration funcDec;
		public Token f;
		public IdentifierContext name;
		public FunctionArgumentsDeclarationContext args;
		public BodyContext bodyStmt;
		public TerminalNode COLON() { return getToken(JepetoParser.COLON, 0); }
		public TerminalNode FUNC() { return getToken(JepetoParser.FUNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((FunctionDeclarationContext)_localctx).f = match(FUNC);
			setState(97);
			((FunctionDeclarationContext)_localctx).name = identifier();
			setState(98);
			((FunctionDeclarationContext)_localctx).args = functionArgumentsDeclaration();
			setState(99);
			match(COLON);
			setState(100);
			((FunctionDeclarationContext)_localctx).bodyStmt = body();
			((FunctionDeclarationContext)_localctx).funcDec =  new FunctionDeclaration(); _localctx.funcDec.setFunctionName(((FunctionDeclarationContext)_localctx).name.id); _localctx.funcDec.setArgs(((FunctionDeclarationContext)_localctx).args.args); _localctx.funcDec.setBody(((FunctionDeclarationContext)_localctx).bodyStmt.bodyStatement); _localctx.funcDec.setLine(((FunctionDeclarationContext)_localctx).f.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsDeclarationContext extends ParserRuleContext {
		public ArrayList<Identifier> args;
		public Token lpar;
		public Token lp;
		public IdentifierContext arg1;
		public IdentifierContext arg2;
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public FunctionArgumentsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgumentsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionArgumentsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionArgumentsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionArgumentsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsDeclarationContext functionArgumentsDeclaration() throws RecognitionException {
		FunctionArgumentsDeclarationContext _localctx = new FunctionArgumentsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionArgumentsDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionArgumentsDeclarationContext)_localctx).args =  new ArrayList<>();
			setState(104);
			((FunctionArgumentsDeclarationContext)_localctx).lp = match(LPAR);
			((FunctionArgumentsDeclarationContext)_localctx).lpar =  ((FunctionArgumentsDeclarationContext)_localctx).lp;
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(106);
				((FunctionArgumentsDeclarationContext)_localctx).arg1 = identifier();
				_localctx.args.add(((FunctionArgumentsDeclarationContext)_localctx).arg1.id);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(108);
					match(COMMA);
					setState(109);
					((FunctionArgumentsDeclarationContext)_localctx).arg2 = identifier();
					if ((((FunctionArgumentsDeclarationContext)_localctx).arg2!=null?_input.getText(((FunctionArgumentsDeclarationContext)_localctx).arg2.start,((FunctionArgumentsDeclarationContext)_localctx).arg2.stop):null) != null) {_localctx.args.add(((FunctionArgumentsDeclarationContext)_localctx).arg2.id);}
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(119);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Statement bodyStatement;
		public SingleStatementContext single;
		public BlockContext blockStatement;
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(121);
				((BodyContext)_localctx).single = singleStatement();
				((BodyContext)_localctx).bodyStatement =  ((BodyContext)_localctx).single.bodyStatement;
				}
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(124);
				((BodyContext)_localctx).blockStatement = block();
				((BodyContext)_localctx).bodyStatement =  ((BodyContext)_localctx).blockStatement.blockStmt;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public MainDeclaration mainDec;
		public Token name;
		public FunctionCallStatementContext functionCallStmt;
		public PrintStatementContext printStmt;
		public TerminalNode COLON() { return getToken(JepetoParser.COLON, 0); }
		public TerminalNode MAIN() { return getToken(JepetoParser.MAIN, 0); }
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((MainContext)_localctx).name = match(MAIN);
			((MainContext)_localctx).mainDec =  new MainDeclaration();
			setState(131);
			match(COLON);
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(132);
				((MainContext)_localctx).functionCallStmt = functionCallStatement();
				_localctx.mainDec.setBody(((MainContext)_localctx).functionCallStmt.functionCallStmt);
				}
				}
				break;
			case PRINT:
				{
				{
				setState(135);
				((MainContext)_localctx).printStmt = printStatement();
				_localctx.mainDec.setBody(((MainContext)_localctx).printStmt.printStmt);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.mainDec.setLine(((MainContext)_localctx).name.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCall funcCall;
		public Expression expr;
		public IdentifierContext id;
		public Token lpar1;
		public FunctionArgumentsContext funcCallArgs1;
		public Token lpar2;
		public FunctionArgumentsContext funcCallArgs2;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(JepetoParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(JepetoParser.RPAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(JepetoParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(JepetoParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((FunctionCallContext)_localctx).id = identifier();
			((FunctionCallContext)_localctx).expr =  ((FunctionCallContext)_localctx).id.id;
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					((FunctionCallContext)_localctx).lpar1 = match(LPAR);
					setState(145);
					((FunctionCallContext)_localctx).funcCallArgs1 = functionArguments();
					setState(146);
					match(RPAR);
					((FunctionCallContext)_localctx).expr =  new FunctionCall(_localctx.expr, ((FunctionCallContext)_localctx).funcCallArgs1.args, ((FunctionCallContext)_localctx).funcCallArgs1.argsWithKey); _localctx.expr.setLine(((FunctionCallContext)_localctx).lpar1.getLine());
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			{
			setState(154);
			((FunctionCallContext)_localctx).lpar2 = match(LPAR);
			setState(155);
			((FunctionCallContext)_localctx).funcCallArgs2 = functionArguments();
			setState(156);
			match(RPAR);
			((FunctionCallContext)_localctx).funcCall =  new FunctionCall(_localctx.expr, ((FunctionCallContext)_localctx).funcCallArgs2.args, ((FunctionCallContext)_localctx).funcCallArgs2.argsWithKey); _localctx.funcCall.setLine(((FunctionCallContext)_localctx).lpar2.getLine());
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public ArrayList<Expression> args;
		public Map<Identifier, Expression> argsWithKey;
		public SplitedExpressionsWithCommaContext serial;
		public SplitedExpressionsWithCommaAndKeyContext keyVal;
		public SplitedExpressionsWithCommaContext splitedExpressionsWithComma() {
			return getRuleContext(SplitedExpressionsWithCommaContext.class,0);
		}
		public SplitedExpressionsWithCommaAndKeyContext splitedExpressionsWithCommaAndKey() {
			return getRuleContext(SplitedExpressionsWithCommaAndKeyContext.class,0);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionArguments);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(159);
				((FunctionArgumentsContext)_localctx).serial = splitedExpressionsWithComma();
				((FunctionArgumentsContext)_localctx).args =  ((FunctionArgumentsContext)_localctx).serial.args; ((FunctionArgumentsContext)_localctx).argsWithKey =  null;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(162);
				((FunctionArgumentsContext)_localctx).keyVal = splitedExpressionsWithCommaAndKey();
				((FunctionArgumentsContext)_localctx).args =  null; ((FunctionArgumentsContext)_localctx).argsWithKey =  ((FunctionArgumentsContext)_localctx).keyVal.args;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitedExpressionsWithCommaContext extends ParserRuleContext {
		public ArrayList<Expression> args;
		public ExpressionContext expr1;
		public ExpressionContext expr2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public SplitedExpressionsWithCommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitedExpressionsWithComma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSplitedExpressionsWithComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSplitedExpressionsWithComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSplitedExpressionsWithComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitedExpressionsWithCommaContext splitedExpressionsWithComma() throws RecognitionException {
		SplitedExpressionsWithCommaContext _localctx = new SplitedExpressionsWithCommaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_splitedExpressionsWithComma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SplitedExpressionsWithCommaContext)_localctx).args =  new ArrayList<>();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(168);
				((SplitedExpressionsWithCommaContext)_localctx).expr1 = expression();
				if ((((SplitedExpressionsWithCommaContext)_localctx).expr1!=null?_input.getText(((SplitedExpressionsWithCommaContext)_localctx).expr1.start,((SplitedExpressionsWithCommaContext)_localctx).expr1.stop):null) != null) _localctx.args.add(((SplitedExpressionsWithCommaContext)_localctx).expr1.expr);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(170);
					match(COMMA);
					setState(171);
					((SplitedExpressionsWithCommaContext)_localctx).expr2 = expression();
					if ((((SplitedExpressionsWithCommaContext)_localctx).expr2!=null?_input.getText(((SplitedExpressionsWithCommaContext)_localctx).expr2.start,((SplitedExpressionsWithCommaContext)_localctx).expr2.stop):null) != null) _localctx.args.add(((SplitedExpressionsWithCommaContext)_localctx).expr2.expr);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitedExpressionsWithCommaAndKeyContext extends ParserRuleContext {
		public Map<Identifier, Expression> args;
		public IdentifierContext id1;
		public ExpressionContext expr1;
		public IdentifierContext id2;
		public ExpressionContext expr2;
		public List<TerminalNode> ASSIGN() { return getTokens(JepetoParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(JepetoParser.ASSIGN, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public SplitedExpressionsWithCommaAndKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitedExpressionsWithCommaAndKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSplitedExpressionsWithCommaAndKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSplitedExpressionsWithCommaAndKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSplitedExpressionsWithCommaAndKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitedExpressionsWithCommaAndKeyContext splitedExpressionsWithCommaAndKey() throws RecognitionException {
		SplitedExpressionsWithCommaAndKeyContext _localctx = new SplitedExpressionsWithCommaAndKeyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_splitedExpressionsWithCommaAndKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SplitedExpressionsWithCommaAndKeyContext)_localctx).args =  new LinkedHashMap<>();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(182);
				((SplitedExpressionsWithCommaAndKeyContext)_localctx).id1 = identifier();
				setState(183);
				match(ASSIGN);
				setState(184);
				((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr1 = expression();
				if ((((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr1!=null?_input.getText(((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr1.start,((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr1.stop):null) != null) _localctx.args.put(((SplitedExpressionsWithCommaAndKeyContext)_localctx).id1.id, ((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr1.expr);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(186);
					match(COMMA);
					setState(187);
					((SplitedExpressionsWithCommaAndKeyContext)_localctx).id2 = identifier();
					setState(188);
					match(ASSIGN);
					setState(189);
					((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr2 = expression();
					if ((((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr2!=null?_input.getText(((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr2.start,((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr2.stop):null) != null) _localctx.args.put(((SplitedExpressionsWithCommaAndKeyContext)_localctx).id2.id, ((SplitedExpressionsWithCommaAndKeyContext)_localctx).expr2.expr);
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public FunctionCallStmt functionCallStmt;
		public FunctionCallContext funcCall;
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((FunctionCallStatementContext)_localctx).funcCall = functionCall();
			((FunctionCallStatementContext)_localctx).functionCallStmt =  new FunctionCallStmt(((FunctionCallStatementContext)_localctx).funcCall.funcCall); _localctx.functionCallStmt.setLine(((FunctionCallStatementContext)_localctx).funcCall.funcCall.getLine());
			setState(201);
			match(SEMICOLLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnStmt;
		public Token ret;
		public ExpressionContext expr;
		public VoidValueContext void_;
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public TerminalNode RETURN() { return getToken(JepetoParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VoidValueContext voidValue() {
			return getRuleContext(VoidValueContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			((ReturnStatementContext)_localctx).ret = match(RETURN);
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				{
				setState(204);
				((ReturnStatementContext)_localctx).expr = expression();
				}
				break;
			case VOID:
				{
				setState(205);
				((ReturnStatementContext)_localctx).void_ = voidValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if ((((ReturnStatementContext)_localctx).void_!=null?_input.getText(((ReturnStatementContext)_localctx).void_.start,((ReturnStatementContext)_localctx).void_.stop):null) == null) {((ReturnStatementContext)_localctx).returnStmt =  new ReturnStmt(((ReturnStatementContext)_localctx).expr.expr);} else {((ReturnStatementContext)_localctx).returnStmt =  new ReturnStmt(((ReturnStatementContext)_localctx).void_.void_);} _localctx.returnStmt.setLine(((ReturnStatementContext)_localctx).ret.getLine());
			setState(209);
			match(SEMICOLLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt conditionalStmt;
		public Token if_;
		public ExpressionContext expr;
		public ConditionBodyContext body1;
		public Token else_;
		public ConditionBodyContext body2;
		public List<TerminalNode> COLON() { return getTokens(JepetoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(JepetoParser.COLON, i);
		}
		public TerminalNode IF() { return getToken(JepetoParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ConditionBodyContext> conditionBody() {
			return getRuleContexts(ConditionBodyContext.class);
		}
		public ConditionBodyContext conditionBody(int i) {
			return getRuleContext(ConditionBodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JepetoParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((IfStatementContext)_localctx).if_ = match(IF);
			setState(212);
			((IfStatementContext)_localctx).expr = expression();
			setState(213);
			match(COLON);
			setState(214);
			((IfStatementContext)_localctx).body1 = conditionBody();
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(215);
				((IfStatementContext)_localctx).else_ = match(ELSE);
				setState(216);
				match(COLON);
				setState(217);
				((IfStatementContext)_localctx).body2 = conditionBody();
				}
				break;
			}
			((IfStatementContext)_localctx).conditionalStmt =  new ConditionalStmt(((IfStatementContext)_localctx).expr.expr, ((IfStatementContext)_localctx).body1.bodyStatement); if ((((IfStatementContext)_localctx).else_!=null?((IfStatementContext)_localctx).else_.getText():null) != null) {_localctx.conditionalStmt.setElseBody(((IfStatementContext)_localctx).body2.bodyStatement);} _localctx.conditionalStmt.setLine(((IfStatementContext)_localctx).if_.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementWithReturnContext extends ParserRuleContext {
		public ConditionalStmt conditionalStmt;
		public Token if_;
		public ExpressionContext expr;
		public BodyContext body1;
		public BodyContext body2;
		public List<TerminalNode> COLON() { return getTokens(JepetoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(JepetoParser.COLON, i);
		}
		public TerminalNode ELSE() { return getToken(JepetoParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(JepetoParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public IfStatementWithReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatementWithReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIfStatementWithReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIfStatementWithReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIfStatementWithReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementWithReturnContext ifStatementWithReturn() throws RecognitionException {
		IfStatementWithReturnContext _localctx = new IfStatementWithReturnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatementWithReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((IfStatementWithReturnContext)_localctx).if_ = match(IF);
			setState(223);
			((IfStatementWithReturnContext)_localctx).expr = expression();
			setState(224);
			match(COLON);
			setState(225);
			((IfStatementWithReturnContext)_localctx).body1 = body();
			setState(226);
			match(ELSE);
			setState(227);
			match(COLON);
			setState(228);
			((IfStatementWithReturnContext)_localctx).body2 = body();
			((IfStatementWithReturnContext)_localctx).conditionalStmt =  new ConditionalStmt(((IfStatementWithReturnContext)_localctx).expr.expr, ((IfStatementWithReturnContext)_localctx).body1.bodyStatement); _localctx.conditionalStmt.setElseBody(((IfStatementWithReturnContext)_localctx).body2.bodyStatement); _localctx.conditionalStmt.setLine(((IfStatementWithReturnContext)_localctx).if_.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStmt printStmt;
		public Token print;
		public ExpressionContext expr;
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public TerminalNode PRINT() { return getToken(JepetoParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			((PrintStatementContext)_localctx).print = match(PRINT);
			setState(232);
			match(LPAR);
			setState(233);
			((PrintStatementContext)_localctx).expr = expression();
			((PrintStatementContext)_localctx).printStmt =  new PrintStmt(((PrintStatementContext)_localctx).expr.expr); _localctx.printStmt.setLine(((PrintStatementContext)_localctx).print.getLine());
			setState(235);
			match(RPAR);
			setState(236);
			match(SEMICOLLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement stmt;
		public IfStatementContext ifStmt;
		public PrintStatementContext printStmt;
		public FunctionCallStatementContext functionCallStmt;
		public ReturnStatementContext returnStmt;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(238);
				((StatementContext)_localctx).ifStmt = ifStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).ifStmt.conditionalStmt;
				}
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(241);
				((StatementContext)_localctx).printStmt = printStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).printStmt.printStmt;
				}
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(244);
				((StatementContext)_localctx).functionCallStmt = functionCallStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).functionCallStmt.functionCallStmt;
				}
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(247);
				((StatementContext)_localctx).returnStmt = returnStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).returnStmt.returnStmt;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement bodyStatement;
		public ReturnStatementContext returnStmt;
		public IfStatementWithReturnContext conditionalStmt;
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementWithReturnContext ifStatementWithReturn() {
			return getRuleContext(IfStatementWithReturnContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_singleStatement);
		try {
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(252);
				((SingleStatementContext)_localctx).returnStmt = returnStatement();
				((SingleStatementContext)_localctx).bodyStatement =  ((SingleStatementContext)_localctx).returnStmt.returnStmt;
				}
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(255);
				((SingleStatementContext)_localctx).conditionalStmt = ifStatementWithReturn();
				((SingleStatementContext)_localctx).bodyStatement =  ((SingleStatementContext)_localctx).conditionalStmt.conditionalStmt;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockStmt blockStmt;
		public Token lbrace;
		public StatementContext stmt1;
		public ReturnStatementContext returnStmt;
		public IfStatementWithReturnContext conditionalStmt;
		public StatementContext stmt2;
		public TerminalNode RBRACE() { return getToken(JepetoParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(JepetoParser.LBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementWithReturnContext ifStatementWithReturn() {
			return getRuleContext(IfStatementWithReturnContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			((BlockContext)_localctx).lbrace = match(LBRACE);
			((BlockContext)_localctx).blockStmt =  new BlockStmt();
			{
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(262);
					((BlockContext)_localctx).stmt1 = statement();
					_localctx.blockStmt.addStatement(((BlockContext)_localctx).stmt1.stmt);
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				{
				{
				setState(270);
				((BlockContext)_localctx).returnStmt = returnStatement();
				_localctx.blockStmt.addStatement(((BlockContext)_localctx).returnStmt.returnStmt);
				}
				}
				break;
			case IF:
				{
				{
				setState(273);
				((BlockContext)_localctx).conditionalStmt = ifStatementWithReturn();
				_localctx.blockStmt.addStatement(((BlockContext)_localctx).conditionalStmt.conditionalStmt);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(278);
				((BlockContext)_localctx).stmt2 = statement();
				_localctx.blockStmt.addStatement(((BlockContext)_localctx).stmt2.stmt);
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_localctx.blockStmt.setLine(((BlockContext)_localctx).lbrace.getLine());
			setState(287);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionBodyContext extends ParserRuleContext {
		public Statement bodyStatement;
		public Token lbrace;
		public StatementContext stmt1;
		public StatementContext stmt2;
		public TerminalNode RBRACE() { return getToken(JepetoParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(JepetoParser.LBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConditionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterConditionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitConditionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitConditionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionBodyContext conditionBody() throws RecognitionException {
		ConditionBodyContext _localctx = new ConditionBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionBody);
		int _la;
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				((ConditionBodyContext)_localctx).bodyStatement =  new BlockStmt();
				{
				setState(290);
				((ConditionBodyContext)_localctx).lbrace = match(LBRACE);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(291);
					((ConditionBodyContext)_localctx).stmt1 = statement();
					((BlockStmt)_localctx.bodyStatement).addStatement(((ConditionBodyContext)_localctx).stmt1.stmt);
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.bodyStatement.setLine(((ConditionBodyContext)_localctx).lbrace.getLine());
				setState(300);
				match(RBRACE);
				}
				}
				break;
			case PRINT:
			case RETURN:
			case IF:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(301);
				((ConditionBodyContext)_localctx).stmt2 = statement();
				((ConditionBodyContext)_localctx).bodyStatement =  (((ConditionBodyContext)_localctx).stmt2.stmt);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expr;
		public AndExpressionContext e1;
		public Token op;
		public AndExpressionContext e2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(JepetoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(JepetoParser.OR, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			((ExpressionContext)_localctx).e1 = andExpression();
			((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).e1.and;
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(308);
				((ExpressionContext)_localctx).op = match(OR);
				setState(309);
				((ExpressionContext)_localctx).e2 = andExpression();
				((ExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr, ((ExpressionContext)_localctx).e2.and, BinaryOperator.or); _localctx.expr.setLine(((ExpressionContext)_localctx).op.getLine());
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression and;
		public EqualityExpressionContext e1;
		public Token op;
		public EqualityExpressionContext e2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JepetoParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JepetoParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			((AndExpressionContext)_localctx).e1 = equalityExpression();
			((AndExpressionContext)_localctx).and =  ((AndExpressionContext)_localctx).e1.eq;
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(319);
				((AndExpressionContext)_localctx).op = match(AND);
				setState(320);
				((AndExpressionContext)_localctx).e2 = equalityExpression();
				((AndExpressionContext)_localctx).and =  new BinaryExpression(_localctx.and, ((AndExpressionContext)_localctx).e2.eq, BinaryOperator.and); _localctx.and.setLine(((AndExpressionContext)_localctx).op.getLine());
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression eq;
		public RelationalExpressionContext e1;
		public Token eqop;
		public RelationalExpressionContext e2;
		public Token neqop;
		public RelationalExpressionContext e3;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(JepetoParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(JepetoParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(JepetoParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(JepetoParser.NOT_EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			((EqualityExpressionContext)_localctx).e1 = relationalExpression();
			((EqualityExpressionContext)_localctx).eq =  ((EqualityExpressionContext)_localctx).e1.rel;
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL || _la==NOT_EQUAL) {
				{
				setState(338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EQUAL:
					{
					{
					setState(330);
					((EqualityExpressionContext)_localctx).eqop = match(EQUAL);
					setState(331);
					((EqualityExpressionContext)_localctx).e2 = relationalExpression();
					((EqualityExpressionContext)_localctx).eq =  new BinaryExpression(_localctx.eq, ((EqualityExpressionContext)_localctx).e2.rel, BinaryOperator.eq); _localctx.eq.setLine(((EqualityExpressionContext)_localctx).eqop.getLine());
					}
					}
					break;
				case NOT_EQUAL:
					{
					{
					setState(334);
					((EqualityExpressionContext)_localctx).neqop = match(NOT_EQUAL);
					setState(335);
					((EqualityExpressionContext)_localctx).e3 = relationalExpression();
					((EqualityExpressionContext)_localctx).eq =  new BinaryExpression(_localctx.eq, ((EqualityExpressionContext)_localctx).e3.rel, BinaryOperator.neq); _localctx.eq.setLine(((EqualityExpressionContext)_localctx).neqop.getLine());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression rel;
		public AdditiveExpressionContext e1;
		public Token gop;
		public AdditiveExpressionContext e2;
		public Token lop;
		public AdditiveExpressionContext e3;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(JepetoParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(JepetoParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(JepetoParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(JepetoParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			((RelationalExpressionContext)_localctx).e1 = additiveExpression();
			((RelationalExpressionContext)_localctx).rel =  ((RelationalExpressionContext)_localctx).e1.add;
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				setState(353);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					{
					setState(345);
					((RelationalExpressionContext)_localctx).gop = match(GREATER_THAN);
					setState(346);
					((RelationalExpressionContext)_localctx).e2 = additiveExpression();
					((RelationalExpressionContext)_localctx).rel =  new BinaryExpression(_localctx.rel, ((RelationalExpressionContext)_localctx).e2.add, BinaryOperator.gt); _localctx.rel.setLine(((RelationalExpressionContext)_localctx).gop.getLine());
					}
					}
					break;
				case LESS_THAN:
					{
					{
					setState(349);
					((RelationalExpressionContext)_localctx).lop = match(LESS_THAN);
					setState(350);
					((RelationalExpressionContext)_localctx).e3 = additiveExpression();
					((RelationalExpressionContext)_localctx).rel =  new BinaryExpression(_localctx.rel, ((RelationalExpressionContext)_localctx).e3.add, BinaryOperator.lt); _localctx.rel.setLine(((RelationalExpressionContext)_localctx).lop.getLine());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression add;
		public MultiplicativeExpressionContext e1;
		public Token pop;
		public MultiplicativeExpressionContext e2;
		public Token mop;
		public MultiplicativeExpressionContext e3;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(JepetoParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(JepetoParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(JepetoParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(JepetoParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			((AdditiveExpressionContext)_localctx).e1 = multiplicativeExpression();
			((AdditiveExpressionContext)_localctx).add =  ((AdditiveExpressionContext)_localctx).e1.mult;
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(368);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(360);
					((AdditiveExpressionContext)_localctx).pop = match(PLUS);
					setState(361);
					((AdditiveExpressionContext)_localctx).e2 = multiplicativeExpression();
					((AdditiveExpressionContext)_localctx).add =  new BinaryExpression(_localctx.add, ((AdditiveExpressionContext)_localctx).e2.mult, BinaryOperator.add); _localctx.add.setLine(((AdditiveExpressionContext)_localctx).pop.getLine());
					}
					}
					break;
				case MINUS:
					{
					{
					setState(364);
					((AdditiveExpressionContext)_localctx).mop = match(MINUS);
					setState(365);
					((AdditiveExpressionContext)_localctx).e3 = multiplicativeExpression();
					((AdditiveExpressionContext)_localctx).add =  new BinaryExpression(_localctx.add, ((AdditiveExpressionContext)_localctx).e3.mult, BinaryOperator.sub); _localctx.add.setLine(((AdditiveExpressionContext)_localctx).mop.getLine());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression mult;
		public PreUnaryExpressionContext e1;
		public Token multop;
		public PreUnaryExpressionContext e2;
		public Token dop;
		public PreUnaryExpressionContext e3;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(JepetoParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(JepetoParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(JepetoParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(JepetoParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			((MultiplicativeExpressionContext)_localctx).e1 = preUnaryExpression();
			((MultiplicativeExpressionContext)_localctx).mult =  ((MultiplicativeExpressionContext)_localctx).e1.pre;
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				setState(383);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					{
					setState(375);
					((MultiplicativeExpressionContext)_localctx).multop = match(MULT);
					setState(376);
					((MultiplicativeExpressionContext)_localctx).e2 = preUnaryExpression();
					((MultiplicativeExpressionContext)_localctx).mult =  new BinaryExpression(_localctx.mult, ((MultiplicativeExpressionContext)_localctx).e2.pre, BinaryOperator.mult); _localctx.mult.setLine(((MultiplicativeExpressionContext)_localctx).multop.getLine());
					}
					}
					break;
				case DIVIDE:
					{
					{
					setState(379);
					((MultiplicativeExpressionContext)_localctx).dop = match(DIVIDE);
					setState(380);
					((MultiplicativeExpressionContext)_localctx).e3 = preUnaryExpression();
					((MultiplicativeExpressionContext)_localctx).mult =  new BinaryExpression(_localctx.mult, ((MultiplicativeExpressionContext)_localctx).e3.pre, BinaryOperator.div); _localctx.mult.setLine(((MultiplicativeExpressionContext)_localctx).dop.getLine());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression pre;
		public UnaryOperator operator;
		public Token nop;
		public Token mop;
		public PreUnaryExpressionContext e;
		public AppendExpressionContext e2;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JepetoParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(JepetoParser.MINUS, 0); }
		public AppendExpressionContext appendExpression() {
			return getRuleContext(AppendExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_preUnaryExpression);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(392);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(388);
					((PreUnaryExpressionContext)_localctx).nop = match(NOT);
					((PreUnaryExpressionContext)_localctx).operator =  UnaryOperator.not;
					}
					break;
				case MINUS:
					{
					setState(390);
					((PreUnaryExpressionContext)_localctx).mop = match(MINUS);
					((PreUnaryExpressionContext)_localctx).operator =  UnaryOperator.minus;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(394);
				((PreUnaryExpressionContext)_localctx).e = preUnaryExpression();
				}
				((PreUnaryExpressionContext)_localctx).pre =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).e.pre, _localctx.operator); if (_localctx.operator == UnaryOperator.not) _localctx.pre.setLine(((PreUnaryExpressionContext)_localctx).nop.getLine()); if (_localctx.operator == UnaryOperator.minus) _localctx.pre.setLine(((PreUnaryExpressionContext)_localctx).mop.getLine());
				}
				break;
			case TRUE:
			case FALSE:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				((PreUnaryExpressionContext)_localctx).e2 = appendExpression();
				((PreUnaryExpressionContext)_localctx).pre =  ((PreUnaryExpressionContext)_localctx).e2.app;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppendExpressionContext extends ParserRuleContext {
		public Expression app;
		public AccessExpressionContext e1;
		public Token aop;
		public AccessExpressionContext e2;
		public List<AccessExpressionContext> accessExpression() {
			return getRuleContexts(AccessExpressionContext.class);
		}
		public AccessExpressionContext accessExpression(int i) {
			return getRuleContext(AccessExpressionContext.class,i);
		}
		public List<TerminalNode> APPEND() { return getTokens(JepetoParser.APPEND); }
		public TerminalNode APPEND(int i) {
			return getToken(JepetoParser.APPEND, i);
		}
		public AppendExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appendExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAppendExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAppendExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAppendExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendExpressionContext appendExpression() throws RecognitionException {
		AppendExpressionContext _localctx = new AppendExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_appendExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			((AppendExpressionContext)_localctx).e1 = accessExpression();
			((AppendExpressionContext)_localctx).app =  ((AppendExpressionContext)_localctx).e1.acc;
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==APPEND) {
				{
				{
				setState(405);
				((AppendExpressionContext)_localctx).aop = match(APPEND);
				setState(406);
				((AppendExpressionContext)_localctx).e2 = accessExpression();
				((AppendExpressionContext)_localctx).app =  new BinaryExpression(_localctx.app, ((AppendExpressionContext)_localctx).e2.acc, BinaryOperator.append); _localctx.app.setLine(((AppendExpressionContext)_localctx).aop.getLine());
				}
				}
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression acc;
		public OtherExpressionContext e1;
		public Token lpar;
		public FunctionArgumentsContext fArgs;
		public Token lbrac;
		public ExpressionContext e2;
		public SizeExpressionContext se;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(JepetoParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(JepetoParser.RPAR, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JepetoParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JepetoParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(JepetoParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(JepetoParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JepetoParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JepetoParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<SizeExpressionContext> sizeExpression() {
			return getRuleContexts(SizeExpressionContext.class);
		}
		public SizeExpressionContext sizeExpression(int i) {
			return getRuleContext(SizeExpressionContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_accessExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			((AccessExpressionContext)_localctx).e1 = otherExpression();
			((AccessExpressionContext)_localctx).acc =  ((AccessExpressionContext)_localctx).e1.other;
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAR) {
				{
				{
				setState(416);
				((AccessExpressionContext)_localctx).lpar = match(LPAR);
				setState(417);
				((AccessExpressionContext)_localctx).fArgs = functionArguments();
				setState(418);
				match(RPAR);
				((AccessExpressionContext)_localctx).acc =  new FunctionCall(_localctx.acc, ((AccessExpressionContext)_localctx).fArgs.args, ((AccessExpressionContext)_localctx).fArgs.argsWithKey); _localctx.acc.setLine(((AccessExpressionContext)_localctx).lpar.getLine());
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(426);
				((AccessExpressionContext)_localctx).lbrac = match(LBRACK);
				setState(427);
				((AccessExpressionContext)_localctx).e2 = expression();
				((AccessExpressionContext)_localctx).acc =  new ListAccessByIndex(_localctx.acc, ((AccessExpressionContext)_localctx).e2.expr); _localctx.acc.setLine(((AccessExpressionContext)_localctx).lbrac.getLine());
				setState(429);
				match(RBRACK);
				}
				}
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(436);
				((AccessExpressionContext)_localctx).se = sizeExpression();
				((AccessExpressionContext)_localctx).acc =  new ListSize(_localctx.acc); _localctx.acc.setLine(((AccessExpressionContext)_localctx).se.dot.getLine());
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression other;
		public ValuesContext v;
		public IdentifierContext id;
		public AnonymousFunctionContext ano;
		public ExpressionContext expr;
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnonymousFunctionContext anonymousFunction() {
			return getRuleContext(AnonymousFunctionContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_otherExpression);
		try {
			setState(459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				((OtherExpressionContext)_localctx).v = values();
				((OtherExpressionContext)_localctx).other =  ((OtherExpressionContext)_localctx).v.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(447);
				((OtherExpressionContext)_localctx).id = identifier();
				((OtherExpressionContext)_localctx).other =  ((OtherExpressionContext)_localctx).id.id;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				((OtherExpressionContext)_localctx).ano = anonymousFunction();
				((OtherExpressionContext)_localctx).other =  ((OtherExpressionContext)_localctx).ano.ano;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(453);
				match(LPAR);
				{
				setState(454);
				((OtherExpressionContext)_localctx).expr = expression();
				((OtherExpressionContext)_localctx).other =  ((OtherExpressionContext)_localctx).expr.expr;
				}
				setState(457);
				match(RPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnonymousFunctionContext extends ParserRuleContext {
		public AnonymousFunction ano;
		public FunctionArgumentsDeclarationContext funcDec;
		public BlockContext bodyStmt;
		public TerminalNode ARROW() { return getToken(JepetoParser.ARROW, 0); }
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AnonymousFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAnonymousFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAnonymousFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAnonymousFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousFunctionContext anonymousFunction() throws RecognitionException {
		AnonymousFunctionContext _localctx = new AnonymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_anonymousFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			((AnonymousFunctionContext)_localctx).funcDec = functionArgumentsDeclaration();
			setState(462);
			match(ARROW);
			setState(463);
			((AnonymousFunctionContext)_localctx).bodyStmt = block();
			((AnonymousFunctionContext)_localctx).ano =  new AnonymousFunction(((AnonymousFunctionContext)_localctx).funcDec.args); _localctx.ano.setBody(((AnonymousFunctionContext)_localctx).bodyStmt.blockStmt); _localctx.ano.setLine(((AnonymousFunctionContext)_localctx).funcDec.lpar.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeExpressionContext extends ParserRuleContext {
		public Token dot;
		public Token d;
		public TerminalNode SIZE() { return getToken(JepetoParser.SIZE, 0); }
		public TerminalNode DOT() { return getToken(JepetoParser.DOT, 0); }
		public SizeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSizeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSizeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSizeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeExpressionContext sizeExpression() throws RecognitionException {
		SizeExpressionContext _localctx = new SizeExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sizeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			((SizeExpressionContext)_localctx).d = match(DOT);
			((SizeExpressionContext)_localctx).dot =  ((SizeExpressionContext)_localctx).d;
			setState(468);
			match(SIZE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public Value value;
		public BoolValueContext bool;
		public Token str;
		public Token int_;
		public ListValueContext list;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode STRING_VALUE() { return getToken(JepetoParser.STRING_VALUE, 0); }
		public TerminalNode INT_VALUE() { return getToken(JepetoParser.INT_VALUE, 0); }
		public ListValueContext listValue() {
			return getRuleContext(ListValueContext.class,0);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_values);
		try {
			setState(480);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				((ValuesContext)_localctx).bool = boolValue();
				((ValuesContext)_localctx).value =  ((ValuesContext)_localctx).bool.bool;
				}
				break;
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				((ValuesContext)_localctx).str = match(STRING_VALUE);
				((ValuesContext)_localctx).value =  new StringValue((((ValuesContext)_localctx).str!=null?((ValuesContext)_localctx).str.getText():null)); _localctx.value.setLine(((ValuesContext)_localctx).str.getLine());
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				((ValuesContext)_localctx).int_ = match(INT_VALUE);
				((ValuesContext)_localctx).value =  new IntValue((((ValuesContext)_localctx).int_!=null?Integer.valueOf(((ValuesContext)_localctx).int_.getText()):0)); _localctx.value.setLine(((ValuesContext)_localctx).int_.getLine());
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(477);
				((ValuesContext)_localctx).list = listValue();
				((ValuesContext)_localctx).value =  ((ValuesContext)_localctx).list.list;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListValueContext extends ParserRuleContext {
		public ListValue list;
		public Token lbrac;
		public SplitedExpressionsWithCommaContext serial;
		public TerminalNode RBRACK() { return getToken(JepetoParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(JepetoParser.LBRACK, 0); }
		public SplitedExpressionsWithCommaContext splitedExpressionsWithComma() {
			return getRuleContext(SplitedExpressionsWithCommaContext.class,0);
		}
		public ListValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterListValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitListValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListValueContext listValue() throws RecognitionException {
		ListValueContext _localctx = new ListValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_listValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			((ListValueContext)_localctx).lbrac = match(LBRACK);
			setState(483);
			((ListValueContext)_localctx).serial = splitedExpressionsWithComma();
			((ListValueContext)_localctx).list =  new ListValue(((ListValueContext)_localctx).serial.args); _localctx.list.setLine(((ListValueContext)_localctx).lbrac.getLine());
			setState(485);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public BoolValue bool;
		public Token true_;
		public Token false_;
		public TerminalNode TRUE() { return getToken(JepetoParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JepetoParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_boolValue);
		try {
			setState(491);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				((BoolValueContext)_localctx).true_ = match(TRUE);
				((BoolValueContext)_localctx).bool =  new BoolValue(true); _localctx.bool.setLine(((BoolValueContext)_localctx).true_.getLine());
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				((BoolValueContext)_localctx).false_ = match(FALSE);
				((BoolValueContext)_localctx).bool =  new BoolValue(false); _localctx.bool.setLine(((BoolValueContext)_localctx).false_.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidValueContext extends ParserRuleContext {
		public VoidValue void_;
		public Token v;
		public TerminalNode VOID() { return getToken(JepetoParser.VOID, 0); }
		public VoidValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterVoidValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitVoidValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitVoidValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidValueContext voidValue() throws RecognitionException {
		VoidValueContext _localctx = new VoidValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_voidValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			((VoidValueContext)_localctx).v = match(VOID);
			((VoidValueContext)_localctx).void_ =  new VoidValue(); _localctx.void_.setLine(((VoidValueContext)_localctx).v.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier id;
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(JepetoParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			((IdentifierContext)_localctx).name = match(IDENTIFIER);
			((IdentifierContext)_localctx).id =  new Identifier((((IdentifierContext)_localctx).name!=null?((IdentifierContext)_localctx).name.getText():null)); _localctx.id.setLine(((IdentifierContext)_localctx).name.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u01f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3S\n\3"+
		"\f\3\16\3V\13\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3^\n\3\f\3\16\3a\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5s\n\5\f"+
		"\5\16\5v\13\5\5\5x\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0082\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\u0098\n\b\f\b\16\b\u009b\13\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a8\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b1"+
		"\n\n\f\n\16\n\u00b4\13\n\5\n\u00b6\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00c3\n\13\f\13\16\13\u00c6\13\13\5\13\u00c8"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00d1\n\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00dd\n\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00fd\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0105\n\22\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u010c\n\23\f\23\16\23\u010f\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0117\n\23\3\23\3\23\3\23\7\23\u011c\n\23\f\23\16\23\u011f\13\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u0129\n\24\f\24\16\24\u012c\13"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u0133\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u013b\n\25\f\25\16\25\u013e\13\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u0146\n\26\f\26\16\26\u0149\13\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\7\27\u0155\n\27\f\27\16\27\u0158\13\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0164\n\30\f\30\16"+
		"\30\u0167\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0173\n\31\f\31\16\31\u0176\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0182\n\32\f\32\16\32\u0185\13\32\3\33\3\33\3\33"+
		"\3\33\5\33\u018b\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0194\n"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u019c\n\34\f\34\16\34\u019f\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01a8\n\35\f\35\16\35\u01ab"+
		"\13\35\3\35\3\35\3\35\3\35\3\35\7\35\u01b2\n\35\f\35\16\35\u01b5\13\35"+
		"\3\35\3\35\3\35\7\35\u01ba\n\35\f\35\16\35\u01bd\13\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01ce"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\5!\u01e3\n!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\5#\u01ee\n#\3$\3$\3$\3"+
		"%\3%\3%\3%\2\2&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFH\2\2\2\u01ff\2J\3\2\2\2\4N\3\2\2\2\6b\3\2\2\2\bi\3\2\2"+
		"\2\n\u0081\3\2\2\2\f\u0083\3\2\2\2\16\u0090\3\2\2\2\20\u00a7\3\2\2\2\22"+
		"\u00a9\3\2\2\2\24\u00b7\3\2\2\2\26\u00c9\3\2\2\2\30\u00cd\3\2\2\2\32\u00d5"+
		"\3\2\2\2\34\u00e0\3\2\2\2\36\u00e9\3\2\2\2 \u00fc\3\2\2\2\"\u0104\3\2"+
		"\2\2$\u0106\3\2\2\2&\u0132\3\2\2\2(\u0134\3\2\2\2*\u013f\3\2\2\2,\u014a"+
		"\3\2\2\2.\u0159\3\2\2\2\60\u0168\3\2\2\2\62\u0177\3\2\2\2\64\u0193\3\2"+
		"\2\2\66\u0195\3\2\2\28\u01a0\3\2\2\2:\u01cd\3\2\2\2<\u01cf\3\2\2\2>\u01d4"+
		"\3\2\2\2@\u01e2\3\2\2\2B\u01e4\3\2\2\2D\u01ed\3\2\2\2F\u01ef\3\2\2\2H"+
		"\u01f2\3\2\2\2JK\5\4\3\2KL\7\2\2\3LM\b\2\1\2M\3\3\2\2\2NT\b\3\1\2OP\5"+
		"\6\4\2PQ\b\3\1\2QS\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3"+
		"\2\2\2VT\3\2\2\2WX\5\f\7\2XY\b\3\1\2Y_\3\2\2\2Z[\5\6\4\2[\\\b\3\1\2\\"+
		"^\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\5\3\2\2\2a_\3\2\2\2"+
		"bc\7\3\2\2cd\5H%\2de\5\b\5\2ef\7#\2\2fg\5\n\6\2gh\b\4\1\2h\7\3\2\2\2i"+
		"j\b\5\1\2jk\7\33\2\2kw\b\5\1\2lm\5H%\2mt\b\5\1\2no\7!\2\2op\5H%\2pq\b"+
		"\5\1\2qs\3\2\2\2rn\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3"+
		"\2\2\2wl\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\34\2\2z\t\3\2\2\2{|\5\"\22\2"+
		"|}\b\6\1\2}\u0082\3\2\2\2~\177\5$\23\2\177\u0080\b\6\1\2\u0080\u0082\3"+
		"\2\2\2\u0081{\3\2\2\2\u0081~\3\2\2\2\u0082\13\3\2\2\2\u0083\u0084\7\4"+
		"\2\2\u0084\u0085\b\7\1\2\u0085\u008c\7#\2\2\u0086\u0087\5\26\f\2\u0087"+
		"\u0088\b\7\1\2\u0088\u008d\3\2\2\2\u0089\u008a\5\36\20\2\u008a\u008b\b"+
		"\7\1\2\u008b\u008d\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\b\7\1\2\u008f\r\3\2\2\2\u0090\u0091\5H%\2\u0091"+
		"\u0099\b\b\1\2\u0092\u0093\7\33\2\2\u0093\u0094\5\20\t\2\u0094\u0095\7"+
		"\34\2\2\u0095\u0096\b\b\1\2\u0096\u0098\3\2\2\2\u0097\u0092\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\33\2\2\u009d\u009e\5\20\t\2\u009e"+
		"\u009f\7\34\2\2\u009f\u00a0\b\b\1\2\u00a0\17\3\2\2\2\u00a1\u00a2\5\22"+
		"\n\2\u00a2\u00a3\b\t\1\2\u00a3\u00a8\3\2\2\2\u00a4\u00a5\5\24\13\2\u00a5"+
		"\u00a6\b\t\1\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a4\3\2"+
		"\2\2\u00a8\21\3\2\2\2\u00a9\u00b5\b\n\1\2\u00aa\u00ab\5(\25\2\u00ab\u00b2"+
		"\b\n\1\2\u00ac\u00ad\7!\2\2\u00ad\u00ae\5(\25\2\u00ae\u00af\b\n\1\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00aa\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00c7\b\13\1"+
		"\2\u00b8\u00b9\5H%\2\u00b9\u00ba\7\32\2\2\u00ba\u00bb\5(\25\2\u00bb\u00c4"+
		"\b\13\1\2\u00bc\u00bd\7!\2\2\u00bd\u00be\5H%\2\u00be\u00bf\7\32\2\2\u00bf"+
		"\u00c0\5(\25\2\u00c0\u00c1\b\13\1\2\u00c1\u00c3\3\2\2\2\u00c2\u00bc\3"+
		"\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\25\3\2\2\2\u00c9\u00ca\5\16\b\2\u00ca\u00cb\b\f\1\2\u00cb\u00cc"+
		"\7$\2\2\u00cc\27\3\2\2\2\u00cd\u00d0\7\7\2\2\u00ce\u00d1\5(\25\2\u00cf"+
		"\u00d1\5F$\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2"+
		"\2\u00d2\u00d3\b\r\1\2\u00d3\u00d4\7$\2\2\u00d4\31\3\2\2\2\u00d5\u00d6"+
		"\7\t\2\2\u00d6\u00d7\5(\25\2\u00d7\u00d8\7#\2\2\u00d8\u00dc\5&\24\2\u00d9"+
		"\u00da\7\n\2\2\u00da\u00db\7#\2\2\u00db\u00dd\5&\24\2\u00dc\u00d9\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\16\1\2\u00df"+
		"\33\3\2\2\2\u00e0\u00e1\7\t\2\2\u00e1\u00e2\5(\25\2\u00e2\u00e3\7#\2\2"+
		"\u00e3\u00e4\5\n\6\2\u00e4\u00e5\7\n\2\2\u00e5\u00e6\7#\2\2\u00e6\u00e7"+
		"\5\n\6\2\u00e7\u00e8\b\17\1\2\u00e8\35\3\2\2\2\u00e9\u00ea\7\6\2\2\u00ea"+
		"\u00eb\7\33\2\2\u00eb\u00ec\5(\25\2\u00ec\u00ed\b\20\1\2\u00ed\u00ee\7"+
		"\34\2\2\u00ee\u00ef\7$\2\2\u00ef\37\3\2\2\2\u00f0\u00f1\5\32\16\2\u00f1"+
		"\u00f2\b\21\1\2\u00f2\u00fd\3\2\2\2\u00f3\u00f4\5\36\20\2\u00f4\u00f5"+
		"\b\21\1\2\u00f5\u00fd\3\2\2\2\u00f6\u00f7\5\26\f\2\u00f7\u00f8\b\21\1"+
		"\2\u00f8\u00fd\3\2\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fb\b\21\1\2\u00fb"+
		"\u00fd\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f3\3\2\2\2\u00fc\u00f6\3\2"+
		"\2\2\u00fc\u00f9\3\2\2\2\u00fd!\3\2\2\2\u00fe\u00ff\5\30\r\2\u00ff\u0100"+
		"\b\22\1\2\u0100\u0105\3\2\2\2\u0101\u0102\5\34\17\2\u0102\u0103\b\22\1"+
		"\2\u0103\u0105\3\2\2\2\u0104\u00fe\3\2\2\2\u0104\u0101\3\2\2\2\u0105#"+
		"\3\2\2\2\u0106\u0107\7\37\2\2\u0107\u010d\b\23\1\2\u0108\u0109\5 \21\2"+
		"\u0109\u010a\b\23\1\2\u010a\u010c\3\2\2\2\u010b\u0108\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0116\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\5\30\r\2\u0111\u0112\b\23\1\2\u0112\u0117\3"+
		"\2\2\2\u0113\u0114\5\34\17\2\u0114\u0115\b\23\1\2\u0115\u0117\3\2\2\2"+
		"\u0116\u0110\3\2\2\2\u0116\u0113\3\2\2\2\u0117\u011d\3\2\2\2\u0118\u0119"+
		"\5 \21\2\u0119\u011a\b\23\1\2\u011a\u011c\3\2\2\2\u011b\u0118\3\2\2\2"+
		"\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\b\23\1\2\u0121\u0122\7 \2\2\u0122"+
		"%\3\2\2\2\u0123\u0124\b\24\1\2\u0124\u012a\7\37\2\2\u0125\u0126\5 \21"+
		"\2\u0126\u0127\b\24\1\2\u0127\u0129\3\2\2\2\u0128\u0125\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012d\u012e\b\24\1\2\u012e\u0133\7 \2\2\u012f"+
		"\u0130\5 \21\2\u0130\u0131\b\24\1\2\u0131\u0133\3\2\2\2\u0132\u0123\3"+
		"\2\2\2\u0132\u012f\3\2\2\2\u0133\'\3\2\2\2\u0134\u0135\5*\26\2\u0135\u013c"+
		"\b\25\1\2\u0136\u0137\7\24\2\2\u0137\u0138\5*\26\2\u0138\u0139\b\25\1"+
		"\2\u0139\u013b\3\2\2\2\u013a\u0136\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d)\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0140\5,\27\2\u0140\u0147\b\26\1\2\u0141\u0142\7\23\2\2\u0142\u0143\5"+
		",\27\2\u0143\u0144\b\26\1\2\u0144\u0146\3\2\2\2\u0145\u0141\3\2\2\2\u0146"+
		"\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148+\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u014a\u014b\5.\30\2\u014b\u0156\b\27\1\2\u014c\u014d"+
		"\7\17\2\2\u014d\u014e\5.\30\2\u014e\u014f\b\27\1\2\u014f\u0155\3\2\2\2"+
		"\u0150\u0151\7\20\2\2\u0151\u0152\5.\30\2\u0152\u0153\b\27\1\2\u0153\u0155"+
		"\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u0150\3\2\2\2\u0155\u0158\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157-\3\2\2\2\u0158\u0156\3\2\2\2"+
		"\u0159\u015a\5\60\31\2\u015a\u0165\b\30\1\2\u015b\u015c\7\21\2\2\u015c"+
		"\u015d\5\60\31\2\u015d\u015e\b\30\1\2\u015e\u0164\3\2\2\2\u015f\u0160"+
		"\7\22\2\2\u0160\u0161\5\60\31\2\u0161\u0162\b\30\1\2\u0162\u0164\3\2\2"+
		"\2\u0163\u015b\3\2\2\2\u0163\u015f\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166/\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u0169\5\62\32\2\u0169\u0174\b\31\1\2\u016a\u016b\7\13\2\2\u016b\u016c"+
		"\5\62\32\2\u016c\u016d\b\31\1\2\u016d\u0173\3\2\2\2\u016e\u016f\7\f\2"+
		"\2\u016f\u0170\5\62\32\2\u0170\u0171\b\31\1\2\u0171\u0173\3\2\2\2\u0172"+
		"\u016a\3\2\2\2\u0172\u016e\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175\61\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178"+
		"\5\64\33\2\u0178\u0183\b\32\1\2\u0179\u017a\7\r\2\2\u017a\u017b\5\64\33"+
		"\2\u017b\u017c\b\32\1\2\u017c\u0182\3\2\2\2\u017d\u017e\7\16\2\2\u017e"+
		"\u017f\5\64\33\2\u017f\u0180\b\32\1\2\u0180\u0182\3\2\2\2\u0181\u0179"+
		"\3\2\2\2\u0181\u017d\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\63\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\25\2"+
		"\2\u0187\u018b\b\33\1\2\u0188\u0189\7\f\2\2\u0189\u018b\b\33\1\2\u018a"+
		"\u0186\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\5\64"+
		"\33\2\u018d\u018e\3\2\2\2\u018e\u018f\b\33\1\2\u018f\u0194\3\2\2\2\u0190"+
		"\u0191\5\66\34\2\u0191\u0192\b\33\1\2\u0192\u0194\3\2\2\2\u0193\u018a"+
		"\3\2\2\2\u0193\u0190\3\2\2\2\u0194\65\3\2\2\2\u0195\u0196\58\35\2\u0196"+
		"\u019d\b\34\1\2\u0197\u0198\7\26\2\2\u0198\u0199\58\35\2\u0199\u019a\b"+
		"\34\1\2\u019a\u019c\3\2\2\2\u019b\u0197\3\2\2\2\u019c\u019f\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\67\3\2\2\2\u019f\u019d\3\2\2"+
		"\2\u01a0\u01a1\5:\36\2\u01a1\u01a9\b\35\1\2\u01a2\u01a3\7\33\2\2\u01a3"+
		"\u01a4\5\20\t\2\u01a4\u01a5\7\34\2\2\u01a5\u01a6\b\35\1\2\u01a6\u01a8"+
		"\3\2\2\2\u01a7\u01a2\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9"+
		"\u01aa\3\2\2\2\u01aa\u01b3\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad\7\35"+
		"\2\2\u01ad\u01ae\5(\25\2\u01ae\u01af\b\35\1\2\u01af\u01b0\7\36\2\2\u01b0"+
		"\u01b2\3\2\2\2\u01b1\u01ac\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01bb\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6"+
		"\u01b7\5> \2\u01b7\u01b8\b\35\1\2\u01b8\u01ba\3\2\2\2\u01b9\u01b6\3\2"+
		"\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"9\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\5@!\2\u01bf\u01c0\b\36\1\2\u01c0"+
		"\u01ce\3\2\2\2\u01c1\u01c2\5H%\2\u01c2\u01c3\b\36\1\2\u01c3\u01ce\3\2"+
		"\2\2\u01c4\u01c5\5<\37\2\u01c5\u01c6\b\36\1\2\u01c6\u01ce\3\2\2\2\u01c7"+
		"\u01c8\7\33\2\2\u01c8\u01c9\5(\25\2\u01c9\u01ca\b\36\1\2\u01ca\u01cb\3"+
		"\2\2\2\u01cb\u01cc\7\34\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01be\3\2\2\2\u01cd"+
		"\u01c1\3\2\2\2\u01cd\u01c4\3\2\2\2\u01cd\u01c7\3\2\2\2\u01ce;\3\2\2\2"+
		"\u01cf\u01d0\5\b\5\2\u01d0\u01d1\7\31\2\2\u01d1\u01d2\5$\23\2\u01d2\u01d3"+
		"\b\37\1\2\u01d3=\3\2\2\2\u01d4\u01d5\7\"\2\2\u01d5\u01d6\b \1\2\u01d6"+
		"\u01d7\7\5\2\2\u01d7?\3\2\2\2\u01d8\u01d9\5D#\2\u01d9\u01da\b!\1\2\u01da"+
		"\u01e3\3\2\2\2\u01db\u01dc\7\'\2\2\u01dc\u01e3\b!\1\2\u01dd\u01de\7%\2"+
		"\2\u01de\u01e3\b!\1\2\u01df\u01e0\5B\"\2\u01e0\u01e1\b!\1\2\u01e1\u01e3"+
		"\3\2\2\2\u01e2\u01d8\3\2\2\2\u01e2\u01db\3\2\2\2\u01e2\u01dd\3\2\2\2\u01e2"+
		"\u01df\3\2\2\2\u01e3A\3\2\2\2\u01e4\u01e5\7\35\2\2\u01e5\u01e6\5\22\n"+
		"\2\u01e6\u01e7\b\"\1\2\u01e7\u01e8\7\36\2\2\u01e8C\3\2\2\2\u01e9\u01ea"+
		"\7\27\2\2\u01ea\u01ee\b#\1\2\u01eb\u01ec\7\30\2\2\u01ec\u01ee\b#\1\2\u01ed"+
		"\u01e9\3\2\2\2\u01ed\u01eb\3\2\2\2\u01eeE\3\2\2\2\u01ef\u01f0\7\b\2\2"+
		"\u01f0\u01f1\b$\1\2\u01f1G\3\2\2\2\u01f2\u01f3\7&\2\2\u01f3\u01f4\b%\1"+
		"\2\u01f4I\3\2\2\2*T_tw\u0081\u008c\u0099\u00a7\u00b2\u00b5\u00c4\u00c7"+
		"\u00d0\u00dc\u00fc\u0104\u010d\u0116\u011d\u012a\u0132\u013c\u0147\u0154"+
		"\u0156\u0163\u0165\u0172\u0174\u0181\u0183\u018a\u0193\u019d\u01a9\u01b3"+
		"\u01bb\u01cd\u01e2\u01ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}