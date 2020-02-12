package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 *
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (59.15%)
 * Likes:    131
 * Dislikes: 0
 * Total Accepted:    27.8K
 * Total Submissions: 46.8K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 
 * 示例：
 * 
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 说明:
 * 
 * 
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * 
 * 
 */

public class E303_RangeSumQueryImmutable {

    public static void main(String[] args) {
        new E303_RangeSumQueryImmutable()
            .new NumArray(null).sumRange(0, 1);
    }

    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }
        
        public int sumRange(int i, int j) {
            int sum = 0;
            for (int ii= i;ii<=j;ii++) {
                sum = sum + nums[ii];
            }
            return sum;
        }
    }


}