package com.LeetCode_jianzhioffer.MoreThanHalfNum_Solution29;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 16:50
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int len = array.length / 2;
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int k = 1;
        int tem = 0;
        while (tem < array.length - 1) {
            for (int j = tem + 1; j < array.length; j++) {
                if (array[tem] == array[j]) {
                    k++;
                    System.out.println("j:" + j + "--tem:" + array[tem] + ':' + k);
                    if (k > len) return array[tem];
                    tem = j;
                    continue;
                }
                tem = j;
                k = 1;
                break;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int i = MoreThanHalfNum_Solution(new int[]{4, 2, 1, 4, 2, 4});
        System.out.println(i);
    }
}
