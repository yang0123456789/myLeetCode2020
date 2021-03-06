package com.Leetcode_top100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/25 16:18
 * # @version 1.0
 * # @File : LRU缓存机制146.java
 * # @Software: IntelliJ IDEA
 */
public class LRU缓存机制146 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    class solution {
        public class LRUCache {
            //定义一个双向链表
            //双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
            class DLinkedNode {//
                int key;
                int value;
                DLinkedNode prev;
                DLinkedNode next;

                public DLinkedNode() {
                }

                public DLinkedNode(int _key, int _value) {
                    key = _key;
                    value = _value;
                }
            }

//            哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
            private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
            private int size;
            private int capacity;
            private DLinkedNode head, tail;

            public LRUCache(int capacity) {
                this.size = 0;
                this.capacity = capacity;
                // 使用伪头部和伪尾部节点
                head = new DLinkedNode();
                tail = new DLinkedNode();
                head.next = tail;
                tail.prev = head;
            }

            public int get(int key) {
                DLinkedNode node = cache.get(key);//根据hash表在 o(1)的时间获取对应的链表中的节点
                if (node == null) {
                    return -1;
                }
                // 如果 key 存在，先通过哈希表定位，再移到头部
                moveToHead(node);
                return node.value;
            }

            public void put(int key, int value) {
                DLinkedNode node = cache.get(key);
                if (node == null) {
                    // 如果 key 不存在，创建一个新的节点
                    DLinkedNode newNode = new DLinkedNode(key, value);
                    // 添加进哈希表
                    cache.put(key, newNode);
                    // 添加至双向链表的头部
                    addToHead(newNode);
                    ++size;
                    if (size > capacity) {
                        // 如果超出容量，删除双向链表的尾部节点
                        DLinkedNode tail = removeTail();
                        // 删除哈希表中对应的项
                        cache.remove(tail.key);
                        --size;
                    }
                } else {
                    // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                    node.value = value;
                    moveToHead(node);
                }
            }

            private void addToHead(DLinkedNode node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            private void removeNode(DLinkedNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            private void moveToHead(DLinkedNode node) {
                removeNode(node);
                addToHead(node);
            }

            private DLinkedNode removeTail() {
                DLinkedNode res = tail.prev;
                removeNode(res);
                return res;
            }
        }

    }
}