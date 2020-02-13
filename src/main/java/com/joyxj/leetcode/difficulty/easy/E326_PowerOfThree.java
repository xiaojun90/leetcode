package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 *
 * https://leetcode-cn.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (46.10%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    35.5K
 * Total Submissions: 76.4K
 * Testcase Example:  '27'
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 27
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: 9
 * 输出: true
 * 
 * 示例 4:
 * 
 * 输入: 45
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

public class E326_PowerOfThree {

    public static void main(String[] args) {
        

    }

    class Solution {
        /**
         * 采用递归的方式
         * @param n
         * @return
         */
        public boolean isPowerOfThree(int n) {
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            if (n!=1 && n % 3 != 0) {
                return false;
            }
            return isPowerOfThree(n /3);
        }
    }


}