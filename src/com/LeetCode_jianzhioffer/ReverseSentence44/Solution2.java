package com.LeetCode_jianzhioffer.ReverseSentence44;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/16 14:45
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 */
public class Solution2 {
//    链接：https://www.nowcoder.com/questionTerminal/3194a4f4cf814f63919d0790578d51f3?answerType=1&f=discussion
//    来源：牛客网
public String ReverseSentence(String str) {
    if (str == null || str.trim().length() == 0) return str;
    char[] chars = str.toCharArray();
    reverseChars(chars, 0, str.length() - 1);
    // 利用滑动窗口
    // 遇到' '执行翻转
    int l = 0;
    int r = 0;
        while (l < str.length()) {
        if (chars[r] == ' ') {
            reverseChars(chars, l, r - 1);
            // 交换完之后,一起跳过' '
            r++;
            l = r;
        }
        if (r == str.length() - 1) {
            reverseChars(chars, l, r);
            // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
            break;
        }
        r++;
    }
        return String.valueOf(chars);
}
    private void reverseChars(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
