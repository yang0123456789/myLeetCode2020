package com.vivo;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/10
 * @Version 1.0
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序"1,2,-1,1"
     * @param input string字符串
     * @return string字符串
     */
    public String compileSeq (String input) {
        String[] strs=input.split(",");
        int num=strs.length;
        int[] orders=new int[num];
        // write code here
        for(int i=0;i<num ;i++){
            orders[i]=Integer.parseInt(strs[i]);
        }
        String s="";
        for(int i=0;i<num-1 ;i++){
        s=s+orders[i]+",";
        }
        s=s+orders[num-1];
        return s;

    }
}
