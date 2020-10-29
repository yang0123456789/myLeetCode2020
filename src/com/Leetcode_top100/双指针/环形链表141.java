package com.Leetcode_top100.双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 23:04
 * # @version 1.0
 * # @File : 环形链表141.java
 * # @Software: IntelliJ IDEA
 */

public class 环形链表141 {
    public boolean hasCycle(ListNode head) {
        //借助hash表

        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

//快慢指针
    public boolean hasCycle3(ListNode head) {
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



    //        我这个自己琢磨出来的方法，貌似是快慢指针的变形？java 击败 100%，但是会破坏链表结构。
//        我想的是当 head.next 不为空时，将head.next 指向 head.next.next，相当于去掉了next节点，到最后如果有环，head == head.next

    //如果有环，进入到环里以后，删的最终只剩下两个互相指向对方的
    public boolean hasCycle2(ListNode head) {
        while(head != null){
            if(head == head.next){
                return true;
            }
            if(head.next != null){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return false;
    }


}
