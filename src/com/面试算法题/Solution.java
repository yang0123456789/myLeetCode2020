package com.面试算法题;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/31 14:00
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public static int get_StringNum(String str) {
        if (str == null || "".equals(str)) return Integer.parseInt(str);
        str = str.trim();
        String str2 = "";
        int resut = -1;

        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }
        }
        if (str2.length() == 0) {
            return -1;
        }
        else {
            double l = Double.parseDouble(str2);
            if (l > Integer.MAX_VALUE) {
                resut =  Integer.MAX_VALUE;
                return resut;
            }
            resut = Integer.parseInt(str2);
            return resut;
        }
    }

    public static void main(String[] args) {
        String str = "-+gh-j453546ijkljkl";
        System.out.println(get_StringNum(str));
    }

}
