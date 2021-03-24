package com.虾皮面试;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle2(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;


                }
            }
            return null;
        }
        //判断是否有环
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }


    }
}