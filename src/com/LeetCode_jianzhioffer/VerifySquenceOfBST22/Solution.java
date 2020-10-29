package com.LeetCode_jianzhioffer.VerifySquenceOfBST22;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/29 11:37
 * # @version 1.0
 * # @File : Sulotion.java
 * # @Software: IntelliJ IDEA
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个
 * 数字都互不相同。
 *
 *
 * 结合图中分析：
 *
 * 一棵 BST ：左孩子 < 根结点 < 右孩子
 *
 * 一棵 BST 的左子树或者右子树都是 BST
 *
 * 后序遍历是，左右根：[3, 4, 9, 5, 12, 11, 10]，结合图再从左往右分析后序序列，分析子树，可以发现：
 *
 * [3, 4, 9, 5] 10 [12, 11]
 * [3, 4] 5 [9]
 * [3] 4
 * [12] 11
 * 发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
 *
 * 那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，
 * 这个条件是否满足即可
 *
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)
            return false;
        return isBST(sequence, 0,sequence.length-1);



    }
    private  boolean isBST(int[] list , int start ,int end){
        if (start>=end){
            return true;
        }
        int val=list[end];
        int split=0;
        for(;split<end&&list[split]<val;split++);
        for(int i=split;i<end ;i++){
           if (list[i]<val){
               return false;
           }
        }
        return isBST( list,0,split-1)&&isBST( list,split,end-1);
    }



}
