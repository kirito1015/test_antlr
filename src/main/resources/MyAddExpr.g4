grammar MyAddExpr;

mystat : expr;

expr : expr op='++' expr   # AddSub
    | INT                  # int
    ;


//lexer
INT : [0-9]+ ;
ADD : '++' ;