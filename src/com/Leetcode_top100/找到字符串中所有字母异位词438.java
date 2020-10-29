package com.Leetcode_top100;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 14:40
 * # @version 1.0
 * # @File : 找到字符串中所有字母异位词438.java
 * # @Software: IntelliJ IDEA
 */
public class 找到字符串中所有字母异位词438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new LinkedList<>();
            if (s.length() < p.length()) return list;
            char[] ps = p.toCharArray();
            Arrays.sort(ps);
            for (int i = 0; i < s.length()-ps.length+1; i++) {
                char[] chars = s.substring(i, i + ps.length).toCharArray();
                Arrays.sort(chars);
                if (isAnagrams(chars, ps, i)) {
                    list.add(i);
                }
            }
            return list;

        }
        public boolean isAnagrams(char[] ss, char[] ps, int start) {
            for (int i = 0; i <  ps.length; i++) {
                if (ss[i] != ps[i]) {
                    return false;
                }
            }
            return true;
        }

    }
    class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length()<p.length()) return null;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < s.length()-p.length()+1; i++) {
                if (IsAnagram(s.substring(i,i+p.length()), p)) {
                    list.add(i);
                }
            }
            return list;

        }
        public boolean IsAnagram(String s, String t) {
            int[] arr = new int[26];
            for(char c : s.toCharArray())
                arr[c - 'a']++;
            for(char c : t.toCharArray())
                arr[c - 'a']--;
            for(int i : arr)
                if(i != 0)
                    return false;
            return true;
        }
        public List<Integer> findAnagrams2(String s, String p){
            //滑动窗口，未完待续
            List<Integer> resList = new ArrayList<Integer>();
            if(s == null || s.length() == 0 || s.length() < p.length()) return resList;

            Map<Character,Integer> need =new HashMap<>();
            Map<Character,Integer> window=new HashMap<>();
            for (char c:p.toCharArray()
                 ) {
                if (need.containsKey(c)){
                    Integer i = need.get(c);
                    need.put(c,i++);

                }else {
                    need.put(c,1);
                }


            }
            int left = 0, right = 0;
            int valid = 0;
            return resList;

        }
//        vector<int> findAnagrams(string s, string t) {
//            unordered_map<char, int> need, window;
//            for (char c : t) need[c]++;
//
//            int left = 0, right = 0;
//            int valid = 0;
//            vector<int> res; // 记录结果
//            while (right < s.size()) {
//                char c = s[right];
//                right++;
//                // 进行窗口内数据的一系列更新
//                if (need.count(c)) {
//                    window[c]++;
//                    if (window[c] == need[c])
//                        valid++;
//                }
//                // 判断左侧窗口是否要收缩
//                while (right - left >= t.size()) {
//                    // 当窗口符合条件时，把起始索引加入 res
//                    if (valid == need.size())
//                        res.push_back(left);
//                    char d = s[left];
//                    left++;
//                    // 进行窗口内数据的一系列更新
//                    if (need.count(d)) {
//                        if (window[d] == need[d])
//                            valid--;
//                        window[d]--;
//                    }
//                }
//            }
//            return res;
//        }

    }


}
