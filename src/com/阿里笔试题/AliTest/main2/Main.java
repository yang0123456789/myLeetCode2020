package com.aliTest.main2;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/11 9:34
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
//
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    while (sc.hasNextLine()){
        String s=sc.nextLine();
        System.out.println(isValid(s));
    }
}
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}



class Solution {

}

