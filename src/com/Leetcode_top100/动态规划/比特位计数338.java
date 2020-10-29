package com.Leetcode_top100.动态规划;

import sun.applet.Main;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/17 15:47
 * # @version 1.0
 * # @File : 比特位计数338.java
 * # @Software: IntelliJ IDEA
 */
public class 比特位计数338 {
    public static void main(String[] args) {
        int x=5;
        x &= x - 1;
        System.out.println(x);

    }
    class Solution {
        public int[] countBits(int num) {
            if (num == 0) return new int[]{0};
            int[] nums = new int[num + 1];
            nums[0] = 0;
            for (int i = 1; i <= num; i++) {
                nums[i] = i % 2 + nums[i >> 1];
            }
            return nums;

        }
    }

    class Solution2 {
//        对于所有的数字，只有两类：
//
//奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
//          举例：
//         0 = 0       1 = 1
//         2 = 10      3 = 11
//偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
//           举例：
//          2 = 10       4 = 100       8 = 1000
//          3 = 11       6 = 110       12 = 1100
//另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。

        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            result[0] = 0;
            for (int i = 1; i <= num; i++) {
                if ((i&1)==1) {
                    result[i] = result[i - 1] + 1;
                } else {
                    result[i] = result[i / 2];
                }
            }

            return result;

        }
    }
    public class Solution3 {
//        Pop count
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 0; i <= num; ++i)
                ans[i] = popcount(i);
            return ans;
        }
        private int popcount(int x) {
            int count;
            for (count = 0; x != 0; ++count)
                x &= x - 1; //zeroing out the least significant nonzero bit
            return count;
        }
    }
    public class Solution4 {
//        https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
//        方法二：动态规划 + 最高有效位 【通过】
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            int i = 0, b = 1;
            // [0, b) is calculated
            while (b <= num) {
                // generate [b, 2b) or [b, num) from [0, b)
                while(i < b && i + b <= num){
                    ans[i + b] = ans[i] + 1;
                    ++i;
                }
                i = 0;   // reset i
                b <<= 1; // b = 2b
            }
            return ans;
        }
    }


    public class Solution5 {
//        方法四：动态规划 + 最后设置位【通过】
//算法
//
//与上述方法思路相同，我们可以利用最后设置位。
//
//最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0，就可以得到以下状态转移函数：
//
//P(x)=P(x&(x−1))+1;
//

        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i & (i - 1)] + 1;
            return ans;
        }
    }

}