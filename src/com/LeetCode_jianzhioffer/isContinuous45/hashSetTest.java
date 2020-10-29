package com.LeetCode_jianzhioffer.isContinuous45;

import java.util.Set;
import java.util.TreeSet;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 10:27
 * # @version 1.0
 * # @File : hashSetTest.java
 * # @Software: IntelliJ IDEA
 */
public class hashSetTest {
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();
        set.add(5);
        if (set.contains(5)) System.out.println("sdfsd");
        set.remove(5);
        if (set.contains(5)) System.out.println("sdfsd");

    }
}
