package com.Leetcode_top100.贪心算法;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 20:29
 * # @version 1.0
 * # @File : 跳跃游戏55.java
 * # @Software: IntelliJ IDEA
 */
public class 跳跃游戏55 {
    class Solution {
        //时间超时
        public boolean canJump(int[] nums) {
            if (nums.length <= 0) return false;
            int len = nums.length - 1;
            boolean res = dfs(nums, 0, len);
            return res;

        }
        //nums 跳的格子
        //start，起跳的位置，
        //len ， nums最后一个格子的位置
        // [3,2,1,0,4]
        public boolean dfs(int[] nums, int start, int len) {
            if (start >= len) return true;
            boolean res;
            for (int i = nums[start]; i >= 1; i--) {
                res = dfs(nums, start + i, len);
                if (res ==true) return res;

            }
            return false;
        }
    }

    class Solution2 {

            public boolean canJump(int[] nums) {
                int n = nums.length;
                int rightmost = 0;//最远可以到达的位置
//                只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为
//                x +nums[x]，这个值大于等于 y，即 x + nums[x]≥y，那么位置 y 也可以到达。


                for (int i = 0; i < n; ++i) {
                    if (i>rightmost)return false;
                     //rightmost>=i i的位置才可以达到
                        rightmost = Math.max(rightmost, i + nums[i]);//x+nums[x] 更新 最远可以到达的位置。
                        if (rightmost >= n - 1) {
                            return true;
                        }

                }
                return false;
            }
        }
    class Solution3 {

        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;//最远可以到达的位置
//                只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为
//                x +nums[x]，这个值大于等于 y，即 x + nums[x]≥y，那么位置 y 也可以到达。


            for (int i = 0; i <= rightmost&&rightmost<n-1; ++i) {

                rightmost = Math.max(rightmost, i + nums[i]);//x+nums[x] 更新 最远可以到达的位置。

            }
            return rightmost>=n-1;
        }
    }

}
