package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/20
 * @Version 1.0
 **/
public class 逆序对 {
    class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) return 0;
            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }
            int[] tem = new int[len];
            return reversePairs(copy, 0, len - 1, tem);
        }

        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left>= right) return 0;
            int mid = left + (right - left) / 2;//只有两个数，mid一定等于left
            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);
            if (nums[mid] <= nums[mid + 1]) return leftPairs + rightPairs;
            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs+crossPairs;

        }

        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            for(int i=left;i<=right ;i++){
                temp[i]=nums[i];
            }
            int count=0;
            int i=left;
            int j=mid+1;
            for(int k=left;k<=right ;k++){
                if (i>mid){//左边没了
                    nums[k]=temp[j];
                    j++;
                }else if(j>right){
                //    右边没了
                    nums[k]=temp[i];
                    i++;
                }else if(temp[i]<=temp[j]){//左边小
                    nums[k]=temp[i];
                    i++;
                }else {
                //右边小，计算左边剩下的元素
                    nums[k]=temp[j];
                    j++;
                    count+=(mid-i+1);
                }
            }
            return count;
        }
    }
}
