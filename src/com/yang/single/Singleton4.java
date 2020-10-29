package com.yang.single;/*
 @author
 @create 2020-05-21-18:53

    直接创建
    适合单线程
 */


import sun.security.jca.GetInstance;

public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }


            instance = new Singleton4();
        }

        return instance;
    }

}
