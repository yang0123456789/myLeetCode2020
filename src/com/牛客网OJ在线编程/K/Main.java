package com.牛客网OJ在线编程.K;



/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 23:10
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 *   // 不要用 int a, b, 因为测试数据会越界，为了效果，所以这个题目故意不在题面说数据范围
 *     // 你可以试试测试用例 12141483647 12141483647，输出结果是否正确
 */
import java.util.Arrays;
import java.util.Scanner;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLong()){
            long a=sc.nextLong();
            long b=sc.nextLong();
            System.out.println(a+b);
        }

    }
}

class Main2 {
    public static void main(String[] args){
        Scanner cn=new Scanner(System.in);
        while(cn.hasNextLine()){
            String str=cn.nextLine();
            String[] strd=str.split(" ");
            long sum=0;
            for(String s:strd){
                sum+=Long.valueOf(s);
            }

            System.out.println(sum);
        }
    }
}

 class Main3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(sc.nextLong()+sc.nextLong());
        }
    }
}
class Main4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            long sum = 0;
            for(int i=0;i<arr.length;i++){
                long a = Long.parseLong(arr[i]);
                sum += a;
            }
            System.out.println(sum);
        }
    }
}