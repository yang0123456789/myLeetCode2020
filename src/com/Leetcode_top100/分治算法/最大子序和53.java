package com.Leetcode_top100.分治算法;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/22 16:38
 * # @version 1.0
 * # @File : 最大子序和53.java
 * # @Software: IntelliJ IDEA
 */
public class 最大子序和53 {
    class Solution {

        /**
         动态规划：
         方法一：维护一个二维数组

         状态：opt[i,j]表示包含i 到 包含j 中间的数的和的值,
         初试状态:
         opt[0,0]=nums[0]
         状态转移方程：opt[i,j]=opt[i-1,j]-opt[i-1，j]  一列一列填写
         =opt[i,j-1]+opt[j]  一行一行填写

         二维数组的状态


         */
        /**
         * 行不通
         * 方法二：维护一个一维数组
         * 状态：opt[i]表示以i结尾的区间的最优解的值，必须以i结尾
         * 初试状态：opt[0]=nums[0]
         * <p>
         * 状态转移方程：opt[i]=max{opt[i-1]+nums[i],nums[i]}
         * 我们可以考虑 a_i
         * 单独成为一段还是加入 f(i - 1)f(i−1) 对应的那一段，这取决于 a_i和 f(i - 1) + a_i
         * 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
         * f(i)=max{f(i−1)+a[i],a[i]​}
         * 不难给出一个时间复杂度 O(n)O(n)、空间复杂度 O(n)O(n) 的实现，即用一个 f 数组来保存 f(i)f(i) 的值，
         * 用一个循环求出所有 f(i)f(i)。考虑到 f(i)f(i) 只和 f(i - 1)f(i−1) 相关，
         * 于是我们可以只用一个变量 pre 来维护对于当前 f(i)f(i) 的 f(i - 1)f(i−1) 的值是多少，
         * 从而让空间复杂度降低到 O(1)O(1)，这有点类似「滚动数组」的思想。
         */
        public int maxSubArray(int[] nums) {

            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }

        class Solution2 {
//            分治法我还是觉得这个好理解一些
            public int maxSubArray(int[] nums) {
                if (nums == null || nums.length == 0) return 0;
                return helper(nums, 0, nums.length - 1);
            }

            public int helper(int[] nums, int l, int r) {
                if (l > r) return Integer.MIN_VALUE;
                int mid = (l + r) >>> 1;
                int left = helper(nums, l, mid - 1);
                int right = helper(nums, mid + 1, r);
                int leftMaxnum = 0;//表示 [l, r]内以 mid - 1为右端点的最大子段和
                   int   rightMaxnum = 0;//表示 [l, r] 内以 mid + 1 为左端点的最大子段和
                int sum = 0;//表示[l,r] 的区间和
                for (int i = mid - 1; i >= l; i--) {//[1,mid-1]左半段的leftMaxnum
                    sum += nums[i];//表示[i,mid] 的区间和
                    leftMaxnum = Math.max(leftMaxnum, sum);
                }
                sum = 0;
                for (int j = mid + 1; j <= r; j++) {
                    sum += nums[j];//表示[mid+1,j] 的区间和
                    rightMaxnum = Math.max(rightMaxnum, sum);
                }
                return Math.max(leftMaxnum + nums[mid] + rightMaxnum, Math.max(left, right));
            }
        }

    }
    class Solution4 {
        /**
         * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 注意越界,连个范围都没有还行，注意子数组连续。
         * 尝试线段树
         *
         * @param nums 整数数组
         * @return 最少包含一个元素的最大和的连续子数组的和
         */
        public int maxSubArray(int[] nums) {
            // 输入校验
            if (nums == null || nums.length <= 0)
                return 0;
            int len = nums.length;// 获取输入长度
            return getInfo(nums, 0, len - 1).mSum;
        }

        class wtevTree {
            int lSum;// 以左区间为端点的最大子段和
            int rSum;// 以右区间为端点的最大子段和
            int iSum;// 区间所有数的和
            int mSum;// 该区间的最大子段和

            // 构造函数
            wtevTree(int l, int r, int i, int m) {
                lSum = l;
                rSum = r;
                iSum = i;
                mSum = m;
            }
        }

        // 通过既有的属性，计算上一层的属性,一步步往上返回,获得线段树
        wtevTree pushUp(wtevTree leftT, wtevTree rightT) {
            // 新子段的lSum等于左区间的lSum或者左区间的 区间和 加上右区间的lSum
            int l = Math.max(leftT.lSum, leftT.iSum + rightT.lSum);
            // 新子段的rSum等于右区间的rSum或者右区间的 区间和 加上左区间的rSum
            int r = Math.max(leftT.rSum + rightT.iSum, rightT.rSum);
            // 新子段的区间和等于左右区间的区间和之和
            int i = leftT.iSum + rightT.iSum;
            // 新子段的最大子段和，其子段有可能穿过左右区间，或左区间，或右区间
            int m = Math.max(leftT.rSum + rightT.lSum, Math.max(leftT.mSum, rightT.mSum));
            return new wtevTree(l, r, i, m);
        }

        // 递归建立和获得输入区间所有子段的结构
        wtevTree getInfo(int[] nums, int left, int right) {
            // 若区间长度为1，其四个子段均为其值
            if (left == right)
                return new wtevTree(nums[left], nums[left], nums[left], nums[left]);
            int mid = (left + right) >> 1;// 获得中间点mid
            wtevTree leftT = getInfo(nums, left, mid);
            wtevTree rightT = getInfo(nums, mid + 1, right);//mid+1,左右区间没有交集。
            return pushUp(leftT, rightT);
        }
    }
}
