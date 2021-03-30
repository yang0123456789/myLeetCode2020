package com.剑指offer三刷不会的题目;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 **/
public class 滑动窗口的最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque=new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            //i k 窗口第一位 ，j窗口最后一位
            //左边界范围 i∈[1−k,n−k] ，右边界范围j∈[0,n−1] ；
            for(int j = 0, i =1 - k; j < nums.length; i++, j++){
                if(i>0&&deque.peekFirst()==nums[i-1]){
                    deque.removeFirst();
                }
                //必须是last，保证与他相连的k内比他小的去掉   [1,3,1,2,0,5] 3
                while(!deque.isEmpty()&&deque.peekLast()<nums[j]){
                    deque.removeLast();
                }
                deque.addLast(nums[j]);
                if(i>=0){
                    res[i]=deque.peekFirst();
                }

            }

            return res;


        }
    }
}
