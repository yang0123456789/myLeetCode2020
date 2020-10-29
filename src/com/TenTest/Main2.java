package com.TenTest;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 20:04
 * # @version 1.0
 * # @File : Main3.java
 * # @Software: IntelliJ IDEA
 */
public class Main2 {
    ArrayList<Integer> root = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Set<Integer>> group = new ArrayList<>();
        boolean flag;
        Set<Integer> setwithzero = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int len = sc.nextInt();
            for (int j = 0; j < len; j++) {
                Set<Integer> set = new HashSet<>();
                set.add(sc.nextInt());
                if (set.contains(0)) {
                    setwithzero = set;
                }
                group.add(i,set);
            }
            sc.nextLine();
        }
        Set<Integer> res = new HashSet<>();
        res.addAll(setwithzero);
        int count = 0;
        boolean flag2=true;
        while (count < m && !group.isEmpty()) {
            for (int i : res) {
                for (Set<Integer> set : group) {
                    if (set.contains(i))
                        res.addAll(set);
                }

            }
        }

    }
}
