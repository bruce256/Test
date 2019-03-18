grammar power;

prog: stat;

stat: INT'^'INT # Pow
;

INT : [0-9]+ ;
WS : [ \t]+ -> skip;