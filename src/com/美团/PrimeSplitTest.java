package com.美团;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 19:32
 * # @version 1.0
 * # @File : thgf.java
 * # @Software: IntelliJ IDEA
 */

import java.util.*;

public class PrimeSplitTest {
    public static void main(String[] args) {
        int x; //定义一个整型变量
        Scanner sc = new Scanner(System.in);//定义从键盘输入
//        System.out.print("请输入一个正整数:");//提示
        while (sc.hasNextInt()) {
            x = sc.nextInt();//将从键盘输入的数赋值给x
            new PrimeSplit(x); //匿名初始化一个对象，还有参数的构造函数
        }
    }
}

class PrimeSplit {
    int k = 2; //将最小的质数赋值给k

    public PrimeSplit(int x) {
        //小于等于1的数不可以分解
        if (x <= 1) {
//            System.out.println(x+"是无效的被分解数");
            System.out.println(x + "=" + x);
        }
        //如果输入的是最小质数2，
        else if (x == 2) {
//            System.out.println(x+"分解后的质因数为: 1*"+x);
            System.out.println(x + "=" + x);
        } else {
            //1是所有的正整数的质数
            System.out.print(x + "=");
            while (k <= x) {
                //输入的数可以被k整除
                if (x % k == 0) {
                    //将k添加到结果中
                    System.out.print("*" + k);
                    x = x / k;//除以最小质数后重新循环
                }
                //如果k不能被x整除，就将k++
                else {
                    k++;
                }
            }
        }
    }
}