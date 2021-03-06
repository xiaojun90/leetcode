package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (67.60%)
 * Total Accepted:    36K
 * Total Submissions: 53K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */


public class E104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        
    }
    class Solution {
        public int maxDepth(TreeNode root) {
            // 特殊情况处理
            if (root == null) {
                return 0;
            }
            // 树的深度等于其左右子树的最大深度+1
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}