package com.LeetCode_jianzhioffer.FirstNotRepeatingChar34;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/17 16:34
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 1) return 0;
        if (str.length() == 0) return -1;


        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i])+1);

            } else {
                map.put(chars[i], 1);
            }

        }
        char first;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()==1){
                first=entry.getKey();
                for(int i=0;i<chars.length ;i++){
                if (chars[i]==first){
                    return i;
                }
                }
            }
        }
        return -1;

    }
}
