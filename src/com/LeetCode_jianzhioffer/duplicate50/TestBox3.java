package com.LeetCode_jianzhioffer.duplicate50;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 22:13
 * # @version 1.0
 * # @File : TestBox3.java
 * # @Software: IntelliJ IDEA
 */



public class TestBox3 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Long d = 2L;
        Long e = 3L;
        int f = 2;
        //一旦有包装类型和数值类型判断==时，则触发包装类型的自动拆箱，转为数值类型的比较
        System.out.println(new Integer(300) == 300);//返回true

        //一旦有包装类型和数值类型发生运算时，则触发包装类型的自动拆箱，转为数值类型的运算
        System.out.println(c == (a + f));//返回true

        //一旦有包装类型和包装类型发生运算时，则触发包装类型的自动拆箱，转为数值类型的运算
        System.out.println(c == (a + b));//返回true

        //只有对象类型才有equals方法，因此首先a,b触发包装类型的自动拆箱，转为数值类型的运算。
        //运算完，再将结果3自动装箱，Integer重写了equals,因此可以转为包装类型与包装类型的比较。
        //当两边的包装类型不一致时，必定返回false。
        //当两边的包装类型一致时,再进行拆箱，判断两者代表的数值是否相等。
        System.out.println(c.equals(a + b));//返回true

        //不同数据类型的数值进行运算，首先会将低精度的数据类型转化为高精度的数据类型，即自动类型转换。
        //比如现在的int+long,会提升到long+long,再进行运算。
        System.out.println(e == (a + d));//返回true

        //==号两边类型不一致时，直接执行自动拆箱，比较之后的数值
        System.out.println(e == (a + b));//返回true

        //依次经历自动拆箱，自动类型转换、运算、自动装箱，类型比较，拆箱，数值比较
        System.out.println(e.equals(a + d));//返回true

        //依次经历自动拆箱，自动类型转换、运算、自动装箱，类型比较，两边类型不一致，直接返回false
        System.out.println(c.equals(a + d));//返回false
    }}