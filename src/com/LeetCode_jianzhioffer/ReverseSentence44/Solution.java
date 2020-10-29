package com.LeetCode_jianzhioffer.ReverseSentence44;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 10:42
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().isEmpty()||str.equals((""))) return str;
//        char[] chars=str.toCharArray();
        String[] s=str.split(" ");
        StringBuffer sb=new StringBuffer(s[s.length-1]);
        for(int i=s.length-2;i>=0;i--){

            sb.append(" "+s[i]);


        }

        return sb.toString();

    }
}
