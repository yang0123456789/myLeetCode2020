package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/26 0:55
 * # @version 1.0
 * # @File : 相交链表160.java
 * # @Software: IntelliJ IDEA
 */
public class 相交链表160 {

//    方法一: 暴力法
//    对链表A中的每一个结点 a_i，遍历整个链表 B 并检查链表 B 中是否存在结点和 a_i相同。

//方法二: 哈希表法
//遍历链表 A 并将每个结点的地址/引用存储在哈希表中。然后检查链表 B 中的每一个结点 b_i是否在哈希表中。若在，则 b_i  为相交结点。

//    方法三：双指针法
//    创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
//    当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
//    若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
//    想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
//    如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
//方法三很好理解，就是a + all +b = b + all + a  all 是两个链表相交部分的个数, a 是 A 链表不相交的个数, b 是 B 链表不相交的个数.
//a + c + b   = b + c + a  ，其中，c为公共部分，a，b分别为两个链表在交点之前的部分，正好走到相交的位置

//    若不相交，a +b = b+a 。因此相遇处是NULL
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = q == null? headA : q.next;
        }
        return p;
    }
}
}
