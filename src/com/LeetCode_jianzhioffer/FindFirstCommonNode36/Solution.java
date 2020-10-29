package com.LeetCode_jianzhioffer.FindFirstCommonNode36;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 13:23
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp1=pHead1;
        ListNode temp2=pHead2;
        while (temp1!=null){
            while (temp2!=null){
                if (temp1==temp2){
                    return temp1;
                }else {
                    temp2=temp2.next;
                }

            }
            temp1=temp1.next;
            temp2=pHead2;
        }
        return null;

    }
}
