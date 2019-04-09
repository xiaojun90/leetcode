package com.joyxj.leetcode.difficulty.easy;


/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (61.56%)
 * Total Accepted:    15.5K
 * Total Submissions: 25K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */


public class E108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        new E108_ConvertSortedArrayToBinarySearchTree().new Solution().sortedArrayToBST(nums);
    }

    /**
     * 解题思路：由于数组是一个排序数组，所以数组的中间元素为根节点，左侧的为左子树，右侧的为右子树
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null) {
                return null;
            }
            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums,int l,int r) {
            if (l > r) {
                return null;
            }
            int center = (l + r) /2;
            System.out.println(l + ":" + r + ":" + center);
            TreeNode node = new TreeNode(nums[center]);
            node.left = buildTree(nums, l, center-1);
            node.right = buildTree(nums, center+1, r);
            return node;
        }
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}