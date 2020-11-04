package com.企业面试题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/4 14:18
 * # @version 1.0
 * # @File : nc119_2.java
 * # @Software: IntelliJ IDEA
 */
//A=new PriorityQueue<>(new Comparator<Integer>() {
//
//@Override
//public int compare(Integer o1, Integer o2) {
//        // TODO 自动生成的方法存根
//        return o2-o1;
//        }
//        });

public class nc119_2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k == 0)
            return res;
        Queue<Integer> pq=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                 return o2-o1;
            }
        });
        for (int num : input) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {//如果堆顶元素 > 新数，则删除堆顶，加入新数入堆
                pq.poll();
                pq.offer(num);
            }
        }
        for(int i=0;i<k ;i++){
        res.add(pq.poll());
        }
        return  res;


    }
}
