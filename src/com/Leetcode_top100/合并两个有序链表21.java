package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/3 15:06
 * # @version 1.0
 * # @File : 合并两个有序链表21.java
 * # @Software: IntelliJ IDEA
 */
public class 合并两个有序链表21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode head = new ListNode();
            ListNode root = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                    head = head.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                    head = head.next;
                }
            }

            if (l1 != null) head.next = l1;
            if (l2 != null) head.next = l2;
            return root.next;
        }
    }
    class Solution2 {
        //递归解法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if (l1==null){
                return l2;
            }else if (l2==null)
            {
                return l1;
            }else if (l1.val<l2.val){
                l1.next=mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                l2.next=mergeTwoLists(l1,l2.next);
                return l2;
            }

        }
    }
}
