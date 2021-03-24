package com.虾皮面试;

import com.JAVA并发编程的艺术.Priority;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/20
 * @Version 1.0
 **/
public class kuaipai {
    //从小打到排，以第一位为基准，先从右往左找小与，再从左往右找大于，交换,时刻判断i<j。最终i=j，就是基准的最终位置，直接交换就行
    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) return;
        int pivo = arr[low];//
        int i = low;
        int j = high;
        int tem;//交换基准用
        int t;//交换左右用
        while (i < j) {
            //先左边
            while (arr[j] >= pivo && j > i) {
                j--;
            }
            while (arr[i] <= pivo && j > i) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }


        }
        //    i==j交换基准
        arr[low] = arr[i];
        arr[i] = pivo;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);


    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
