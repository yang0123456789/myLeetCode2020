package com.二刷leetcode核心题目.分治算法;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 16:54
 * # @version 1.0
 * # @File : 合并K个升序链表_23.java
 * # @Software: IntelliJ IDEA
 */
//分治法
public class 合并K个升序链表_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);


    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) return null;

        int mid = (l + r) >> 1;

        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    public ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode();
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
