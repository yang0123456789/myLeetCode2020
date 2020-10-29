package com.LeetCode_jianzhioffer.FindKthToTail14;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/25 22:32
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 设置两个指针，第一个往后走k个节点，如果没有走到第k个节点或者走到第k个节点为空，说明数组长度不到k，返回null；
 * 如果第k个节点不是空，然后第一个节点再往前走一步，如果为空，说明只有k个节点，返回head，如果不为空，则然后第一个指针往后走一步如果，第二个指针往后再走一步，
 * 直到第一个节点走到最后一个节点的下一个空节点，第二个指针的位置就是倒数第k个节点的位置
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        int count = 0;
        ListNode first = head;
        ListNode sec = head;
        for (int i = 0; i < k; i++) {
            if (first == null) return null;
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            sec=sec.next;
        }
        return sec;


    }
}