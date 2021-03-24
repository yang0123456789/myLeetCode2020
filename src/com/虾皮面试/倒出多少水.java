package com.虾皮面试;

import java.util.Scanner;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/21
 * @Version 1.0
 **/
public class 倒出多少水 {
    void pour(int A, int B, int target) {
        //inA, inB分别表示A，B中水的数量
        int inA = 0;
        int inB = 0;

        int flag = 0;
        while (true) {
            //假设倒水操作可在一定的while循环次数内完成
            if (flag++ > 999) {
                break;
            }

            if (0 == inA) {
                inA = A;
            } else {
                inB += inA;

                if (inB >= B) {
                    inA = inB - B;
                    inB = 0;
                } else {
                    inA = 0;
                }
            }  //end  if(0 == inA)

            if (target == inA || target == inB) {
                break;
            }

        }//end  while(1)
    }

    int main() {
        int A, B, target;
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        target = sc.nextInt();

        //可以证明，任何的A，B，target在该题目中都可以转成如下形式
        //即：0 <= target < A < B
        if (A <= 1 || B <= 0 || A >= B || target >= A) {
            return 0;
        }

        pour(A, B, target);

        return 0;
    }


}
