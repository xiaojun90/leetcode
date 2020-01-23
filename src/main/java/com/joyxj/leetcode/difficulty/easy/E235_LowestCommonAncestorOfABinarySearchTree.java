package com.joyxj.leetcode.difficulty.easy;

public class E235_LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        



    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 特殊情况,自己的祖先
            if (p == root || q == root) {
                return root;
            }
            // p、q的值分布在二边，其祖先就是root
            if ((p.val < root.val && q.val > root.val) || 
                (p.val > root.val && q.val < root.val)) {
                    return root;
            }
            // p、q 节点均在左子树
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // p、q 节点均在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}