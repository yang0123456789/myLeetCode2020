package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 9:30
 * # @version 1.0
 * # @File : 反转链表206.java
 * # @Software: IntelliJ IDEA
 */
public class 反转链表206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode res = null;
            ListNode tem = head;
            while (head != null) {
                tem = head.next;
                head.next = res;
                res = head;
                head = tem;
            }
            return res;
        }
    }
//    看了半个小时可算是把这个递归看懂了！不妨假设链表为1，2，3，4，5。按照递归，当执行reverseList（5）的时候返回了5这个节点，
//    reverseList(4)中的p就是5这个节点，我们看看reverseList（4）接下来执行完之后，5->next = 4, 4->next = null。这时候返回了p这个节点，
//    也就是链表5->4->null，接下来执行reverseList（3），代码解析为4->next = 3,3->next = null，
//    这个时候p就变成了，5->4->3->null, reverseList(2), reverseList(1)依次类推，p就是:5->4->3->2->1->null
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;//最后一个节点和最后一个节点为null的next节点
        ListNode p = reverseList(head.next);
        //递归的意思：我子节点下的所有节点都已经反转好了，现在就剩我和我的子节点 没有完成最后的反转了，所以反转一下我和我的子节点。
        head.next.next = head;
        head.next = null;
        return p;
    }
}

