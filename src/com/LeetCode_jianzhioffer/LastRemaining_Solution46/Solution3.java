package com.LeetCode_jianzhioffer.LastRemaining_Solution46;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 9:39
 * # @version 1.0
 * # @File : Solution3.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/f78a359491e64a50bce2d89cff857eb6?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 方法二：递归
 * 假设f(n, m) 表示最终留下元素的序号。比如上例子中表示为:f(5,3) = 3
 *
 * 首先，长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。那么，我们可以递归地求解 f(n - 1, m)，就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素，我们设答案为 x = f(n - 1, m)。
 *
 * 由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。当我们知道了 f(n - 1, m) 对应的答案 x 之后，我们也就可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
 *
 * 当n等于1时，f(1,m) = 0
 *
 * 链接：https://www.nowcoder.com/questionTerminal/f78a359491e64a50bce2d89cff857eb6?f=discussion
 * 来源：牛客网
 *
 * 如果只求最后一个报数胜利者的话，我们可以用数学归纳法解决该问题，为了讨      论方便，先把问题稍微改变一下，并不影响原意：
 *
 *  问题描述：n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人 继续从0开始报数。求胜利者的编号。
 *
 *  我们知道第一个人(编号一定是m%n-1) 出列之后，剩下的n-1个人组成了一个新      的约瑟夫环（以编号为k=m%n的人开始）:
 *
 *         k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0。
 *
 * 现在我们把他们的编号做一下转换：
 *
 * k     --> 0
 *
 * k+1   --> 1
 *
 * k+2   --> 2
 *
 * ...
 *
 * ...
 *
 * k-2   --> n-2
 *
 * k-1   --> n-1
 *
 * 变换后就完完全全成为了(n-1)个人报数的子问题，假如我们知道这个子问题的解： 例如x是最终的胜利者，那么根据上面这个表把这个x变回去不刚好就是n个人情 况的解吗？！！变回去的公式很简单，相信大家都可以推出来：x'=(x+k)%n。
 *
 * 令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]。
 *
 * 递推公式
 *
 * f[1]=0;
 *
 * f[i]=(f[i-1]+m)%i;  (i>1)
 *
 * 有了这个公式，我们要做的就是从1-n顺序算出f[i]的数值，最后结果是f[n]。 因为实际生活中编号总是从1开始，我们输出f[n]+1。
 */
public class Solution3 {
//    链接：https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
//    来源：牛客网

    /*
     * 编号为(0~n-1)
     */
    public int getResult(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        int last = 0;
        for(int i=2;i<=n;++i){
            last = (last+m)%i;
        }
        // 因为实际编号为(1~n)
        return (last+1);
    }
}
