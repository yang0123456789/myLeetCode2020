package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 11:15
 * # @version 1.0
 * # @File : 旋转图像48.java
 * # @Software: IntelliJ IDEA
 */
public class 旋转图像48 {
//    方法 1 ：转置加翻转
//    最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

}
