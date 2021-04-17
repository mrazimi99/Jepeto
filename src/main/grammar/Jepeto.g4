grammar Jepeto;

jepeto: function_definition* main function_definition* EOF;

main: MAIN COLON {System.out.println("Main");} ((PRINT {System.out.println("Built-in : print");} sequential_function_arguments) | ({System.out.println("FunctionCall");} function_call)) SEMICOLON;

function_definition: FUNCTION IDENTIFIER {System.out.println("FunctionDec : " + $IDENTIFIER.text);} function_definition_arguments COLON function_body;

function_definition_arguments: LPRAN (() | ((IDENTIFIER COMMA {System.out.println("ArgumentDec : " + $IDENTIFIER.text);})*) IDENTIFIER {System.out.println("ArgumentDec : " + $IDENTIFIER.text);}) RPRAN;

function_body: single_body | multi_body;

single_body: returning_statement;

multi_body: LBRACE (statement | returning_statement)* returning_statement (statement | returning_statement)* RBRACE;

statement: (((PRINT {System.out.println("Built-in : print");} sequential_function_arguments) | ({System.out.println("FunctionCall");} function_call)) SEMICOLON) | conditional_statement;

returning_statement: (RETURN {System.out.println("Return");} (expression | VOID) SEMICOLON) | full_returning_condition;

full_returning_condition: (IF {System.out.println("Conditional : if");} expression COLON returning_statement) (ELSE {System.out.println("Conditional : else");} COLON returning_statement);

conditional_statement: ((IF {System.out.println("Conditional : if");} expression COLON statement) (ELSE {System.out.println("Conditional : else");} COLON statement)?)
	| (IF {System.out.println("Conditional : if");} expression COLON returning_statement)
	| ((IF {System.out.println("Conditional : if");} expression COLON statement) (ELSE {System.out.println("Conditional : else");} COLON returning_statement))
	| ((IF {System.out.println("Conditional : if");} expression COLON returning_statement) (ELSE {System.out.println("Conditional : else");} COLON statement));

function_call: dynamic_call;

dynamic_call: multi_callable ((function_argument_to_call)  | (LBRACK expression RBRACK))* function_argument_to_call+;

multi_callable: (IDENTIFIER | func_ptr);

function_argument_to_call: sequential_function_arguments | key_value_function_arguments;

sequential_function_arguments: LPRAN (() | (((expression COMMA)*) expression)) RPRAN;

key_value_function_arguments: LPRAN (() | (((assign_value_to_key COMMA)*) assign_value_to_key)) RPRAN;

assign_value_to_key: IDENTIFIER ASSIGN expression;

expression: and_expression (OR and_expression {System.out.println("Operator : or");})*;

and_expression: equality_expression (AND equality_expression {System.out.println("Operator : and");})*;

equality_expression: relational_expression (equality relational_expression {System.out.println("Operator : " + $equality.text);})*;

relational_expression: add_expression (relation add_expression {System.out.println("Operator : " + $relation.text);})*;

add_expression: multiply_expression (addition multiply_expression {System.out.println("Operator : " + $addition.text);})*;

multiply_expression: unary_expression (multiply unary_expression {System.out.println("Operator : " + $multiply.text);})*;

unary_expression: (single_operator unary_expression {System.out.println("Operator : " + $single_operator.text);}) | atomic_expression;

atomic_expression: value | function_call | indexed_list | list_size | (LPRAN expression RPRAN) | IDENTIFIER;

value: primitive_value | non_primitive_value;

primitive_value: INT | BOOL | STRING;

non_primitive_value: list | func_ptr;

list: LBRACK (() | ((expression COMMA)*) expression) RBRACK;

indexed_list: (indexed_list_left) indexing+;

indexed_list_left: value | function_call | IDENTIFIER | (LPRAN indexed_list RPRAN) | (LPRAN indexed_list_left RPRAN);

indexing: LBRACK expression RBRACK;

func_ptr: {System.out.println("Anonymous Function");} function_definition_arguments ARROW multi_body;

list_size: (list_size_left) (DOT SIZE {System.out.println("Size");})+;

list_size_left: value | function_call | indexed_list | IDENTIFIER | (LPRAN list_size RPRAN) | (LPRAN list_size_left RPRAN);

equality: EQUALS | NOT_EQUALS;
relation: GREATER_THAN | LESS_THAN;
addition: PLUS | MINUS;
multiply: MULTIPLY | DIVISION;
single_operator: NOT | MINUS;

COMMENT: ('#' (~('\r' | '\n'))*) -> skip;

WS: [ \t\r\n]+ -> skip;

MAIN: 'main';

INT: [0-9]+;

BOOL: 'true' | 'false';

STRING: '"' (~('"'))* '"';

PRINT: 'print';

DOT: '.';

SIZE: 'size';

ASSIGN: '=';

LBRACK: '[';

RBRACK: ']';

COMMA: ',';

FUNCTION: 'func';

VOID: 'void';

LBRACE: '{';

RBRACE: '}';

RETURN: 'return';

LPRAN: '(';

RPRAN: ')';

COLON: ':';

SEMICOLON: ';';

IF: 'if';

ELSE: 'else';

ARROW: '->';

CONCAT: '::';

NOT: '~';

PLUS: '+';

MINUS: '-';

MULTIPLY: '*';

DIVISION: '/';

LESS_THAN: '<';

GREATER_THAN: '>';

EQUALS: 'is';

NOT_EQUALS: 'not';

AND: 'and';

OR: 'or';

IDENTIFIER: [A-Za-z_] [A-Za-z0-9_]*;