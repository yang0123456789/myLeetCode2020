package com.Leetcode_top100;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 8:32
 * # @version 1.0
 * # @File : 最短无序连续子数组581.java
 * # @Software: IntelliJ IDEA
 */
public class 最短无序连续子数组581 {
    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{1,3,2,2,2});

    }


        //我的思路：从左往右找第一个逆序，从右往左找第二个逆序，就是中间的部分，两个想减+1就是最短
        //然后找出这一段中间的最大值，再从右往左找第一个大于这个最大值的地方，这个值与right相比，哪个大哪个就是边界
        public static int findUnsortedSubarray(int[] nums) {
            int left=0;
            int right=nums.length-1;
            while (left<nums.length-1&&nums[left]<=nums[left+1]){
                left++;
            }
            if (left==nums.length-1) return 0;
            while (right>=0&&nums[right]>=nums[right-1]){
                right--;
            }
            int max=nums[left];
            int min=nums[right];
            for(int i=left+1;i<=right ;i++){
                max=Math.max(max,nums[i]);
                min=Math.min(min,nums[i]);


            }
            int right2=nums.length-1;
            while (right2>=right&&nums[right2]>=max){
                right2--;
            }
            int left2=0;
            while (left2<=left&&nums[left2]<=min){
                left2++;
            }
           right=right>right2?right:right2;
            left=left<left2?left:left2;
            return right-left+1;

        }
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] snums = nums.clone();
            Arrays.sort(snums);
            int start = snums.length, end = 0;
            for (int i = 0; i < snums.length; i++) {
                if (snums[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end - start >= 0 ? end - start + 1 : 0);

        }
    }

}
