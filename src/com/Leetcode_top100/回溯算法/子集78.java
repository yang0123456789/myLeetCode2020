package com.Leetcode_top100.回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 17:11
 * # @version 1.0
 * # @File : 子集78.java
 * # @Software: IntelliJ IDEA
 */
public class 子集78 {



    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList();
            output.add(new ArrayList<Integer>());//先加一个空的

            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList();
                //挨个将新的num加到 output，每一个子串的后面，保存到一个新的List<List<Integer>>中，
                // 再将这个新的list元素挨个加入到output中，相当于是按顺序加入output中每个以num[i]结尾的子串
                for (List<Integer> curr : output) {
                    newSubsets.add(new ArrayList<Integer>(curr) {{ //挨个将新的num加到 output，
                        add(num);
                    }});
                }
                for (List<Integer> curr : newSubsets) { // 再将这个新的list元素挨个加入到output中
                    output.add(curr);
                }
            }
            return output;
        }
    }
    class Solution3 {
        //回溯法
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
            // if the combination is done
            if (curr.size() == k)
                output.add(new ArrayList(curr));

            for (int i = first; i < n; ++i) {
                // add i into the current combination
                curr.add(nums[i]);
                // use next integers to complete the combination
                backtrack(i + 1, curr, nums);
                // backtrack
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {//根据长度遍历所有的走k步的路径，添加到结果中，k表示路径有几个元素，因此范围是0-n，所以这个是看k<n+1
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return output;
        }
    }

    class Solution {
//        字典排序
        public List<List<Integer>> subsets(int[] nums) {
//            将每个子集映射到长度为 n 的位掩码中，其中第 i 位掩码 nums[i] 为 1，表示第 i 个元素在子集中；
//            如果第 i 位掩码 nums[i] 为 0，表示第 i 个元素不在子集中。


            List<List<Integer>> output = new ArrayList();
            int n = nums.length;
            //Math.*pow*(2, 3)); 2的3次方
            for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
                // generate bitmask, from 0..00 to 1..11
                String bitmask = Integer.toBinaryString(i).substring(1);
                // substring (int beginIndex)从beginIndex开始截取字符串到字符串结尾
                //toBinaryString一个二进制字符串.

                // append subset corresponding to that bitmask
                List<Integer> curr = new ArrayList();
                for (int j = 0; j < n; ++j) {
                    if (bitmask.charAt(j) == '1') curr.add(nums[j]);
                }
                output.add(curr);
            }
            return output;
        }
    }

}
