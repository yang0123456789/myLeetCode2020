package com.Leetcode_top100;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/1 11:38
 * # @version 1.0
 * # @File : 最小区间632.java
 * # @Software: IntelliJ IDEA
 */
public class 最小区间632 {
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            //区间的左边和右边
            int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
            //最小范围
            int minRange = rangeRight - rangeLeft;
            //区间的左边最大值
            int max = Integer.MIN_VALUE;
            int size = nums.size();
            //由于 k 个列表都是升序排列的，因此对每个列表维护一个指针，
            //通过指针得到列表中的元素，指针右移之后指向的元素一定大于或等于之前的元素。
            int[] next = new int[size];
            //使用最小堆维护 k 个指针指向的元素中的最小值，优先队列存的是k个列表的标号，根据Comparator将最小值的队列号放在最前面
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer index1, Integer index2) {
                    //第index个列表的next[index1]指针指向的元素
                    return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
                }
            });

            for (int i = 0; i < size; i++) {
                //初始时，i 个指针都指向下标 0，因为next[i]=0
                priorityQueue.offer(i);
                //最大元素即为所有列表的下标 0 位置的元素中的最大值
                max = Math.max(max, nums.get(i).get(0));
            }

            while (true) {
                //每次从堆中取出最小值，minIndex是指第几个列表，也代表指针数组next的下标
                int minIndex = priorityQueue.poll();
                //根据最大值和最小值计算当前区间
                int curRange = max - nums.get(minIndex).get(next[minIndex]);
                //如果当前区间小于最小区间则用当前区间更新最小区间
                if (curRange < minRange) {
                    minRange = curRange;
                    rangeLeft = nums.get(minIndex).get(next[minIndex]);
                    rangeRight = max;
                }
                //然后将对应列表的指针右移
                next[minIndex]++;
                //如果一个列表的指针超出该列表的下标范围，则说明该列表中的所有元素都被遍历过，
                //堆中不会再有该列表中的元素，因此退出循环。
                if (next[minIndex] == nums.get(minIndex).size()) {
                    break;
                }
                //将当前列表的编号重新放入小堆中，然后优先队列会根据compare算法维持当前k个元素最小的队列号在第一个
                priorityQueue.offer(minIndex);
                //并更新堆中元素的最大值
                max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
            }
            return new int[]{rangeLeft, rangeRight};
        }
    }
}
