package com.LeetCode_jianzhioffer.IsPopOrder20;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/29 8:38
 * # @version 1.0
 * # @File : IsPopOrder20.java
 * # @Software: IntelliJ IDEA
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等
 * 。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹
 * 出序列。（注意：这两个序列的长度是相等的）
 *
 * 新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        int j = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < pushA.length ; i++) {
            s.push(pushA[i]);

            while (!s.isEmpty()&&s.peek() == popA[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }

}