package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 9:46
 * # @version 1.0
 * # @File : 字符串相乘43.java
 * # @Software: IntelliJ IDEA
 */
public class 字符串相乘43 {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            String ans="0";

            int m=num1.length();
            int n=num2.length();
            //用num2每个位去乘num1，然后结果挨个相加，

            for(int i=n-1;i>=0 ;i--){
                StringBuffer curr=new StringBuffer();
                int add=0;//add表示数字挨个乘以后的进位值
                //num1各个位置要补0,字符串高位是数字的低位，因此用n-1开始补0
                for(int j=n-1;j>i ;j--){
                curr.append(0);
                }
                int y=num2.charAt(i)-'0';
                for(int j=m-1;j>=0;j--){
                    int x=num1.charAt(j)-'0';
                    int product=x*y+add;
                    add=product/10;
                    curr.append(product%10);

                }
//                num2[i]挨个乘完num1各位以后，看有没有剩余的进位，有的话，就加载curr后面
                if (add!=0){
                    curr.append(add%10);
                }
                ans=addStrings(ans,curr.reverse().toString());//ans加上相乘的结果


            }
            return ans;

        }
        public String addStrings(String num1,String num2){
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuffer ans = new StringBuffer();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            ans.reverse();
            return ans.toString();
        }
    }
}
