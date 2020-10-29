package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/8 15:01
 * # @version 1.0
 * # @File : 寻找重复数287.java
 * # @Software: IntelliJ IDEA
 */
public class 寻找重复数287 {
    public class Solution {

        public int findDuplicate(int[] nums) {
            int len = nums.length;
            int left = 1;
            int right = len - 1;
            while (left < right) {
                // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
                int mid = (left + right) >>> 1;

                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt += 1;
                    }
                }

                // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
                // 此时重复元素一定出现在 [1, 4] 区间里
                if (cnt > mid) {
                    // 重复元素位于区间 [left, mid]
                    right = mid;
                } else {
                    // if 分析正确了以后，else 搜索的区间就是 if 的反面
                    // [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    class Solution2 {
        public int findDuplicate(int[] nums) {
            int n = nums.length, ans = 0;
            int bit_max = 31;
            while (((n - 1) >> bit_max) == 0) {
                bit_max -= 1;
            }
            for (int bit = 0; bit <= bit_max; ++bit) {
                int x = 0, y = 0;
                for (int i = 0; i < n; ++i) {
                    if ((nums[i] & (1 << bit)) != 0) {
                        x += 1;
                    }
                    if (i >= 1 && ((i & (1 << bit)) != 0)) {
                        y += 1;
                    }
                }
                if (x > y) {
                    ans |= 1 << bit;
                }
            }
            return ans;
        }
    }
    class Solution3 {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }



}
