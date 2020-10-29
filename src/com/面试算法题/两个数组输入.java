package com.面试算法题;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/27 10:52
 * # @version 1.0
 * # @File : 两个数组输入.java
 * # @Software: IntelliJ IDEA
 * <p>
 * // 输入如下
 * 3 4
 * 10 2 3
 * 11 4 5 6
 * 以三行输入为例，第一行输入两个数字m，n，分别表示数组num1和num2的长度，
 * 第二行和第三行输入num1和num2的元素，以空格分隔。
 */
public class 两个数组输入 {
    public static void main(String[] args) {
//        字符串数组();
//        多行输入多个参数_每行参数个数不定();
//        inputStringToIntArrayListWithoutN();

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

    }



    public static void 整形数组() {
        System.out.println("输入：");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] num1 = new int[m];
        int[] num2 = new int[n];
        // 换成其他数据类型也一样，其他数值类型就修改int跟nextInt就可以了，
        //String就把nextInt()换成next()
        for (int i = 0; i < m; i++) {
            num1[i] = sc.nextInt();  // 一个一个读取
        }
        for (int i = 0; i < n; i++) {
            num2[i] = sc.nextInt();
        }
        System.out.println("输出：");
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

    public static void 字符串数组() {
        System.out.println("输入string：");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[] num1 = new String[m];
        String[] num2 = new String[n];
        // 换成其他数据类型也一样，其他数值类型就修改int跟nextInt就可以了，
        //String就把nextInt()换成next()
        for (int i = 0; i < m; i++) {
            num1[i] = sc.next();  // 一个一个读取
        }
        for (int i = 0; i < n; i++) {
            num2[i] = sc.next();
        }
        System.out.println("输出：");
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

    public static void 单行输入多个参数() {
        // 输入如下
//        ABB CCC DDD  EEE 123 435
        System.out.println("输入：");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  // 读取一行
        System.out.println("输出：");
        System.out.println(str);
        String[] strIn = str.trim().split(" ");  // 以空格分割
        System.out.println(Arrays.toString(strIn));
    }

    public static void 多行输入多个参数_每行参数个数不定() {
//        第一行输入m，n，m表示后面有m行，n表示每行最多有n个(可用来截断某一行多输入的参数，不详细分析了)。
        // 输入如下
//        3 4
//        AA bcd 123 54
//        AA BB
//        A B C
        System.out.println("输入：");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();  // 很重要，跳到第二行
        // 若直接确定行数，注释掉上面两行，加入下面一行
        // int m = 3;
        String[] strArr = new String[m];
        // 从第二行开始读取
        for (int i = 0; i < m; i++) {
            strArr[i] = sc.nextLine();
        }
        System.out.println("输出：");
        System.out.println(Arrays.toString(strArr));
        ArrayList<String[]> strToOne = new ArrayList<String[]>();
        for (int i = 0; i < m; i++) {
//            trim() 去掉起始和结尾的空格
//            String[] s = str.split(",");//将序列化之后的序列用，分隔符转化为数组
            String[] tmp = strArr[i].trim().split(" ");
            strToOne.add(tmp);
        }
        System.out.println(strToOne);
        // 形象点显示
        System.out.print("[");
        for (int i = 0; i < strToOne.size(); i++) {
            System.out.print(Arrays.toString(strToOne.get(i)));
            if (i != strToOne.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");


    }

    //后面一直有输入的时候，没有指明 n，获得所有数据都在的一个列表
    //注意： 在IDEA测试的时候以-1结束，上机考试时候不需要-1结束
    public static ArrayList<Integer> inputStringToIntArrayListWithoutN() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            int a = in.nextInt();
            if (a == -1)
                break;
            else
                list.add(a);
        }
        System.out.println(Arrays.toString(list.toArray()));
        return list;

    }

}


/**
 *大家不要忘了考虑大数溢出问题
 */

 class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            BigInteger a=scan.nextBigInteger();
            BigInteger b=scan.nextBigInteger();
            System.out.println(a.add(b));
        }
        scan.close();
    }
}