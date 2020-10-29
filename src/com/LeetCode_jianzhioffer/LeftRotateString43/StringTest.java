package com.LeetCode_jianzhioffer.LeftRotateString43;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 14:49
 * # @version 1.0
 * # @File : StringTest.java
 * # @Software: IntelliJ IDEA
 */
public class StringTest {
    public static void main(String[] args) {
        String str="123456";
        String str1= str.substring(0,3);
        String str2= str.substring(3,str.length());
        System.out.println(str1+":"+str2);
    }
}
