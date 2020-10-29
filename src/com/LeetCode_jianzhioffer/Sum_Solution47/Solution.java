package com.LeetCode_jianzhioffer.Sum_Solution47;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/15 17:26
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *  * 链接：https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1?f=discussion
 *  * 来源：牛客网
 *  *
 *  * //其实只要先看我们手里有什么牌就能一步一步想到利用短路特性了
 *  * //我们手里现在可以使用（按优先级高低）单目运算符：++和--,双目运算符：+,-，移位运算符<<和>>，关系运算符>,<等，逻辑运算符&&，||,&,|,^，赋值=
 *  * //单目和双目的作用是一样的，移位显然没有规律性，因为一个二进制位并不能区分某个数和其他数，这也就排除了&,|,^,因为不需要做位运算了
 *  * //关系运算符要和if匹配，但这是不行的，这时看看剩下的运算符只能选&&,||了
 *  * //如果做过Java笔试题，会对这两个运算符非常敏感，他们有短路特性，前面的条件判真（或者假）了，就不会再执行后面的条件了
 *  * //这时就能联想到--n,直到等于0就能返回值。
 */
public class Solution {
    public static int Sum_Solution(int n) {
        int result=n;

        boolean flag=(result>1)&&((result=result+Sum_Solution(result-1))>0);
        System.out.println("执行："+n);
        return result;

    }

    public static void main(String[] args) {
        int t=Sum_Solution(3);
        System.out.println(t);

    }

}
