package com.LeetCode_jianzhioffer.multiply51;

import java.util.Arrays;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/14 21:20
 * # @version 1.0
 * # @File : arrayTest.java
 * # @Software: IntelliJ IDEA
 */
public class arrayTest {
    public static void main(String[] args) {
//        String[] stringArray = { "a", "b", "c", "d", "e" };
//        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
//        System.out.println(Arrays.asList(stringArray));
//        System.out.println(arrayList);
// [a, b, c, d, e]
        String[] stringArray = { "a", "b", "c", "d", "e" };
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);
// true
//        ArrayUtils常用方法的基本操作 PS（首先需要导入commons-lang.jar，我的是3-3.6版本
//        int[] intArray = { 1, 2, 3, 4, 5 };
//        int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
//        System.out.println(Arrays.toString(removed));
    }
}
