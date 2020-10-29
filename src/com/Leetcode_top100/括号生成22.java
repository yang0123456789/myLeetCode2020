package com.Leetcode_top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/3 15:27
 * # @version 1.0
 * # @File : 括号生成22.java
 * # @Software: IntelliJ IDEA
 */
public class 括号生成22 {
    //    方法一：暴力法
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList();
            generateALL(new char[2*n], 0, result);
            return result;


        }

        public void generateALL(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            }else {
                current[pos] = '(';
                generateALL(current, pos + 1, result);
                current[pos] = ')';
                generateALL(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c: current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);

        }
    }
    class Solution2 {
        //回溯法
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result,new StringBuilder(2*n),0,0,n);
            return result;

        }
        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max)
        {
            //回溯的终点
            if (cur.length()==2*max){
                ans.add(cur.toString());
                return;//一定要终止循环
            }
            //往前推进条件，只要是左边括号没有够n个都可以加
            if (open<max){
                cur.append('(');
                backtrack(ans,cur,open+1,close,max);
                cur.deleteCharAt(cur.length()-1);//将加进去的‘（’删除，相当于回溯，往下迭代
            }

            if (close<open){//右边括号不能比左边括号多，因此想进行这一步，就必须右括号比左括号小。相当于剪枝
                cur.append(')');
                backtrack(ans,cur,open,close+1,max);
                cur.deleteCharAt(cur.length()-1);//将加进去的‘）’删除，相当于回溯，往下迭代
            }
        }

    }
}
