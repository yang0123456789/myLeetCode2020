package com.LeetCode_jianzhioffer.EntryNodeOfLoop55;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 15:47
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
 * 来源：牛客网
 *
 * 思路：
 *     设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)。接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)。以下是两个结论证明：
 * 两个结论：
 * 1、设置快慢指针，假如有环，他们最后一定相遇。
 * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
 * 证明结论1：设置快慢指针fast和low，fast每次走两步，low每次走一步。假如有环，两者一定会相遇（因为low一旦进环，可看作fast在后面追赶low的过程，每次两者都接近一步，最后一定能追上）。
 * 证明结论2：
 * 设：
 * 链表头到环入口长度为--a
 * 环入口到相遇点长度为--b
 * 相遇点到环入口长度为--c


 * 则：相遇时
 * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）。
 * 慢指针路程=a+b
 * 快指针走的路程是慢指针的两倍，所以：
 * （a+b）*2=a+(b+c)k+b
 * 化简可得：
 * a=(k-1)(b+c)+c 这个式子的意思是： 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
 */
public class Solution {
    class ListNode {
        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
//    链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
//    来源：牛客网

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        low = pHead;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}