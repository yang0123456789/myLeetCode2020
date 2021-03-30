package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 **/
public class 盛最多水的容器11 {
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;



        }
    }
}
