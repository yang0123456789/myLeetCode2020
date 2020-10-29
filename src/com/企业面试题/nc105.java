package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/30 0:06
 * # @version 1.0
 * # @File : nc105.java
 * # @Software: IntelliJ IDEA
 */
public class nc105 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int i=0;
        int j=n-1;
        int mid= (i+j)/2;
        while (i<=j){
            if (a[mid]<v){
                i=mid+1;
                mid=(i+j)/2;
            }else if(mid>0&&a[mid-1]>=v){
                //保证前一个数比该数小，这时候等于才是第一个，如果前一个等于v，者还得往前走，这个位置肯定不是了。所以判断mid-1。
                j=mid-1;
                mid=(i+j)/2;
            }else {
                return mid+1;
            }

        }
        return n+1;
    }
}
