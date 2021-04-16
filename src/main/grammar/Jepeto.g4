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
	: returning_statement
	;

multi_body
	: LBRACE (statement | returning_statement)* returning_statement (statement | returning_statement)* RBRACE
	;

statement
	: (function_call SEMICOLON) | conditional_statement
	;

returning_statement
	: (RETURN (expression | VOID) SEMICOLON) | full_returning_condition
	;

full_returning_condition
	: (IF expression COLON returning_statement) (ELSE COLON returning_statement)
	;

conditional_statement
	: ((IF expression COLON statement) (ELSE COLON statement)?)
	| (IF expression COLON returning_statement)
	| ((IF expression COLON statement) (ELSE COLON returning_statement))
	| ((IF expression COLON returning_statement) (ELSE COLON statement))
	;

function_call
	: (PRINT function_argument_to_call) | dynamic_call
	;

dynamic_call
	: multi_callable function_argument_to_call+
	;

multi_callable
	: IDENTIFIER | func_ptr
	;

function_argument_to_call
	: sequential_function_arguments | key_value_function_arguments
	;

sequential_function_arguments
	: LPRAN (() | (((expression COMMA)*) expression)) RPRAN
	;

key_value_function_arguments
	: LPRAN (() | (((assign_value_to_key COMMA)*) assign_value_to_key)) RPRAN
	;

assign_value_to_key
	: IDENTIFIER ASSIGN expression
	;

expression
	: (term PLUS expression) | term
	;

term
	: (factor MULTIPLY term) | factor
	;

factor
	: atomic_expression | (LPRAN expression RPRAN)
	;

atomic_expression
	: value | function_call | indexed_list | list_size | (LPRAN expression RPRAN) | IDENTIFIER
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

indexed_list
	: (indexed_list_left) indexing+
	;

indexed_list_left
	: value | function_call | IDENTIFIER | (LPRAN indexed_list RPRAN) | (LPRAN indexed_list_left RPRAN)
	;

indexing
	: LBRACK expression RBRACK
	;

func_ptr
	: LPRAN IDENTIFIER RPRAN ARROW multi_body
	;

list_size
	: (list_size_left) (DOT SIZE)+
	;

list_size_left
	: value | function_call | indexed_list | IDENTIFIER | (LPRAN list_size RPRAN) | (LPRAN list_size_left RPRAN)
	;

COMMENT
	: SHARP (~('\n'))* -> skip
	;

WS
	: [ \t\r\n]+ -> skip
	;

SHARP
	: '#'
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
	: '"' (~('"'))* '"'
	;

PRINT
	: 'print'
	;

DOT
	: '.'
	;

SIZE
	: 'size'
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
	: '('
	;

RPRAN
	: ')'
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

CONCAT
	: '::'
	;

NOT
	: '~'
	;

PLUS
	: '+'
	;

MINUS
	: '-'
	;

MULTIPLY
	: '*'
	;

DEVISION
	: '/'
	;

LESS_THAN
	: '<'
	;

GREATER_THAN
	: '>'
	;

IS_NOT
	: 'is not'
	;

AND
	: 'and'
	;

OR
	: 'or'
	;

IDENTIFIER
	: [A-Za-z_] [A-Za-z0-9_]*
	;