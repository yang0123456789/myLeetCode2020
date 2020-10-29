package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 9:47
 * # @version 1.0
 * # @File : 汉明距离461.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 擦汗
 */
public class 汉明距离461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int[] binx = new int[32];
            int[] biny = new int[32];
            int tem = 0;
            while (x != 0) {
                int a = x % 2;
                binx[tem++] = a;
                x = x / 2;
            }
            tem = 0;
            while (y != 0) {
                int a = y % 2;
                biny[tem++] = a;
                y = y / 2;
            }
            int dis = 0;
            for (int i = 0; i < 32; i++) {
                if (binx[i] != biny[i]) {
                    dis++;
                }
            }
            return dis;

        }
    }

    //    计算 x 和 y 之间的汉明距离，可以先计算 x XOR y，然后统计结果中等于 1 的位数
    class Solution2 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

//    这里采用右移位，每个位置都会被移动到最右边。移位后检查最右位的位是否为 1 即可。检查最右位是否为 1，可以使用取模运算（i % 2）或者 AND 操作（i & 1），这两个操作都会屏蔽最右位以外的其他位。
class Solution3 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }
}

    public static void main(String[] args) {
        byte b= -127;//（b是byte类型的）
        System.out.println(b & 0xff);
        System.out.println(Integer.toHexString(b & 0xff));
        System.out.println(Integer.toHexString(b));
    }
}
