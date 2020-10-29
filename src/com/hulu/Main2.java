package com.hulu;

import com.Leetcode_top100.二叉树相关.TreeNode;

import java.util.Scanner;

public class Main2 {
   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        treeNode treeNode=CreatTree();
        inOrder(treeNode);

    }

    static treeNode CreatTree()/*按照前序遍历的顺序输入，如果没有节点就用#,有节点就用字母*/ {
     int ch=sc.nextInt();
        if (ch == -1) return null;/*如果是*，说明节点为空*/
        else {
            treeNode tree = new treeNode();
            tree.val = ch;
            tree.lchild = CreatTree();
            tree.rchild = CreatTree();
            return tree;
        }
    }
    public static void inOrder(treeNode root){
        if (root==null){
            return;
        }else {
            inOrder(root.lchild);
            System.out.println(root.val);
            inOrder(root.rchild);
        }

    }
    public treeNode lowestCommonAncestor(treeNode root, int p, int q) {
        if(root == null || root.val == p || root.val == q) return root;
        treeNode left = lowestCommonAncestor(root.lchild, p, q);
        treeNode right = lowestCommonAncestor(root, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


}




class treeNode {
    int val;

    treeNode() {
    }



    treeNode(int val) {
        this.val = val;
    }

    treeNode lchild;
    treeNode rchild;
}