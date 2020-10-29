package com.LeetCode_jianzhioffer.PrintMinNumber32;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 23:36
 * # @version 1.0
 * # @File : StringTest.java
 * # @Software: IntelliJ IDEA
 */
public class StringTest {
    public static void main(String args[]) {
        String str1 = "Stringa";
        String str2 = "Stringa";
        String str3 = "Stringa123";
        String str4="Stringc";

        int result = str1.compareTo( str2 );
        System.out.println(result);

        result = str2.compareTo( str3 );
        System.out.println(result);

        result = str3.compareTo( str1 );
        System.out.println(result);
        result = str4.compareTo( str2 );
        System.out.println(result);
    }
}
