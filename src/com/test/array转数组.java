package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class array转数组 {
    public static void main(String[] args) {
        Integer [] myArray = { 1, 2, 3 };
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
//基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
    }
}
