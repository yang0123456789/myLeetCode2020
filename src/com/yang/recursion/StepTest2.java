package com.yang.recursion;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/22 8:58
 * # @version 1.0
 * # @File : StepTest2.java
 * # @Software: IntelliJ IDEA
 */
public class StepTest2 {
    public static void main(String[] args) {
        System.out.println(loop(40));
    }

    public static int loop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + "能不能小于1");
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;

        }
        return sum;
    }

}
