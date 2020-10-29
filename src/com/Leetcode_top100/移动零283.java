package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 19:23
 * # @version 1.0
 * # @File : 移动零283.java
 * # @Software: IntelliJ IDEA
 */
public class 移动零283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums==null) {
                return;
            }
            //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
            int j = 0;
            for(int i=0;i<nums.length;++i) {
                if(nums[i]!=0) {
                    nums[j++] = nums[i];
                }
            }
            //非0元素统计完了，剩下的都是0了
            //所以第二次遍历把末尾的元素都赋为0即可
            for(int i=j;i<nums.length;++i) {
                nums[i] = 0;
            }
        }
    }

}
