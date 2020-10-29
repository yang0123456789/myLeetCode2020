package com.美团;

import java.util.Scanner;

public class Main {
    //n代表需要输入的正整数
     int n, k = 2;

    public static void main(String[] args) {
//        System.out.print("请输入一个大于2的正整数：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.print(n + "=");
            Main example = new Main();
            example.f(n);
            scanner.nextLine();

        }
    }
    public void f(int n) {
        if (n<=1){
            System.out.println(n);
        }
        while (k <= n) {
            if (k == n) {
                System.out.print(n);
                break;
            } else if (n > k && n % k == 0) {
                System.out.print(k + "*");
                n = n / k;
                f(n);
                break;
            } else if (n > k && n % k != 0) {
                k++;
                f(n);
                break;
            }
        }
    }
}
