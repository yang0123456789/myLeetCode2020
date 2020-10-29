package com.LeetCode_jianzhioffer.FirstNotRepeatingChar34;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 21:31
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
//    链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c?f=discussion
//    来源：牛客网

    public int FirstNotRepeatingChar(String str)
    {
        char[] c = str.toCharArray();
        int[] a = new int['z'];
        for (char d : c)
            a[(int) d]++;
        for (int i = 0; i < c.length; i++)
            if (a[(int) c[i]] == 1)
                return i;
        return -1;
    }
}
