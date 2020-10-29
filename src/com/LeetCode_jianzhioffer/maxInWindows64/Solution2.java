package com.LeetCode_jianzhioffer.maxInWindows64;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/5 16:18
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {


    /**
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1.判断当前最大值是否过期
     * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     */

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            //begin是用于保存当前窗口的第一个值在原始数组中的【下标】，这样写的目的是为了少写一些判断边界条件的代码。
            // begin表示滑动窗口的起始位置，
            if (q.isEmpty())
                q.add(i);
            else if (begin > q.peekFirst())
                q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0)//表示i的位置已经大于或等于一个窗口的位置了
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}

