package com.xiaomi;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/8 17:59
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stringList = sc.nextLine().trim().split(" ");
        int len = stringList.length;
        for (int i = 0; i < len; i++) {
            int sLen = stringList[i].length();
            if (sLen < 8 || sLen > 120) {
                System.out.println("1");

            }else if (!checkchars(stringList[i])){

                System.out.println("2");
            }
            else {
                System.out.println("0");
            }
        }


    }

  public static   boolean checkchars(String s) {
        boolean nums = false;
        boolean upChar = false;
        boolean lowChar = false;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums = true;
            } else if (c >= 'A' && c <= 'Z') {
                upChar = true;
            } else if (c >= 'a' && c <= 'b') {
                lowChar = true;
            } else {
                flag = true;
            }

        }
        return nums&&upChar&&lowChar&&flag;

    }
}
