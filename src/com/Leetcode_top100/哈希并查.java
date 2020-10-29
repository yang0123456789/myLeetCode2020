package com.Leetcode_top100;

import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 22:07
 * # @version 1.0
 * # @File : 哈希并查.java
 * # @Software: IntelliJ IDEA
 */
public class 哈希并查 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            //set可以完成去重的目的
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                //如果这个数有比他小1位的，直接跳过，因为遍历到比他小1位的会找到他作为子序列的一部分。遍历的目的就是为了
                // 发现各个起点元素，然后由起点元素寻找连续子序列
                if (!num_set.contains(num - 1)) {//先找到一个num是连续序列的起点，也就是hashset中不存在比这个数小1的前一个数，
                    // 作为起点，遍历一遍就能确定所有可能的起点
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {//然后往后挨个找连成的序列
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

}
