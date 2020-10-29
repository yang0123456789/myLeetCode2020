package com.xiaomi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/8 18:50
 * # @version 1.0
 * # @File : Main2.java
 * # @Software: IntelliJ IDEA
 */
public class Main2 {

    private static char[][] boards = {{
            'A', 'B', 'C', 'E',},

            {'S', 'F', 'C', 'S'},

            {'A', 'D', 'E', 'E'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().trim();
        int m =boards.length;
        int n =boards[0].length;

        boolean[][] marked = new boolean[m][n];
        int k=word.length();
        if (k<=0) System.out.println("false"); ;
        boolean flag=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int start = 0;
                if (word.charAt(start) == boards[i][j]) {
                    if (exit(boards, marked, k, i, j, word, start + 1)) {
                       if(k>0) System.out.println("true");
                        flag=true;

                    }
                }
            }
        }
      if (k>0&&!flag) System.out.println(false);

    }

    private static boolean exit(char[][] boards, boolean[][] marked, int k, int i, int j, String word, int start) {
        if (start == k) return true;
        marked[i][j] = true;
        int[][] xy = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};//四个方向
        for (int dic = 0; dic < 4; dic++) {

            int x = xy[dic][0] + i;
            int y = xy[dic][1] + j;
            //边界判断
            if (x < 0 || y < 0 || (x >= boards.length) || (y >= boards[0].length)||marked[x][y]) {
                continue;
            }
            if (boards[x][y] == word.charAt(start)) {
                if (exit(boards, marked, k, x, y, word, start + 1)) {
                    return true;
                }
            }

        }
        marked[i][j]=false;
        return false;


    }

}
