import com.addexpr.AddExprBaseVisitor;
import com.addexpr.AddExprParser;
public class MyAddVisitor extends AddExprBaseVisitor<Integer> {


    @Override
    public Integer visitStat(AddExprParser.StatContext ctx) {
        Integer value=visitChildren(ctx);
        return value;
    }

    @Override
    public Integer visitAddSub(AddExprParser.AddSubContext ctx) {

        Integer left=visit(ctx.expr(0));        //获取左边表达式最终值
        Integer right=visit(ctx.expr(1));       //获取右边表达式最终值

        return left+right;
    }

    @Override
    public Integer visitInt(AddExprParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

}
