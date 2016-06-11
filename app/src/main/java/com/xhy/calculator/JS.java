//package com.xhy.calculator;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Created by change100 on 2016/5/17.
// */
//public class JS {
//
//
//    public JS(String expressionStrs){
//
//
//
//    }
//
//    public boolean comparePrior(String s1,String s2){
//
//        if(s1.equals("*")||s1.equals("/")){
//            return true;
//        }else{
//            if(s2.equals("+")||s2.equals("-")){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public String[] getHouZhui(String expressionStrs){
//
//        String[] s = expressionStrs.split(";");
//        List<String> lts = new ArrayList<>();
//        Stack<String> st = new Stack<String>();
//        for(int i = 0; i < s.length; i++){
//
//            if("+".equals(s[i])||"-".equals(s[i])||"*".equals(s[i])||"/".equals(s[i])){
//                if(!st.isEmpty()){
//                    String pop = st.pop();
//                    if(comparePrior(pop,s[i])){
//                        lts.add(pop);
//                    } else {
//                        st.push(pop);
//                    }
//
//                }
//                st.push(s[i]);
//            } else{
//                lts.add(s[i]);
//            }
//
//        }
//        while(!st.isEmpty()) {
//            String pop = st.pop();
//            lts.add(pop);
//        }
//
//        return lts.toArray(new String[0]);
//    }
//}
