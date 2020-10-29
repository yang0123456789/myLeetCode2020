package com.LeetCode_jianzhioffer.cutRope26;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/4 11:12
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 3) return 2;
        if (target == 4) return 4;
        int[] opt = new int[target + 1];//opt[i]表示长度为i时的最优解
        opt[0] = 0;
        opt[1] = 0;
        opt[2] = 1;
        opt[3] = 2;
        opt[4] = 4;
        for (int i = 5; i <= target; i++) {//i表示总长度为i的时候，怎么分。
            int max = 0;//辅助数字，用来寻找每个i的最大值
            for (int j = 1; j < i; j++) {//j表示第一段绳子可以取的长度，最小为1，最大为i-1，因为要分成两段
                //Math.max(opt[i-j],i-j),第一段长度为j考虑第二段以后的分割，要么直接分成一段（i-j），要么就是i-j长度下分成两段以上的最大值
                //然后让第一段j乘以剩下的i-j分的最优解，就是这个的长度，然后看是否大于之前划分的最大的值
                max = Math.max(max, j * (Math.max(opt[i - j], i - j)));
            }
            opt[i] = max;//遍历结束，找到长度为i时候的最大值

        }

        return opt[target];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        for (int i = 0; i < 60; i++) {
        int t = solution.cutRope(60);
        System.out.println(Integer.toString(36) + ':' + t);

//        }

    }


}
