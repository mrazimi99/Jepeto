grammar Jepeto;

jepeto
	: {System.out.println("");} IDENTIFIER* EOF
	;

value:
	IDENTIFIER | INT | BOOL | STRING
	;

list
	: LBRACK (() | ((expression COMMA)*) expression) RBRACK
	;

function_arguments
	: LPRAN (() | ((expression COMMA)*) expression) RPRAN
	;
sequential_function
	: FUNCTION IDENTIFIER function_arguments COLON function_body
	;

function_body
	: multi_body | single_body
	;

single_body
	: returning_statement | ()
	;

multi_body
	: LBRACE statement* RBRACE
	;

statement
	: function_call SEMICOLON | returning_statement
	;

returning_statement
	: RETURN expression SEMICOLON | returning_condition
	;

returning_condition
	: IF expression COLON returning_statement (ELSE COLON returning_statement)?
	;

function_call
	: IDENTIFIER function_arguments
	;

expression
	: IDENTIFIER
	;

INT
	: [0-9]+
	;

BOOL
	: 'true' | 'false'
	;

STRING
	: '"' ~('"') '"'
	;

LBRACK
	: '['
	;

RBRACK
	: ']'
	;

COMMA
	: ','
	;

FUNCTION
	: 'func'
	;

LBRACE
	: '{'
	;

RBRACE
	: '}'
	;

RETURN
	: 'return'
	;

WS
	: [ \t\r\n]+ -> skip
	;

LPRAN
	: '{'
	;

RPRAN
	: '}'
	;

COLON
	: ':'
	;

SEMICOLON
	: ';'
	;

IF
	: 'if'
	;

ELSE
	: 'else'
	;

IDENTIFIER
	: [A-Za-z_] [A-Za-z0-9_]*
	;