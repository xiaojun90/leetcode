package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (59.34%)
 * Total Accepted:    11.8K
 * Total Submissions: 19.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

 /**
  * 利用递归的方式解决。
  * 从第一层开始往下遍历，下一层的集合等于其左、右子树的集合。
  */
public class E107_BinaryTreeLevelOrderTraversalIi {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new E107_BinaryTreeLevelOrderTraversalIi().new Solution().levelOrderBottom(root);
    }


    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            levelOrderBottom(root,0,result);
            Collections.reverse(result);
            return result;
          }
    
          /**
           * 
           * @param node 节点
           * @param level 层次
           * @param result 结果
           */
          public void levelOrderBottom(TreeNode node,int level,List<List<Integer>> result) {
              if (node == null) {
                  return ;
              }
              // 特殊情况
              if (level >= result.size() ) {
                result.add(new ArrayList<>());
              }
              System.out.println(level + ":" + result.size());
              result.get(level).add(node.val);
              levelOrderBottom(node.left,level+1,result);
              levelOrderBottom(node.right,level+1,result);
          }     
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}