package com.LeetCode_jianzhioffer.multiply51;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 21:08
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?f=discussion
 * 来源：牛客网
 *
 * 剑指的思路：
 * B[i]的值可以看作下图的矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，
 * 然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 *
 */
public class Solution2 {
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        if (B.length!=0){
            B[0]=1;
            //计算下三角连乘,从1到最后一位
            for(int i=1;i<A.length ;i++){
                B[i]=B[i-1]*A[i-1];
            }
            int temp=1;
            //计算上三角，因为B[n-1]已经计算过，从倒数第二位往前算，直到第一位0
            for(int j=A.length-2;j>=0 ;j--){

                temp=temp*A[j+1];
                B[j]=B[j]*temp;

            }

        }

        return B;

    }
}
