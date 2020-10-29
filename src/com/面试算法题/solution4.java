package com.面试算法题;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/31 14:46
 * # @version 1.0
 * # @File : solution4.java
 * # @Software: IntelliJ IDEA
 */
public class solution4 {
//    public static void findSolution(int a,int b,int c,int n){
//        if(a<=0||baib<=0||c<=0||c<=0){
//            System.out.println("必须输入正整数！");
//            return;
//        }
//        int count=0;
//        for(int a1=0;a1<=a;a1++){
//            for(int b1=0;b1<=b;b1++){
//                for(int c1=0;c1<=c;c1++){
//                    if(a1*10+b1*5+c1*2==n){
//                        count++;
//                        System.out.println(a1+"张十元du纸币zhi、"+b1+"张5元纸币和dao"+c1+"张2元纸币组成"+n+"元！");
//                    }
//                }
//            }
//        }
//        if(count==0){
//            System.out.println(a+"张十元纸币、"+b+"张5元纸币和"+c+"张2元纸币无法组成"+n+"元！");
//        }
//    }


    //const int N=7;
//    int Count[N]={3,0,2,1,0,3,5};//每一张纸币的数量
//    int Value[N]={1,2,5,10,20,50,100};//每一张的面额
    public static int solve(int x1, int x5, int x10, int x50, int x100,
                            int money) {
        int N = 5;//共有5种纸币
        int[] Value = new int[]{1, 5, 10, 50, 100};//每一张纸币的数量
        int[] Count = new int[]{x1, x5, x10, x50, x100};//每一张的面额
        int num = 0;
        for (int i = N - 1; i >= 0; i--) {
            int c = Math.min(money / Value[i], Count[i]);//每一个所需要的张数
            money = money - c * Value[i];
            num += c;//总张数
        }
        if (money > 0) num = -1;
        return num;
    }

    public static void main(String[] args) {

        int money = 55;
        int res = solve(5,2,2,3,5,money);
        System.out.println(res);
    }
}
