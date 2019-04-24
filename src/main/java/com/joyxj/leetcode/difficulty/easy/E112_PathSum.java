package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (45.86%)
 * Total Accepted:    15.7K
 * Total Submissions: 34.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class E112_PathSum {

    public static void main(String[] args) {
        
    }

    class Solution {

        /**
         * 解法一：查询出所有的叶子结点，并用集合记录所有叶子结点的和
         * @param root
         * @param sum
         * @return
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            List<Integer> list = new ArrayList<Integer>();
            getSum(root,0,list);
            for (Integer ii : list) {
                if (ii == sum) {
                    return true;
                }
            }
            return false;
        }

        private void getSum(TreeNode node,int sum,List<Integer> list) {
            if (node == null) {
                return;
            }
            // 表示是叶子结点
            if (node.left == null && node.right == null) {
                list.add(node.val + sum);
            }
            getSum(node.left, sum + node.val, list);
            getSum(node.right, sum + node.val, list);
        }

        /**
         * 解法二
         * @param root
         * @param sum
         * @return
         */
        public boolean hasPathSum1(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                // 叶子节点
                return sum - root.val == 0;
            }
            return hasPathSum1(root.left, sum- root.val) || hasPathSum1(root.right, sum - root.val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}