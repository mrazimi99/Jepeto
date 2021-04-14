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

sequential_function
	: FUNCTION IDENTIFIER LPRAN (() | ((expression COMMA)*) expression) RPRAN COLON function_body
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

expression
	: IDENTIFIER
	;

IDENTIFIER
	: [A-Za-z_] [A-Za-z0-9_]*
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