package com.面试算法题;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/31 17:14
 * # @version 1.0
 * # @File : dfsdfdsf.java
 * # @Software: IntelliJ IDEA
 */
public class dfsdfdsf {
    public static int get_StringNum(String str) {
        if (str == null || "".equals(str)) return Integer.parseInt(str);
        str = str.trim();
        String str2 = "";
        boolean flag=false;

        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)=='-'){
                    if (str2.length()==0){
                        flag=true;

                    }
                }
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }
        }
        double l= Double.parseDouble(str2);
        if (l>Integer.MAX_VALUE){
            return flag?Integer.MIN_VALUE:Integer.MAX_VALUE;

        }
        return flag==true?0-Integer.parseInt(str2):Integer.parseInt(str2);
    }

    public static void main(String[] args) {
        String str="+5-0dsfdsf5645+61561561-4536456";
        System.out.println(get_StringNum(str));
    }
}
