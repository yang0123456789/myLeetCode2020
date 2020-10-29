package com.aliTest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/20 17:07
 * # @version 1.0
 * # @File : Main3.java
 * # @Software: IntelliJ IDEA
 */
public class Main3 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int w=sc.nextInt();
//        int k=sc.nextInt();
//        sc.nextLine();
//        int[] costs=new int[n];
//        int[] profits=new int[n];
//        for(int i=0;i< ;i++){
//
//        }
//
//    }
    public static class Node { //项目所对应的节点
        public int p;
        public int c;
        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node> { //这是生成小根堆的时候的比较器
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {//这是生成大根堆的时候的比较器
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) { //构建项目所对应的节点
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator()); //生成小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());//生成大根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) { //W是初始资金
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
