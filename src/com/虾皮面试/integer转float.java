package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/23
 * @Version 1.0
 * java.lang包的Integer类的java.lang.Integer.floatValue()方法用于在扩展原始转换后将给定Integer的值转换为float类型。
 **/
public class integer转float {
    public static void main(String[] args) {

        //变量初始化

        int i1 = 30;

        int i2 = 40;
        double v = i2 * 1.0;
        System.out.println("ob2.floatValue(): " + i2 * 1.0);

//它返回一个由此Integer ob1对象表示的整数值

//转换为float

        Integer ob1 = new Integer(i1);

//显示ob1结果

        System.out.println("ob1.floatValue(): " + ob1.floatValue());

//它返回一个由此Integer ob2对象表示的整数值

//转换为float

        Integer ob2 = new Integer(i2);

//显示ob2结果

        System.out.println("ob2.floatValue(): " + ob2.floatValue());

    }

}
