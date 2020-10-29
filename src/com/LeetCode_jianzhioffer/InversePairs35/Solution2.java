package com.LeetCode_jianzhioffer.InversePairs35;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 15:35
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5?f=discussion
 * 来源：牛客网
 *
 * /*归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
 * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
 * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
 * 参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
 * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
 * */

public class Solution2 {
    public int InversePairs(int [] array) {
        if (array==null||array.length<=1) return 0;
        int[] copy=new int[array.length];
        for(int i=0;i<array.length ;i++){
        copy[i]=array[i];
        }
        int count=InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;//递归求解前半段，求解完了以后这一段是有序的数列
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;//递归求解后半段，求解完了以后这一段是有序的数列
        //求解
        int count = 0;
        int i=mid;//【low--mid】部分的最大值
        int j=high;//(mid,high]部分的最大一位
        int locCopy = high;//辅助序列的【low，high】部分最大的部分，用来提供复制
        while (i>=low&&j>mid){//前半段的值比后半段最大还大，则这个值最大。
            if (array[i]>array[j]){
                count+=j-mid;//说明逆序是后半段的
                copy[locCopy--]=array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else {
                copy[locCopy--]=array[j--];//说明前一段最大值没大过最后一段的最大值，复制最后一段的最大值
            }


        }//while循环玩以后，从【low，high】已经是有序的了这一段的逆序数也计算出来了，
        // 最终i停在low或者high停在mid-1最后的位置，然后将剩下的部分复制到copy序列中
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        //然后将有序的序列复制到array序列中
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        //然后返回这一段的逆序数
        return (leftCount+rightCount+count)%1000000007;
    }
}
