package com.虾皮面试;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/23
 * @Version 1.0
 **/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class 二叉树层序遍历使用队列 {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }


    public static void main(String[] args) {

        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.
                asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode root = createBinary(inputList);
        System.out.println("二叉树层序遍历：");
        printBinaryTreeWithQueue(root);
    }

    private static void printBinaryTreeWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//通过LinkedList创建队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            //甩掉本元素时，让自己的左右孩子入队列，追加到队尾
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    private static TreeNode createBinary(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinary(inputList);
            node.right = createBinary(inputList);
        }
        return node;
    }


}