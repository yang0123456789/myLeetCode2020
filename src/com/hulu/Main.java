package com.hulu;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/16 19:08
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
sanjiaoxing(7);
    }

    public static void sanjiaoxing(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            System.out.println(1 + " " + 1 + " " + 1);
            return;

        }
        int[] feiqi = new int[n];
        feiqi[0] = 1;
        feiqi[1] = 1;
        for (int i = 2; i < n; i++) {
            feiqi[i] = feiqi[i - 1] + feiqi[i - 2];

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(feiqi[j] + " ");
            }
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(feiqi[j] + " ");
            }
            System.out.println();
        }
    }
}
