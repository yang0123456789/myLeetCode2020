package com.Leetcode_top100;

import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/20 11:29
 * # @version 1.0
 * # @File : 删除无效的括号301.java
 * # @Software: IntelliJ IDEA
 */
public class 删除无效的括号301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {

return null;
        }

        public boolean isValid(String s) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') cnt++;
                else if (c == ')') cnt--;
                if (cnt < 0) return false;
            }
            return cnt == 0;
        }
    }
}
