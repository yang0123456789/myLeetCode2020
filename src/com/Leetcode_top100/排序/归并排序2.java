package com.Leetcode_top100.排序;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/25 20:47
 * # @version 1.0
 * # @File : 归并排序2.java
 * # @Software: IntelliJ IDEA
 */
public class 归并排序2 {
    public static void main(String args[]) {
        int a[] = {2, 4, 11, 8, 1, 3, 5, 9};
        int k = 0;
        int temp[] = new int[11];
        mergesort(a, 0, a.length - 1, temp);
        for (int i = 0; i < a.length;
             i++) {
            System.out.print(a[i]);
        }
    }

    public static void mergearray(int[] a, int first, int mid, int last, int temp[]) {
        int f = first, j = mid + 1;
        int m = mid, l = last;
        int k = 0;
        while (f <= m &&
                j <= l) {
            if (a[f] <= a[j]) temp[k++] = a[f++];
            else temp[k++] = a[j++];
        }
        while (f <= m) temp[k++] = a[f++];
        while (j <= l) temp[k++] = a[j++];
        for (f = 0; f < k;
             f++)
            a[first + f] = temp[f];
    }

    public static void mergesort(int[] a, int first, int last, int[] temp) {
        if (first < last) {//最后分到只剩一个数的时候，默认是有序的，first=last会直接结束递归，返回给上一层
            int mid = (first + last) / 2;//奇数个节点找到中点，偶数个节点找到中心左边的节点。
            mergesort(a, first, mid, temp); //左边有序
             mergesort(a, mid + 1, last, temp); //右边有序
             mergearray(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }
}