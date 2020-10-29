package com.LeetCode_jianzhioffer.isContinuous45;

import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 10:18
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int max = 0;
        int min = 13;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            if (numbers[i] != 0) {
                if (numbers[i]<min) min =numbers[i];
                if (numbers[i]>max) max=numbers[i];
                if (set.contains(numbers[i])) {
                    return false;
                } else {
                    set.add(numbers[i]);
                }
            }


        }
        if ((max-min)>=5)return false;


        return true;

    }

    public static void main(String[] args) {
        boolean i=isContinuous(new  int[]{1,3,2,5,4});
        System.out.println(i);
    }

}
