package com.LeetCode_jianzhioffer.FindNumsAppearOnce40;

import java.util.Set;
import java.util.TreeSet;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 16:07
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *num1,num2分别为长度为1的数组。传出//将num1[0],num2[0]设置为返回结果
 *
 *
 */
public class Solution {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length<2||array.length%2!=0)return;
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<array.length ;i++){
        if (set.contains(array[i])){
            set.remove(array[i]);
            System.out.println("排除："+array[i]);
        }else {
            set.add(array[i]);
        }

        }
        Object[] array1 = set.toArray();
        System.out.println(array1.length);
        num1[0]=(int)array1[0];
        num2[0]=(int)array1[1];

    }

    public static void main(String[] args) {
        int[] num1=new int[1];
        int[] num2=new int[1];
        int[] array=new int[]{2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(array,num1,num2);
    }

}
