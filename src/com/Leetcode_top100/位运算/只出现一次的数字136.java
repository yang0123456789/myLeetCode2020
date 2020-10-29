package com.Leetcode_top100.位运算;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 22:44
 * # @version 1.0
 * # @File : 位运算.java
 * # @Software: IntelliJ IDEA
 */
public class 只出现一次的数字136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single=single ^ num;
            }
            return single;
        }
    }


}
