package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/30 0:18
 * # @version 1.0
 * # @File : nc4.java
 * # @Software: IntelliJ IDEA
 */
public class nc4 {
    //1.快慢指针法
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                return true;

            }}
        return false;


    }
      class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
}
