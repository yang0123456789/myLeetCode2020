package com.Leetcode_top100;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 10:29
 * # @version 1.0
 * # @File : 每日温度739.java
 * # @Software: IntelliJ IDEA
 */
public class 每日温度739 {
    class Solution {
        public int[] dailyTemperatures(int[] t) {
            if (t.length==0) return null;
            int n=t.length;
            int[] res=new int[n];
            for(int i=0;i<n-1 ;i++){
                int day=0;
                for(int j=i+1;j<n ;j++){
                    if (t[j]>t[i]){
                        day=j-i;
                        break;
                    }

                }
                res[i]=day;

            }
            res[n-1]=0;
            return res;
        }

    }
    class Solution2 {
        //单调栈法
        public int[] dailyTemperatures(int[] t) {
            if (t.length==0) return null;
            int n=t.length;
            int[] res=new int[n];
            Deque<Integer> stack=new ArrayDeque<>() ;
            for(int i=0;i<n ;i++){
                while (!stack.isEmpty()&&t[stack.peek()]<t[i]){
                    int idx=stack.pop();
                    res[idx]=i-idx;
                }
                stack.push(i);

            }


            return res;
        }

    }

}
