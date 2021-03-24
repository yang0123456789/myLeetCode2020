package com.牛客网OJ在线编程.A;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 21:20
 * # @version 1.0
 * # @File : A.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(x + y);
            in.nextLine();
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x=in.nextInt();
            int y=in.nextInt();
            System.out.println(x + y);
        }
    }
}
