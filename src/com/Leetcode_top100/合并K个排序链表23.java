package com.Leetcode_top100;

import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/3 21:29
 * # @version 1.0
 * # @File : 合并K个排序链表23.java
 * # @Software: IntelliJ IDEA
 *
 * 方法三，直接将所有链表合成一个数组，然后用快排序，然后再组成一个链表
 */
public class 合并K个排序链表23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        //暴力破解法
        public ListNode mergeKLists(ListNode[] lists) {

            int len = lists.length;
            if (len == 0) return null;
            if (len == 1) return lists[0];
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            head.next = lists[0];
            for (int i = 1; i < len; i++) {
                mergeTwoLists(head.next, lists[i], head);
            }
            return head.next;


        }

        public void mergeTwoLists(ListNode l1, ListNode l2, ListNode head) {
            ListNode temp = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                    temp = temp.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                    temp = temp.next;
                }
            }
            if (l1 == null) {
                temp.next = l2;
            }
            if (l1 == null) {
                temp.next = l2;
            }
            if (l2 == null) {
                temp.next = l1;
            }
        }
    }

    class solution2 {
        //每次合并两个，时间复杂度比较低
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) {
                return null;
            }
            // 将n个链表以中间为对称，合并，即合并
            while (len > 1) {
                for (int i = 0; i < len / 2; i++) {
                    lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
                }
                len = (len + 1) / 2;
            }
            return lists[0];
        }

        // 合并两个链表
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            } else if (l2 != null) {
                p.next = l2;
            }
            return head.next;
        }

    }
}
