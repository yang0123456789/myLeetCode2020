package com.二刷leetcode核心题目.分治算法;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 17:23
 * # @version 1.0
 * # @File : 最大子序和_53.java
 * # @Software: IntelliJ IDEA
 */
public class 多数元素_169 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);

    }
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }
        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }
        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
