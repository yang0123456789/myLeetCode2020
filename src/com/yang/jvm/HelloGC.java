package com.yang.jvm;

import java.util.concurrent.TimeUnit;

/**
 * # @author  chilcyWind
 * # @Time   2020/6/4 22:23
 * # @version 1.0
 * # @File : HelloGC.java
 * # @Software: IntelliJ IDEA
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("hello");
        Byte[] bytes=new Byte[50*1024*1024];
//        try {
//            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
