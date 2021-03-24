package com.LeetCode_jianzhioffer.RandomListNode25;

import java.util.HashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/29 16:13
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对
 * 此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 整体思路还是想的比较简单：用map保存旧节点和新节点之间的映射关系，如果节点已经存在那么使用存在的节点即可，如果不存在
 * 那么需要新开辟节点并存储他们之间的映射关系
 * <p>
 * 1.创建三个节点，newhead 指向复制的新的链表的头结点
 * p代表正在复制的旧的节点
 * q代表正在复制的新节点
 * 创建一个map<旧节点，复试的新节点>，用来提供查询，如果旧的节点被复制过，在后面复制的过程中，就用map中存储的这个新的节点
 * <p>
 * <p>
 * <p>
 * 3.首先复制头节点，将旧的节点的值值复制到将头结点放入map中，让p指向pHead，q指向复制的新的newHead
 * 复制节点的操作是，存在就用map中复制过的。不存在就复制旧的节点的值，然后递归复制新的next和random节点
 * <p>
 * 4.然后开始复制头结点的next 部分，如果不存在，创建一个辅助节点temp，将p.next节点的值放入temp中，然后将f这个
 * 放入的map中，将q.next指向temp
 * <p>
 * 5.然后复制random部分,与next部分是一样的
 * <p>
 * 6.然后p指向下一个，q也走向下一个，循环复制，循环的终止条件是p==null，即沿着p。next走到最后
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = null;
        RandomListNode p = pHead;
        RandomListNode q = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            if (newHead == null) {
                newHead = new RandomListNode(pHead.label);
                q = newHead;
                map.put(pHead, newHead);
            } else {
                if (p.next != null && map.containsKey(p.next)) {
                    q.next = map.get(p.next);
                } else {
                    if (p.next != null) {
                        RandomListNode temp = new RandomListNode(p.next.label);
                        map.put(p.next, temp);
                        q.next = temp;
                    }
                }
                if (p.random != null && map.containsKey(p.random)) {
                    q.random = map.get(p.random);
                } else {
                    if (p.random != null) {
                        RandomListNode temp = new RandomListNode(p.random.label);
                        map.put(p.random, temp);
                        q.random = temp;

                    }
                }

                p = p.next;
                q = q.next;


            }
        }
        return newHead;
    }


    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;

        // target 作为将要返回的头，记住要new的
        RandomListNode target = new RandomListNode(pHead.label);
        // cur 获取链表头
        RandomListNode cur = pHead;
        // p   获取新链表头
        RandomListNode p = target;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        // 由pHead将所有值存入map，每一个结点都要new的
        while (pHead != null) {
            map.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }

        // target作为新链表的头，由cur，p移动来复制链表
        while (cur != null) {
            p.next = map.get(cur.next);
            p.random = map.get(cur.random);

            cur = cur.next;
            p = p.next;
        }

        return target;
    }
}
