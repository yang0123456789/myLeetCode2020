package com.Leetcode_top100.排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/2 10:46
 * # @version 1.0
 * # @File : 数组中的第K个最大元素215.java
 * # @Software: IntelliJ IDEA
 */
public class 数组中的第K个最大元素215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];

        }
    }
    class Solution2 {
        //小顶堆
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int num :
                    nums) {
                heap.add(num);
                if (heap.size()>k)
                    heap.poll();
            }
            return heap.poll();

        }
    }
    class Solution3 {
        //基于快速排序，找到第k个值
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSelect(int[] a, int l, int r, int index) {
            int q = randomPartition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        public int randomPartition(int[] a, int l, int r) {
            int i = random.nextInt(r - l + 1) + l;
            swap(a, i, r);
            return partition(a, l, r);
        }

        public int partition(int[] a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; ++j) {//i的位置保存的都是比a[r]小的值
                if (a[j] <= x) {
                    swap(a, ++i, j);
                }
            }
            swap(a, i + 1, r);//i+1的位置保存的都是比a[r]大的值
            return i + 1;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

}
