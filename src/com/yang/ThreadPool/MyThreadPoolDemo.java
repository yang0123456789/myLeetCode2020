package com.yang.ThreadPool;

/**
 * # @author  chilcyWind
 * # @Time   2020/6/4 10:52
 * # @version 1.0
 * # @File : MyThreadPoolDemo.java
 * # @Software: IntelliJ IDEA
 */


import java.util.concurrent.*;

/**
 * 第四种获得java多线程的方式--线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();
    //        ExecutorService threadPool = Executors.newCachedThreadPool();

        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
//new ThreadPoolExecutor.AbortPolicy();
//new ThreadPoolExecutor.CallerRunsPolicy();
//new ThreadPoolExecutor.DiscardOldestPolicy();
//new ThreadPoolExecutor.DiscardPolicy();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();

        }
    }
}
