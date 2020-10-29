package com.Leetcode_top100;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/15 15:58
 * # @version 1.0
 * # @File : 路径总和3_437.java
 * # @Software: IntelliJ IDEA
 * 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class 路径总和3_437 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution {
        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            //先序或者后续遍历每个节点，以每个节点为起点的子路径有多少个路径
            if (root == null) return count;
            path(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
            return count;

        }

        public void path(TreeNode node, int rest) {

            if (node == null) return;//迭代的出口，
            rest -= node.val;//看到这个节点以后，减去该节点的值，剩下的数值是不是0，如果是的话，就是一条路径
            if (rest == 0) {
                count++;
            }
            path(node.left, rest);//递归左子树向下走
            path(node.right, rest);//递归左子树向下走
        }
    }



        //        遍历每个节点。 关键点：递归
//        计算以当前节点为路径终点的所有路径和。
//        关键点：用一个数组保存从遍历过的每个节点出发，到当前节点的路径的和
//        因此，只需计算每一步中，sum在数组sumlist中出现的次数，然后与每一轮递归的结果相加即可
//        解题思路
//只需一次递归五行代码，用列表记录下当前结果即可，为什么要双重递归呢？
//
//sumlist[]记录当前路径上的和，在如下样例中：
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//当DFS刚走到2时，此时sumlist[]从根节点10到2的变化过程为：
//
//    10
//    15 5
//    17 7 2
//当DFS继续走到1时，此时sumlist[]从节点2到1的变化为：
//
//    18 8 3 1
//因此，只需计算每一步中，sum在数组sumlist中出现的次数，然后与每一轮递归的结果相加即可
//
//count = sumlist.count(sum)等价于：
//
// count = 0
// for num in sumlist:
//     if num == sum:
//         count += 1
//count计算本轮sum在数组sumlist中出现的次数
//
//作者：821218213
//链接：https://leetcode-cn.com/problems/path-sum-iii/solution/437zhi-xu-yi-ci-di-gui-wu-xing-dai-ma-yong-lie-bia/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        class Solution2 {
        public int pathSum(TreeNode root, int sum) {
            return pathSum(root, sum, new int[1000], 0);
        }

        public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
            if (root == null) {
                return 0;
            }
            int tmp = root.val;
            int n = root.val == sum ? 1 : 0;//当前节点的值为sum的话，单独算一条路径
            for (int i = p - 1; i >= 0; i--) {
                tmp += array[i];//将数组中存储的所有路径。看加上该节点的所有路径是不是符合sum的值
                if (tmp == sum) {
                    n++;
                }
            }
            array[p] = root.val;//这个地方已经修改了每个分支的该位置的值，边递归边修改，添加以该节点为起点的路径
            int n1 = pathSum(root.left, sum, array, p + 1);//p+1限制了读取的范围，因此不会乱
            int n2 = pathSum(root.right, sum, array, p + 1);//递归以左子树、右子树为终点的所有路径的总和
            return n + n1 + n2;//返回该节点为起点的路径以及递归左右子节点的路径和
        }


    }
}
