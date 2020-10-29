package com.Leetcode_top100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 16:07
 * # @version 1.0
 * # @File : test.java
 * # @Software: IntelliJ IDEA
 */
public class test {
    public static void main(String[] args) {
        Queue<Character> wait=new LinkedList<>();
        wait.offer('a');
        wait.offer('b');
        for (char i :
                wait) {
            System.out.println(i);

        }
    }
}
