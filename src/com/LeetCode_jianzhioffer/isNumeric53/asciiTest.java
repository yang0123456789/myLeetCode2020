package com.LeetCode_jianzhioffer.isNumeric53;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 17:48
 * # @version 1.0
 * # @File : asciiTest.java
 * # @Software: IntelliJ IDEA
 */
public class asciiTest {
    public static void main(String[] args) {
        char c='5';
        if (c>='a'&&c<='z'){
            System.out.println("c是字符串");
        }
        if (c>='0'&&c<='9'){
            System.out.println("c是数字");
        }

    }
}
