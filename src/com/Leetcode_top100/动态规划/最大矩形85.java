package com.Leetcode_top100.动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/24 9:56
 * # @version 1.0
 * # @File : sdfsd.java
 * # @Software: IntelliJ IDEA
 */
public class 最大矩形85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            //暴力解法
//        https://leetcode-cn.com/problems/maximal-rectangle/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-8/
            if (matrix.length == 0) {
                return 0;
            }
            //保存以当前数字结尾的连续 1 的个数
            int[][] width = new int[matrix.length][matrix[0].length];
            int maxArea = 0;
            //遍历每一行
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    //更新 width
                    if (matrix[row][col] == '1') {//这个点是1才找该行以该点结尾的连续1的长度
                        if (col == 0) {
                            width[row][col] = 1;//这个点在最左边
                        } else {
                            width[row][col] = width[row][col - 1] + 1;
                            //等于前一个点该行以该点结尾的连续1的长度+1
                        }
                    } else {
                        width[row][col] = 0;//不是1 长度就是0
                    }
                    //记录所有行中最小的数
                    int minWidth = width[row][col];
                    //向上扩展行
                    for (int up_row = row; up_row >= 0; up_row--) {
                        int height = row - up_row + 1;//高度就是两行之间的高度[up_row,row]都是闭区间
                        //找最小的数作为矩阵的宽
                        minWidth = Math.min(minWidth, width[up_row][col]);
                        //更新面积
                        maxArea = Math.max(maxArea, height * minWidth);
                    }
                }
            }
            return maxArea;
        }
    }

    class Solution2 {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int[] heights = new int[matrix[0].length];
            int maxArea = 0;
            for (int row = 0; row < matrix.length; row++) {
                //遍历每一列，更新高度
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                //调用上一题的解法，更新函数
                maxArea = Math.max(maxArea, largestRectangleArea(heights));
            }
            return maxArea;
        }

        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            int p = 0;
            while (p < heights.length) {
                //栈空入栈
                if (stack.isEmpty()) {
                    stack.push(p);
                    p++;
                } else {
                    int top = stack.peek();
                    //当前高度大于栈顶，入栈
                    if (heights[p] >= heights[top]) {
                        stack.push(p);
                        p++;
                    } else {
                        //保存栈顶高度
                        int height = heights[stack.pop()];
                        //左边第一个小于当前柱子的下标
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        //右边第一个小于当前柱子的下标
                        int RightLessMin = p;
                        //计算面积
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                }
            }
            while (!stack.isEmpty()) {
                //保存栈顶高度
                int height = heights[stack.pop()];
                //左边第一个小于当前柱子的下标
                int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
                int RightLessMin = heights.length;
                int area = (RightLessMin - leftLessMin - 1) * height;
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }

    }

    class Solution3 {
        //        其中 力扣 84 下的代码是从 84 - 柱状图中最大的矩形的题解中复制来的。
        // Get the maximum area in a histogram given its heights
        public int leetcode84(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxarea = 0;
            for (int i = 0; i < heights.length; ++i) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                    maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
                stack.push(i);
            }
            while (stack.peek() != -1)
                maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            return maxarea;
        }

        public int maximalRectangle(char[][] matrix) {

            if (matrix.length == 0) return 0;
            int maxarea = 0;
            int[] dp = new int[matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    // update the state of this row's histogram using the last row's histogram
                    // by keeping track of the number of consecutive ones

                    dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;//更新每一列的，以[i][j]为结尾的向上的最大高度，本质还是与暴力解法是一样的。这里以第row[i]行作为底边计算高度
                }
                // update maxarea with the maximum area from this row's histogram
                maxarea = Math.max(maxarea, leetcode84(dp));
            }
            return maxarea;
        }
    }

    class Solution4 {

        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;

            int[] left = new int[n]; // initialize left as the leftmost boundary possible
            int[] right = new int[n];
            int[] height = new int[n];

            Arrays.fill(right, n); // initialize right as the rightmost boundary possible

            int maxarea = 0;
            for (int i = 0; i < m; i++) {
                int cur_left = 0, cur_right = n;
                // update height
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }
                // update left
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                    else {
                        left[j] = 0;
                        cur_left = j + 1;
                    }
                }
                // update right
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                    else {
                        right[j] = n;
                        cur_right = j;
                    }
                }
                // update area
                for (int j = 0; j < n; j++) {
                    maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
                }

            }
            return maxarea;
        }


    }

    class Solution5 {
//        动态规划 - 每个点的最大高度
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;

            int[] left = new int[n]; // initialize left as the leftmost boundary possible
            int[] right = new int[n];
            int[] height = new int[n];
//  leftLessMin [ ] 和 rightLessMin [ ] 的含义，
//  leftLessMin [ i ] 代表左边第一个比当前柱子矮的下标，如下图橙色柱子时当前遍历的柱子。
//  rightLessMin [ ] 时右边第一个。

            Arrays.fill(right, n); // initialize right as the rightmost boundary possible

            int maxarea = 0;
            for (int i = 0; i < m; i++) {
                int cur_left = 0, cur_right = n;//cur_left表示这一行出现的0的位置，距离当前列最近的一个，相当于是边界
                // update height
                for (int j = 0; j < n; j++) {//如果height出现断层，就是这个位置是0，那么他往上的高度就是0
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }
                // update left
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                    else {
                        left[j] = 0;
                        cur_left = j + 1;//这个位置是0的话，更近左边0出现的位置为当前位置，之所以+1是表示这个是0的下一个位置，为了能构成[l.r）的区间方便计算
                    }
                }
                // update right
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                    else {
                        right[j] = n;
                        cur_right = j;
                    }
                }
                // update area
                for (int j = 0; j < n; j++) {
                    maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
                }

            }
            return maxarea;
        }
    }
    public int maximalRectangle4(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] leftLessMin = new int[cols];
        int[] rightLessMin = new int[cols];
        Arrays.fill(leftLessMin, -1); //初始化为 -1，也就是最左边
        Arrays.fill(rightLessMin, cols); //初始化为 cols，也就是最右边
        int[] heights = new int[cols];
        for (int row = 0; row < matrix.length; row++) {
            //更新所有高度
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //更新所有leftLessMin
            int boundary = -1; //记录上次出现 0 的位置
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    //和上次出现 0 的位置比较
                    leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                } else {
                    //当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
                    leftLessMin[col] = -1;
                    //更新 0 的位置
                    boundary = col;
                }
            }
            //右边同理
            boundary = cols;
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                } else {
                    rightLessMin[col] = cols;
                    boundary = col;
                }
            }

            //更新所有面积
            for (int col = cols - 1; col >= 0; col--) {
                int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                maxArea = Math.max(area, maxArea);
            }

        }
        return maxArea;

    }


}