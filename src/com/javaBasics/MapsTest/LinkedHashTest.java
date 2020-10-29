package com.javaBasics.MapsTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/10 14:50
 * # @version 1.0
 * # @File : LinkedHashTest.java
 * # @Software: IntelliJ IDEA
 */
public class LinkedHashTest {
    public static void main(String[] args) {
//        键是按照:“c”, “d”,"a"的顺序插入的，修改d不会修改顺序
        Map<String, Integer> seqMap = new LinkedHashMap<>();
        seqMap.put("c",100);
        seqMap.put("d",200);
        seqMap.put("a",500);
        seqMap.put("d",300);
        for(Map.Entry<String,Integer> entry:seqMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());

        }
        System.out.println("```````````````````");
//        其中参数accessOrder就是用来指定是否按访问顺序，如果为true，就是访问顺序。
//        访问顺序：所谓访问指的是get/put操作，对一个键执行get/put操作后，其对应的键值对会移动到链表末尾，所以最末尾的是最近访问的，最开始的是最久没有被访问的，这就是访问顺序。
        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);
        accessMap.put("c", 100);
        accessMap.put("d", 200);
        accessMap.put("a", 500);
//        accessMap.get("c");
        accessMap.put("d", 300);
        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

            LRUCache<String,Object> cache = new LRUCache<>(3);
            cache.put("a","abstract");
            cache.put("b","basic");
            cache.put("c","call");
            cache.get("a");
            cache.put("d","滴滴滴");
            System.out.println(cache); // 输出为：{c=call, a=abstract, d=滴滴滴}
        }

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "C++");
        map.put(1, "Java");

        map.put(3, "PHP");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + entry.getValue());


        }


        Integer i=25;
        String string = Integer.toBinaryString(i);
        System.out.println(string);
    }
}
class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int maxEntries;

    public LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }

}