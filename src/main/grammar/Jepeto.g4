grammar Jepeto;

@header{
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;

    import org.antlr.v4.runtime.Token;
}

jepeto returns [Program jepetoProgram]: prog = program EOF {$jepetoProgram = $prog.prog;};

program returns [Program prog]: {$prog = new Program(); $prog.setLine(1);} (funcDec1 = functionDeclaration {$prog.addFunction($funcDec1.funcDec);})*  (mainDec = main {$prog.setMain($mainDec.mainDec);}) (funcDec2 = functionDeclaration {$prog.addFunction($funcDec2.funcDec);})*;

functionDeclaration returns [FunctionDeclaration funcDec]: f = FUNC name = identifier args = functionArgumentsDeclaration COLON bodyStmt = body {$funcDec = new FunctionDeclaration(); $funcDec.setFunctionName($name.id); $funcDec.setArgs($args.args); $funcDec.setBody($bodyStmt.bodyStatement); $funcDec.setLine($f.getLine());};

functionArgumentsDeclaration returns [ArrayList<Identifier> args, Token lpar]: {$args = new ArrayList<>();} lp = LPAR {$lpar = $lp;} (arg1 = IDENTIFIER {$args.add(new Identifier($arg1.text));} (COMMA arg2 = IDENTIFIER {if ($arg2.text != null) {$args.add(new Identifier($arg2.text));}})*)? RPAR ;

body returns [Statement bodyStatement]: (single = singleStatement {$bodyStatement = $single.bodyStatement;}) | (blockStatement = block {$bodyStatement = $blockStatement.blockStmt;});

main returns [MainDeclaration mainDec]: name = MAIN {$mainDec = new MainDeclaration();} COLON ((functionCallStmt = functionCallStatement {$mainDec.setBody($functionCallStmt.functionCallStmt);}) | (printStmt = printStatement {$mainDec.setBody($printStmt.printStmt);})) {$mainDec.setLine($name.getLine());};

functionCall returns [FunctionCall funcCall, Expression expr]: id = identifier {$expr = $id.id;} (lpar1 = LPAR funcCallArgs1 = functionArguments RPAR {$expr = new FunctionCall($expr, $funcCallArgs1.args, $funcCallArgs1.argsWithKey); $expr.setLine($lpar1.getLine());})* (lpar2 = LPAR funcCallArgs2 = functionArguments RPAR {$funcCall = new FunctionCall($expr, $funcCallArgs2.args, $funcCallArgs2.argsWithKey); $funcCall.setLine($lpar2.getLine());});

functionArguments returns [ArrayList<Expression> args, Map<Identifier, Expression> argsWithKey]: (serial = splitedExpressionsWithComma {$args = $serial.args; $argsWithKey = null;}) | (keyVal = splitedExpressionsWithCommaAndKey {$args = null; $argsWithKey = $keyVal.args;});

splitedExpressionsWithComma returns [ArrayList<Expression> args]: {$args = new ArrayList<>();} (expr1 = expression {if ($expr1.text != null) $args.add($expr1.expr);} (COMMA expr2 = expression {if ($expr2.text != null) $args.add($expr2.expr);})*)?;

splitedExpressionsWithCommaAndKey returns [Map<Identifier, Expression> args]: {$args = new HashMap<>();} (id1 = identifier ASSIGN expr1 = expression {if ($expr1.text != null) $args.put($id1.id, $expr1.expr);} (COMMA id2 = identifier ASSIGN expr2 = expression {if ($expr2.text != null) $args.put($id2.id, $expr2.expr);})*)?;

functionCallStatement returns [FunctionCallStmt functionCallStmt]: funcCall = functionCall {$functionCallStmt = new FunctionCallStmt($funcCall.funcCall); $functionCallStmt.setLine($funcCall.funcCall.getLine());} SEMICOLLON;

returnStatement returns [ReturnStmt returnStmt]: ret = RETURN (expr = expression | void_ = voidValue) {if ($void_.text == null) {$returnStmt = new ReturnStmt($expr.expr);} else {$returnStmt = new ReturnStmt();} $returnStmt.setLine($ret.getLine());} SEMICOLLON;

