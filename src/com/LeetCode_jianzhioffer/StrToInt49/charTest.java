package com.LeetCode_jianzhioffer.StrToInt49;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 23:09
 * # @version 1.0
 * # @File : charTest.java
 * # @Software: IntelliJ IDEA
 */
public class charTest {
    public static void main(String args[]) {
        System.out.println(Character.isDigit('c'));
        System.out.println(Character.isDigit('5'));
        char ch = '9';
        if (Character.isDigit(ch)) {  // 判断是否是数字
            int num = (int) ch - (int) ('0');
            System.out.println(num);
        }
        ch='8';
        int i = ch - '0';
        System.out.println((ch-'0'));
    }
}
