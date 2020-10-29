package com.Leetcode_top100;

import java.lang.annotation.Target;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/2 17:47
 * # @version 1.0
 * # @File : 两数相加2.java
 * # @Software: IntelliJ IDEA
 * https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * 官方题解
 */
public class 两数相加2 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //笨方法，先转化为对应的整数，然后相加，然后再将结果变成链表
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
}