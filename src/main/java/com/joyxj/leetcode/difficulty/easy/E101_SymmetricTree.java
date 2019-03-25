package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (45.47%)
 * Total Accepted:    25.1K
 * Total Submissions: 55.1K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */

 /**
  * 解题关键在于：对于对称二叉树，其左节点的左子树等于其右节点的右子树，右子树等于其右节点的左子树
  */

public class E101_SymmetricTree {

    public static void main(String[] args) {
        
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return match(root, root);
        }

        public boolean match(TreeNode lNode,TreeNode rNode) {
            if (lNode == null && rNode == null) {
                return true;
            }
            if (lNode == null || rNode == null) {
                return false;
            }

            return (lNode.val == rNode.val) && match(lNode.left, rNode.right)
             && match(lNode.right, rNode.left);
        }
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}