package com.二刷leetcode核心题目.DFS;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/16 9:26
 * # @version 1.0
 * # @File : 组合数字问题.java
 * # @Software: IntelliJ IDEA
 *
 * 从一个数组中选择若干数字组成一个值s，有的话返回true，没有的话，返回false。数组都是正数
 *
 */
public class 组合数字问题 {
    public boolean isInArr(int[] arr,int s){
        //从最高位开始操作，也可以从最低位开始操作，结果是一样的
        return rec_subset(arr,arr.length-1,s);

    }

    public boolean rec_subset(int[] arr,int i,int s){
        //1.先写出口条件
        if (s==0) {return true;}
        else if (i==0){
            return arr[0]==s;
        }
        else if (arr[i]>s){//这一步是进行剪枝 预先判断大于S的元素，直接删除，再选子集
            return rec_subset(arr,i-1,s);
        }
        else {//进行递归的条件
            return rec_subset(arr,i-1,s) ||rec_subset(arr,i-1,s-arr[i]);
        }
    }
}
