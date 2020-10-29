package com.面试算法题;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 10:17
 * # @version 1.0
 * # @File : 标准输入输出.java
 * # @Software: IntelliJ IDEA
 */
public class 标准输入输出 {
    public static void main(String[] args) {
//        next():只读取输入直到空格。它不能读两个由空格或符号隔开的单词。
//        此外，next()在读取输入后将光标放在同一行中。(next()只读空格之前的数据,并且光标指向本行)

//        nextLine():读取输入，包括单词之间的空格和除回车以外的所有符号(即。它读到行尾)。
//        读取输入后，nextLine()将光标定位在下一行。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串(中间能加空格或符号)");
        String a = input.nextLine();
        System.out.println("请输入一个字符串(中间不能加空格或符号)");
        String b = input.next();
        System.out.println("请输入一个整数");
        int c;
        c = input.nextInt();
        System.out.println("请输入一个double类型的小数");
        double d = input.nextDouble();
        System.out.println("请输入一个float类型的小数");
        float f = input.nextFloat();
        System.out.println("按顺序输出abcdf的值：");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(f);


    }
}
