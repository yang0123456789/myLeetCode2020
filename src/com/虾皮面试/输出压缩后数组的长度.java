package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 输出压缩后数组的长度 {
    class Solution {
        public int compress(char[] chars) {
            int anchor = 0;//每个字符的位置起始
            int write = 0;//写入的位置
            //挨个读字符
            for (int read = 0; read < chars.length; read++) {
                //1.读到最后一位 2.下一位和这个位不同
                if (read == chars.length - 1 || chars[read + 1] != chars[read]) {
                    chars[write++] = chars[anchor];
                    //读和起始位置不同，说明有多个，写入数字
                    if (read > anchor) {
                        for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                            chars[write++] = c;
                        }
                    }
                    anchor = read + 1;//读下一位
                }
            }
            return write;
        }
    }


}
