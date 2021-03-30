package com.携程;

import java.util.LinkedList;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/30
 * @Version 1.0
 * <p>
 * 给一个字符串，比如ABC， 把所有的排列，即：ABC, ACB, BAC, BCA, CAB, CBC 都找出来。
 * 解题思路：
 * <p>
 * 对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里 那个字符 的排列。 有点难理解，用例子说明：
 * <p>
 * 对于字符串ABC来讲，它所有的排列就是 A + BC 的排列 加上 B + AC 的排列，再加上 C + AB的排列。
 * <p>
 * 而BC的排列是 B + C 的排列 加上 C + B 的排列。
 * <p>
 * 所以，对一个字符串，我们从中去一个值，然后求剩余部分的排列，然后把它们再组合在一起。所有，代码如下：
 **/
public class 字符串的全排列 {
    // str has been sorted.
    public static LinkedList<String> permutation(String str) {

        LinkedList<String> linkedString = new LinkedList<String>();
        if (str.length() <= 1) {
            linkedString.add(str);
            return linkedString;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //consider the case in which the characters may be duplicated.
            if (i > 0 && ch == str.charAt(i - 1)) {
                continue;
            }
            String newStr = remove(str, i);
            LinkedList<String> newStrList = permutation(newStr);
            for (int j = 0; j < newStrList.size(); j++) {
                linkedString.add(ch + newStrList.get(j));
            }
        }
        return linkedString;
    }

    //remove the ith character from the string
    public static String remove(String str, int i) {
        if (i == 0) return str.substring(1, str.length());
        if (i == str.length() - 1) return str.substring(0, i);
        return str.substring(0, i) + str.substring(i + 1, str.length());
    }
}

// 这里贴出另一个permutation 的版本：
class solution {
    static void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void permutation(char[] arr, int index, int size) {
        if (index == size) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = index; i < size; i++) {
                if (i != index && arr[i] == arr[index])
                    continue;
                swap(arr, i, index);
                permutation(arr, index + 1, size);
                swap(arr, i, index);
            }
        }
    }
}

class solution2 {
    static void swap(char[] arr, int idx1, int idx2) {
        char tem = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tem;

    }

    static void permutation(char[] arr, int index, int size) {
        if (index == size) {
            System.out.println(String.valueOf(arr));
        } else {
            for (int i = index; i < size; i++) {
                if (i != index && arr[i] == arr[index]) {
                    continue;
                } else {
                    swap(arr, i, index);
                    permutation(arr, index + 1, size);
                    swap(arr, i, index);
                }
            }
        }
    }

}