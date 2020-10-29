package com.yang.single;/*
 @author
 @create 2020-05-21-18:53

    改进
    锁已经解决重排序问题了，无论整么重排序都只new一个对象
 */


public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    instance = new Singleton5();
                }
            }
        }

        return instance;

    }

}

