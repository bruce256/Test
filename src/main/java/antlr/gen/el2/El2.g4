
grammar El2;

program: (stat ';' | logicStat ';') +;

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

// 逻辑表达式
logicStat: logicStat '&&' logicStat     # And
        | logicStat '||' logicStat      # Or
        | '(' logicStat ')'             # logicParenthesis
        | relStat                            # relation
        ;

// 关系表达式
relStat : relStat '>' relStat # gt
        | relStat '<' relStat # lt
        | relStat '==' relStat # equal
        | NUM                   # relNum
        | ID # relId
        ;

ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
ID : [a-zA-Z]+ ;
NUM : [0-9]+ ;
SEMICOLON : ';';
WS : [ \t]+ -> skip;