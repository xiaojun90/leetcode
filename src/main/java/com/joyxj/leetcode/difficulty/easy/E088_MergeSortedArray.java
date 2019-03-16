package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (43.12%)
 * Total Accepted:    32.6K
 * Total Submissions: 75.5K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

 /**
  * 利用归并排序
  */
public class E088_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new E088_MergeSortedArray().new Solution().merge(nums1, 3, nums2, 3);

    }

    static void print(int[] nums1) {
        for (int nums:nums1) {
            System.out.print(nums + "\t");
        }
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m+n];
            int i = 0;
            int j = 0;
            int count = 0;
            while (i < m && j < n) {
                if (nums1[i] > nums2[j]) {
                    result[count++] = nums2[j];
                    j ++;
                } else {
                    result[count ++] = nums1[i];
                    i ++;
                }
            }
            while(i < m) {
                result[count ++] = nums1[i++];
            }
            while(j < n) {
                result[count ++] = nums2[j++];
            }
            nums1 = result;
            print(nums1);
        }
    }
}