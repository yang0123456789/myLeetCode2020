package com.yang.test;

import com.yang.single.Singleton5;


import java.util.concurrent.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/21 19:19
 * # @version 1.0
 * # @File : singleTest.java
 * # @Software: IntelliJ IDEA
 */
public class singleTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<Singleton5> c = new Callable<Singleton5>() {

            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };
//        创建多线程的第四种方式：线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = es.submit(c);
        Future<Singleton5> f2 = es.submit(c);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        es.shutdown();
    }
}
