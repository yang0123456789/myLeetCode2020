package com.LeetCode_jianzhioffer.Add48;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/15 15:09
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public int Add(int num1, int num2) {

        int result=0;
        int carry=0;
        do{
            result=num1^num2;//不带进位的加法
            carry=(num1&num2)<<1; //进位
            num1=result;
            num2=carry;// 进位不为0则继续执行加法处理进位

        }while (carry!=0);
        return result;

    }
}
