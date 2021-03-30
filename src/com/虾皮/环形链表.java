package com.虾皮;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/27
 * @Version 1.0
 * a+(n+ 1)b+ nc= 2(a+b)→
 * a=c+ (n- 1)(b+c)
 * 从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
 *
 * 因此，当发现 \textit{slow}slow 与 fast 相遇时，我们再额外使用一个指针 ptr。
 * 起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 **/
public class 环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;


            }
        }
        return null;
    }
}
