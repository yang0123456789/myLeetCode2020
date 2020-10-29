package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 14:59
 * # @version 1.0
 * # @File : 回文子串647.java
 * # @Software: IntelliJ IDEA
 */
public class 回文子串647 {
    class Solution {
        public int countSubstrings(String s) {
            if(s.length()==0) return 0;
            int count=0;
            for(int i=0;i<s.length() ;i++){
                int left=i;
                int right=i;
                //当字符串为奇数时，以i为中心向两边扩展
                while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }

                //当子字符串为偶数时，以i和i-1为中心向两边扩展
                left=i-1;
                right=i;
               while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                   count++;
                   left--;
                   right++;
               }

            }
            return count;

        }
    }
}
