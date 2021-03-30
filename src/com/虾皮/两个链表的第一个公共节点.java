package com.虾皮;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/27
 * @Version 1.0
 **/
public class 两个链表的第一个公共节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode l1 = headA;
            ListNode l2 = headB;
            while (l1 != l2) {
                l1 = l1 != null ? l1.next : headB;
                l2 = l2 != null ? l2.next : headA;
            }
            return l1;


        }
    }
}
