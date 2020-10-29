package com.华为笔试;

import com.Leetcode_top100.二叉树相关.TreeNode;

import java.sql.SQLOutput;
import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/9 19:07
 * # @version 1.0
 * # @File : 二叉树.java
 * # @Software: IntelliJ IDEA
 */
public class 二叉树 {
     二叉树(){
        
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, List<Integer>> maps = new HashMap<>();
        String n = sc.nextLine();
        for (int i = 0; i <Integer.parseInt(n); i++) {
            String line =sc.nextLine();
            List<Integer> list = new ArrayList<>();
//                Arrays.asList(line.split(" ")).parallelStream()
                Arrays.stream(line.trim().split(" ")).forEach(z->{
//                System.out.println("z = " + z);
                list.add(Integer.parseInt(z));
            });
//            int treeNode = sc.nextInt();
//            int weight = sc.nextInt();
//            int left = sc.nextInt();
//            int right = sc.nextInt();
//            list.add(weight);
//            list.add(left);
//            list.add(right);
            maps.put(list.get(0), list);
//            sc.nextLine();
        }
        int maxRes = Integer.MIN_VALUE;
        for (int treeNode = 1;treeNode <= Integer.parseInt(n); treeNode++) {
            int res = dfs(maps,-1 , treeNode);
            maxRes = Math.max(maxRes, res);

        }
        System.out.println(maxRes);
    }

    public static int dfs(HashMap<Integer, List<Integer>> maps, int i, int treeNode) {
        if (treeNode != -1) {

            List<Integer> list = maps.get(treeNode);
            int weight = list.get(1);
            if (i == -1) {
                //传入的i事-1的话，表示这个是第一个节点，不需要异或
                i = weight;
            } else {
                i = i ^ weight;
            }
            int left = list.get(2);
            int right = list.get(3);
            int leftRes = dfs(maps, i, left);
            int rightRes = dfs(maps, i, right);
            return Math.max(i, Math.max(leftRes, rightRes));
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
