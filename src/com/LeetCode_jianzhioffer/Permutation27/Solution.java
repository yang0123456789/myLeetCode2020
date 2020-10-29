package com.LeetCode_jianzhioffer.Permutation27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/31 14:02
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?f=discussion
 * 来源：牛客网
 * <p>
 * 1、递归算法
 * *
 * * 解析：http://www.cnblogs.com/cxjchen/p/3932949.html  (感谢该文作者！)
 * *
 * * 对于无重复值的情况
 * *
 * * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 * *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 * *
 * * 假如有重复值呢？
 * * *由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
 * * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
 * * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
 * * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
 * *
 * * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
 * * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
 * *
 * *
 */


public class Solution {
    public ArrayList<String> Permutation(String str) {


        ArrayList<String> list = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }


    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {//递归终止的条件是递归到最后一个位置，只剩一个字符，说明递归进行到最后一个，已经排序完了，则吧前面加进去的序列，加入到结果list中
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<Character>();
            // for循环和swap的含义：对于“ABC”，
            // 第一次'A' 与 'A'交换，字符串为"ABC", pos为0， 相当于固定'A'
            // 第二次'A' 与 'B'交换，字符串为"BAC", pos为0， 相当于固定'B'
            // 第三次'A' 与 'C'交换，字符串为"CBA", pos为0， 相当于固定'C'
            for (int j = i; j < chars.length; ++j) {
                if (j == i || !charSet.contains(chars[j])) {//第一个是原始的序列，不需要判断是否重复，从第二个开始，
                    // 就要判断在这个子字符串中有没有字母相同的，因为相同的话，交换完以后，进行递归的结果是相同的
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                    // 回溯的原因：比如第二次交换后是"BAC"，需要回溯到"ABC"
                    // 然后进行第三次交换，才能得到"CBA"
                }
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}

