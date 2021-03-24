package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 21:03
 * # @version 1.0
 * # @File : 二分查找.java
 * # @Software: IntelliJ IDEA
 * https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=117&&tqId=1024577
 * 5,4,[1,2,4,4,5]
 * 返回值3
 *
 *
 */

public class 二分查找 {

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        if (n<=0) return 1;
        int l=0;
        int r=n-1;
        int mid=(l+r)/2;
        while (l<=r){
            if (v>a[mid]){
                l=mid+1;
                mid=(l+r)/2;
            }else if (mid>0&&a[mid-1]>=v){
                //保证前一个数比该数小，这时候等于才是第一个，如果前一个等于v，者还得往前走，这个位置肯定不是了。所以判断mid-1。
                r=mid-1;
                mid=(l+r)/2;
            }else {
                return mid+1;
            }
        }
        return n+1;
    }
}
