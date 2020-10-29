package com.LeetCode_jianzhioffer.Convert26;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/19 11:03
 * # @version 1.0
 * # @File : Solution2.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?f=discussion
 * 来源：牛客网
 * <p>
 * 方法二：递归版
 * 解题思路：
 * 1.将左子树构造成双链表，并返回链表头节点。
 * 2.定位至左子树双链表最后一个节点。
 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
 * 4.将右子树构造成双链表，并返回链表头节点。
 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
 * 6.根据左子树链表是否为空确定返回的节点。
 */
public class Solution2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public TreeNode Convert(TreeNode root) {
            if (root == null) return null;
            if (root.left == null && root.right == null) {//表示到了叶子节点
                return root;
            }

            // 1.将左子树构造成双链表，并返回链表头节点
            TreeNode left = Convert(root.left);//表示中序遍历先遍历左子树，返回的是左子树第一个节点，这也是整个链表的头节点

            // 2.定位至左子树双链表最后一个节点
            TreeNode p = left;
            while (p != null && p.right != null) {
                    p = p.right;
            }
            // 3.如果左子树链表不为空的话，将当前root追加到左子树链表，表示中序遍历遍历当前节点
            if (left != null) {
                p.right = root;
                root.left = p;
            }

            // 4.将右子树构造成双链表，并返回链表头节点
            TreeNode right = Convert(root.right);

            // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
            if (right != null) {
                right.left = root;
                root.right = right;
            }
            return left != null ? left : root;

        }


    }
}
