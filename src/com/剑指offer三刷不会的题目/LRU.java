package com.剑指offer三刷不会的题目;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 * 我们知道，当accessOrder标志位为true时，表示双向链表中的元素按照访问的先后顺序排列，
 * 可以看到，虽然Entry插入链表的顺序依然是按照其put到LinkedHashMap中的顺序，但put和get
 * 方法均有判断accessOrder的值。如果accessOrder为true，put时将新插入的元素放入到双向链
 * 表的尾部，get时将当前访问的Entry移到双向链表的尾部。当标志位accessOrder的值为false时，
 * 表示双向链表中的元素按照Entry插入LinkedHashMap到中的先后顺序排序，即每次put到LinkedHashMap
 * 中的Entry都放在双向链表的尾部，这样遍历双向链表时，Entry的输出顺序便和插入的顺序一致，这也是
 * 默认的双向链表的存储顺序。
 *
 * 使用LinkedHashMap实现LRU的必要前提是将accessOrder标志位设为true以便开启按访问顺序排序的模式。我们可以看到，
 * 无论是put方法还是get方法，都会导致目标Entry成为最近访问的Entry，因此就把该Entry加入到了双向链表的末尾。
 * 这样，我们便把最近使用的Entry放入到了双向链表的后面。多次操作后，双向链表前面的Entry便是最近没有使用的，
 * 这样当节点个数满的时候，删除最前面的Entry即可，因为它就是最近最少使用的Entry。
 * ————————————————
 * 版权声明：本文为CSDN博主「fuzhongmin05」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/fuzhongmin05/article/details/104355841
 **/
public class LRU<K, V> {

    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / hashLoadFactory) + 1;
        map = new LinkedHashMap<K, V>(capacity, hashLoadFactory, true) {
            private static final long serialVersionUID = 1;

             // * 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余cacheSize个时，删除最老的节点（即最不经常使用的元素）
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRU.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(128);
        System.out.println("------HashMap------");
        map.put("first", "a");
        map.put("second", "b");
        map.put("third", "c");
        map.put("fourth", "d");
        map.put("fifth", "e");
        map.put("sixth", "f");
        map.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);
        });

        map.clear();
        System.out.println("------LinkedHashMap------");
        map = new LinkedHashMap<>(128);
        map.put("first", "a");
        map.put("second", "b");
        map.put("third", "c");
        map.put("fourth", "d");
        map.put("fifth", "e");
        map.put("sixth", "f");

        map.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);
        });
    }



}