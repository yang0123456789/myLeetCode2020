package com.Leetcode_top100.排序;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/5 15:12
 * # @version 1.0
 * # @File : 滑动窗口最大值239.java
 * # @Software: IntelliJ IDEA
 */
public class 滑动窗口最大值239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            if (length < k || length * k == 0) return new int[0];
            int[] res = new int[length - k + 1];
            Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < k - 1; i++) {
                heap.add(nums[i]);
            }
            for (int i = 0; i < length - k + 1; i++) {
                heap.add(nums[i + k - 1]);
                res[i] = heap.peek();
                heap.remove(nums[i]);
            }
            return res;
        }
    }

    class Solution2 {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();//存储的是索引
        int[] nums;

        public void clean_deque(int i, int k) {
//            - 只保留当前滑动窗口中有的元素的索引。
//            - 移除比当前元素小的所有元素，它们不可能是最大的。
            //clean完以后，双端队列中保存的只有比当前元素大的值，因此基本上是降序排列的，因为比后面元素小的值都被清理掉了
            // remove indexes of elements not from sliding window
//            ，从i开始往前的k个元素为[i-k+1,i]
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            //第一个窗口的初始化，将第一个窗口的，即前 k个元素入双端队列
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                //从尾端移除比num[i]小的值，并且将第一个不是从i往前k个序列的元素删掉
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }

            int[] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                //第一个元素就是当前窗口的最大值
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }
    class Solution3 {
        //动态规划 见官方题解
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            int [] left = new int[n];
            left[0] = nums[0];
            int [] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = 1; i < n; i++) {
                // from left to right
                if (i % k == 0) left[i] = nums[i];  // block_start
                else left[i] = Math.max(left[i - 1], nums[i]);

                // from right to left
                int j = n - i - 1;
                if ((j + 1) % k == 0) right[j] = nums[j];  // block_end (j + 1) % k 第一位%k为0 最后一位%k为k-1，所有j+1%k==0表示分组的最后一位
                else right[j] = Math.max(right[j + 1], nums[j]);
            }

            int [] output = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) //[i,i+k-1],
                output[i] = Math.max(left[i + k - 1], right[i]);

            return output;
        }
    }


}
