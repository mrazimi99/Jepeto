grammar Jepeto;

jepeto
	: {System.out.println("");}
	function_definition* main function_definition* EOF
	;

main
	: MAIN COLON function_call SEMICOLON
	;

function_definition
	: FUNCTION IDENTIFIER function_definition_arguments COLON function_body
	;

function_definition_arguments
	: LPRAN (() | ((IDENTIFIER COMMA)*) IDENTIFIER) RPRAN
	;

function_body
	: single_body | multi_body
	;

single_body
	: returning_statement | ()
	;

multi_body
	: LBRACE statement* returning_statement RBRACE
	;

statement
	: function_call SEMICOLON | returning_statement
	;

returning_statement
	: RETURN (expression |  VOID) SEMICOLON | returning_condition
	;

returning_condition
	: IF expression COLON returning_statement (ELSE COLON returning_statement)?
	;

function_call
	: (PRINT | IDENTIFIER | func_ptr) sequential_function_arguments | key_value_function_arguments
	;

sequential_function_arguments
	: LPRAN (() | ((expression COMMA)*) expression) RPRAN
	;

key_value_function_arguments
	: LPRAN (() | ((assign_value_to_key COMMA)*) assign_value_to_key) RPRAN
	;

assign_value_to_key
	: IDENTIFIER ASSIGN expression
	;

expression
	: IDENTIFIER | value | function_call
	;

value
	: primitive_value | non_primitive_value
	;

primitive_value
	: INT | BOOL | STRING
	;

non_primitive_value
	: list | func_ptr
	;

list
	: LBRACK (() | ((expression COMMA)*) expression) RBRACK
	;

func_ptr
	: LPRAN IDENTIFIER RPRAN ARROW multi_body
	;

WS
	: [ \t\r\n]+ -> skip
	;

MAIN
	: 'main'
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

PRINT
	: 'print'
	;

ASSIGN
	: '='
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

VOID
	: 'void'
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

ARROW
	: '->'
	;

IDENTIFIER
	: [A-Za-z_] [A-Za-z0-9_]*
	;