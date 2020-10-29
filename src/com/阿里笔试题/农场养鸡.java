package com.阿里笔试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/28 9:19
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 * 第一题：农场养鸡
 * n个农场，第i个农场有a[i]只鸡，每天每个农场都会增加k只鸡。每晚农场主都会选择鸡最多的农场，将该农场鸡的个数除以2下取整，在m天后剩下多少只鸡？
 *
 * 输入：
 * 第一行输入三个int类型n,m,k（1 <= n,m,k <= 10^6）
 * 第二行输入n个正整数，表示n个养鸡场初始鸡的个数
 * 输出：
 * 输出鸡的总数
 */
public class 农场养鸡 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int count =in.nextInt();
            int day=in.nextInt();
            int k=in.nextInt();
            in.nextLine();
            int[] farm=new int[count];
            for(int i=0;i<count ;i++){
            farm[i]=in.nextInt();
                System.out.println(farm[i]);
            }
            in.nextLine();
            while (day>0){
                int maxIndex=0;
                for(int i=0;i<count ;i++){
                    farm[i]+=k;
                    if (farm[i]>=farm[maxIndex])maxIndex=i;
                }

                farm[maxIndex]=farm[maxIndex]/2;
                day--;

            }
            int sum=0;
            for(int i=0;i<count ;i++){
            sum+=farm[i];
            }
            System.out.println(sum);
        }
    }
}
