package com.yuanfudao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/12 21:27
 * # @version 1.0
 * # @File : Main3.java
 * # @Software: IntelliJ IDEA
 */

class P{
    int x;
    int y;
    public P(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

}
//15
//0 7 7 7
//*5#++B+B+++++$3
//55#+++++++###$$
//###$++++++#+*#+
//++$@$+++$$$3+#+
//+++$$+++$+4###+
//A++++###$@+$++A
//+++++#++$#$$+++
//A++++#+5+#+++++
//+++$$#$++#++++A
//+++$+@$###+++++
//+###4+$+++$$+++
//+#+3$$$+++$##++
//+#*+#++++++#$$+
//$####+++++++$##
//3$+++B++B++++#5
public class Main3{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int M =N;
        scn.nextLine();
        int sx=scn.nextInt(),sy=scn.nextInt(),ex=scn.nextInt(),ey=scn.nextInt();
        scn.nextLine();
        char arr[][];
        arr=new char[N][M];
        for(int i=0;i<N;i++) {
            arr[i]=scn.nextLine().toCharArray();
        }

        int arr2[][]=new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                arr2[i][j]=10000;
            }
        }
        int arr3[] = {-1,0,1,0};
        int arr4[] = {0,-1,0,1};
        Queue<P> que = new LinkedList();
        que.add(new P(sx,sy));
        arr2[sx][sy]=0;
        while(que!=null) {
            P p =que.poll();
            if(p.getX()==ex&&p.getY()==ey)
                break;
            for (int i=0;i<4;i++) {
                int x = p.x+arr3[i];
                int y = p.y+arr4[i];
                if(x>=0&&y>=0&&x<N&&y<M&&arr2[x][y]==10000&&arr[x][y]!='#'&&arr[x][y]!='@') {
                    que.add(new P(x,y));
                    arr2[x][y]=arr2[p.x][p.y]+1;
                }
            }
        }
        System.out.println(arr2[ex][ey]);
    }

}
