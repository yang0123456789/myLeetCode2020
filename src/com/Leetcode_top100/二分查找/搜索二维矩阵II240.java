package com.Leetcode_top100.二分查找;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/5 19:34
 * # @version 1.0
 * # @File : 搜索二维矩阵II240.java
 * # @Software: IntelliJ IDEA
 */
public class 搜索二维矩阵II240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // start our "pointer" in the bottom-left
            int row = matrix.length-1;
            int col = 0;

            while (row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }

            return false;
        }
    }
    class Solution2 {
        private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
            int lo = start;
            int hi = vertical ? matrix[0].length-1 : matrix.length-1;

            while (hi >= lo) {
                int mid = (lo + hi)/2;
                if (vertical) { // searching a column
                    if (matrix[start][mid] < target) {
                        lo = mid + 1;
                    } else if (matrix[start][mid] > target) {
                        hi = mid - 1;
                    } else {
                        return true;
                    }
                } else { // searching a row
                    if (matrix[mid][start] < target) {
                        lo = mid + 1;
                    } else if (matrix[mid][start] > target) {
                        hi = mid - 1;
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            // an empty matrix obviously does not contain `target`
            if (matrix == null || matrix.length == 0) {
                return false;
            }

            // iterate over matrix diagonals
            int shorterDim = Math.min(matrix.length, matrix[0].length);
            for (int i = 0; i < shorterDim; i++) {
                boolean verticalFound = binarySearch(matrix, target, i, true);
                boolean horizontalFound = binarySearch(matrix, target, i, false);
                if (verticalFound || horizontalFound) {
                    return true;
                }
            }

            return false;
        }
    }

    class Solution3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            for (int i = 0; i < matrix.length; i++) {
//                比如某一行的第一个元素大于了 target ，当前行和后边的所有行都不用考虑了，直接返回 false。

//                某一行的最后一个元素小于了 target ，当前行就不用考虑了，换下一行。
                if (matrix[i][0] > target) {
                    break;
                }
                if (matrix[i][matrix[i].length - 1] < target) {
                    continue;
                }
                int col = binarySearch(matrix[i], target);
                if (col != -1) {
                    return true;
                }
            }
            return false;
        }

        //二分查找
        private int binarySearch(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }

    }



}
