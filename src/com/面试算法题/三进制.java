package com.面试算法题;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 10:03
 * # @version 1.0
 * # @File : 三进制.java
 * # @Software: IntelliJ IDEA
 */
public class 三进制 {


    public static String tricoding(int  num){
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
          int i=  num % 3;
          if (i==0){
            sb.append("@");}else if (i==1){
              sb.append("$");
          }else {
              sb.append("&");
          }
            num /= 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String tricoding = tricoding(123);
        System.out.println(tricoding);
    }
}
