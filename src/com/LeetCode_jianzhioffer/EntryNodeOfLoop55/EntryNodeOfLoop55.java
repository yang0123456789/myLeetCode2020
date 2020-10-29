package com.LeetCode_jianzhioffer.EntryNodeOfLoop55;

import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 10:41
 * # @version 1.0
 * # @File : EntryNodeOfLoop55.java
 * # @Software: IntelliJ IDEA
 */
public class EntryNodeOfLoop55 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null||pHead.next==null) return null;
        Set<ListNode> set=new HashSet<>();
        set.add(pHead);
        ListNode work=pHead.next;
        while (work!=null){
            if (set.contains(work)){
                return work;
            }else {
                set.add(work);
                work=work.next;
            }

        }
        return null;
    }

    }
}
