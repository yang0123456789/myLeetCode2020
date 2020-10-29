package com.牛客网OJ在线编程.J;


/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 23:10
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            String[] as = a.trim().split(",");
            Arrays.sort(as);
            for (int i = 0; i < as.length; i++) {
                System.out.print(as[i] + ' ');
            }
            System.out.println();
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            String[] as = a.split(",");
            Arrays.sort(as);
            for (int i = 0; i < as.length - 1; i++) {
                System.out.print(as[i] + ',');
            }
            System.out.println(as[as.length - 1]);
        }
    }
}
