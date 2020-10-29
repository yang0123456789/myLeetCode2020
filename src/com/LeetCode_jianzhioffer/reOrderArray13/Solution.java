package com.LeetCode_jianzhioffer.reOrderArray13;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/25 20:18
 * # @version 1.0
 * # @File : Solution13.java
 * # @Software: IntelliJ IDEA
 * 方法一：创建一个新数组，先遍历一遍原来的数组，查清奇数和偶数各几个，再遍历一遍原来的数组，放入新数组中
 * <p>
 * 方法二：两个指针i和j。i、j从0开始，j找第一个偶数，然后i找j后面的第一个奇数，找到后与j互换，j上的偶数往后移位，然后j更
 * 新为j+的位置，i从这个位置继续往后面找奇数，如果i到最后一位仍然没找到，说明已经遍历完
 */
public class Solution {

    public static void reOrderArray(int[] array) {
        if (array.length == 0 || array == null) return;
        int i = 0, j = 0;
        while (j < array.length && array[j] % 2 == 1) {
            j++;
        }

        if (j < array.length - 1) {
            for (i = j + 1; i < array.length; i++) {

                if (array[i] % 2 == 1) {
                    for (int k = i; k > j; k--) {
                        int m = array[k];
                        array[k] = array[k - 1];
                        array[k - 1] = m;


                    }

                    j = j + 1;

                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array={1,5,2,4,6,3,7};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));

    }
}