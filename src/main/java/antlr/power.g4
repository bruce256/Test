grammar power;

prog: express SEMICOLON;

express: express '^' express    # Pow
    | '(' express ')'           # parenthesis
    | INT                       # int
    ;


INT : [0-9]+ ;
SEMICOLON : ';';
WS : [ \t]+ -> skip;