grammar power;

prog: stat+;

stat: INT'^'INT # pow
;

INT : [0-9]+ ;
WS : [ \t]+ -> skip;