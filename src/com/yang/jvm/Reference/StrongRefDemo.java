package com.yang.jvm.Reference;

/**
 * # @author  chilcyWind
 * # @Time   2020/6/5 10:29
 * # @version 1.0
 * # @File : StrongRefDemo.java
 * # @Software: IntelliJ IDEA
 */
public class StrongRefDemo {
    public static void main(String[] args) {
        Object obj1=new Object();
        Object obj2=obj1;
        obj1=null;
        System.gc();
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
