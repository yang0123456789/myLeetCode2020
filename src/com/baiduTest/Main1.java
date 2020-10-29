package com.baiduTest;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/14 18:52
 * # @version 1.0
 * # @File : baiduTest.java
 * # @Software: IntelliJ IDEA
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 0; k < t; k++) {


            int n = sc.nextInt();//人
            int m = sc.nextInt();//戏
            sc.nextLine();
            int[] peoples = new int[n];
            Integer[] peoples2 = new Integer[n];
            int[] xi = new int[m];
//            int[] act = new int[n];
            for (int i = 0; i < n; i++) {
                peoples[i] = sc.nextInt();
                peoples2[i] = peoples[i];
            }
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                xi[i] = sc.nextInt();
            }
            sc.nextLine();
            Arrays.sort(peoples2);

            Arrays.sort(xi);


            HashMap<Integer,Integer> map=new HashMap<>();
            int i=0;
            int j=0;
           while (i<n&&j<m){
               while (j<m&&xi[j]<peoples2[i])j++;
               if (j<m) {
                   map.put(peoples2[i], m-j);
                   i++;
               }
           }
           if (i<n){
               for(int l=i;l<n ;l++){
                map.put(peoples2[i],0);
               }
           }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (xi[j] >= peoples[i]) {
//                        act[i] = act[i] + 1;
//                    }
//
//                }
//
//            }
            for (int l = 0; l < n; l++) {
                System.out.print(map.get(peoples[l]) + " ");
            }
            System.out.println();


        }
    }
}