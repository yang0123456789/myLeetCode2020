package com.LeetCode_jianzhioffer.Merge16;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/26 8:57
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * 1. 第一步先判断第一个链表是否为空，为空则返回第二个链表地址，如果不为空，第二个链表为空，则返回第一个链表地址。如果都
 * 不为空进行下一步
 * 2.创建两个指针分别指向两个链表，创建一个新的为空的指针head，这就是合成后的头结点，首先比较两个链表的头结点，确定head
 * 的地址。然后设置一个辅助指针tar首先指向head节点，负责比较两个链表节点的大小，tar.next指向小的，然后小的和tar都往后走
 * 一个节点，继续比较大小，最终一个走到头，将另一个剩下的合并到target。最终返回head就是合成后的链表
 *
 *
 * 方法二：同一，但是初始化head节点不为null而是值为-1的节点作为头结点，然后返回的是head.next的地址
 * 如果初始化为null的话，返回的是nullpointexception错误
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list1!=null&&list2==null) return list1;

        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode head =new  ListNode(-1);
        if (h1.val<h2.val){
            head= h1;
            h1=h1.next;
        }else {
            head=h2;
            h2=h2.next;
        }

        ListNode tar = head;
        while (h1!=null&&h2!=null){
            if (h1.val<h2.val){
                tar.next = h1;
                h1=h1.next;
                tar=tar.next;
            }else {
                tar.next=h2;
                h2=h2.next;
                tar=tar.next;
            }

        }
        if (h1!=null){
            tar.next = h1;
        }
        if (h2!=null){
            tar.next = h2;
        }
        return head;

    }
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list1!=null&&list2==null) return list1;

        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode head = new  ListNode(-1);
        ListNode tar = head;
        while (h1!=null&&h2!=null){
            if (h1.val<h2.val){
                tar.next = h1;
                h1=h1.next;
                tar=tar.next;
            }else {
                tar.next=h2;
                h2=h2.next;
                tar=tar.next;
            }

        }
        if (h1!=null){
            tar.next = h1;
        }
        if (h2!=null){
            tar.next = h2;
        }
        return head.next;


    }
}