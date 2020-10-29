package com.LeetCode_jianzhioffer.ReverseList15;


/**
 * # @author  chilcyWind
 * # @Time   2020/5/25 23:10
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 三个指针，slow指向倒叙以后的第一个节点，mid指向正在操作的节点，fast指向操作节点的下一个节点。
 * 先把slow.next修改为null
 * 把mid.next修改为slow， 然后把slow = mid。mid= fast，fast=fast。next，一直循环，直到 fast=null，也就是mid是最后一个节点，将
 * mid.next改为 slow，返回mid，就是最终的值
 * 如果只有一个节点或者节点为空，返回该节点，如果只有两个节点，可以按上面的操作
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode mid = head.next;
        ListNode fast = mid.next;
        head.next = null;
        while (fast != null) {
            mid.next = slow;
            slow = mid;
            mid = fast;
            fast = fast.next;

        }
        mid.next = slow;
        return mid;

    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while (head != null) {
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }
}