package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/27 21:10
 * # @version 1.0
 * # @File : nc78.java
 * # @Software: IntelliJ IDEA
 */
public class nc78 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while (head != null) {
            next = head.next; // 1.记录当前节点的下一个节点位置；
            head.next = pre; //2. 让当前节点指向前一个节点位置，完成反转
            pre = head; // 3.pre 往右走
            head = next;// 4.当前节点往右继续走
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}


