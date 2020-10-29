package com.牛客网OJ在线编程.E;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 22:33
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n>0){
             int sum = 0;
             String a=in.nextLine();
             String[] as=a.split(" ");
           for(int i=1;i<as.length ;i++){
           sum+=Integer.parseInt(as[i]);
           }
            System.out.println(sum);
           n--;
        }
    }
}


 class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n>0){
            int sum = 0;
            String a = sc.nextLine();
            String[] as = a.split(" ");
            for(int i=1;i<as.length;i++){
                sum = sum + Integer.parseInt(as[i]);
            }
            System.out.println(sum);
            n--;
        }
    }
}