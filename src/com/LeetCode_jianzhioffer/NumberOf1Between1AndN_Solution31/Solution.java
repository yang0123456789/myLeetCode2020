package com.LeetCode_jianzhioffer.NumberOf1Between1AndN_Solution31;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 10:27
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA

 */
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=n ;i++){

            sb.append(i);
        }
        int count=0;
        int length = sb.length();
        for(int i=0;i<length ;i++){
        if (sb.charAt(i)=='1'){
            count++;

        }

        }
        return count;
    }

}
