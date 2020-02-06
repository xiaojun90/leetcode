package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 *
 * https://leetcode-cn.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (65.30%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    29.9K
 * Total Submissions: 45.6K
 * Testcase Example:  '38'
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 
 * 示例:
 * 
 * 输入: 38
 * 输出: 2 
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 
 * 
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * 
 */

// @lc code=start
public class E258_AddDigits {
    class Solution {
        /**
         * 常规解法
         * 通过递归，求余
         * @param num
         * @return
         */
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }
            int temp = num;
            int count = 0;
            while (temp >= 10) {
                count = count + temp%10;
                temp = temp/10;
            }
            count = count + temp%10;
            return addDigits(count);
            
        }

        /**
         * 牛逼解法
         * @param num
         * @return
         */
        public int addDigits_2(int num) {
            return (num - 1) % 9 + 1;
        }
    }
}

// @lc code=end

