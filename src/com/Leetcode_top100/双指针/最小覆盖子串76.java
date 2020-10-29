package com.Leetcode_top100.双指针;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/23 11:10
 * # @version 1.0
 * # @File : 最小覆盖子串76.java
 * # @Software: IntelliJ IDEA
 */
public class 最小覆盖子串76 {
    class Solution {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();//记录模式 t 中的字符频数
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();//记录字符串 s 中的窗口l到r 中的 字符频数

        public String minWindow(String s, String t) {
            //t中有重复的字符
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);//记录模式 t 中的字符频数
            }
            int l = 0, r = -1;//窗口的范围
            // ansL ansR记录最小窗口范围 的左右边界 ， len记录最小子串的长度
            int len = Integer.MAX_VALUE,
                    ansL = -1,
                    ansR = -1;
            int sLen = s.length();
            //这里窗口的范围为闭区间，即[l,r],因此长度为 r-l+1
            while (r < sLen) {//r < sLen 遍历结束的标志
                ++r;//在s的窗口没有包含t所有字符的时候，先固定左边指针，移动右边指针，扩大范围
                if (r < sLen && ori.containsKey(s.charAt(r))) {//如果右边边界r的字符在 t中，更新 cnt
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    //如果窗口包含了t所有字符，则固定右边指针，移动左边指针缩小窗口，结束的标志是[l,r]字符串没有包含t中的所有字符，
                    // 然后可以固定l,开始移动r,继续到下一个符合的位置
                    if (r - l + 1 < len) {
                        //看当前位置是不是最短的子字符串，是的话更新 len l ，r
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {//如果缩小的l位置是t中的字符，则对应位置减一，
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);//如果没有更新ans，说明没找到，直接返回空
        }

        public boolean check() {
            //检查字符s窗口的字符串是不是包含了 t所有的字符
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }

}
