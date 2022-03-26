grammar CalExpr;


// parser
//最后定义 prog
//prog 可以有多个的语句，即：
prog : stat+;

//然后定义语句： stat
//语句可以使 表达式 + 换行，可以是 变量声明，也可以是 空行
stat : expr               #printExpr
    |ID '=' expr NEWLINE  #assign
    |NEWLINE              #blank
    ;

//定义表达式 ：expr 表达式可以是数字（INT），变量（ID），可以是加减乘除运算表达式，也可以是括号表达式。
expr : expr op=('+'|'-') expr   # AddSub
    | expr op=('*'|'/') expr    # MulDiv
    | ID                        # id
    | INT                       # int
    | '(' expr ')'              # parens
    ;

//lexer
ID : [a-zA-Z]+ ;  // 变量可以为大写小写字母的任意组合
INT : [0-9]+ ;  // 运算数为整数的任意组合
NEWLINE : '\r' ? '\n'; //匹配换行
WS : [ \t]+ -> skip; //跳过空格和 \t

ADD : '+' ; //乘法
SUB : '-' ; //除法
MUL : '*' ; //加法
DIV : '/' ;  //减法
