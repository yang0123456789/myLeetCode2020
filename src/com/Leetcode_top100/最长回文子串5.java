package com.Leetcode_top100;

import java.util.logging.XMLFormatter;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/3 10:47
 * # @version 1.0
 * # @File : 最长回文子串5.java
 * # @Software: IntelliJ IDEA
 */
public class 最长回文子串5 {
    class Solution {
        //暴力解法
        public String longestPalindrome(String s) {
            int len =s.length();
            if (len<2) return s;
            int maxLen=1;
            int begin=0;
            char[] chars = s.toCharArray();
            for(int i=0;i<len ;i++){
                for(int j=i+1;j<len ; j++){
                    if (j-i+1>maxLen&&isPalindrome(chars,i,j)){
                        maxLen=j-i+1;
                        begin=i;
                    }
                }
            }
            return s.substring(begin,begin+maxLen);

        }

        public boolean isPalindrome(char[] chars, int left, int right) {
            while (left<right){
                if (chars[left]!=chars[right]){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }


    class Solution2 {
        //中心扩散法
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);//回文中心是一个字符串 bab这种
                int len2 = expandAroundCenter(s, i, i + 1);//回文中心是两个字符串 baab这种
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);

        }
        public int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;


        }

    }
    class Solution3 {
        //中心扩散法
        public String longestPalindrome(String s) {
            int len=s.length();
            if (len<2) return s;

            boolean[][] dp=new  boolean[len][len];
            for(int i=0;i<len ;i++){
            dp[i][i]=true;
            }

            int maxlen=1;//记录最长回文子串的长度
            int start=0;//记录最长回文子串的开始位置

            //i 为行 j为列 表格中的每个值都参考了左下角的值，因此要一列一列填写上半个三角形，同时i不可能比j大，因此左下半表不用填写
            for(int j=1;j< len;j++){
                for(int i=0;i<j ;i++){
                    if (s.charAt(i)!=s.charAt(j)){
                        dp[i][j]=false;
                    }else {
                        if (j-i<3){
                            dp[i][j]=true;
                        }else {
                            dp[i][j]=dp[i+1][j-1];
                        }
                    }
                    if (dp[i][j]&&j-1+1>maxlen){
                        start=i;
                        maxlen=i-j+1;
                    }

                }

            }
            return s.substring(start,start+maxlen);

        }
    }

}
