package com.Leetcode_top100.双指针;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/21 15:40
 * # @version 1.0
 * # @File : 接雨水42.java
 * # @Software: IntelliJ IDEA
 */
public class 接雨水42 {
    //方法一、暴力解法：
    //每一根柱子上面的水是由她左边最大值 和右边 最大值 中较小的一个与它的差。把每根柱子上面的水都加起来，就是最终的容积
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int len = height.length;
            if (height.length < 3) return 0;
            for (int i = 1; i < len - 1; i++) {
                int max_left = 0;
                int max_right = 0;
                //计算左边和右边最大值的时候，将i的位置也计算进去，就不用考虑两边最大值都比i位置小的情况
                for (int j = 0; j <= i; j++) {

                    max_left = Math.max(max_left, height[j]);

                }
                for (int j = i; j < len; j++) {
                    max_right = Math.max(max_right, height[j]);
                }
                ans += Math.min(max_left, max_right) - height[i];
            }
            return ans;
        }

    }

    class Solution2 {
        //动态规划
        public int trap(int[] height) {
            {
                if (height == null)
                    return 0;
                int ans = 0;
                int size = height.length;
                int[] left_max = new int[size];
                int[] right_max = new int[size];
                left_max[0] = height[0];
                for (int i = 1; i < size; i++) {
                    left_max[i] = Math.max(height[i], left_max[i - 1]);
                }
                right_max[size - 1] = height[size - 1];
                for (int i = size - 2; i >= 0; i--) {
                    right_max[i] = Math.max(height[i], right_max[i + 1]);
                }
                for (int i = 1; i < size - 1; i++) {
                    ans += Math.min(left_max[i], right_max[i]) - height[i];
                }
                return ans;
            }

        }
    }

    class Solution3 {
        //单调递增栈
        public int trap(int[] height) {
            int ans = 0, current = 0;
            Stack<Integer> st = new Stack<>();//st存储的是数组的下标，这是一个单调递减的栈
            while (current < height.length) {
                while (!st.empty() && height[current] > height[st.peek()]) {
                    //如果下一根柱子比栈中的柱子要大，并且栈非空，就有可能形成低洼处，
                    // 而且将栈中比这个小的柱子形成的低洼全部计算
                    int top = st.peek();
                    st.pop();
                    if (st.empty())//需要三根柱子才能形成一个低洼，如果只有一根柱子，可以直接舍弃
                        break;
                    int distance = current - st.peek() - 1;//计算宽度
                    int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];//计算高度
                    ans += distance * bounded_height;//加上这一条水道
                }
                st.push(current++);//计算完以后，将这个柱子入栈，继续遍历
            }
            return ans;
        }
    }

    class Solution4 {
        //双指针

        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int ans = 0;
            int left_max = 0, right_max = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= left_max) {
                        left_max = height[left];
                    } else {
                        ans += (left_max - height[left]);
                    }
                    ++left;
                } else {
                    if (height[right] >= right_max) {
                        right_max = height[right];
                    } else ans += (right_max - height[right]);
                    --right;
                }
            }
            return ans;
        }

    }
}
