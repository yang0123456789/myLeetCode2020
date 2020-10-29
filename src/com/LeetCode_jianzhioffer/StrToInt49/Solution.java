package com.LeetCode_jianzhioffer.StrToInt49;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 23:01
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/1277c681251b4372bdef344468e4f26e?answerType=1&f=discussion
 * 来源：牛客网
 *
 * int的范围为
 * 如果超过了这两个范围该怎么办？
 * 其实也很简单，首先判断这个数的正负，如果正数，超过了INT_MAX，
 * 就设置为INT_MAX，如果是负数，首先我们不考虑负号，如果超过了INT_MAX+1,
 * 则就置为INT_MAX+1, 最后再根据正负号，来加负号。
 */
public class Solution {
    public int StrToInt(String str) {

        int len=str.length();
        if (len == 0) return 0;


        long num=0;
        boolean flag=false;//判断是不是正负号
        for(int i=0;i<len ;i++){
            char c=str.charAt(i);
            if (c>='0'&&c<='9'){
                num=num*10+(int)(c-'0');
                continue;
            }
            if (c=='+'||c=='-'){
                if (i!=0)return 0;//+、-必须在第一位
                if(i==len-1)return 0;//Cannot have lone "+" or "-"
                if (c=='-'){
                flag=true;

                }
                continue;
            }
            if(c==' ')continue;//删除开头的空格

            return 0;



        }
        if (flag&&(num>-(long)Integer.MIN_VALUE)){
            return Integer.MIN_VALUE;
        }else if (!flag&&num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else {
            return flag?(int)-num:(int)num;
        }
//        return flag?-num:num;
//        return 0;

    }

}
