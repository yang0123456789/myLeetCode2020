package com.LeetCode_jianzhioffer.hasPath28;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/5 10:02
 * # @version 1.0
 * # @File : Slution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    boolean[] visited = null;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        visited = new boolean[matrix.length];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(dfs(matrix,rows,cols,str,i,j,0))
                    return true;
        return false;
    }

    //num标记已经确定相同的字符的个数
    public boolean dfs(char[] matrix, int rows, int cols, char[] str, int row, int col, int len) {
        if(matrix[row*cols+col] != str[len]|| visited[row*cols+col] == true) return false;
        if(len == str.length-1) return true;
        visited[row*cols+col] = true;
        if(row > 0 && dfs(matrix,rows,cols,str,row-1,col,len+1)) return true;
        if(row < rows-1 && dfs(matrix,rows,cols,str,row+1,col,len+1)) return true;
        if(col > 0 && dfs(matrix,rows,cols,str,row,col-1,len+1)) return true;
        if(col < cols-1 && dfs(matrix,rows,cols,str,row,col+1,len+1)) return true;
        visited[row*cols+col] = false;
        return false;


    }

    //"ABCESFCSADEE",3,4,"ABCB"
//
//"ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SLHECCEIDEJFGGFIE" true
//
//
//
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SLHECCEIDEJFGGFIE".toCharArray());
        System.out.println(b);

    }
}
