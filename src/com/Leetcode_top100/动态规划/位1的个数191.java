package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/17 16:02
 * # @version 1.0
 * # @File : 位1的个数191.java
 * # @Software: IntelliJ IDEA
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例  中，输入表示有符号整数 -3。
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class 位1的个数191 {
    public class Solution {
        // you need to treat n as an unsigned value
        //方法 1：循环和位移动
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }


    public class Solution2 {
//        我们不再检查数字的每一个位，而是不断把数字最后一个 1 反转，并把答案加一。当数字变成 0的时候偶，我们就知道它没有 1的位了，此时返回答案。
//        这里关键的想法是对于任意数字 n ，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0 。为什么？考虑 n 和 n - 1的二进制表示。
//        相当于把n的最后一位1移动到最低位，而对高位的1没有影响
//        在二进制表示中，数字 n 中最低位的11总是对应 n - 1中的 0 。因此，将 n和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
//        6-> 1 1 0
//        5-> 1 0 1
//        &-> 1 0 0 删掉一个1
//
//        5-> 1 0 1
//        4-> 1 0 0
//        &-> 1 0 0 删掉一个1
//        链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
//        来源：力扣（LeetCode）
//
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count=0;
            while (n!=0){
                n&=n-1;
                count++;
            }
            return count;

        }
    }

}