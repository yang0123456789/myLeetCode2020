package com.面试算法题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 10:29
 * # @version 1.0
 * # @File : 扑克牌排序.java
 * # @Software: IntelliJ IDEA
 */
public class 扑克牌排序 {
    //    给花色赋权重0 2  15 28 41，排序时某个卡牌的绝对值等于花色+数字，依据这个排序，一次扫描OK。
    public String[] getpokeOrer(String[] cards) {
        Arrays.sort(cards, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = 0;
                int b = 0;
                if (o1.charAt(0) == 'k') {
                    a = 0;
                } else if (o1.charAt(0) == 's') {
                    a = 2;
                } else if (o1.charAt(0) == 'h') {
                    a = 15;
                } else if (o1.charAt(0) == 'p') {
                    a = 28;
                } else {
                    a = 41;
                }
                if (o2.charAt(0) == 'k') {
                    b = 0;
                } else if (o1.charAt(0) == 's') {
                    b = 2;
                } else if (o1.charAt(0) == 'h') {
                    b = 15;
                } else if (o1.charAt(0) == 'p') {
                    b = 28;
                } else {
                    b = 41;
                }
                if (a != b) return
                        a - b;
                else
                    return getscore(o1) - getscore(o2);
            }
        });

        return cards;
    }

    public int getscore(String poke) {
        int a = 0;
        int b = 0;
        if (poke.charAt(0) == 'k') {
            a = 0;
        } else if (poke.charAt(0) == 's') {
            a = 2;
        } else if (poke.charAt(0) == 'h') {
            a = 15;
        } else if (poke.charAt(0) == 'p') {
            a = 28;
        } else {
            a = 41;
        }
        b = Integer.parseInt(poke.substring(1));
//        System.out.println(a+b);
        return a + b;
    }


    public static void main(String[] args) {
        扑克牌排序 s = new 扑克牌排序();
        System.out.println("k1:" + s.getscore("k135"));
        String[] cards = new String[]{"s1", "s3", "s9", "s4", "h1", "p3", "p2", "q5", "q4", "q9", "k2", "k1"};
        s.getpokeOrer(cards);
        for (String str :
                cards) {
            System.out.print(str + "-");
        }
        System.out.println();
        double v = Double.parseDouble("41.24566");
        float v1 = Float.parseFloat("42.546");
        System.out.println(v1);
    }


}
