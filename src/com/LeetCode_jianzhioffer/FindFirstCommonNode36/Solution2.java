package com.LeetCode_jianzhioffer.FindFirstCommonNode36;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 13:30
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 看下面的链表例子：
 * 0-1-2-3-4-5-null
 * a-b-4-5-null
 * 代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
 * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
 * p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
 * p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
 * 因此，两个指针所要遍历的链表就长度一样了！
 * 如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
 */
public class Solution2 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        if (pHead1 == null || pHead2 == null) return null;
        if (pHead1==pHead2) return pHead1;
        while (temp1 != temp2) {

          temp1=temp1.next;
          temp2=temp2.next;
          if (temp1!=temp2){
          if (temp1==null){
            temp1=pHead2;
          }
            if (temp2==null){
                temp2=pHead1;
            }}





        }
        return temp1;
    }
}
