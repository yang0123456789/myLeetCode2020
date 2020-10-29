package com.Leetcode_top100.动态规划;

import com.sun.org.apache.xpath.internal.operations.Lt;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/20 15:24
 * # @version 1.0
 * # @File : 最长上升子序列300.java
 * # @Software: IntelliJ IDEA
 */
public class 最长上升子序列300 {
    class Solution {
//        定义 dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 {nums}[i] 必须被选取。
//我们从小到大计算 dp[] 数组的值，在计算 dp[i]之前，我们已经计算出 dp[0…i−1] 的值，则状态转移方程为：
//
//        dp[i] = max(dp[j]) + 1,其中, 0 <=j < i 且 num[j]<num[i]
//        dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
//
//        即考虑往 dp[0…i−1] 中最长的上升子序列后面再加一个 nums[i]。由于 dp[j] 代表 nums[0…j] 中以 nums[j] 结尾的最长上升子序列，
//        所以如果能从 dp[j] 这个状态转移过来，那么 nums[i] 必然要大于 nums[j]，才能将 nums[i] 放在 nums[j] 后面以形成更长的上升子序列。
//


        public int lengthOfLIS(int[] nums) {
            if (nums.length <= 0) return 0;
            int dp[] = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;//记录最大的顺序串
            for (int i = 1; i < nums.length ; i++) {//外层循环，逐个填写dp[i]
                int maxval = 0;//记录最大的dp[j]的值
                for (int j = 0; j < i; j++) {//内层循环，根据状态转移公式 dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
                    if (nums[j]<nums[i]){
                       maxval=Math.max(maxval,dp[j]);
                    }


                }
                dp[i]=maxval+1;//加上num[i]的长度
                maxans = Math.max(maxans, dp[i]);
            }

return maxans;
        }

    }
    class Solution2 {
        //贪心+状态转移
        public int lengthOfLIS(int[] nums) {
            if (nums.length <= 0) return 0;
            int[] tail = new int[nums.length];
            tail[0]=nums[0];
            // end 表示有序数组 tail 的最后一个已经赋值元素的索引
            int end = 0;
            for(int i=1;i<nums.length ;i++){
                if (nums[i]>=tail[end]){
                    end++;
                    tail[end]=nums[i];


                }else {
                    int left=0;
                    int right=end;
                    while (left<right){
                        int mid=(right+left)>>>1;
                        if (tail[mid]<nums[i]){
                            left=mid+1;
                        }else {
                            right=mid;//这里是因为 else以后，是nums[mid]>=nums[i],所以要用right=mid，而不是right=mid-1;
                        }
                    }
                    tail[left]=nums[i];//最终left>=right;
                    //这里不需要end++，因为只是将里面的值变小了，而没有增加tail的有效长度


                }



            }
            end++;//end是从0开始的，数量要+1
            return end;
        }

    }
}

