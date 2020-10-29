package com.LeetCode_jianzhioffer.GetMedian63;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/6 10:29
 * # @version 1.0
 * # @File : PriorityQueueTest.java
 * # @Software: IntelliJ IDEA
 */
public class PriorityQueueTest {
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;
        }
    };
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(cmp);
        int[] nums= {2,5,3,4,1,6};
        for(int i:nums)
        {
            q.add(i);
        }
        Object[] nn=q.toArray();
        for(int i=nn.length-1;i>=0;i--)
            System.out.print((int)nn[i]+" ");
        System.out.println("nn.toString() = " + nn);
        Arrays.sort(nn);
        for(int i=nn.length-1;i>=0;i--)
            System.out.print((int)nn[i]+" ");
        /**
         * 输出结果
         * 6 5 4 3 2 1
         */
    }
}
