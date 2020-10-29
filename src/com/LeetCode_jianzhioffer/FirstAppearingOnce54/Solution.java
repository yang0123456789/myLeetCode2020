package com.LeetCode_jianzhioffer.FirstAppearingOnce54;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 15:53
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 *
 * 使用一个HashMap来统计字符出现的次数，
 * 同时用一个ArrayList来记录输入流，
 * 每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为key去map中查找。
 *
 */
public class Solution {
    //Insert one char from stringstream
    HashMap<Character,Integer> map=new HashMap<>();
    ArrayList<Character> list=new ArrayList<>();
    public void Insert(char ch)
    {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
        list.add(ch);


    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c='#';
        for(char key:list){
            if( map.get(key).equals(1) ){
                c=key;
                break;
            }
        }
        return c;

    }


}
