package com.Leetcode_top100.排序;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/25 16:53
 * # @version 1.0
 * # @File : 排序.java
 * # @Software: IntelliJ IDEA
 */
public class 排序链表148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }


    class Solution2{
//        递归方法

        public ListNode sortList(ListNode head) {
            // 1、递归结束条件
            if (head == null || head.next == null) {
                return head;
            }

            // 2、找到链表中间节点并断开链表 & 递归下探
            ListNode midNode = middleNode(head);
            ListNode rightHead = midNode.next;
            midNode.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(rightHead);

            // 3、当前层业务操作（合并有序链表）
            return mergeTwoLists(left, right);
        }

        //  找到链表中间节点（876. 链表的中间结点）
        private ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        // 合并两个有序链表（21. 合并两个有序链表）
        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode sentry = new ListNode(-1);
            ListNode curr = sentry;

            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }

                curr = curr.next;
            }

            curr.next = l1 != null ? l1 : l2;
            return sentry.next;
        }
    }

    class Solution3 {
        public ListNode sortList(ListNode head) {

//        4.    cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
            if (head == null || head.next == null)
                return head;

            //一、分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
//                1.我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
                slow = slow.next;
                fast = fast.next.next;
            }
//           2. 找到中点 slow 后，执行 slow.next = None 将链表切断。
            ListNode tmp = slow.next;
            slow.next = null;
//        3.    递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);

        // 二、合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
//            1.双指针法合并，建立辅助ListNode h 作为头部。
            ListNode h = new ListNode(0);
            ListNode res = h;
//            设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
//            返回辅助ListNode h 作为头部的下个节点 h.next。
            return res.next;
        }
    }
    class Solution4 {
//        根据以上推论，我们可以仅根据intv计算每个单元边界，并完成链表的每轮排序合并，例如:
//        当intv = 1时，将链表第1和第2节点排序合并，第3和第4节点排序合并，……。
//        当intv = 2时，将链表第1-2和第3-4节点排序合并，第5-6和第7-8节点排序合并，……。
//        当intv = 4时，将链表第1-4和第5-8节点排序合并，第9-12和第13-16节点排序合并，……。

        class Solution {
            public ListNode sortList(ListNode head) {
                ListNode h, h1, h2, pre, res;
                h = head;
                int length = 0, intv = 1;
                while (h != null) {
                    h = h.next;
                    length++;
                }
                res = new ListNode(0);//头节点
                res.next = head;
                while (intv < length) {
                    //两个段长为intv的段合并
                    pre = res;
                    h = res.next;
                    while (h != null) {
                        int i = intv;
                        h1 = h;//第一段长度为intv的起点
                        while (i > 0 && h != null) {
                            h = h.next;//h移动到pre节点的后 intv个节点
                            i--;
                        }
                        if (i > 0) break;//如果第一段都凑不够intv个长度，不需要排序，经过前面的intv长度排序是有序的
                        i = intv;
                        h2 = h;//第二段长度为intv的起点
                        while (i > 0 && h != null) {
                            h = h.next;//h是下两段长度为intv的节点的起点
                            i--;//i剩余几个，就说明第二段距离intv差几个
                        }
                        int c1 = intv, c2 = intv - i;//c1,c2代表两段的距离
                        //合并intv
                        while (c1 > 0 && c2 > 0) {
                            if (h1.val < h2.val) {
                                pre.next = h1;
                                h1 = h1.next;
                                c1--;
                            } else {
                                pre.next = h2;
                                h2 = h2.next;
                                c2--;
                            }
                            pre = pre.next;
                        }
                        pre.next = c1 == 0 ? h2 : h1;//剩下的部分连接到该段
                        while (c1 > 0 || c2 > 0) {//pre移动到这两段排序好的末端
                            pre = pre.next;
                            c1--;
                            c2--;
                        }
                        pre.next = h;//连接上下一段排序的头节点
                    }
                    intv *= 2;//将intv增大一段继续排序
                }
                return res.next;
            }
        }
    }


}
