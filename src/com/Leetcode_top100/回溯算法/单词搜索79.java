package com.Leetcode_top100.回溯算法;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 22:28
 * # @version 1.0
 * # @File : 单词搜索79.java
 * # @Software: IntelliJ IDEA
 */
public class 单词搜索79 {
    //    单词必须按照字母顺序
//
//    同一个单元格内的字母不允许被重复使用。
//
//    可以从任意一个位置开始
    class Solution {

        private boolean[][] marked;

        //        x-1,y
        // x,y-1  x,y    x,y+1
        //        x+1,y
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        // 盘面上有多少行
        private int m;
        // 盘面上有多少列
        private int n;
        private String word;
        private char[][] board;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[m][n];
            this.word = word;
            this.board = board;
            for (int i = 0; i < m; i++) {
                //    可以从任意一个位置开始
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {//路径到最后一个位置了
                return word.charAt(start) == board[i][j];
            }
            if (word.charAt(start) == board[i][j]) {
                marked[i][j] = true;//设置访问标志，不可以重复访问
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (inArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;//回溯
            }
            return false;

        }
        private boolean inArea(int x, int y) {//保证不越界
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }

}
