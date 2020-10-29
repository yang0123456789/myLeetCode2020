package com.yang.recursion;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/22 8:41
 * # @version 1.0
 * # @File : StepTest.java
 * # @Software: IntelliJ IDEA
 */
public class StepTest {

    public static void main(String[] args) {
        System.out.println(f(0));
    }

    public static int f(int n) {
        if(n<1){
            throw  new IllegalArgumentException(n+"能不能小于1");
        }

        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 2) + f(n - 1);
    }

}
