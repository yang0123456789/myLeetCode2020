package com.yang.juc.lock;

/**
 * # @author  chilcyWind
 * # @Time   2020/6/1 17:53
 * # @version 1.0
 * # @File : ReadWriteLockDemo.java
 * # @Software: IntelliJ IDEA
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程象取写共享资源来，就不应该自由其他线程可以对资源进行读或写
 * 总结
 * 读读能共存
 * 读写不能共存
 * 写写不能共存
 */
public class ReadWriteLockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyCache2 myCache = new MyCache2();
        for (int i = 1; i <= 5; i++) {
//            Thread.sleep(1000);
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, "Thread " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, "Thread " + i).start();
        }
        Thread.sleep(5000);
        System.out.println(myCache.toString());
    }
}

class MyCache2 {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
//    private ReentrantLock rwLock = new ReentrantLock();

    /**
     * 写操作：原子+独占
     * 整个过程必须是一个完整的统一体，中间不许被分割，不许被打断
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        rwLock.writeLock().lock();
//        rwLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入：" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
//            rwLock.unlock();
        }

    }

    public void get(String key) {
//        rwLock.readLock().lock();
//        rwLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读取：" + key);
//            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            rwLock.readLock().unlock();
//            rwLock.unlock();
        }

    }

    public void clear() {
        map.clear();
    }

    public Map<String, Object> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "MyCache{" +
                "map=" + map.toString() +
                '}';
    }
}