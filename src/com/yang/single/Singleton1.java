package com.yang.single;/*
 @author
 @create 2020-05-21-18:53

    直接创建
    1.构造器私有
    2.直接静态创建实例  INSTACE
    3.实例入口公开
    4.防止多创建设置为final常量
 */



public class Singleton1 {


      public final   static Singleton1 INSTANCE = new Singleton1();

    private  Singleton1(){

    }


}
