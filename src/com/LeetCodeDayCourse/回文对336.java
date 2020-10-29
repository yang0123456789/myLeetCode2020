package com.LeetCodeDayCourse;

import com.Leetcode_top100.合并K个排序链表23;
import sun.plugin.javascript.navig.LinkArray;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/6 10:48
 * # @version 1.0
 * # @File : 回文对336.java
 * # @Software: IntelliJ IDEA
 *
 *
 *
 *
 */
public class 回文对336 {
    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            //暴力破解法 时间复杂度过高
            if(words.length<2)return null;
            List<List<Integer>> lists=new ArrayList<>();
            for(int i=0;i<words.length-1 ;i++){
                for(int j=i+1;j<words.length ;j++){
                    if (isRomePairs(words[i],words[j])) {
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);}
                    if (isRomePairs(words[j],words[i])) {
                        List<Integer> list=new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        lists.add(list);}

                }

            }
            return lists;
        }
        public boolean isRomePairs(String str1,String str2){
            int left=0;
            int right=str1.length()+str2.length()-1;
            String tem1=str1+str2;
//            String tem2=str2+str1;
            while (left<=right){
                if (tem1.charAt(left)==tem1.charAt(right)){
                    left++;
                    right--;
                    continue;
                }
                break;
            }
            if (left>right) return true;
//            left=0;
//             right=str1.length()+str2.length();
//            while (left<=right){
//                if (tem2.charAt(left)==tem2.charAt(right)){
//                    left++;
//                    right--;
//                    continue;
//                }
//                break;
//            }
//            if (left>right) return true;
            return false;

        }
    }
    class Solution2 {

        class Node {
            int[] ch = new int[26];
            int flag;

            public Node() {
                flag = -1;
            }
        }

        List<Node> tree = new ArrayList<Node>();

        public List<List<Integer>> palindromePairs(String[] words) {
            tree.add(new Node());
            int n = words.length;
            for (int i = 0; i < n; i++) {
                insert(words[i], i);
            }
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                int m = words[i].length();
                for (int j = 0; j <= m; j++) {
                    if (isPalindrome(words[i], j, m - 1)) {
                        int leftId = findWord(words[i], 0, j - 1);
                        if (leftId != -1 && leftId != i) {
                            ret.add(Arrays.asList(i, leftId));
                        }
                    }
                    if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                        int rightId = findWord(words[i], j, m - 1);
                        if (rightId != -1 && rightId != i) {
                            ret.add(Arrays.asList(rightId, i));
                        }
                    }
                }
            }
            return ret;
        }

        public void insert(String s, int id) {
            int len = s.length(), add = 0;
            for (int i = 0; i < len; i++) {
                int x = s.charAt(i) - 'a';
                if (tree.get(add).ch[x] == 0) {
                    tree.add(new Node());
                    tree.get(add).ch[x] = tree.size() - 1;
                }
                add = tree.get(add).ch[x];
            }
            tree.get(add).flag = id;
        }

        public boolean isPalindrome(String s, int left, int right) {
            int len = right - left + 1;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(left + i) != s.charAt(right - i)) {
                    return false;
                }
            }
            return true;
        }

        public int findWord(String s, int left, int right) {
            int add = 0;
            for (int i = right; i >= left; i--) {
                int x = s.charAt(i) - 'a';
                if (tree.get(add).ch[x] == 0) {
                    return -1;
                }
                add = tree.get(add).ch[x];
            }
            return tree.get(add).flag;
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution3 {
    List<String> wordsRev = new ArrayList<String>();//
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        //wordsRev保存所有输入字符串的倒置字符串
        for (String word: words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        //indices 按照顺序保存倒置的字符串，key是倒置的字符串，value是对应第几个字符串的倒置
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }


        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        //判断s制定 子串是不是 回文串
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        //找到对应的反转的字符串
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
