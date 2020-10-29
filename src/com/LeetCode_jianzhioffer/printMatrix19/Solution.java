package com.LeetCode_jianzhioffer.printMatrix19;

import java.util.ArrayList;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/27 16:12
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *
 * 链接：https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 简单来说，就是不断地收缩矩阵的边界
 * 定义四个变量代表范围，up、down、left、right
 *
 * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
 * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
 * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
 * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
 *
 */




public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (true){
            //访问最上面一行
            for (int i = left; i <=right ; i++) {
                list.add(matrix[up][i]);
            }
            //向下逼近
            up++;
            //判断是不是越界
            if (up>down){
                break;
            }
            //最右面一行
            for (int i = up; i <=down ; i++) {
                list.add(matrix[i][right]);
            }
            //向左逼近
            right--;
            ///. 判断是不是越界
            if (left>right)
                break;
            //最下面一行
            for(int i=right;i>=left ;i--){
                list.add(matrix[down][i]);
            }
            //向上逼近
            down--;
            //判断是不是越界
            if (up>down)
                break;

            //最左边一行
            for(int i=down;i>=up ;i--){
                list.add(matrix[i][left]);
            }
            //向右逼近
            left++;
            //判断是否越界
            if (left>right)
                break;
        }
        return list;
    }
}