package com.LeetCode_jianzhioffer.cutRope26;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/3 23:36
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */


/**
 方法一：暴力递归




 */

public class Solution {
    public int cutRope(int target) {
        if (target == 2) return 1;//m>1,最少两段
        if (target < 2) return 0;
        if (target == 3) return 3;
//能走到这一步，基本都是大于4的，
        return cut(target);

    }

    public static int cut(int target) {
        //能走到递归方法的绳子，都是大于4的，经过递归会才有可能小于4，因此在小于4的时候，就不需要再切割了
        if (target <= 4) return target;//递归跳出的条件，4的时候可以分成两段2*2，因此可以跳出循环
        int rep = 0;//记录子递归中的最大值
        for (int i = 1; i < target;++ i)//i表示第一段的长度，最小为1，最大为target-1，因为至少分成两段，这时候已经至少是5了，
        {
            rep = Math.max(i * cut(target - i), rep);

        }
        return rep;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        for (int i = 0; i < 60; i++) {
            int t = solution.cutRope(40);
            System.out.println(Integer.toString(36) + ':' + t);

//        }

    }
}
