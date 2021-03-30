package com.虾皮;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/26
 * @Version 1.0
 * 双指针，指向当前位置
 * left_max  right_max 记录已经发现的左右两边的最大值，当前位置的水就是左右两边最大值小的那个减去当前高度的值
 *
 **/
public class 接雨水 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];//
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

}
