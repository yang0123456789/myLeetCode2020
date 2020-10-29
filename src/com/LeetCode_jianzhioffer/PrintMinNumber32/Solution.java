package com.LeetCode_jianzhioffer.PrintMinNumber32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 22:54
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
//    链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?f=discussion
//    来源：牛客网

    public static String PrintMinNumber(int [] numbers) {
        if (numbers.length==1)return Arrays.toString(numbers);
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>(){

            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            System.out.println(j);
            s+=j;
        }
        return s;

    }

    public static void main(String[] args) {
        PrintMinNumber(new int[]{102,1,123,103,101,156,456});

    }
}
