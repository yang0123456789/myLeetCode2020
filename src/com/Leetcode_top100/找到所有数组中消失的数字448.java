package com.Leetcode_top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 10:38
 * # @version 1.0
 * # @File : 找到所有数组中消失的数字448.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 我们可以在输入数组本身以某种方式标记已访问过的数字，然后再找到缺失的数字。
 * 遍历输入数组的每个元素一次。
 * 我们将把 |nums[i]|-1 索引位置的元素标记为负数。即 nums[∣nums[i]∣−1]×−1 。
 * 然后遍历数组，若当前数组元素 nums[i] 为负数，说明我们在数组中存在数字 i+1。
 * 可以通过以下图片示例来帮助理解。
 */
public class 找到所有数组中消失的数字448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int newindex = Math.abs(nums[i]) - 1;
                if (nums[newindex] > 0) {
                    nums[newindex] *= -1;
                }
            }
            List<Integer> result = new LinkedList<Integer>();

            // Iterate over the numbers from 1 to N and add all those
            // that have positive magnitude in the array
            for (int i = 1; i <= nums.length; i++) {

                if (nums[i - 1] > 0) {
                    result.add(i);
                }
            }

            return result;

        }

        class Solution2 {
            public List<Integer> findDisappearedNumbers(int[] nums) {
                Arrays.sort(nums);

                List<Integer> result = new LinkedList<Integer>();


                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] != i + 1) {
                        result.add(i + 1);
                    }
                }

                return result;

            }
        }
    }
}