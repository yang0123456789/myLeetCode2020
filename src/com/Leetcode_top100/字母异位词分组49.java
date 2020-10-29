package com.Leetcode_top100;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 16:10
 * # @version 1.0
 * # @File : 字母异位词分组49.java
 * # @Software: IntelliJ IDEA
 */
public class 字母异位词分组49 {
    class Solution {
//        思路
//
//        当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
//
//        算法
//
//        维护一个映射 ans : {String -> List}，其中每个键 \text{K}K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 \text{K}K。
//
//        在 Java 中，我们将键存储为字符串，例如，code。 在 Python 中，我们将键存储为散列化元组，例如，('c', 'o', 'd', 'e')。



        //字符串转成 char数组，然后排序，生成一个新的按字符排序的排序的字符串，
        // 然后放入一个string类的arrylist，将这个字符串加进去
        //这样就可以判断每个string是不是有相同的字母
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();
            ArrayList<String> ans = new ArrayList<>();
            HashMap<String, List> hashMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String s = new String(chars);
                if (!hashMap.containsKey(s)) {
                    hashMap.put(s, new ArrayList());
                }
                hashMap.get(s).add(strs[i]);
            }
            return new ArrayList(hashMap.values());

        }
    }
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
