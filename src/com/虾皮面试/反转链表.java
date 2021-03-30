package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/27
 * @Version 1.0
 **/
public class 反转链表 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ans = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null)
                ans = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;
    }
}
