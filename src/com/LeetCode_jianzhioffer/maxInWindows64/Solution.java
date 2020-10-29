package com.LeetCode_jianzhioffer.maxInWindows64;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/5 15:25
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 * 暴力破解法，提高刷题速度
 *
 *
 */
public class Solution {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(num.length<size||size==0) return list;
        int first=0;
        int last=size-1;
        int max=0;
        for(;last<num.length;last++){
            for(int i=first;i<=last ;i++){
                max=Math.max(max,num[i]);

            }
            list.add(max);
            max=0;
            first++;

        }
        return list;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(list);
    }

}
