package com.LeetCode_jianzhioffer.Add48;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/15 15:26
 * # @version 1.0
 * # @File : weiTest.java
 * # @Software: IntelliJ IDEA
 */
public class weiTest {
    public static void main(String[] args) {

//        int[] A = {1, 2, 5, 4, 4, 1, 2};
//
//        int n = A[0];
//        for (int i = 1; i < A.length; i++) {
//            n = n ^ A[i];
//
//        }
//        System.out.println(n);
//        //Integer.toBinaryString()是将数字用二进制格式显示
        int i = -10;
        System.out.println(Integer.toBinaryString(i)+':'+i);
        //左移两位
        int j = -10 << 2;
        System.out.println(Integer.toBinaryString(j)+':'+j);
        //右移两位
        int m = -10 >> 2;
        System.out.println(Integer.toBinaryString(m)+':'+m);
        int k = 10 >> 2;
        System.out.println(Integer.toBinaryString(k)+':'+k);
        //无符号右移
        int g = -10 >>> 2;
        System.out.println(Integer.toBinaryString(g)+':'+g);

//        int a,b,c;
//        a=3^1;
//        System.out.println("a = " + Integer.toBinaryString(a));
//        b=(3&1)<<1;
//        System.out.println("b = " + Integer.toBinaryString(b));
//        c=a^b;
//        System.out.println("c = " + Integer.toBinaryString(c));
//        int d=(a&b)<<1;
//        System.out.println("d = " + Integer.toBinaryString(d));
//        System.out.println("d = " + d);
    }



}



