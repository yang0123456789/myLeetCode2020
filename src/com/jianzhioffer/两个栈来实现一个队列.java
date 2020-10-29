package com.jianzhioffer;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/14 15:36
 * # @version 1.0
 * # @File : 两个栈来实现一个队列.java
 * # @Software: IntelliJ IDEA
 */
public class 两个栈来实现一个队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
//    push操作就直接往stack1中push， pop操作需要分类一下：如果stack2为空，
//
//    那么需要将stack1中的数据转移到stack2中，然后在对stack2进行pop，如果stack2不为空，直接pop就ok。

    public void push(int node) {
        stack1.push(node);


    }

    public int pop() {

        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());

            }
        }
        int ret = stack2.pop();
        return ret;
    }
}