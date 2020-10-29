package com.牛客网OJ在线编程.C;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 21:20
 * # @version 1.0
 * # @File : A.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            int x=in.nextInt();
            int y=in.nextInt();
            if (x==0&&y==0)break;
            System.out.println(x+y);
            in.nextLine();
        }
    }


}
