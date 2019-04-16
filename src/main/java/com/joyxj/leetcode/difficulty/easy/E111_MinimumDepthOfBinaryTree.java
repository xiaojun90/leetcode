package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (37.98%)
 * Total Accepted:    15.2K
 * Total Submissions: 40K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
 */

public class E111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        
    }

    class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMinDepth = minDepth(root.left);
            int rightMinDepth = minDepth(root.right);
            // 判断节点的左、右节点是否是空，如果为空，则取深度时取另外一个非空的值。
            if (leftMinDepth == 0) {
                return rightMinDepth + 1;
            }
            if (rightMinDepth == 0) {
                return leftMinDepth + 1;
            }
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}