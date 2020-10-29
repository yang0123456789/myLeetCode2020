package com.Leetcode_top100;

import java.util.Stack;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 21:41
 * # @version 1.0
 * # @File : 合并二叉树617.java
 * # @Software: IntelliJ IDEA
 *
 * 我们首先把两棵树的根节点入栈，栈中的每个元素都会存放两个根节点，并且栈顶的元素表示当前需要处理的节点。在迭代的每一步中，
 * 我们取出栈顶的元素并把它移出栈，并将它们的值相加。随后我们分别考虑这两个节点的左孩子和右孩子，如果两个节点都有左孩子，
 * 那么就将左孩子入栈；如果只有一个节点有左孩子，那么将其作为第一个节点的左孩子；如果都没有左孩子，那么不用做任何事情。对于右孩子同理。
 *
 * 最后我们返回第一棵树的根节点作为答案
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 合并二叉树617 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            //二叉树的先序遍历
            if (t1 == null)
                return t2;
            if (t2 == null)
                return t1;
            t1.val += t2.val;
            t1.left=mergeTrees(t1.left,t2.left);
            t1.right=mergeTrees(t1.right,t2.right);
            return t1;


        }
    }
    public class Solution2 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
                if (t1 == null)
                    return t2;
                Stack < TreeNode[] > stack = new Stack < > ();
                stack.push(new TreeNode[] {t1, t2});//相当于层次遍历
                while (!stack.isEmpty()) {
                    TreeNode[] t = stack.pop();
                    if (t[0] == null || t[1] == null) {//如果只要有一个为空，说明已经不需要进行合并，只有一棵树或者都为空，就结束下一步的操作，说明后续什么都不用做
                        continue;
                    }
                    t[0].val += t[1].val;//if (t[0] == null || t[1] == null)已经判定t1 t2不为空，合并两个节点到第一个节点
                    if (t[0].left == null) {//如果t1左子树为空，直接将t2左子树搬过来，然后不用入栈，已经固定了
                        t[0].left = t[1].left;
                    } else {//如果t1左子树不为空，入栈，进行下一次迭代
                        stack.push(new TreeNode[] {t[0].left, t[1].left});
                    }
                    if (t[0].right == null) {//右子树同样的操作
                        t[0].right = t[1].right;
                    } else {
                        stack.push(new TreeNode[] {t[0].right, t[1].right});
                    }
                }
            return t1;
        }
    }

}
