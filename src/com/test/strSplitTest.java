package com.test;

import java.sql.SQLOutput;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/24
 * @Version 1.0
 **/
public class strSplitTest {
    public static void main(String[] args) {
        String str="123   345   23 3";
        String[] s = str.split(" ");
        for(String tem:s){
            System.out.println("tem = " + tem);

        }

    }
}
