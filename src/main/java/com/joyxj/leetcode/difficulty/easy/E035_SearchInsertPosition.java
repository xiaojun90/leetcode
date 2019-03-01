package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.76%)
 * Total Accepted:    30K
 * Total Submissions: 70.2K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */

public class E035_SearchInsertPosition {

    public static void main(String[] args) {
        
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            // 特殊情况处理
            if (null == nums || nums.length == 0) {
                return 0;
            }

            for (int i=0,len=nums.length;i<len;i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            // 剩余一种情况:target大于数组的任意元素
            return nums.length;
        }
    }
}