package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 最长递增子序列 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }

    // 方法二：贪心 + 二分查找
    // 我们维护一个数组 d[i]d[i] ，表示长度为 ii 的最长上升子序列的末尾元素的最小值，用len 记录目前最长上升子序列的长度，起始时 lenlen 为 11，d[1] =nums[0]d[1]=nums[0]。
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
    public int lengthOfLIS(int[] nums) {
        // 起始时 len 为 1，d[1]=nums[0]。
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            // 如果nums[i]>d[len] ，则直接加入到d数组末尾，并更新len=len+1；
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 否则，在 d 数组中二分查找，找到第一个比nums[i]小的数 d[k] ，并更新 d[k + 1] =nums[i]（比num小的最近的一个值）
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
