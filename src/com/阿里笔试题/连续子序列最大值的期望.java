package com.阿里笔试题;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/28 9:56
 * # @version 1.0
 * # @File : 连续子序列最大值的期望.java
 * # @Software: IntelliJ IDEA
 * <p>
 * https://blog.csdn.net/AgoniAngel/article/details/105220949
 * <p>
 * 所以关键是如何计算每个元素是多少个子序列的最大值。
 * 方法：以这个元素为中心，找到它是最大值的左右边界，那么 以它为最大值的子序列数 = 左边界长度*右边界长度
 * 怎么得到左右边界长度呢？
 */
public class 连续子序列最大值的期望 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int length = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = sc.nextInt();
            }
            sc.nextLine();
            float[] opt=new float[length+1];
            opt[0]=1;



        }
    }
}
