package com.Leetcode_top100.动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/25 9:04
 * # @version 1.0
 * # @File : 单词拆分139.java
 * # @Software: IntelliJ IDEA
 */
public class 单词拆分139 {
    //动态规划，关键是用set保存字典，然后用set.contains来查找子字符串是否在字典中,set的应用
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;//初试状态 表示没有字符的时候，肯定是true
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }

            }
            return dp[s.length()];
        }
    }
//    优化一下，dp[i]只需要往前探索到词典里最长的单词即可，优化后击败100%

    class Solution2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length(), maxw = 0;
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            Set<String> set = new HashSet();
            for(String str : wordDict){
                set.add(str);
                maxw = Math.max(maxw, str.length());
            }
            for(int i = 1; i < len + 1; i++){
                for(int j = i; j >= 0 && j >= i - maxw; j--){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len];
        }
    }
    // dfs
    // 来自java最快提交，很简洁，只是有面向用例痕迹
    public class Solution3 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.length() == 0) return true;
            if (s.length() >= 151) return false;//不加这个 会超时，这个思路可以参考，这个数字就是为了应付超时的大串设计的
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                if (s.startsWith(word)) {
                    // substring (int beginIndex)从beginIndex开始截取字符串到字符串结尾
                    if (wordBreak(s.substring(word.length()), wordDict))
                        return true;
                }
            }
            return false;
        }
    }
}
