package com.Leetcode_top100;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 23:27
 * # @version 1.0
 * # @File : 根据身高重建队列406.java
 * # @Software: IntelliJ IDEA
 *
 * 该策略可以递归进行：
 *(h,k)
 * 将最高的人按照 k 值升序排序，然后将它们放置到输出队列中与 k 值相等的索引位置上。
 *按降序取下一个高度，同样按 k 值对该身高的人升序排序，然后逐个插入到输出队列中与 k 值相等的索引位置上。
 * 直到完成为止。
 *排序：
 * 按高度降序排列。
 * 在同一高度的人中，按 k 值的升序排列。
 * 逐个地把它们放在输出队列中，索引等于它们的 k 值。
 * 返回输出队列
 *核心思路就是先排高个子的人，因为低个子的人的顺序对高个子的k值无影响，然后按照h的降序将低个子按k值插入到高个子中，就是最终的排序。
 *
 */
public class 根据身高重建队列406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // if the heights are equal, compare k-values
                    // 先按身高h的降序排列，h相同的话按k的升序排列
                    // 先按身高降序排序，相同身高按k升序排序，经过此次排序后高的人一定在矮的人的前面并且相同高度的人的相对顺序就是最终结果的相对顺序。请记住这两点，敲黑板
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });
//            创建一个集合，这个集合的每个元素是一个一维数组，也就是我们二维数组的一行。
            List<int[]> output = new LinkedList<>();
//            以行为单位遍历排好序的people[][]数组，假设每行数据是p[], 把每行元素插入到集合的索引为p[1]的位置，
            for (int[] p : people) {
                output.add(p[1], p);
            }
//            把集合中的数据转换为一个二维数组，返回即是正确结果
            int n = people.length;
            return output.toArray(new int[n][2]);
        }
    }

    class Solution2 {
        public int[][] reconstructQueue(int[][] people) {

            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });
            List<int[]> list = new LinkedList<>();
            for (int[] peoples : people) {
                list.add(peoples[1], peoples);
            }
            return list.toArray(new int[people.length][2]);

        }


    }
}