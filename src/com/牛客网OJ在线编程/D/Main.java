package com.牛客网OJ在线编程.D;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 22:29
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            int count=in.nextInt();
            if (count==0)break;
//            int[] nums=new int[count];
            int total=0;
            for(int i=0;i<count ;i++){
            total+=in.nextInt();
            }
            System.out.println(total);
            in.nextLine();
        }
    }
    public  void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        while(len!=0){
            int sum = 0;
            for (int i=0;i<len;i++){
                sum = sum + sc.nextInt();
            }
            len = sc.nextInt();
            System.out.println(sum);
        }
    }

}
