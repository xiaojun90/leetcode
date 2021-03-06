package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (41.18%)
 * Likes:    435
 * Dislikes: 0
 * Total Accepted:    41K
 * Total Submissions: 98.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */

/**
 * 这是一个经典的动态规划问题。
 * 
 * 先从最简单的情况开始：
 * 1. n=1的情况下，显然f(1)=A1。
 * 2. n=2的情况下，f(2) = max(A1,A2)。
 * 3. n=3的情况下，考虑二种情况：
 *  - 抢第三个房子, f(3) = f(1) + A3。
 *  - 不抢第三个房子，f(3) = f(2)。
 * 很显然，我们会选择金额更大的情况。于是有：f(3) = max(f2,f1+A3)。
 * ...
 * 总结出公式：f(n) = max(f[n-1],f[n-2] + An);
 * 
 */

public class HouseRobber {

    public static void main(String[] args) {
        
    }

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int curMax = 0;
            int preMax = 0;
            for (int i : nums) {
                int temp = curMax;
                curMax = Math.max(curMax, preMax + i);
                preMax = temp;
            }
            return curMax;        
        }
    }

}


