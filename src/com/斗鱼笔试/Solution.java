package com.斗鱼笔试;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/19 20:19
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
import java.util.*;


public class Solution {
    /**
     * 反转字符串，输入Douyu，输出uyuoD
     * @param str string字符串 任意字符串
     * @return string字符串
     */
    public String reverse (String str) {
        // write code here
        if (str.length()<=1)return str;
        char[] chars = str.toCharArray();
        StringBuffer sb=new StringBuffer();
        int len=str.length();
        for (int i=len-1;i>=0;i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}