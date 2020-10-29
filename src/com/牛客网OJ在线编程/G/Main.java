package com.牛客网OJ在线编程.G;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 22:51
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int sum = 0;
            String a = sc.nextLine();
            String[] as = a.split(" ");
            for(int i=0;i<as.length;i++){
                sum = sum + Integer.parseInt(as[i]);
            }
            System.out.println(sum);
        }
    }
}