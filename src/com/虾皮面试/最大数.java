package com.虾皮面试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 最大数 {
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> l = new ArrayList<>();
            for(int i = 0; i < nums.length; i++)
                l.add(String.valueOf(nums[i]));

            Collections.sort(l, (String o1, String o2) -> (o2+o1).compareTo(o1+o2));

            if(l.get(0).equals("0"))
                return "0";

            StringBuffer sb = new StringBuffer("");

            for(int i = 0; i < nums.length; i++)
                sb.append(l.get(i));

            return sb.toString();
        }
    }
    public String largestNumber(int[] nums) {
        int n= nums.length;
        List<String> tem=new ArrayList<>();
        for(int i=0;i<n;i++){
            tem.add(nums[i]+"");
        }
        Collections.sort(tem,(String x,String y)->((y+x).compareTo(x+y)));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(tem.get(i));
        }
        if(Integer.parseInt(tem.get(0))==0){
            return "0";
        }
        return sb.toString();
    }
}
