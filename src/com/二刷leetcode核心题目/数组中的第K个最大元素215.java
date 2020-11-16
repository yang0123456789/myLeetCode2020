package com.二刷leetcode核心题目;

import java.util.PriorityQueue;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 14:28
 * # @version 1.0
 * # @File : 数组中的第K个最大元素215.java
 * # @Software: IntelliJ IDEA
 *我们可以使用最小堆来解决，一个个遍历原数组的值，添加到堆中，如果堆中元素的个数小于等于k的时候，我们就往堆中添加，
 * 添加之后如果堆中元素个数大于k的时候，我们就把最顶端的元素给移除掉，因为是最小堆，所以移除的就是堆中最小的值
 *
 *
 */
public class 数组中的第K个最大元素215 {
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }


    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo + 1; j <= hi; j++)
                if (nums[j] < nums[lo])
                    swap(nums, j, ++i);
            swap(nums, lo, i);
            if (k == i)
                return nums[i];
            else if (k < i)
                hi = i - 1;
            else
                lo = i + 1;
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }


}
