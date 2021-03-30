package com.剑指offer三刷不会的题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/24
 * @Version 1.0
 **/
public class 和为s的连续正数序列57 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> res=new ArrayList<>();
            for(int l=1,r=2;l<r;){
                int sum=(l+r)*(r-l+1)/2;
                if(sum==target){
                    int[] tem=new int[r-l+1];
                    for(int k=l;k<=r;k++){
                        tem[k-l]=k;
                    }
                    res.add(tem);
                    l++;//等于的情况别忘了往下一个走
                }else if(sum<target){
                    r++;//增大队列长度
                }else {
                    l++;//缩短队列，不然l--反而增大了，因为变长了
                }
            }

            return res.toArray(new int[res.size()][]);

        }
    }

}
