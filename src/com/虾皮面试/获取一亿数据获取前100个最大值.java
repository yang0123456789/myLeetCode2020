package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/20
 * @Version 1.0
 **/

import java.util.Random;

/**
 * 获取一亿数据获取前100个最大值
 * 1. 假设数组为 array[N] (N = 1 亿)，首先利用quicksort的原理把array分成两个部分，左边部分比 array[N - 1] (array中的最后一个值，即pivot) 大， 右边部分比pivot 小。然后，可以得到 array[array.length - 1] (即 pivot) 在整个数组中的位置，假设是 k.
 * 2. 如果 k 比 99 大，我们在数组[0, k - 1]里找前 100 最大值。 （继续递归）
 * 3. 如果 k 比 99 小， 我们在数组[k + 1, ..., N ]里找前 100 - (k + 1) 最大值。（继续递归）
 * 4. 如果 k == 99, 那么数组的前 100 个值一定是最大的。（退出）
 */
public class 获取一亿数据获取前100个最大值 {
    static class TopHundredQuickSort {

        public static void main(String[] args) {
            // the size of the array
            int number = 100000000;
            // the top k values
            int k = 100;
            // the range of the values in the array
            int range = 1000000001;

            // input for minHeap based method
            int[] array = new int[number];

            Random random = new Random();
            for (int i = 0; i < number; i++) {
                array[i] = random.nextInt(range);
            }

            TopHundredQuickSort topHundred = new TopHundredQuickSort();

            // start time
            long t1 = System.currentTimeMillis();
            topHundred.tophundred(array, 0, array.length - 1, k);

            // end time
            long t2 = System.currentTimeMillis();

            System.out.println("The total execution time of quicksort based method is" + (t2 - t1) + " millisecond");

            // print out the top k largest values in the top array
            System.out.println("The top " + k + " largest values are:");
            for (int i = 0; i < k; i++) {
                System.out.println(array[i]);
            }
        }

        private void tophundred(int[] array, int start, int end, int k) {
            int switchPointer = start;
            // array最后一个值作为pivot
            int pivot = array[end];
            for (int i = start; i < end; i++) {
                if (array[i] >= pivot) {
                    swap(array, switchPointer, i);
                    switchPointer++;
                }
            }

            // 交换后 array左边的值比pivot大   右边的值比pivot小
            swap(array, end, switchPointer);

            if (switchPointer < k - 1) {
                tophundred(array, switchPointer + 1, end, k);
            } else if (switchPointer == k - 1) {
                return;
            } else {
                tophundred(array, 0, switchPointer - 1, k);
            }

        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
