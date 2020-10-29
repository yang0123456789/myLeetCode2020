package com.Leetcode_top100.双指针;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 16:47
 * # @version 1.0
 * # @File : 颜色分类75.java
 * # @Software: IntelliJ IDEA
 */
public class 颜色分类75 {
    class Solution {
        /*
        荷兰三色旗问题解
        */
        public void sortColors(int[] nums) {
            // 对于所有 idx < i : nums[idx < i] = 0
            // j是当前考虑元素的下标
            int p0 = 0, curr = 0;
            // 对于所有 idx > k : nums[idx > k] = 2
            int p2 = nums.length - 1;

//            我们用三个指针（p0, p2 和curr）来分别追踪0的最右边界,这里po是指向第一个不等于0的位置，2的最左边界（左边第一个不是2的位置）和
//            当前考虑的元素（正在操作）。

            int tmp;
            while (curr <= p2) {
                if (nums[curr] == 0) {
                    // 交换第 p0个和第curr个元素，交换完以后，po位置已经是0了，右移到下一个不是0的位置
                    // i++，j++
                    tmp = nums[p0];
                    nums[p0++] = nums[curr];
                    nums[curr++] = tmp;
                }
                else if (nums[curr] == 2) {
                    // 交换第k个和第curr个元素，交换完以后，p2位置已经是2了，左下移到下一个不是2的位置
                    // p2--
                    tmp = nums[curr];
                    nums[curr] = nums[p2];
                    nums[p2--] = tmp;
                }
                else curr++;
            }
        }
    }


}
