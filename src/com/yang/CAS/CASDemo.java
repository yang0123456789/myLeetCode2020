package com.yang.CAS;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/25 17:00
 * # @version 1.0
 * # @File : CASDemo.java
 * # @Software: IntelliJ IDEA
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.CAS是什么？
 * 1.1比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        checkCAS();
    }

    public static void checkCAS(){
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data is " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014) + "\t current data is " + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
