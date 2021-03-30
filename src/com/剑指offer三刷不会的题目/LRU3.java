package com.剑指offer三刷不会的题目;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 **/

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRU3<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LRU3(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余cacheSize个时，删除最老的节点（即最不经常使用的元素）
     *
     * @param eldest
     * @return
     */
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > getCacheSize();
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public static void main(String[] args) {
        LRU3<Character, Integer> lru = new LRU3<>(8);
        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i + 1);
        }
        System.out.println("LRU的大小： " + lru.size());
        System.out.println(lru);
        System.out.println("LRU的中key为h的value值： " + lru.get('h'));
        System.out.println(lru);
        lru.put('z', 26);
        System.out.println(lru);
    }
}

