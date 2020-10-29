package com.yang.test;

import com.yang.single.Singleton1;
import com.yang.single.Singleton2;
import com.yang.single.Singleton3;
import com.yang.single.Singleton4;

import java.util.concurrent.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/21 19:19
 * # @version 1.0
 * # @File : singleTest.java
 * # @Software: IntelliJ IDEA
 */
public class singleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        System.out.println(singleton1);
        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2);
        Singleton3 singleton3 = Singleton3.INSTANCE;
        System.out.println(singleton3);

//        Singleton4 singleton41 = Singleton4.getInstance();
//        Singleton4 singleton42 = Singleton4.getInstance();
//        System.out.println(singleton41 == singleton42);
//        System.out.println(singleton41);
//        System.out.println(singleton42);

        Callable<Singleton4> c =new Callable<Singleton4>(){

            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
//        创建多线程的第四种方式：线程池
        ExecutorService es= Executors.newFixedThreadPool(2);
        Future<Singleton4> f1=es.submit(c);
        Future<Singleton4> f2=es.submit(c);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}
