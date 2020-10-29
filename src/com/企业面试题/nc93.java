package com.企业面试题;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/27 21:39
 * # @version 1.0
 * # @File : nc93.java
 * # @Software: IntelliJ IDEA
 */
public class nc93 {
    /**
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        LinkedHashMap<Integer, Integer> maps = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < operators.length; i++) {
            int ope = operators[i][0];
            int key = operators[i][1];
            if (ope == 1) {
                //set操作
                int value=operators[i][2];
                if (maps.containsKey(key)) {
                    maps.remove(key);
                } else {
                    if (maps.size() == k) {
                        maps.remove(maps.keySet().toArray()[0]);

                    }

                }
                maps.put(key, operators[i][2]);

            } else if (ope == 2) {
                if (maps.containsKey(key)) {
                    int vla = maps.remove(key);
                    maps.put(key, vla);
                    list.add(maps.get(key));
                } else {
                    list.add(-1);
                }
            }

        }

        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++) arr[i]=list.get(i);
        return arr;

    }
}
