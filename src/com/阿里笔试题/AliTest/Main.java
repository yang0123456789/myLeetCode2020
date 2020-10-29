package com.aliTest;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/11 9:09
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String s = sc.nextLine();
        String[] mingan = new String[m];
        for (int i = 0; i < m; i++) {
            mingan[i] = sc.nextLine();
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max += main.pipeiNum(s, mingan[i]);

        }
        System.out.println(max);
//        System.out.println(main.pipeiNum("hello","hello"));

    }

    public int pipeiNum(String s, String moshi) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = moshi.toCharArray();
        int total = 0;
        for (int i = 0; i < chars1.length - chars2.length + 1; i++) {
            if (chars1[i] == chars2[0]) {
                int tem = 1;
                for (int j = 1; j < chars2.length; j++) {
                    if (chars1[i + j] == chars2[j]) {
                        tem++;
                    } else {
                        break;
                    }
                }
                if (tem == chars2.length) total++;
            }
        }
        return total;
    }

//    public boolean kmp(String str,String sub) {
//        int j=0;
//        int[] n=next(sub);
//
//
//    }
}
