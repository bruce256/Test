
grammar El;

program: (stat ';') +;

// 数学运算
stat:  stat '*' stat     # Multiply
        | stat '/' stat     # Divide
        | stat '+' stat         # Add
        | stat '-' stat     # Subtract
        | '(' stat ')'      # parenthesis
        | ID '=' stat       # assign
        | ID                # id
        | NUM               # num
        ;


ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
ID : [a-zA-Z]+ ;
NUM : [0-9]+ ;
SEMICOLON : ';';
WS : [ \t]+ -> skip;