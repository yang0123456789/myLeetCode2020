package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/30 10:57
 * # @version 1.0
 * # @File : nc88_2.java
 * # @Software: IntelliJ IDEA
 */
public class nc88_2 {


    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }
}

