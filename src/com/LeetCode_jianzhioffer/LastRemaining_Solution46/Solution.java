package com.LeetCode_jianzhioffer.LastRemaining_Solution46;

import java.util.LinkedList;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/15 17:41
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *用Java实现的话，可以使用LinkedList，考虑删除节点的效率。模拟游戏过程即可：
 *
 */
public class Solution {

    public  int LastRemaining_Solution(int n, int m) {



        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;


    }

    public static void main(String[] args) {

    }



}
