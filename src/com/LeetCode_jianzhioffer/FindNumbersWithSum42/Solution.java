package com.LeetCode_jianzhioffer.FindNumbersWithSum42;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 14:54
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {


        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0) return result;

        int start = 0;
        int last = array.length-1;
        while (start < array.length) {
            for ( last = array.length - 1; last >= start; last--) {
                if (array[start] + array[last] == sum) {
                    result.add(array[start]);
                    result.add(array[last]);
                    return result;
                }
            }
            start++;

        }

        return result;

    }
}
