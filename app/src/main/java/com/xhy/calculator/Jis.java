package com.xhy.calculator;

/**
 * Created by change100 on 2016/5/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author lmiky
 *
 */
public class Jis {

    /**
     * 优先级比较
     * @param operator1 比较值
     * @param operator2 被比较值
     * @return 小于等于返回false,大于返回true
     */
    public boolean comparePrior(String operator1, String operator2) {
        if("(".equals(operator2)) {
            return true;
        }
        if ("*".equals(operator1) || "/".equals(operator1)) {
            if ("+".equals(operator2) || "-".equals(operator2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 转为后缀表达式:
     * 1、如果是"("直接压入stack栈。
     * 2、如果是")"，依次从stack栈弹出运算符加到数组newExpressionStrs的末尾，知道遇到"("；
     * 3、如果是非括号，比较扫描到的运算符，和stack栈顶的运算符。如果扫描到的运算符优先级高于栈顶运算符则，把运算符压入栈。否则的话，就依次把栈中运算符弹出加到数组newExpressionStrs的末尾，直到遇到优先级低于扫描到的运算符或栈空，并且把扫描到的运算符压入栈中。就这样依次扫描，知道结束为止。如果扫描结束，栈中还有元素，则依次弹出加到数组newExpressionStrs的末尾，就得到了后缀表达式。
     * @param expressionStrs
     * @return
     */
    public String[] toSuffixExpression(String[] expressionStrs) {
        //新组成的表达式
        List<String> newExpressionStrs = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < expressionStrs.length; i++) {
            if ("(".equals(expressionStrs[i])) { // 如果是左括号,则入栈
                stack.push(expressionStrs[i]);
            } else if ("+".equals(expressionStrs[i]) || "-".equals(expressionStrs[i]) || "*".equals(expressionStrs[i]) || "/".equals(expressionStrs[i])) {
                if (!stack.empty()) { // 取出先入栈的运算符
                    String s = stack.pop();
                    if(comparePrior(expressionStrs[i], s)) { //如果栈值优先级小于要入栈的值,则继续压入栈
                        stack.push(s);
                    } else {  //否则取出值
                        newExpressionStrs.add(s);
                    }
                }
                stack.push(expressionStrs[i]);
            } else if (")".equals(expressionStrs[i])) { //如果是")",则出栈,一直到遇到"("
                while (!stack.empty()) {
                    String s = stack.pop();
                    if (!"(".equals(s)) {
                        newExpressionStrs.add(s);
                    } else {
                        break;
                    }
                }
            } else {
                newExpressionStrs.add(expressionStrs[i]);
            }
        }
        while (!stack.empty()) {
            String s = stack.pop();
            newExpressionStrs.add(s);
        }
        return newExpressionStrs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        //前台传过来的字符格式,所以测试也写成这个格式
        String expressionStr = "5;+;(;4;-;5;+;1;);-;4;+;(;6;-;5;+;3;);+;2;";
        // 分割成表达式数组
        String[] expressionStrs = expressionStr.split(";");
        String[] newExpressionStrs = new Jis().toSuffixExpression(expressionStrs);
        for (int i = 0; i < newExpressionStrs.length; i++) {
            System.out.print(newExpressionStrs[i]);
        }

        System.out.println();

        expressionStr = "5;+;(;4;-;5;*;1;);-;4;/;(;6;*;5;+;3;);/;2;";
        expressionStrs = expressionStr.split(";");
        newExpressionStrs = new Jis().toSuffixExpression(expressionStrs);
        for (int i = 0; i < newExpressionStrs.length; i++) {
            System.out.print(newExpressionStrs[i]);
        }
    }
}