package com.LeetCode_jianzhioffer.GetNumberOfK37;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 23:56
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }
}
