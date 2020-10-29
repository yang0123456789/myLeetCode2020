package com.LeetCodeDayCourse;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/3 22:36
 * # @version 1.0
 * # @File : 字符串相加415.java
 * # @Software: IntelliJ IDEA
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字符串相加415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1=num1.length();
            int len2=num2.length();
            if (len1==0) return num2;
            if (len2==0) return num1;
//            StringBuffer str=new StringBuffer();
            String str="";
            int carry=0;//进位
            int i=len1-1;
            int j=len2-1;
            while (i>=0||j>=0||carry!=0){
                int x=(i>=0?num1.charAt(i)-'0':0);
                int y=(j>=0?num2.charAt(j)-'0':0);
                int result=x+y+carry;
                if (result>=10){
                    carry=1;
                    result=result-10;
                    str=""+result+str;

                }else{
                    carry=0;
                    str=""+result+str;
                }
                i--;
                j--;


            }
            return  str;
        }
    }
}
