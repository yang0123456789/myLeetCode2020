package com.test;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class 重载 {
    public static void main(String[] args) {
        int  a = 0,b = 0;
        System.out.println(a+b);

    }

    public void add(int a) {

    }

    public int add(int a, int b) {
        return a + b;

    }
}
