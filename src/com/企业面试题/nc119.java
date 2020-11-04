package com.企业面试题;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/4 13:44
 * # @version 1.0
 * # @File : nc119.java
 * # @Software: IntelliJ IDEA
 * 创建一个大小为k的数组，遍历n个整数，如果遍历到的数小于大小为k的数组的最大值，则将此数与其最大值替换
 */
public class nc119 {
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            if (input == null || input.length == 0 || k > input.length || k == 0)
                return list;
            int[] arr = new int[k + 1];//数组下标0的位置作为哨兵，不存储数据
            //初始化数组
            for (int i = 1; i < k + 1; i++)
                arr[i] = input[i - 1];
            buildMaxHeap(arr, k + 1);//构造大根堆
            for (int i = k; i < input.length; i++) {
                if (input[i] < arr[1]) {
                    arr[1] = input[i];
                    adjustDown(arr, 1, k + 1);//将改变了根节点的二叉树继续调整为大根堆
                }
            }
            for (int i = 1; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;

        }
        /**
         * @Description: 构造大根堆
         * @Param: [arr, length]  length:数组长度 作为是否跳出循环的条件
         * @return: void
         * @Date: 2020/1/30-22:06
         */
        public void buildMaxHeap(int[] arr, int length) {
            if (arr == null || arr.length == 0 || arr.length == 1)
                return;
            for (int i = (length - 1) / 2; i > 0; i--) {
                adjustDown(arr, i, arr.length);
            }
        }
        public void adjustDown(int[] arr, int k, int length) {
            arr[0] = arr[k];//哨兵
            for (int i = 2 * k; i <= length; i *= 2) {
                if (i < length - 1 && arr[i] < arr[i + 1])
                    i++;//取k较大的子结点的下标
                if (i > length - 1 || arr[0] >= arr[i])
                    break;
                else {
                    arr[k] = arr[i];
                    k = i; //向下筛选
                }
            }
            arr[k] = arr[0];
        }
    }
}
