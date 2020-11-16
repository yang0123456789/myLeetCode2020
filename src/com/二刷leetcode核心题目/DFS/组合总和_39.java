package com.二刷leetcode核心题目.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 9:26
 * # @version 1.0
 * # @File : 组合数字问题.java
 * # @Software: IntelliJ IDEA
 *
 * 三个条件很重要：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 给定一个无重复元素的数组
 *
 *
 */
public class 组合总和_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;//到最后一个+1的位置，说明前面已经遍历结束，仍然没有凑成，直接返回
        }
        if (target == 0) {//上一步没结束，说明还没遍历结束，这个时候如果 target=0说明凑成了，将结果集加入到ans中
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 不选idx位置的数，往下走
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当idx位置的数
        if (target - candidates[idx] >= 0) {//满足这个数比剩下的target才能选，大于的话没法选
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);//回溯到上一步，将combine中的加入的这个数删去，加了才删，不加不用删
        }
    }

}
