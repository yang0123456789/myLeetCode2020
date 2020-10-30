package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/10/30 10:12
 * # @version 1.0
 * # @File : nc88.java
 * # @Software: IntelliJ IDEA
 *
 *
 *
 *
 *
 */
public class nc88 {

    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKth(a,K,0,n-1);

    }
    public int  findKth(int[] a, int k,int left,int right){
        int part=partation(a,left,right);
        if(k==part-left+1) return a[part];
        else if(k>part-left+1)return findKth(a,k-part+left-1,part+1,right);
        else return findKth(a,k,left,part-1);



    }

    public int partation(int[] a, int low, int high){
        int key= a[low];
        while(low<high){
            //一次迭代完成，实现左右比key大小的值交换，同时low位置的值为冗余，可以在下一次迭代中被替换，然后最终low==high的时候，就是key的位置
            while(low<high&&a[high]<=key)
                high--;

            a[low]=a[high];
            while(low<high&&a[low]>=key)
                low++;

            a[high]=a[low];
        }
        a[low]=key;
        return low;


    }
}
