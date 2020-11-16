package com.二刷leetcode核心题目.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 8:47
 * # @version 1.0
 * # @File : 最长回文子串_5.java
 * # @Software: IntelliJ IDEA
 */
public class 最长回文子串_5 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int len =s.length();
        int begin=0;
        int maxLen=1;//至少一个字符，也就是s的第一个
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len ;i++){
            dp[i][i]=true;
        }
        //一列一列填写,从上往下填写
        for(int j=1;j<len ;j++){
            for(int i=0;i<j ;i++){
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else {
                    //s[i+1][j-1]的长度为0或者1，也就是少于二，则dp[i+1][j-1]的值为true
                    if (j-1-(i+1)+1<=1){
                        dp[i][j]=true;
                    }
                    //s[i+1][j-1]的长度大于1
                    else {
                        dp[i][j]=dp[i+1][j-1];//左下一个dp的值，正好是一列一列填写

                    }
                }
                if (dp[i][j]==true){
                    if (j-i+1>maxLen){
                        begin=i;
                        maxLen=j-i+1;
                    }
                }
            }

        }
        return s.substring(begin,begin+maxLen);


    }
}
