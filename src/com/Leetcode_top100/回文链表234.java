package com.Leetcode_top100;

import java.util.ArrayList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/4 21:20
 * # @version 1.0
 * # @File : 回文链表234.java
 * # @Software: IntelliJ IDEA
 */
public class 回文链表234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<>();

            // Convert LinkedList into ArrayList.
            ListNode currentNode = head;
            while (currentNode != null) {
                vals.add(currentNode.val);
                currentNode = currentNode.next;
            }

            // Use two-pointer technique to check for palindrome.
            int front = 0;
            int back = vals.size() - 1;
            while (front < back) {
                // Note that we must use ! .equals instead of !=
                // because we are comparing Integer, not int.
                if (!vals.get(front).equals(vals.get(back))) {
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }
    }

    class Solution2 {

        private ListNode frontPointer;

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) return false;
                if (currentNode.val != frontPointer.val) return false;
                frontPointer = frontPointer.next;
            }
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
        }
    }

    class Solution3 {

        public boolean isPalindrome(ListNode head) {

            if (head == null) return true;

            // Find the end of first half and reverse second half.
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // Check whether or not there is a palindrome.
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) result = false;
                p1 = p1.next;
                p2 = p2.next;
            }

            // Restore the list and return the result.
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

}
