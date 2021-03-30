package com.TenTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 * 一、ArrayList转换为数组
 * ArrayList提供public T[] toArray(T[] a)方法返回一个按照正确的顺序包含此列表中所有元素的数组，返回数组的运行时类型就是指定数组的运行时类型。
 **/
public class JavaArrayList和数组间的相互转换 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        int size = list.size();
        String[] array = (String[]) list.toArray(new String[size]);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    //     二、数组转换为List
// 2.1 其实数组转换成为List的问题，Arrays对象也提供给我们public static List asList(T… a)供我们调用。
    public static void main2(String[] args) {
        String[] array = new String[3];
        array[0] = "a";
        array[1] = "b";
        array[2] = "c";
        List<String> list = Arrays.asList(array);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
