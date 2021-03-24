package com.牛客网OJ在线编程.H;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 22:51
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 * https://ac.nowcoder.com/acm/contest/5657/H
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
            System.out.println(String.join(" ",as));
        }

    }
}