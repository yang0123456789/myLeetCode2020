package com.面试算法题;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 9:19
 * # @version 1.0
 * # @File : 输入和输出.java
 * # @Software: IntelliJ IDEA
 */
public class 输入和输出 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(m);
            System.out.println(n);
            char[][] matrix = new char[m][n];
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x);
            System.out.println(y);
            sc.nextLine(); // 这一行非常重要！！！！ nextInt 完了之后一定要加这个不然会出错！！！
            for (int i = 0; i < m; i++) {
                String line = sc.nextLine();
                matrix[i] = line.toCharArray();
                System.out.println(line);
            }
        }
    }
}