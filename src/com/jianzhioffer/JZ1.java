package com.jianzhioffer;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/14 14:36
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class JZ1 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n=array[0].length;
        boolean flag=false;
        int x=m-1;
        int y=0;
        while(x>=0&&y<=n-1){
            if(target==array[x][y]){
                return true;
            }
            else if(target<array[x][y]){
                x--;
            }else {
                y++;
            }
        }
        return false;

    }
}


