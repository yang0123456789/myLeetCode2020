package com.LeetCode_jianzhioffer.GetUglyNumber33;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 22:44
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    public static int GetUglyNumber_Solution(int index) {
        if (index<=0)return 0;
        if (index==1)return 1;

        int[] ugly=new int[index];
        ugly[0]=1;

        int p2=0;
        int p3=0;
        int p5=0;
        for(int i=1;i< index;i++){
            ugly[i]=Math.min(Math.min(2*ugly[p2],3*ugly[p3]),5*ugly[p5]);
            if (ugly[i]==2*ugly[p2])p2++;
            if (ugly[i]==3*ugly[p3])p3++;
            if (ugly[i]==5*ugly[p5])p5++;
            System.out.println(ugly[i]);

        }
        return ugly[index-1];

    }
    public static void main(String[] args) {
        int i= GetUglyNumber_Solution(2);
        System.out.println(i);
    }
}
