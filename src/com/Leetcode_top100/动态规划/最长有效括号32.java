package com.Leetcode_top100.动态规划;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/20 22:38
 * # @version 1.0
 * # @File : 最长有效括号32.java
 * # @Software: IntelliJ IDEA
 */
public class 最长有效括号32 {
    class Solution {
        //        超出时间限制
        public int longestValidParentheses(String s) {
            int maxLen = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if ((j - i + 1) % 2 == 0 && (j - i + 1) > maxLen && isValid(s, i, j)) {
                        maxLen = (j - i + 1);
                    }
                }
            }
            return maxLen;

        }

        public boolean isValid(String s, int start, int end) {
            Stack<Character> stack = new Stack<>();
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');

                } else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    class Solution2 {


        //        超出时间限制
        public int longestValidParentheses(String s) {
            if (s.length() <= 1) return 0;
            int maxans = 0;
            int[] dp = new int[s.length()];//状态 以s.charat(i)为结尾的字符串的最大长度
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {//必须是）才能构成有效的字符串，
                    if (s.charAt(i - 1) == '(') {//他的前一个i-1位置字符是'('，肯定他俩是一对，加上i-2为结尾的有效字符串长度就是i为结尾的长度
                        dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//他的前一个i-1位置字符是'('，肯定他俩是一对，加上i-2为结尾的有效字符串长度就是i为结尾的长度
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }
    public class Solution3 {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack<>();//记录没有被匹配的‘（’的序号
            stack.push(-1);//表示从0开始遍历，
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {//将没有被匹配的‘（’的序号入栈
                    stack.push(i);
                } else {
                    stack.pop();//将被匹配的‘（’的序号出栈
                    if (stack.empty()) {//若栈为空，这个位置的“)”是多余的，将这个位置入栈，表示下一个记录位置为i+1，计算有效的子字符串的长度
                        stack.push(i);//将该位置入栈，继续进行下一个循环
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());//如果栈不为空，更新该段有效子字符串的长度，
                    }
                }
            }
            return maxans;
        }
    }
    public class Solution5 {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, maxlength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * left);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return maxlength;
        }
    }




}