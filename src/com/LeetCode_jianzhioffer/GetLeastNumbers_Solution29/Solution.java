package com.LeetCode_jianzhioffer.GetLeastNumbers_Solution29;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 14:41
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length<k)return null;
        Arrays.sort(input);
        ArrayList<Integer> output=new ArrayList<>();
        for(int i=0;i<k ;i++){
        output.add(input[i]);
        }
return output;

    }
}
