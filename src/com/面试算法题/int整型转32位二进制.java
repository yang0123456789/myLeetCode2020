package com.面试算法题;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/28 0:46
 * # @version 1.0
 * # @File : int整型转32位二进制.java
 * # @Software: IntelliJ IDEA
 */
public class int整型转32位二进制 {
//    Java实现int整型转32位二进制、统计二进制中1的个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        intTo32BitBinary(i);
        countBinaryOne(i);
    }

    //将int型整数转成有符号的32位二进制数
    public static void intTo32BitBinary(int x) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            sb.append(x & 1);
            //无符号右移，高位补0，包括符号位在内一起右移
            //>> 是有符号右移。符号位保持不变，负数高位补1，正数高位补0。
            x = x >>> 1;
        }
        //得到32位的二进制字符串
        String str32 = sb.reverse().toString();
        System.out.println("有符号32位二进制为："+str32);
    }

    //统计二进制中1的个数
    public static void countBinaryOne(int x) {
        int count = 0;
        while(x != 0) {
            x = x & (x-1);
            count++;
        }
        System.out.println(count);
    }
}
