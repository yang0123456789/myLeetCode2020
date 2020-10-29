package com.TenTest;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 20:04
 * # @version 1.0
 * # @File : Main2.java
 * # @Software: IntelliJ IDEA
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String[] lists = new String[N];
        for (int i = 0; i < N; i++) {
            lists[i] = sc.nextLine();
        }
        StringBuffer bf = new StringBuffer();
        HashMap<String, Integer> maps = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            if (maps.containsKey(lists[i])) {
                int count = maps.get(lists[i]);
                maps.put(lists[i], count + 1);
            } else {
                maps.put(lists[i], 1);
                bf.append(lists[i] + " ");
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(maps.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else return (o2.getValue() - o1.getValue());
            }
        });
        int count = 0;
        for (Map.Entry<String, Integer> entry : entries
        ) {
            if (count >= K) {
                break;
            }
            System.out.println(entry.getKey() + " "+entry.getValue());
            count++;


        }
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else return (o1.getValue() - o2.getValue());
            }
        });
         count = 0;
        for (Map.Entry<String, Integer> entry : entries
        ) {
            if (count >= K) {
                break;
            }
            System.out.println(entry.getKey() + " "+entry.getValue());
            count++;


        }
    }
}