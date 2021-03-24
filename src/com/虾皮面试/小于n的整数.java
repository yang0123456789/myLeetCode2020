package com.虾皮面试;

import java.util.Arrays;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 小于n的整数 {

    String a, b;

    int cmp(String a, String b) {
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) > b.charAt(i)) return 1;
            else if (a.charAt(i) < b.charAt(i)) return -1;
        return 0;
    }

    int main(String a) {
        b = a;
        // 因为排列是以降序的方式生成的
        char[] chars = a.toCharArray();

        Arrays.sort(chars);

        if (chars[0] == '0' || cmp(a, b) >= 0) System.out.println('0');
        else for (char x : chars) System.out.println(x);

        return 0;
    }


}
