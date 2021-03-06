package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (34.65%)
 * Total Accepted:    24.9K
 * Total Submissions: 71.7K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

public class E069_Sqrtx {

    class Solution {
        public int mySqrt(int x) {
            if (x == 1) {
                return 1;
            }
            // 转成long类型是为了防止溢出
            long left = 0;
            long right = x;
            long mid = (left + right)/2;
            // 采用二分法实现
            while (true) {
                if (mid * mid == x) {
                    return (int)mid;
                }
                if (mid*mid < x && (mid+1)*(mid+1) >x) {
                    return (int)mid;
                }
                if (mid * mid > x) {
                    right = mid;
                    mid = (left + right) /2;
                } else {
                    left = mid;
                    mid = (left + right) /2;
                }
            }
        }
    }
}