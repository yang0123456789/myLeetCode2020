package com.二刷leetcode核心题目.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 17:23
 * # @version 1.0
 * # @File : 最大子序和_53.java
 * # @Software: IntelliJ IDEA
 */
public class 最大子序和_53 {
    public int maxSubArray(int[] nums) {
//    用 f(i) 代表以第 ii个数结尾的「连续子数组的最大和」
//    因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可
        int pre = 0, maxAns = nums[0];
        for (int i:
             nums) {
            pre=Math.max(pre+i,i);
            maxAns=Math.max(pre,maxAns);

        }
        return maxAns;


    }

}
