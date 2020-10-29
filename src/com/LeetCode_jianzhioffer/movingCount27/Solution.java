package com.LeetCode_jianzhioffer.movingCount27;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/4 22:23
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */
public class Solution {
    public  int total = 0;//创建一个成员变量，解决全局参数作用域的问题
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] mark=new int[rows][cols];

        int x=0;
        int y=0;
        dfs( x, y, threshold, rows, cols, mark  );
        return this.    total;

    }



    //1.编写check方法

   public  int check(int x){
        int sum=0;
        while (x!=0){
            sum=sum+x%10;
            x=x/10;

        }
       return sum;

   }
   //编写dfs方法，xy表示即将访问的位置
   public  void  dfs(int x,int y,int threshold,int rows,int cols,int[][] mark  ){
       //1.判断越界+是否访问过
        if(x<0||y<0||x>=rows||y>=cols||mark[x][y]==1){
            return;
        }
        //2.判断这个位置是否符合题目要求的条件
       if (check(x)+check(y)>threshold){
           return;
       }
       //3.判断完，说明这个位置符合要求，可以访问
       mark[x][y]=1;
       total++;
       System.out.println("x:"+x+"   y:"+y+"  total:"+total);


//       4.对这个点的四个能走的位置进行递归遍历
       //上
       dfs( x-1, y, threshold, rows, cols, mark);
       //下
       dfs( x+1, y, threshold, rows, cols, mark);
       //左
       dfs( x, y-1, threshold, rows, cols, mark);
       //右
       dfs( x, y+1, threshold, rows, cols, mark);

   }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int i = solution.movingCount(5, 10, 10);
        System.out.println(i);
    }
}
