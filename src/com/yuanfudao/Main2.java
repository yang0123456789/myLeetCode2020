package com.yuanfudao;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/12 19:45
 * # @version 1.0
 * # @File : Main2.java
 * # @Software: IntelliJ IDEA
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m ;i++) {
            list.add(sc.nextInt());
        }
        System.out.println(list.toString());
        for (int i = 0; i < n; i++) {
            list=orders(list, m);
        }
        for (int i = 0; i < m; i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static ArrayList<Integer> orders(ArrayList<Integer> list, int m) {
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < m / 2; i++) {
            list2.add(list.get(m / 2 + i));
            list2.add(list.get(i));
        }
        list = list2;
        System.out.println(list.toString());
        return list2;
    }

//    public ArrayList<Integer> orders2(int n, List<Integer> arr) {
//        List<Integer> newarr = new ArrayList<>();
//        int i = 0;
//        int mid = n / 2;
//        int j = mid;
//        boolean flag = true;
//        while (i < mid && j < n) {
//            if (flag) {
//                newarr.add(arr.get(j));
//                j += 1;
//                flag = false;
//            } else {
//                newarr.add(arr.get(i));
//                i += 1;
//                flag = true;
//            }
//        }
//        while i<mid:
//        newarr.append(arr[i])
//        i += 1
//        while j<n:
//        newarr.append(arr[j])
//        j += 1
//        return newarr
//
//
//        if __name__ == '__main__':
//        n, m = list(map( int,input().split()))
//        arr = list(map( int,input().split()))
//        print(swarp(arr))
//    }
}
