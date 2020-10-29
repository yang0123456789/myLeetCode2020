package com.面试算法题;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/31 14:32
 * # @version 1.0
 * # @File : Solution3.java
 * # @Software: IntelliJ IDEA
 */
public class Solution3 {
   public static int isOverlap(int x1,int x2,int x3,int x4, int y1,int y2,int y3,int y4)
    {
        if (x3  >= y1 &&
                y3 >= x1 &&
                x4 >= y1 &&
                y4 >= x1
        )
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(isOverlap(0,0,4,2,0,1,5,3));
    }
}
