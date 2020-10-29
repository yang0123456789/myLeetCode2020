package com.美团笔试;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/6 10:23
 * # @version 1.0
 * # @File : 公司管理.java
 * # @Software: IntelliJ IDEA
 */
import java.util.ArrayList;
import java.util.List;

public class sum {
    public static List<Double> list = new ArrayList<Double>();

    public static void main(String[] args) {
        double[] keys = { 1, 2, 3, 4, 5, 6, 7, 121, 154, 156465, 154, 0.05,
                4564, 1564, 121, 11 };
        System.err.println(getNum(keys, 11.05));
    }

    static List<Double> getNum(double[] keys, double kill) {
        int n = keys.length;
        int nbit = 1 << n;
        double in;
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < nbit; i++) {
            in = 0;
            list.clear();
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j; // 由0到n右移位
                if ((tmp & i) != 0) { // 与运算，同为1时才会是1
                    in += keys[j];
                    list.add(keys[j]);
                }
            }
            if (in == kill)
                return list;
        }
        return list;
    }

}
