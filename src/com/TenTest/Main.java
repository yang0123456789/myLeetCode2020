package com.TenTest;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 19:16
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            String[] s = a.trim().split(" ");
            int sum = 0;
            for (int i = 0; i < s.length; i++) {
                sum += Integer.parseInt(s[i]);
            }
            System.out.println(sum);

        }
    }
}
