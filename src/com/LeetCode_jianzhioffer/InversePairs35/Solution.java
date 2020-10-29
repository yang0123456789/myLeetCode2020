package com.LeetCode_jianzhioffer.InversePairs35;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 14:19
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public int InversePairs(int[] array) {

        int len = array.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }
}