ifStatement returns [ConditionalStmt conditionalStmt]: if_ = IF expr = expression COLON body1 = conditionBody (else_ = ELSE COLON body2 = conditionBody)? {$conditionalStmt = new ConditionalStmt($expr.expr, $body1.bodyStatement); if ($else_.text != null) {$conditionalStmt.setElseBody($body2.bodyStatement);} $conditionalStmt.setLine($if_.getLine());};

ifStatementWithReturn returns [ConditionalStmt conditionalStmt]: if_ = IF expr = expression COLON body1 = body ELSE COLON body2 = body {$conditionalStmt = new ConditionalStmt($expr.expr, $body1.bodyStatement); $conditionalStmt.setElseBody($body2.bodyStatement); $conditionalStmt.setLine($if_.getLine());};

printStatement returns [PrintStmt printStmt]: print = PRINT LPAR expr = expression {$printStmt = new PrintStmt($expr.expr); $printStmt.setLine($print.getLine());} RPAR SEMICOLLON;

statement returns [Statement stmt]: (ifStmt = ifStatement {$stmt = $ifStmt.conditionalStmt;}) | (printStmt = printStatement {$stmt = $printStmt.printStmt;}) | (functionCallStmt = functionCallStatement {$stmt = $functionCallStmt.functionCallStmt;}) | (returnStmt = returnStatement {$stmt = $returnStmt.returnStmt;});

singleStatement returns [Statement bodyStatement]: (returnStmt = returnStatement {$bodyStatement = $returnStmt.returnStmt;}) | (conditionalStmt = ifStatementWithReturn {$bodyStatement = $conditionalStmt.conditionalStmt;});

block returns [BlockStmt blockStmt]: lbrace = LBRACE {$blockStmt = new BlockStmt();} ((stmt1 = statement {$blockStmt.addStatement($stmt1.stmt);})* ((returnStmt = returnStatement {$blockStmt.addStatement($returnStmt.returnStmt);}) | (conditionalStmt = ifStatementWithReturn {$blockStmt.addStatement($conditionalStmt.conditionalStmt);})) (stmt2 = statement {$blockStmt.addStatement($stmt2.stmt);})*) {$blockStmt.setLine($lbrace.getLine());} RBRACE;

conditionBody returns [BlockStmt bodyStatement]: {$bodyStatement = new BlockStmt();} (LBRACE (stmt1 = statement {$bodyStatement.addStatement($stmt1.stmt);})* RBRACE) | {$bodyStatement = new BlockStmt();} (stmt2 = statement {$bodyStatement.addStatement($stmt2.stmt);});

expression returns [Expression expr]: e1 = andExpression {$expr = $e1.and;} (op = OR e2 = andExpression {$expr = new BinaryExpression($expr, $e2.and, BinaryOperator.or); $expr.setLine($op.getLine());})*;

andExpression returns [Expression and]: e1 = equalityExpression {$and = $e1.eq;} (op = AND e2 = equalityExpression {$and = new BinaryExpression($and, $e2.eq, BinaryOperator.and); $and.setLine($op.getLine());})*;

equalityExpression returns [Expression eq]: e1 = relationalExpression {$eq = $e1.rel;} ((eqop = EQUAL e2 = relationalExpression {$eq = new BinaryExpression($eq, $e2.rel, BinaryOperator.eq); $eq.setLine($eqop.getLine());}) | (neqop = NOT_EQUAL e3 = relationalExpression {$eq = new BinaryExpression($eq, $e3.rel, BinaryOperator.neq); $eq.setLine($neqop.getLine());}))*;

relationalExpression returns [Expression rel]: e1 = additiveExpression {$rel = $e1.add;} ((gop = GREATER_THAN e2 = additiveExpression {$rel = new BinaryExpression($rel, $e2.add, BinaryOperator.gt); $rel.setLine($gop.getLine());}) | (lop = LESS_THAN e3 = additiveExpression {$rel = new BinaryExpression($rel, $e3.add, BinaryOperator.lt); $rel.setLine($lop.getLine());}))*;

additiveExpression returns [Expression add]: e1 = multiplicativeExpression {$add = $e1.mult;} ((pop = PLUS e2 = multiplicativeExpression {$add = new BinaryExpression($add, $e2.mult, BinaryOperator.add); $add.setLine($pop.getLine());}) | (mop = MINUS e3 = multiplicativeExpression {$add = new BinaryExpression($add, $e3.mult, BinaryOperator.sub); $add.setLine($mop.getLine());}))*;

