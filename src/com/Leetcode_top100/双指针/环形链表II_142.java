package com.Leetcode_top100.双指针;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/25 9:33
 * # @version 1.0
 * # @File : 环形链表II_142.java
 * # @Software: IntelliJ IDEA
 */
public class 环形链表II_142 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> visited = new HashSet<ListNode>();

            ListNode node = head;
            while (node != null) {
                if (visited.contains(node)) {
                    return node;
                }
                visited.add(node);
                node = node.next;
            }

            return null;
        }
    }

}
