package com.javaBasics.ArraysTest;

import java.util.Arrays;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/10 11:24
 * # @version 1.0
 * # @File : 排序.java
 * # @Software: IntelliJ IDEA
 */
public class 排序 {
    public static void main(String[] args) {
        // *************排序 sort****************
        int a[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        // sort(int[] a)方法按照数字顺序排列指定的数组。
        Arrays.sort(a);
        System.out.println("Arrays.sort(a):");
        for (int i : a) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        // sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
        int b[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        Arrays.sort(b, 2, 6);
        System.out.println("Arrays.sort(b, 2, 6):");
        for (int i : b) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        int c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        // parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
        Arrays.parallelSort(c);
        System.out.println("Arrays.parallelSort(c)：");
        for (int i : c) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        // parallelSort给字符数组排序，sort也可以
        char d[] = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        Arrays.parallelSort(d);
        System.out.println("Arrays.parallelSort(d)：");
        for (char d2 : d) {
            System.out.print(d2);
        }
        // 换行
        System.out.println();

        String[] strs = { "abcdehg", "abcdefg", "abcdeag" ,"ab","abc"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));// [ab, abc, abcdeag, abcdefg, abcdehg]

        // *************转列表 asList()****************
        /*
         * 返回由指定数组支持的固定大小的列表。
         * （将返回的列表更改为“写入数组”。）该方法作为基于数组和基于集合的API之间的桥梁，与Collection.toArray()相结合 。
         * 返回的列表是可序列化的，并实现RandomAccess 。
         * 此方法还提供了一种方便的方式来创建一个初始化为包含几个元素的固定大小的列表如下：
         */
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(stooges);
    }
}
