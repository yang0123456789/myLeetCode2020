package com.面试算法题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/26 20:11
 * # @version 1.0
 * # @File : sdfsafds.java
 * # @Software: IntelliJ IDEA
 */
public class 二进制位操作 {
    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     *
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String get32BitBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(Integer.valueOf("11000000000000000000000000000001",2));
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] strings = s.trim().split(" ");

            int[] num = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                num[i] = Integer.parseInt(strings[i]);
            }

            int len = 32 * num.length;
            String[] str_num = new String[num.length];
            for (int i = 0; i < num.length; i++) {
                str_num[i] = get32BitBinString(num[i]);
            }

            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < str_num.length; i++) {
                sBuilder.append(str_num[i]);
            }
//            System.out.println(sBuilder.toString());
//            System.out.println(sBuilder.length());
//            互换相邻的二进制位置
            char[] chars = sBuilder.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 1) {
                    char tem = chars[i];
                    chars[i] = chars[i - 1];
                    chars[i - 1] = tem;
                }
            }

            sBuilder = new StringBuilder();
            sBuilder.append(chars);
//            System.out.println(sBuilder);
            char tem1 = sBuilder.charAt(len - 2);
            char tem2 = sBuilder.charAt(len - 1);
            sBuilder.delete(len - 2, len);

            StringBuilder res = new StringBuilder();
            res.append(tem1);
            res.append(tem2);
            res.append(sBuilder);
            StringBuilder str2 = new StringBuilder();
            int[] bignum = new int[num.length];
            for (int i = 1; i <= num.length; i++) {
                System.out.println(res.substring((i - 1) * 32, i * 32));
                if (res.substring((i - 1) * 32, i * 32).equals("10000000000000000000000000000000")) {
                    bignum[i - 1] = Integer.valueOf(Integer.MAX_VALUE);
//                str2.append("2147483648"+" ");
                    str2.append(bignum[i - 1]+" ");
                    System.out.println(bignum[i - 1]+" ");
                } else {
                    bignum[i - 1] = Integer.valueOf(res.substring((i - 1) * 32, i * 32), 2);
                    System.out.println(num[i - 1]);
                    str2.append(bignum[i - 1] + " ");
                }
//            }
                System.out.println(str2.toString());


//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(get32BitBinString(i));
            }
        }
    }
}