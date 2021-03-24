package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
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


    class Solution {
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
