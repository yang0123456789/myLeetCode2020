package com.yang.single;/*
 @author
 @create 2020-05-21-18:53
 */


public class Singleton6 {

    private Singleton6() {

    }

    private static class Inner {

        public final static Singleton6 INSTANCE = new Singleton6();


    }
    public  static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }

}
