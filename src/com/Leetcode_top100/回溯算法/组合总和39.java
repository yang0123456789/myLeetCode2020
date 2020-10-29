package com.Leetcode_top100.回溯算法;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/21 14:44
 * # @version 1.0
 * # @File : 组合总和39.java
 * # @Software: IntelliJ IDEA
 */
public class 组合总和39 {
    //   双端队列的初始化 ArrayDeque<String> arrayDeque = new ArrayDeque<>(4);
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            int len = candidates.length;
            dfs(candidates, len, target, 0, new ArrayDeque<>(), lists);
            return lists;


        }

        /**
         * @param candidates 数组输入
         * @param len        输入数组的长度，冗余变量
         * @param residue    剩余数值
         * @param begin      本轮搜索的起点下标
         * @param path       从根结点到任意结点的路径
         * @param res        结果集变量
         */
        public void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> res) {
            if (residue == 0) {
                // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                //数组是经过排序的，因此，直接不考虑begin位置之前的数字，从begin往后进行递归，
                // 这样就不会出现类似[2,3,3] [2,3,2][3,2,2]的重复了，指挥出现[3,2,2]

                if (residue - candidates[i] < 0) {
                    // 在数组有序的前提下，剪枝
                    break;
                }

                path.addLast(candidates[i]);

                dfs(candidates, len, residue - candidates[i], i, path, res);
                //回溯的关键点，将上一步加上的元素剔除掉，然后走别的路径，每一步执行完，都剔除掉对path路径的修改，返回递归调用的上层走别的路径，
                path.removeLast();


            }


        }
    }

    class Solution2 {

        public  List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), candidates, target, 0);
            return result;
        }

        private  void backtrack(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
                return;
            }
            //相当于遍历N叉树的子节点
            for (int i = start; i < candidates.length; i++) {
                //如果当前节点大于target我们就不要选了
                if (target < candidates[i])
                    continue;
                //由于在java中List是引用传递，所以这里要重新创建一个,用新创建的list省去了回溯的过程，每次都传递一个新的list，就不用回溯了
                List<Integer> list = new ArrayList<>(cur);
                list.add(candidates[i]);
                backtrack(result, list, candidates, target - candidates[i], i);
            }
        }


    }
}