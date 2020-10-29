package com.面试算法题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 22:52
 * # @version 1.0
 * # @File : 柱状图中最大的矩形84.java
 * # @Software: IntelliJ IDEA
 */
public class 柱状图中最大的矩形84 {
    static class Solution {
        //单调栈+哨兵
        public int largestRectangleArea(int[] h1, int h2[]) {

            if (h1.length == 0 || h2.length == 0) return 0;
            if (h1.length != h2.length) return 0;
            int pacNum = 0;
            for (int i = 0; i < h1.length; i++) {
                if (h1[i]<0) return 0;
                pacNum += h1[i];
            }
            int[] heights = new int[pacNum];
            pacNum = 0;
            for (int i = 0; i < h1.length; i++) {
                for (int j = 0; j < h1[i]; j++) {
                    heights[pacNum++] = h2[i];
                }
            }

            int len = heights.length;
            if (len == 0) return 0;
            if (len == 1) return heights[0];

            int area = 0;
            int[] newHeights = new int[len + 2];
            for (int i = 0; i < len; i++) {
                newHeights[i + 1] = heights[i];
            }
            len += 2;
            heights = newHeights;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(0);

            for (int i = 0; i < len; i++) {
                while (heights[stack.peekLast()] > heights[i]) {//栈顶严格大于当前位置
                    int height = heights[stack.removeLast()];
                    int width = i - stack.peekLast() - 1;// i位置已经比这个高度小了，栈顶也比这个高度小，所以width为(stack.peekLast(),j),都是开区间
                    area = Math.max(area, width * height);
                }
                stack.addLast(i);//如果比栈顶位置高或者相等的的话，将这个位置加入到栈中，作为新的栈顶
            }
            return area;
        }
    }


    public class Solution4 {
        //单调栈
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }

            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {
                // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
                while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                    int curHeight = heights[stack.pollLast()];
                    while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                        stack.pollLast();
                    }

                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peekLast() - 1;
                    }

                    // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.addLast(i);
            }

            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = len;
                } else {
                    curWidth = len - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            return res;
        }
    }


    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Stack<Integer> mono_stack = new Stack<Integer>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            mono_stack.clear();
            for (int i = n - 1; i >= 0; --i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }

    public class Solution3 {
        //暴力解法
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            // 特判
            if (len == 0) {
                return 0;
            }

            int res = 0;
            for (int i = 0; i < len; i++) {

                // 找左边最后 1 个大于等于 heights[i] 的下标
                int left = i;
                int curHeight = heights[i];
                while (left > 0 && heights[left - 1] >= curHeight) {
                    left--;
                }

                // 找右边最后 1 个大于等于 heights[i] 的索引
                int right = i;
                while (right < len - 1 && heights[right + 1] >= curHeight) {
                    right++;
                }

                int width = right - left + 1;
                res = Math.max(res, width * curHeight);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] h1 = new int[]{1, 1, 1,0,2,1,1};
        int[] h2 = new int[]{5, 2, 5,4,5,1,6};
        Solution s=new Solution();
        int aresa=s.largestRectangleArea(h1,h2);
        System.out.println(aresa);
//
//        int pacNum = 0;
//        for (int i = 0; i < h1.length; i++) {
//            pacNum += h1[i];
//        }
//
//        int[] heights = new int[pacNum];
//        pacNum = 0;
//        for (int i = 0; i < h1.length; i++) {
//            for (int j = 0; j < h1[i]; j++) {
//
//                heights[pacNum++] = h2[i];
//
//            }
//
//        }
//        for (int i = 0; i < heights.length; i++) {
//            System.out.println(heights[i]);
//        }


    }

}
