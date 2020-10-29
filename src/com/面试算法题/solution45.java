package com.面试算法题;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/31 15:57
 * # @version 1.0
 * # @File : solution45.java
 * # @Software: IntelliJ IDEA
 */
public class solution45 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9')
                a = a * 10 + c - '0';
        }
//        a -= 123;
        System.out.println(a);
    }
}