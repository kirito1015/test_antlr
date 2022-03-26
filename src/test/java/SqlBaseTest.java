
import com.sqlbase.SqlBaseBaseVisitor;
import com.sqlbase.SqlBaseLexer;
import com.sqlbase.SqlBaseParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SqlBaseTest {

    public static void run(String sql) throws Exception{

        //对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream(sql);

        //用 in 构造词法分析器 lexer，词法分析的作用是产生记号
        SqlBaseLexer lexer = new SqlBaseLexer(in);

        //用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        SqlBaseParser parser = new SqlBaseParser(tokens);

        //最终调用语法分析器的规则 singleStatement，完成对表达式的验证
        ParseTree tree=parser.singleStatement();
        System.out.println();
        System.out.println( "------------------AstTree-------------------");
        System.out.println(tree.toStringTree(parser));
        SqlBaseBaseVisitor visitor=new SqlBaseBaseVisitor();
        visitor.visit(tree);

    }

    public static void main(String[] args) throws Exception{
      String s= "SELECT A,B FROM C";
        run(s);
    }
}
