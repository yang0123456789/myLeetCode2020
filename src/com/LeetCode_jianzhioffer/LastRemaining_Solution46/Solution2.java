package com.LeetCode_jianzhioffer.LastRemaining_Solution46;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/15 19:00
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
    class Node {
        int value;
        Node next;

        //        Solution.Node pre;
        public Node(int n) {
            this.value = n;
        }}

        public int LastRemaining_Solution(int n, int m) {
            if (n == 0) return -1;
            if (n == 1) return 0;
            if (m == 0) return n;
            Node first = new Node(0);
            Node head = new Node(-1);
            head.next = first;

            for (int i = 1; i < n; i++) {
                System.out.println("插入第几个节点：" + i);
                Node node = new Node(i);
                first.next = node;
                first = node;
            }

            first.next=head.next;
            Node pre=first;
            Node work=head.next;

            while (work.next!=work){
                for(int i=0;i<m-1 ;i++){
                    work=work.next;
                    pre=pre.next;

                }
                System.out.println("删除第几个节点："+work.value);
                work=work.next;
                pre.next=work;
            }


            return work.value;

    }
    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        int m=s2.LastRemaining_Solution(5,3);
        System.out.println(m);
    }

}
