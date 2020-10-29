package com.LeetCode_jianzhioffer.NumberOf1Between1AndN_Solution31;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 10:56
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
 * 来源：牛客网
 *
 * 首先可以先分类：
 *
 * 个位
 * 我们知道在个位数上，1会每隔10出现一次，例如1、11、21等等，我们发现以10为一个阶梯的话，每一个完整的阶梯里面都有一个1，例如数字22，按照10为间隔来分三个阶梯，在完整阶梯0-9，10-19之中都有一个1，但是19之后有一个不完整的阶梯，我们需要去判断这个阶梯中会不会出现1，易推断知，如果最后这个露出来的部分小于1，则不可能出现1（这个归纳换做其它数字也成立）。
 * 我们可以归纳个位上1出现的个数为：
 * n/10 * 1+(n%10!=0 ? 1 : 0)
 *
 *
 *
 *
 */
public class Solution2 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
