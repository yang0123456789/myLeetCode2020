package com.collection;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/15 9:55
 * # @version 1.0
 * # @File : HashcodeTest.java
 * # @Software: IntelliJ IDEA
 */
public class HashcodeTest {
    public static void main(String[] args) {
        /*
         * Object类：
         * 			类Object是类层次结构的根类，每个类都使用Object作为超类。
         * 			每个类都直接或间接继承自Object类
         * Object类的方法：
         * 			public native int hashCode();返回该对象的hash码值
         * 			注：哈希值是根据哈希算法算出来的一个值，这个值跟地址值有关，但不是实际地址值。

         * */
        Student s1 = new Student();
        System.out.println(s1.hashCode());
        System.out.println(s1);
        //366712642
        //javase2.Student@15db9742
        System.out.println("--------------------------");
        Student s2 = new Student();
        System.out.println(s2.hashCode());
        System.out.println(s2);
        //1829164700
        //javase2.Student@6d06d69c
        System.out.println("--------------------------");
        Student s3=s2;
        System.out.println(s3.hashCode());
        System.out.println(s3);
        //1829164700
        //javase2.Student@6d06d69c
    }
}
class Student{
    public String name;
    public int id;
}
