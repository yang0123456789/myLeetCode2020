package com.LeetCode_jianzhioffer.GetMedian63;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/5 17:26
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public int count = 0;//存储里面有几个元素,从1开始


    public void Insert(Integer num) {
        if (count == 0) {
            list.add(num);
            count++;
            System.out.println("count:" + count);
            return;
        }
        //从小到大存储元素
        for (int i = 0; i < count; i++) {
            Integer k = list.get(i);
            if (k >=num) {
                list.add(i, num);
                count++;
                System.out.println("count:" + count);
                return;

            }
        }
        list.add(num);
        count++;

        System.out.println("count:" + count);

    }

    public Double GetMedian() {
        Double d = 0.00;
        if (count % 2 == 0) {
            d = (list.get(count / 2) + list.get(count / 2 - 1)) / 2.00;

        }
        if (count % 2 == 1) {
            d = ((list.get((count - 1) / 2)))/1.00 ;

        }

        return d;

    }

    public static void main(String[] args) {
//        5,2,3,4,1,6,7,0,8

        Solution solution = new Solution();
        solution.Insert(5);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(2);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(3);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(4);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);


        solution.Insert(1);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(6);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(7);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
        solution.Insert(0);
        solution.Insert(8);
        System.out.println(solution.list+"中位数为："+solution.GetMedian()+" "+solution.count);
//        solution.Insert(1);

        List<Integer> list2=new ArrayList<>();
        list2.add(0,5);
        list2.add(1,5);
        System.out.println("list2.toString() = " + list2.toString());

    }
}

