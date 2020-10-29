package com.TenTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 20:04
 * # @version 1.0
 * # @File : Main4.java
 * # @Software: IntelliJ IDEA
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String[] list1 = a.trim().split(" ");
        int n = sc.nextInt();
        sc.nextLine();
        String b = sc.nextLine();
        String[] list2 = b.trim().split(" ");
        Set<Integer> set1=new HashSet<>();
        for (int i = 0; i < m; i++) {
            set1.add( Integer.parseInt(list1[i]));
        }
//        int[] nums2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums2[i] = Integer.parseInt(list2[i]);
//        }

        for(int i=0;i<n ;i++){
            if (set1.contains(Integer.parseInt(list2[i]))){
                System.out.print(list2[i]+" ");
            }
        }
    }

}

