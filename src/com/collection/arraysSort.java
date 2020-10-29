package com.collection;

import java.util.Arrays;
import java.util.Comparator;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/15 9:47
 * # @version 1.0
 * # @File : arraysSort.java
 * # @Software: IntelliJ IDEA
 */
public class arraysSort {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{1,2},{4,5},{3,7}};
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });
        for(int i=0;i<nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
	/*输出：
		[1, 2]
		[1, 3]
		[3, 7]
		[4, 5]
	*/
    }

}
