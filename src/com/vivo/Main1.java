package com.vivo;

import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/10
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例

            boolean flag = false;
            String str = in.nextLine();
            if (str == null || str == "") {
                flag = true;
                System.out.print(str);
            }
            char[] chars = str.toCharArray();
            //    首先判断是不是回文子串
            boolean is = isHuiwen(chars);
            if (is) {
                flag = true;
                System.out.print(str);
            } else {
                for (int i = 0; i < chars.length; i++) {
                    char[] tem = new char[chars.length - 1];
                    int k = 0;
                    for (int j = 0; j < chars.length; j++) {
                        if (j == i) {
                            continue;
                        } else {
                            tem[k++] = chars[j];
                        }

                    }

                    if (isHuiwen(tem)) {
                        System.out.print(tem);
                        flag = true;
                        break;
                    }

                }
            }


            if (!flag) {
                System.out.print("false");
            }
        }

    }

    public static boolean isHuiwen(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;

    }
}
