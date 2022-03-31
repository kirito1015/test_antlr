// Generated from /Users/work/test_antlr/src/main/resources/MyAddExpr.g4 by ANTLR 4.9.2
package com.myaddexpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyAddExprParser}.
 */
public interface MyAddExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyAddExprParser#mystat}.
	 * @param ctx the parse tree
	 */
	void enterMystat(MyAddExprParser.MystatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyAddExprParser#mystat}.
	 * @param ctx the parse tree
	 */
	void exitMystat(MyAddExprParser.MystatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MyAddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(MyAddExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MyAddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(MyAddExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MyAddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(MyAddExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MyAddExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(MyAddExprParser.IntContext ctx);
}