package com.xhy.calculator;

/**
 * Created by change100 on 2016/5/18.
 */

import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by change100 on 2016/5/17.
 */
public class HouZhui {

    private String[] s;

    public HouZhui(String expressionStrs) {

        String s1 = getS(expressionStrs);

        s = getHouZhui(s1);

    }

    /**
     * 将所得字符串中的数字，字符之间用分号隔开
     *
     * @param s
     * @return
     */
    public String getS(String s) {

        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {

            if ('+' == c[i] || '-' == c[i] || '*' == c[i] || '/' == c[i]) {

                sb.append(";" + c[i] + ";");
            } else {
                sb.append(c[i]);
            }


        }


        return sb.toString();
    }

    /**
     * 返回计算的结果
     *
     * @return
     */
    public String getJiSuan() {


        return jisuan();
    }

    /**
     * 匹配s1，s2的优先级
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean comparePrior(String s1, String s2) {

        if (s1.equals("*") || s1.equals("/")) {
            return true;
        } else {
            if (s2.equals("+") || s2.equals("-")) {
                return true;
            }
        }

        return false;
    }


    /**
     * 得到后缀式
     *
     * @param expressionStrs
     * @return
     */
    public String[] getHouZhui(String expressionStrs) {

        String[] s = expressionStrs.split(";");
        List<String> lts = new ArrayList<>();
        Stack<String> st = new Stack<String>();
        boolean bl = true;
        for (int i = 0; i < s.length; i++) {

            if ("+".equals(s[i]) || "-".equals(s[i]) || "*".equals(s[i])
                    || "/".equals(s[i])) {
                bl = true;
                while (!st.isEmpty() && bl == true) {
                    String pop = st.pop();
                    if (comparePrior(pop, s[i])) {
                        lts.add(pop);

                    } else {
                        st.push(pop);
                        bl = false;
                    }

                }
                st.push(s[i]);
            } else {
                lts.add(s[i]);
            }

        }
        while (!st.isEmpty()) {
            String pop = st.pop();
            lts.add(pop);
        }

        return lts.toArray(new String[0]);
    }

    /**
     * 判断是否为数字，是数字则返回true
     *
     * @param s
     * @return
     */
    public boolean pdShu(String s) {

        if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
            return false;
        }

        return true;
    }

    /**
     * 根据后缀式计算结果
     *
     * @return
     */
    public String jisuan() {

        String b;
        try {
            String[] hz = s;
            Stack<String> st = new Stack<String>();
            Double n1, n2;
            // #表示没有的部分用空表示，0表示用0填
            DecimalFormat decimalFormat = new DecimalFormat("#.########");
            String str;
            for (int i = 0; i < hz.length; i++) {

                if (pdShu(hz[i])) {

                    st.add(hz[i]);

                } else {
                    if ("+".equals(hz[i])) {
                        n1 = Double.parseDouble(st.pop());
                        n2 = Double.parseDouble(st.pop());

                        str = String.valueOf(n2 + n1);
                        st.add(str);
                    } else if ("-".equals(hz[i])) {
                        n1 = Double.parseDouble(st.pop());
                        n2 = Double.parseDouble(st.pop());
                        str = String.valueOf(n2 - n1);
                        st.add(str);
                    } else if ("*".equals(hz[i])) {
                        n1 = Double.parseDouble(st.pop());
                        n2 = Double.parseDouble(st.pop());
                        str = String.valueOf(n2 * n1);
                        st.add(str);
                    } else if ("/".equals(hz[i])) {
                        n1 = Double.parseDouble(st.pop());
                        n2 = Double.parseDouble(st.pop());
                        str = String.valueOf(n2 / n1);
                        st.add(str);
                    }
                }
            }

            b = decimalFormat.format(Double.parseDouble(st.pop()));


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return b;

    }


}

