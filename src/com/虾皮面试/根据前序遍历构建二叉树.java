package com.虾皮面试;

import java.util.Arrays;
import java.util.List;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/23
 * @Version 1.0
 **/
public class 根据前序遍历构建二叉树 {
    //结点类
    public static class Node {
        char val;//值
        Node left;//左子树
        Node right;//右子树

        Node(char val) {
            this.val = val;
        }
    }

}

class CreateTreeResult {
    public TreeMethod.Node root;
    public int used;

    public CreateTreeResult(TreeMethod.Node root, int used) {
        this.root = root;
        this.used = used;
    }
}


class TreeMethod {
    private static int count = 0;

    public static class Node {
        char val;//值
        Node left;//左子树
        Node right;//右子树

        Node(char val) {
            this.val = val;
        }
    }

    //创建树
    static CreateTreeResult createTree(char[] preOrder) {
        //1.判断是否是终止条件
        if (preOrder.length == 0) {//终止条件  E或E##
            return new CreateTreeResult(null, 0);
        }
        //2.获取根结点的值
        char rootValue = preOrder[0];
        //3.判断是否为空结点
        if (rootValue == '#') {
            return new CreateTreeResult(null, 1);
        }
        //创建根结点
        Node root = new Node(rootValue);

        //4.创建左子树 利用递归
        char[] leftPreorder = new char[preOrder.length - 1];
        leftPreorder = Arrays.copyOfRange(preOrder, 1, preOrder.length);
        CreateTreeResult left = createTree(leftPreorder);
//        left.used;//左子树创建过程中使用的个数
//        右子树使用的个数为preOrder.length-1-left.used
        //5.创建右子树  利用递归
        char[] rightPreorder = new char[preOrder.length - 1 - left.used];
        rightPreorder = Arrays.copyOfRange(preOrder, 1 + left.used, preOrder.length);
        CreateTreeResult right = createTree(rightPreorder);
        //6.将根、左子树和右子树关联起来
        root.left = left.root;
        root.right = right.root;
        //7.返回树和使用的结点树
        return new CreateTreeResult(root, 1 + left.used + right.used);
    }

    public static void main(String[] args) {
        char[] array = new char[]{'A', 'B', 'C', '#', 'D', '#', '#', '#', 'E'};
        CreateTreeResult result = createTree(array);
        System.out.println(result.used);
        System.out.println(result.root.left.left.right.val);
        System.out.println(result.root.right.val);
    }

}