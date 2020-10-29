package com.LeetCode_jianzhioffer.Stack20;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/27 17:18
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 *链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
 * 来源：牛客网
 *
 链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
 来源：牛客网

 参考了别人的思路，这里也是使用了两个栈。
 一个用来存所有的元素“stackTotal”,另一个用来存加入新的元素后当前stackTotal中对应的最小值。
 两个栈中的元素数量始终保持一致，当新的元素小于“stackLittle”栈顶元素时，“stackLittle”像栈顶push新来的元素，否则，“stackLittle”向栈顶加入原栈顶元素。
 执行“pop”方法时，两个栈同时弹出各自的栈顶元素。
 *
 */
public class Solution {

    Stack<Integer> stackTotal = new Stack<Integer>();
    Stack<Integer> stackLittle = new Stack<Integer>();

    public void push(int node) {
        stackTotal.push(node);
        if (stackLittle.empty()==true){
        stackLittle.push(node);
        }else {
            if (node<=stackLittle.peek()){
                stackLittle.push(node);
            }else {
                stackLittle.push(stackLittle.peek());

            }

        }
    }

    public void pop() {
        stackTotal.pop();
        stackLittle.pop();
    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackLittle.peek();
    }
}
