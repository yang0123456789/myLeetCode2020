package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/23
 * @Version 1.0
 * 双指针碰撞法
 **/
public class 希尔排序 {
    static class ShellSort {
        //核心代码---开始
        public static void sort(Comparable[] arr) {
            int j;
            for (int gap = arr.length / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < arr.length; i++) {
                    Comparable tmp = arr[i];
                    for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
                        arr[j] = arr[j - gap];
                    }
                    arr[j] = tmp;
                }
            }
        }

        //核心代码---结束
        public static void main(String[] args) {

            int N = 2000;
            Integer[] arr = new Integer[]{};
            ShellSort.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(' ');
            }
        }
    }
}
