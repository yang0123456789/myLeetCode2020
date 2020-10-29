package com.Leetcode_top100.动态规划;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/2 11:48
 * # @version 1.0
 * # @File : 最大正方形221.java
 * # @Software: IntelliJ IDEA
 */
public class 最大正方形221 {
    class Solution {
        //动态规划
        public int maximalSquare(char[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }
            int rows = matrix.length, columns = matrix[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        // 遇到一个 1 作为正方形的左上角
                        maxSide = Math.max(maxSide, 1);
                        // 计算可能的最大正方形边长
                        int currentMaxSide = Math.min(rows - i, columns - j);
                        for (int k = 1; k < currentMaxSide; k++) {
                            // 判断新增的一行一列是否均为 1
                            boolean flag = true;
                            if (matrix[i + k][j + k] == '0') {
                                break;
                            }
                            for (int m = 0; m < k; m++) {
                                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                maxSide = Math.max(maxSide, k + 1);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            int maxSquare = maxSide * maxSide;
            return maxSquare;
        }
    }



    class Solution2 {
        public int maximalSquare(char[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }
            int rows = matrix.length, columns = matrix[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        // 遇到一个 1 作为正方形的左上角
                        maxSide = Math.max(maxSide, 1);
                        // 计算可能的最大正方形边长
                        int currentMaxSide = Math.min(rows - i, columns - j);
                        for (int k = 1; k < currentMaxSide; k++) {
                            // 判断新增的一行一列是否均为 1
                            boolean flag = true;
                            if (matrix[i + k][j + k] == '0') {
                                break;
                            }
                            for (int m = 0; m < k; m++) {
                                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                maxSide = Math.max(maxSide, k + 1);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            int maxSquare = maxSide * maxSide;
            return maxSquare;
        }
    }


}
