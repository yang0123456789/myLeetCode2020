package com.美团;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 19:02
 * # @version 1.0
 * # @File : 多余的下划线.java
 * # @Software: IntelliJ IDEA
 */
public class 多余的下划线 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            char[] chars = string.trim().toCharArray();
            int index = 0;
            int len = chars.length;
            StringBuffer sb = new StringBuffer();
            while (index < len) {
                while (index < len&&chars[index] == '_') index++;
                while (index < len && chars[index] != '_') {
                    sb.append(chars[index]);
                    index++;
                }
                while (index < len && chars[index] == '_') index++;
                if (index < len) {
                    sb.append('_');
                }
            }
            System.out.println(sb.toString());

        }

    }

}
