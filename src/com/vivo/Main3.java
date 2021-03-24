package com.vivo;

import java.util.Base64;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/10
 * @Version 1.0
 **/
public class Main3 {
    static StringBuilder path = new StringBuilder();
    static int shortestPath = 0;

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int starX = in.nextInt();
        in.nextLine();
        int starY = in.nextInt();
        in.nextLine();
        int endX = in.nextInt();
        in.nextLine();
        int endY = in.nextInt();
        in.nextLine();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = chars[j];
            }

        }

    }
    public  static  void dfsMaze(int x,int y,int endX,int endY,char[][] maze){
        int m=maze.length-1;
        int n=maze[0].length-1;
        if(x<0|y<0||x>m||y>n||maze[x][y]=='#'||maze[x][y]=='@')return;
        
    }
}