multiplicativeExpression returns [Expression mult]: e1 = preUnaryExpression {$mult = $e1.pre;} ((multop = MULT e2 = preUnaryExpression {$mult = new BinaryExpression($mult, $e2.pre, BinaryOperator.mult); $mult.setLine($multop.getLine());}) | (dop = DIVIDE e3 = preUnaryExpression {$mult = new BinaryExpression($mult, $e3.pre, BinaryOperator.div); $mult.setLine($dop.getLine());}))*;

preUnaryExpression returns [Expression pre, UnaryOperator operator]: ((nop = NOT {$operator = UnaryOperator.not;} | mop = MINUS {$operator = UnaryOperator.minus;}) e = preUnaryExpression) {$pre = new UnaryExpression($e.pre, $operator); if ($operator == UnaryOperator.not) $pre.setLine($nop.getLine()); if ($operator == UnaryOperator.minus) $pre.setLine($mop.getLine());} | e2 = appendExpression {$pre = $e2.app;};

appendExpression returns [Expression app]: e1 = accessExpression {$app = $e1.acc;} (aop = APPEND e2 = accessExpression {$app = new BinaryExpression($app, $e2.acc, BinaryOperator.append); $app.setLine($aop.getLine());})*;

accessExpression returns [Expression acc]: e1 = otherExpression {$acc = $e1.other;} (lpar = LPAR fArgs = functionArguments RPAR {$acc = new FunctionCall($acc, $fArgs.args, $fArgs.argsWithKey); $acc.setLine($lpar.getLine());})* (lbrac = LBRACK e2 = expression {$acc = new ListAccessByIndex($acc, $e2.expr); $acc.setLine($lbrac.getLine());} RBRACK)* (se = sizeExpression {$acc = new ListSize($acc); $acc.setLine($se.dot.getLine());})*;

otherExpression returns [Expression other]: v = values {$other = $v.value;} | id = identifier {$other = $id.id;} | ano = anonymousFunction {$other = $ano.ano;} | LPAR (expr = expression {$other = $expr.expr;}) RPAR;

anonymousFunction returns [AnonymousFunction ano]: funcDec = functionArgumentsDeclaration ARROW bodyStmt = block {$ano = new AnonymousFunction($funcDec.args); $ano.setBody($bodyStmt.blockStmt); $ano.setLine($funcDec.lpar.getLine());};

sizeExpression returns [Token dot]: d = DOT {$dot = $d;} SIZE;

values returns [Value value]: bool = boolValue {$value = $bool.bool;} | str = STRING_VALUE {$value = new StringValue($str.text); $value.setLine($str.getLine());} | int_ = INT_VALUE {$value = new IntValue($int_.int); $value.setLine($int_.getLine());} | list = listValue {$value = $list.list;};

listValue returns [ListValue list]: lbrac = LBRACK serial = splitedExpressionsWithComma {$list = new ListValue($serial.args); $list.setLine($lbrac.getLine());} RBRACK;

boolValue returns [BoolValue bool]: true_ = TRUE {$bool = new BoolValue(true); $bool.setLine($true_.getLine());} | false_ = FALSE {$bool = new BoolValue(false); $bool.setLine($false_.getLine());};

voidValue returns [VoidValue void_]: v = VOID {$void_ = new VoidValue(); $void_.setLine($v.getLine());};

identifier returns [Identifier id]: name = IDENTIFIER {$id = new Identifier($name.text); $id.setLine($name.getLine());};


FUNC: 'func';
MAIN: 'main';
SIZE: 'size';

PRINT: 'print';
RETURN: 'return';
VOID: 'void';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';

EQUAL: 'is';
NOT_EQUAL: 'not';
GREATER_THAN: '>';
LESS_THAN: '<';

AND: 'and';
OR: 'or';
NOT: '~';

APPEND: '::';

TRUE: 'true';
FALSE: 'false';

ARROW: '->';

ASSIGN: '=';

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;
STRING_VALUE: '"'~["]*'"';
COMMENT: ('#' ~( '\r' | '\n')*) -> skip;
WS: ([ \t\n\r]) -> skip;
