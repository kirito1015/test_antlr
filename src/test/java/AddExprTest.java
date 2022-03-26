import com.addexpr.AddExprBaseListener;
import com.addexpr.AddExprBaseVisitor;
import com.addexpr.AddExprLexer;
import com.addexpr.AddExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AddExprTest {
    /*
    val lexer = new SqlBaseLexer(new UpperCaseCharStream(CharStreams.fromString(command)))
    lexer.removeErrorListeners()
    lexer.addErrorListener(ParseErrorListener)

    val tokenStream = new CommonTokenStream(lexer)
    val parser = new SqlBaseParser(tokenStream)
    parser.addParseListener(PostProcessor)
    parser.addParseListener(UnclosedCommentProcessor(command, tokenStream))
    parser.removeErrorListeners()
    parser.addErrorListener(ParseErrorListener)
    parser.legacy_setops_precedence_enabled = conf.setOpsPrecedenceEnforced
    parser.legacy_exponent_literal_as_decimal_enabled = conf.exponentLiteralAsDecimalEnabled
    parser.SQL_standard_keyword_behavior = conf.ansiEnabled
    val stat=parser.singleStatement()
    println("------------------AstTree-------------------")
    println(stat.toStringTree(parser))

    astBuilder.visitSingleStatement(stat)

    *
    * */

    public static void run(String expr) throws Exception{

        //对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream(expr);

        //用 in 构造词法分析器 lexer，词法分析的作用是产生记号
        AddExprLexer lexer = new AddExprLexer(in);

        //用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        AddExprParser parser = new AddExprParser(tokens);

        //最终调用语法分析器的规则 stat，完成对表达式的验证
        ParseTree tree=parser.stat();
        System.out.println();
        System.out.println( "------------------AstTree-------------------");
        System.out.println(tree.toStringTree(parser));

        //遍历语法树
       AddExprBaseVisitor visitor=new AddExprBaseVisitor();
       visitor.visit(tree);
       System.out.println(visitor.visit(tree));


       MyAddVisitor myAddVsitor = new MyAddVisitor();
       System.out.println(myAddVsitor.visit(tree));

        //listener模式
        /*ParseTreeWalker walker = new ParseTreeWalker();
        AddExprBaseListener addExprListener=new AddExprBaseListener();
        walker.walk(addExprListener,tree);*/
    }

    public static void main(String[] args) throws Exception{
      // String s= "a+b";
     String s= "1+2";

        run(s);
    }
}