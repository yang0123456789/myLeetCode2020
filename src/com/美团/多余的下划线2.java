package com.美团;

import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/29 19:02
 * # @version 1.0
 * # @File : 多余的下划线.java
 * # @Software: IntelliJ IDEA
 */
public class 多余的下划线2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String string = sc.nextLine();

            int index = 0;
            int len = string.length();
            StringBuffer sb = new StringBuffer();
            while (index < len) {
                while (index < len&&string.charAt(index) =='_') index++;
                while (index < len && string.charAt(index)!= '_') {
                    sb.append(string.charAt(index));
                    index++;
                }
                while (index < len && string.charAt(index) == '_') index++;
                if (index < len) {
                    sb.append('_');
                }
            }
            System.out.println(sb.toString());

        }

    }

}
