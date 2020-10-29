package com.LeetCode_jianzhioffer.MoreThanHalfNum_Solution29;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 17:24
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int len = array.length;
        Arrays.sort(array);
        int num = array[len/2];
        int count = 0;
//        for (int i : array) {
//            if (array[i] == num) count++;
//
//
//        }
        for(int i=0;i<array.length ;i++){
            if (array[i]==num) count++;

        }
        return count > len/2 ? num : 0;
    }
}