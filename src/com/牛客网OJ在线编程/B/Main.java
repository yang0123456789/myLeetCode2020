package com.牛客网OJ在线编程.B;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 21:20
 * # @version 1.0
 * # @File : A.java
 * # @Software: IntelliJ IDEA
 * 链接：https://ac.nowcoder.com/acm/contest/5657/B
 * 来源：牛客网
 *
 * 输入第一行包括一个数据组数t(1 <= t <= 100)
 * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
 * 输出描述:
 * 输出a+b的结果
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        while (in.hasNextLine()){
            int x=in.nextInt();
            int y=in.nextInt();
            System.out.println(x+y);
            in.nextLine();
        }
    }

    public static void main2(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        while (in.hasNext()){
            int x=in.nextInt();
            int y=in.nextInt();
            System.out.println(x+y);

        }
    }


}
