package com.LeetCode_jianzhioffer.multiply51;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 21:08
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for(int i=0;i<A.length ;i++){
            B[i]=1;
            for (int j=0;j<A.length;j++){
                if (j==i) continue;
                B[i]=B[i]*A[j];
            }

        }
        return B;

    }
}
