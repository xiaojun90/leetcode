package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (51.76%)
 * Total Accepted:    16.6K
 * Total Submissions: 32.1K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
 * 
 * 
 */


public class E100_SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(new E100_SameTree().new Solution().isSameTree(p, q));  
    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if ((p == null && q != null) || (p != null && q == null)) {
                // 一个节点为空，另一个节点不为空的情况，肯定返回false
                return false;
            }
            if ( p == null || q == null) {
                // 二个节点均为空情况
                return true;
            }
            // 二个节点都存在
            //当前值比较
            boolean c = p.val == q.val;
            boolean l = isSameTree(p.left, q.left);
            boolean r = isSameTree(p.right, q.right);
            
            return c && l && r;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}