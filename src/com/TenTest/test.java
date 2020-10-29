package com.TenTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 18:47
 * # @version 1.0
 * # @File : test.java
 * # @Software: IntelliJ IDEA
 */
public class test {
    public static void main(String[] args) {
//        Random r = new Random(1);
//        for (int i = 0; i < 5; i++) {
//            int ran1 = r.nextInt(100);
//            System.out.println(ran1);
//        }
//        int max = 100, min = 1;
////        [0.0,1.0）的double型数值
//        int ran2 = (int) (Math.random() * (max - min) + min);
//        System.out.println(ran2);

        String[] stri=new String[]{"1","23 ","12 "," 11","13 "};
        Arrays.sort(stri);
        for(int i=0;i<stri.length ;i++){
            System.out.println(stri[i]);
        }
    }
}