package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/26 1:26
 * # @version 1.0
 * # @File : 打家劫舍198.java
 * # @Software: IntelliJ IDEA
 */
public class 打家劫舍198 {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) return nums[0];
            int pre = nums[0];
            int cur = Math.max(pre, nums[1]);
            ;
            int si = 0;
            int max = Math.max(pre, cur);
            for (int i = 2; i < len; i++) {
                si = Math.max(pre + nums[i], cur);
                pre = cur;
                cur = si;
            }
            return cur;
        }
    }
    class Solution2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }


}
