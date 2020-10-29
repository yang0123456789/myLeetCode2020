package com.LeetCode_jianzhioffer.GetUglyNumber33;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 21:33
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public static int GetUglyNumber_Solution(int index) {
        if (index<=0)return 0;
        if (index==1)return 1;

        int count=1;
        int ugly=0;
        for(int i=2;i< Integer.MAX_VALUE;i++){
            if (isUglyNumber(i)){
                count++;
                System.out.println("第"+count+"个数为："+i);
                if (count==index){
                    ugly=i;
                    return ugly;
                }
            }

        }

        return 0;

    }
    public static boolean isUglyNumber(int num){
        while (num%2==0){
            num=num/2;
        }
        while (num%3==0){
            num=num/3;
        }
        while (num%5==0){
            num=num/5;
        }
        return num==1?true:false;
    }

    public static void main(String[] args) {
        int i= GetUglyNumber_Solution(1500);
        System.out.println(i);
    }
}
