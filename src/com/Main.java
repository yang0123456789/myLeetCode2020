package com;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/27 10:39
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int[][] dp = new int[n][n];//int[i][j] 表示i到j[i,j]有几个 e，则f的数量为j-i+1-e；差值就是两个的差值
        int res = 0;
        //初始化对角线
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'E') {
                dp[i][i] = 1;
                res = 1;
            }else {
                dp[i][i]=-1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j) == 'E') {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] - 1;
                }
                res = Math.max(dp[i][j], res);
            }

        }
        System.out.println( res >= 0 ? res : 0);


    }
}
