package com.yuanfudao;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/12 19:31
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 *
 * https://www.nowcoder.com/questionTerminal/138f0ae35154438caf3d0072bd6ffef5
 */


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[t];
        for (int i = 0; i < t; i++) {
            strs[i] = sc.nextLine();
            String[] split = strs[i].trim().split(" ");
            String str1 = split[0];
            String str2 = split[1];
            String aim = split[2];
            int k = Integer.parseInt(split[3]);
            boolean flag = chkMixture(str1, str1.toCharArray().length, str2, str2.toCharArray().length, aim, aim.toCharArray().length);
            System.out.println(flag);
        }


    }

    //    public boolean dfs(){
//
//    }
    public static boolean chkMixture(String str1, int n, String str2, int m, String aim, int v) {
        if (str1 == null || str2 == null || aim == null)
            return false;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (m + n != v)
            return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1][0] && ch1[i - 1] == chaim[i - 1])
                dp[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
            if (dp[0][j - 1] && ch2[j - 1] == chaim[j - 1])
                dp[0][j] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((dp[i - 1][j] && ch1[i - 1] == chaim[i + j - 1])
                        || (dp[i][j - 1] && ch2[j - 1] == chaim[i + j - 1]))
                    dp[i][j] = true;
            }
        }
        return dp[n][m];
    }


    public static boolean chkMixture(String A, int n, String B, int m, String C, int v, int k) {
        int count = 0;
        // write code here
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (dp[i][j]) {
                    if (i < n && A.charAt(i) == C.charAt(i + j)) {
                        dp[i + 1][j] = true;
                        count++;
                    }
                    if (j < m && B.charAt(j) == C.charAt(i + j)) {
                        dp[i][j + 1] = true;
                        count++;
                    }
                }
            }
        }

        return dp[n][m] && count <= k;
    }
}

