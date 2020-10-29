package com.LeetCode_jianzhioffer.deleteDuplication56;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 9:12
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 链接：https://www.nowcoder.com/questionTerminal/fc533c45b73a41b0b44ccba763f866ef?f=discussion
 * 来源：牛客网
 *
 * 非递归的代码：
 *
 * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
 *
 * 2.设置 pre ，last 指针， pre指向已经确定不重复的最后一个节点，
 * pre.next指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索自己后面是否跟自己重复。
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)return pHead;
        ListNode head=new ListNode(0);
        head.next=pHead;
        ListNode start=head;
        ListNode next=head.next;

        while (next!=null){
            if (next.next!=null&&next.next.val==next.val){
                while (next.next!=null&&next.next.val==next.val){
                    next=next.next;
                }
                start.next=next.next;
                next=next.next;
            }else {
                start=start.next;
                next=next.next;
            }
        }

        return head.next;

    }
}
