package com.二刷leetcode核心题目.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 9:26
 * # @version 1.0
 * # @File : 组合数字问题.java
 * # @Software: IntelliJ IDEA
 *
 * 从一个数组中选择若干数字组成一个值s，有的话返回true，没有的话，返回false。数组都是正数
 *
 */
public class 组合数字问题 {
    public boolean dp_subset(int[] arr, int s) {
//        二维数组的横轴表示的是从0到S，用s表示，共s+1个
//        纵轴是arr的n个数，0——`len-1`，用i表示，共arr.length个
        boolean[][] subsets = new boolean[arr.length][s + 1];
        //第一列设置为true，因为 s=0，不选都可以组合成0
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
                if (arr[i] > j) {//这里之所以选择大于是因为前面存在都不选的情况，而且最终的目的是凑成j，可以直接判不选，j-arr[]
                    subsets[i][j] = subsets[i - 1][j];//如果arr[i]大于s，则直接等于arr[i-1]的位置的情况，也就是上一列，因为arr[i]肯定不在这一列中
                }else {
                    subsets[i][j]=subsets[i-1][j-arr[i]]||subsets[i-1][j];//分为两种情况，包含和不包含，这个地方设置的是这两个值
                }
            }
        }
        return subsets[arr.length-1][s];//返回最后一个值，就是最终的结果
    }
}
