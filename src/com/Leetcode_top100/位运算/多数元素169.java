package com.Leetcode_top100.位运算;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/26 1:08
 * # @version 1.0
 * # @File : 多数元素169.java
 * # @Software: IntelliJ IDEA
 */
public class 多数元素169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }

    class Solution {
        private Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
            for (int num : nums) {
                if (!counts.containsKey(num)) {
                    counts.put(num, 1);
                }
                else {
                    counts.put(num, counts.get(num)+1);
                }
            }
            return counts;
        }

        public int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = countNums(nums);

            Map.Entry<Integer, Integer> majorityEntry = null;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
                }
            }

            return majorityEntry.getKey();
        }
    }

    class Solution2{
//        如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为n/2 的元素（下标从 0 开始）一定是众数。
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }

    class Solution3 {
//        这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数算法
//        由于一个给定的下标对应的数字很有可能是众数，我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选。

        private int randRange(Random rand, int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private int countOccurences(int[] nums, int num) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        public int majorityElement(int[] nums) {
            Random rand = new Random();

            int majorityCount = nums.length/2;

            while (true) {
                int candidate = nums[randRange(rand, 0, nums.length)];
                if (countOccurences(nums, candidate) > majorityCount) {
                    return candidate;
                }
            }
        }
    }
//
//    方法四：分治
//    方法五：Boyer-Moore 投票算法
class Solution5 {
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}

}
