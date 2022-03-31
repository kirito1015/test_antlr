import com.myaddexpr.MyAddExprBaseVisitor;
import com.myaddexpr.MyAddExprParser;

public class MyAddExprVisitor extends MyAddExprBaseVisitor<Integer> {
    @Override
    public Integer visitMystat(MyAddExprParser.MystatContext ctx) {
        Integer value=visitChildren(ctx);
        return value;
    }
    @Override
    public Integer visitAddSub(MyAddExprParser.AddSubContext ctx) {
        System.out.println("=====visit add sub ==== ");
        Integer left=visit(ctx.expr(0));        //获取左边表达式最终值
        Integer right=visit(ctx.expr(1));       //获取右边表达式最终值
        return left+right;
    }
    @Override public Integer visitInt(MyAddExprParser.IntContext ctx) {
        System.out.println("===visit int == ");
        return Integer.parseInt(ctx.INT().getText());
    }
}
