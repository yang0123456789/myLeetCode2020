package com.LeetCode_jianzhioffer.LeftRotateString43;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 14:47
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length()<=n) return  str;
        String str1=str.substring(0,n);
        String str2= str.substring(n,str.length());

        return str2+str1;

    }
}
