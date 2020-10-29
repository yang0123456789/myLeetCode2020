package com.LeetCode_jianzhioffer.FindNumbersWithSum42;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 15:12
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    //    链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b?answerType=1&f=discussion
//    来源：牛客网
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //边界条件
        if (array == null || array.length <= 1) {
            return result;
        }

        int smallIndex = 0;
        int bigIndex = array.length - 1;
        while (smallIndex < bigIndex) {
            //如果相等就放进去
            if ((array[smallIndex] + array[bigIndex]) == sum) {
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                //最外层的乘积最小，别被题目误导
                break;
            } else if ((array[smallIndex] + array[bigIndex]) < sum) {
                smallIndex++;
            } else {
                bigIndex--;
            }
        }
        return result;
    }
}
