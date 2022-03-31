import com.myaddexpr.MyAddExprBaseVisitor;
import com.myaddexpr.MyAddExprLexer;
import com.myaddexpr.MyAddExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyAddExprTest {
    public static void run(String expr) throws Exception {
        // 对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream(expr);

        // 用 in 构造词法分析器 lexer，词法分析的作用是产生记号
        MyAddExprLexer lexer = new MyAddExprLexer(in);

        // 用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        MyAddExprParser parser = new MyAddExprParser(tokens);

        // 最终调用语法分析器的规则 stat，完成对表达式的验证
        ParseTree tree=parser.mystat();
        System.out.println( "\n------------------AstTree-------------------");
        System.out.println(tree.toStringTree(parser));

        // visitor 模式遍历语法树
        MyAddExprBaseVisitor visitor=new MyAddExprBaseVisitor();
        System.out.println(visitor.visit(tree));  // 输出结果为 null

        // 调用自己对 visitor
        MyAddExprVisitor myvisitor = new MyAddExprVisitor();
        System.out.println(myvisitor.visit(tree));
    }

    public static void main(String[] args) throws Exception{
        // String s= "a+b";
        String s= "1++2";
        run(s);

        MyAddExprLexer lexer_2 = new MyAddExprLexer(new ANTLRInputStream(s));
        MyAddExprParser parser_2 = new MyAddExprParser(new CommonTokenStream(lexer_2));
        MyAddExprVisitor visitor_2 = new MyAddExprVisitor();
        System.out.println(visitor_2.visit(parser_2.mystat()));
    }
}
