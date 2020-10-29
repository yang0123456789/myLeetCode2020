package com.Leetcode_top100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 22:17
 * # @version 1.0
 * # @File : 合并区间56.java
 * # @Software: IntelliJ IDEA
 */
public class 合并区间56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
            // 对起点终点进行排序
//            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            int i = 0;
            while (i < intervals.length) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                // 如果有重叠，循环判断哪个起点满足条件
                while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                    i++;
                    right = Math.max(right, intervals[i][1]);
                }
                // 将现在的区间放进res里面
                res.add(new int[]{left, right});
                // 接着判断下一个区间
                i++;
            }
            return res.toArray(new int[0][]);
        }
    }
}
