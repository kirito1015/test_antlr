// Generated from /Users/work/test_antlr/src/main/resources/AddExpr.g4 by ANTLR 4.9.2
package com.addexpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AddExprParser}.
 */
public interface AddExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AddExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(AddExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link AddExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(AddExprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link AddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(AddExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link AddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(AddExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link AddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(AddExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link AddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(AddExprParser.IntContext ctx);
}