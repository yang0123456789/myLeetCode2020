package com.LeetCode_jianzhioffer.PrintMinNumber32;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 10:10
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 *
 * 链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?f=discussion
 * 来源：牛客网
 *
 * * 解题思路：
 *  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 *  * 排序规则如下：
 *  * 若ab > ba 则 a > b，
 *  * 若ab < ba 则 a < b，
 *  * 若ab = ba 则 a = b；
 *  * 解释说明：
 *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 */
public class Solution2 {



    public String PrintMinNumber(int [] numbers) {
        String str = "";
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }

            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }

}
