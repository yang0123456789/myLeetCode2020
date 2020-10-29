package com.牛客网OJ在线编程.H;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 22:51
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()){
            String a=sc.nextLine();
            String[] as=a.trim().split(" ");
            Arrays.sort(as);
           for(int i=0;i<as.length ;i++){
               System.out.print(as[i] + ' ');
           }
        }

    }
}