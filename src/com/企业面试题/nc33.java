package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/1 0:04
 * # @version 1.0
 * # @File : nc33.java
 * # @Software: IntelliJ IDEA
 */
public class nc33 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        // write code here
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        ListNode head=null;

        if(l1.val>=l2.val){
            head=l2;
            l2=l2.next;

        }else{
            head=l1;
            l1=l1.next;
        }
        ListNode res=head;
        while(l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                head.next=l2;
                l2=l2.next;
                head=head.next;

            }else{
                head.next=l1;
                l1=l1.next;
                head=head.next;
            }

        }
        if(l1==null){
            head.next=l2;
        }
        if(l2==null){
            head.next=l1;
        }
        return res;

    }

     class ListNode {
      int val;
      ListNode next = null;
    }

}
