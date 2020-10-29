package com.LeetCode_jianzhioffer.StrToInt49;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 23:37
 * # @version 1.0
 * # @File : intTest.java
 * # @Software: IntelliJ IDEA
 */
public class intTest {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        for (int i =2;i<42;++i) {
            a = a*2;
        }
        System.out.println(a);
        int x = Integer.MAX_VALUE ;  //  得到整型的最大值2147483647
        int p=x/10-1;
        System.out.println("p:"+(p*10+9));
        System.out.println(x);

        int y=Integer.MIN_VALUE ;//int类型的最小值 -2147483648
        System.out.println(y);
        System.out.println("x+1 = "+(x+1));
        System.out.println("x+2 = "+(x+2));

        long l=Integer.MAX_VALUE ;
        l=l*10;
        System.out.println(l>Integer.MAX_VALUE);

        System.out.println((int)(l*10));
        System.out.println(l*10);
        if (l>Integer.MAX_VALUE){
            System.out.println(x);
        }
        System.out.println(-(long)Integer.MIN_VALUE);



    }
}
