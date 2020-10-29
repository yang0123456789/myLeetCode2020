package com.LeetCode_jianzhioffer.HasSubtree17;

/**
 * # @author  chilcyWind
 * # @Time   2020/5/26 10:05
 * # @version 1.0
 * # @File : Solution.java
 * # @Software: IntelliJ IDEA
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 *
 *
 * 1.判断root2，空的话返回 false
 * 2.使用递归，首先找到root1是不是root2，不是的话，是的话返回true。不是的话判断左边节点是不是root2，方法是首先判断左节点是不是空，不是的话
 * 递归调用这个方法，root1改成左节点
 * 然后判断右节点是不是root2，方法是断右节点是不是空递归调用这个方法，root2右边改成左节点
 * 3.如果递归完成没有发现节点，则说明root1下面没有root2节点，返回false
 * 4.如果发现了跟b树相同的节点，则调用判断结构是不是相同的recur进行判断，recur返回true的话说明包含，返回true，recur返回false的话，
 * root1继续寻找root2的节点，继续判断
 *
 *
 *isSubStructure(A, B) 函数：
 *
 * 特例处理： 当 树 AA 为空 或 树 BB 为空 时，直接返回 falsefalse ；
 * 返回值： 若树 BB 是树 AA 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
 * 1.以 节点 AA 为根节点的子树 包含树 BB ，对应 recur(A, B)；
 * 2.树 BB 是 树 AA 左子树 的子结构，对应 isSubStructure(A.left, B)；
 * 3.树 BB 是 树 AA 右子树 的子结构，对应 isSubStructure(A.right, B)；
 * 以上 2. 3. 实质上是在对树 AA 做 先序遍历 。
 *
 *
 *
 * recur判断结构是不是相同：
 * recur(A, B) 函数：
 *
 * 终止条件：
 * 当节点 BB 为空：说明树 BB 已匹配完成（越过叶子节点），因此返回 truetrue ；
 * 当节点 AA 为空：说明已经越过树 AA 叶子节点，即匹配失败，返回 falsefalse ；
 * 当节点 AA 和 BB 的值不同：说明匹配失败，返回 falsefalse ；
 *
 * 返回值：
 * 判断 AA 和 BB 的左子节点是否相等，即 recur(A.left, B.left) ；
 * 判断 AA 和 BB 的右子节点是否相等，即 recur(A.right, B.right) ；
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * <p>
 * 注意点：
 * 1.比较树节点比较的是树节点的val，而不是这个节点，如果用root1==root2的话，比较的是两个的引用地址，肯定是false
 * 2.递归判定的时候，不需要加root1=null的情况，因为只要根节点不为空，递归就能走完全程。就算是root是null的话，它也因为递归
 * 访问用完所有的节点，这期间如果没有为true的值，说明没有合适的节点，最后返回一个false就好
 * 3.如果创建对象为赋值null的话， 除非对该对象进行实体的初始化，不然最好不要直接引用，因为赋值为null是个空引用，没有指向
 * 任何内存空间
 * <p>
 * 二叉树的中序非递归遍历：
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return (root1 != null && root2 != null) && (recur(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
    }

    boolean recur(TreeNode a,TreeNode b){
        if (b==null) return true;
        if (a==null||a.val !=b.val) return  false;
        return recur(a.left,b.left)&&recur(a.right,b.right);
    }
}