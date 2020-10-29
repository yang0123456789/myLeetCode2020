package com.Leetcode_top100.动态规划;

import javax.security.auth.Subject;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/14 17:03
 * # @version 1.0
 * # @File : 数字组合.java
 * # @Software: IntelliJ IDEA
 * <p>
 * <p>
 * 从一个数组中选择若干数字组成一个值s，有的话返回true，没有的话，返回false。
 */
public class 数字组合 {
    public boolean isInArr(int[] arr, int s) {
        //从最高位开始操作，也可以从最低位开始操作，结果是一样的
        return rec_subset(arr, arr.length - 1, s);

    }

    public boolean rec_subset(int[] arr, int i, int s) {
        //1.先写出口条件
        if (s == 0) {
            return true;
        } else if (i == 0) {
            return arr[0] == s;
        } else if (arr[i] > s) {//这一步是进行剪枝
            return rec_subset(arr, i - 1, s);
        } else {//进行递归的条件
            return rec_subset(arr, i - 1, s) || rec_subset(arr, i - 1, s - arr[i]);
        }

    }

    public boolean dp_subset(int[] arr, int s) {
//        二维数组的横轴表示的是从0到S，用s表示，共s+1个
//        纵轴是arr的n个数，0——`len-1`，用i表示，共arr.length个
        boolean[][] subsets = new boolean[arr.length][s + 1];
        //第一列设置为true
        for (int i = 0; i < arr.length; i++) {
            subsets[i][0] = true;
        }
        //设置第一行，也就是arr[0]是不是等于s,(0, 0)这个位置是True还是False其实无所谓。
        for (int i = 0; i <= s; i++) {
            if (arr[0] == i) {
                subsets[0][i] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {//一行一行填写，第一行已经填写过
            for (int j = 1; j <= s; j++) {//第一列也已经填写过
                if (arr[i] > s) {
                    subsets[i][j] = subsets[i - 1][j];//如果arr[i]大于s，则直接等于arr[i-1]的位置的情况，也就是上一列，因为arr[i]肯定不在这一列中
                }else {
                    subsets[i][j]=subsets[i-1][s-arr[i]]||subsets[i-1][s];//分为两种情况，包含和不包含，这个地方设置的是这两个值
                }

            }
        }
        return subsets[arr.length-1][s];//返回最后一个值，就是最终的结果


    }
}
