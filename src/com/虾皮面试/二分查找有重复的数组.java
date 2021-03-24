package com.虾皮面试;

import java.util.Arrays;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/23
 * @Version 1.0
 **/
public class 二分查找有重复的数组 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4, 4, 4, 4, 4, 4, 4, 5, 8, 9};

        Arrays.sort(arr);

        int index1 = Arrays.binarySearch(arr, 6);

        int index2 = Arrays.binarySearch(arr, 4);

        int index3 = Arrays.binarySearch(arr, 0);

        int index4 = Arrays.binarySearch(arr, 10);

        System.out.println("index1 = " + index1 + ", index2 = " + index2 +

                ", index3 = " + index3 + ", index4 = " + index4);
    }
}
