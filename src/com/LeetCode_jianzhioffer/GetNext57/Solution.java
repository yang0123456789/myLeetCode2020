package com.LeetCode_jianzhioffer.GetNext57;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 22:47
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * <p>
 * 题目给出了next，pNode.next指向给定节点的父节点，这样while循环遍历到pNode.next == null，
 * 此时的pNode指向的就是根节点。所以本题只需要给出当前节点即可，根节点可以使用next求出来。
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e?f=discussion
 * 来源：牛客网
 * <p>
 * 分析二叉树的下一个节点，一共有以下情况：
 * 1.二叉树为空，则返回空；
 * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，
 * 一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
 * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；
 * 否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
 *
 * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e?f=discussion
 * 来源：牛客网
 *
 * 1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
 *
 * （2） 若该节点不存在右子树：这时分两种情况：
 *
 * 2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）
 *
 * 2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，
 * 知道找到一个节点的父节点的左子节点为该节点，
 * 则该节点的父节点下一个节点
 * （如图节点 I ，沿着父节点一直向上查找找到 B
 * （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。
 */
public class Solution {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null) return null;
        //如果有右子树，则找右子树的最左节点


        if(pNode.right!=null){    //如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while(pNode.left!=null) pNode = pNode.left;
            return pNode;
        }



        while(pNode.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }


}
