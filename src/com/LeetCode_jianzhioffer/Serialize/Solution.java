package com.LeetCode_jianzhioffer.Serialize;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/13 8:16
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 */




/**



*序列化二叉树
 *递归遍历二叉树的节点，空节点使用#代替，节点之间使用逗号隔开，返回字符串

 *反序列化二叉树
 *设置序号index，将字符串根据逗号分割为数组，根据index的值来设置树节点的val，如果节点的值为#，则返回空的树节点。
*/

public class Solution {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }


        /**
         * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
         *
         * @param root
         * @return
         */

    }

    public  String Serialize(TreeNode root) {


        if (root == null) {
            return "#";
        } else {
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right) ;
        }


    }


    /**
     * 使用index来设置树节点的val值，递归遍历左节点和右节点，如果值是#则表示是空节点，直接返回
     *
     * @param str
     * @return
     */
    int index = -1;

  public   TreeNode Deserialize(String str) {

        //将序列化之后的序列用，分隔符转化为数组
        String[] s = str.split(",");
        int len = s.length;
        index++;//索引每次加一
        if (index>=len){
            return null;
        }
        TreeNode treeNode=null;
        if(!s[index].equals("#")){
            treeNode=new TreeNode(Integer.parseInt(s[index]));
            treeNode.left=Deserialize(str);
            treeNode.right= Deserialize(str);


        }
        return treeNode;



    }



    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        Solution solution=new Solution();



        String str = solution.Serialize(treeNode1);
        System.out.println(str);
        TreeNode treeNode = solution.Deserialize(str);

    }
}