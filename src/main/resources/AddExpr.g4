grammar AddExpr;

// parser
stat : expr;


expr : expr op='+' expr   # AddSub
    | INT                 # int
    ;

//lexer
INT : [0-9]+ ;
ADD : '+' ;