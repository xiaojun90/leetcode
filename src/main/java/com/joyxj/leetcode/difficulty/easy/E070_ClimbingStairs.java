package com.joyxj.leetcode.difficulty.easy;


/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.62%)
 * Total Accepted:    34.6K
 * Total Submissions: 77.5K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 * 1+1+1+1
 * 1+2+1
 * 1+1+2
 * 2+1+1
 * 2+2
 * 
 */

 
public class E070_ClimbingStairs {
    public static void main(String[] args) {
        int a = new E070_ClimbingStairs().new Solution().climbStairs(43);
        System.out.println(a);
    }

    class Solution {
        public int climbStairs(int n) {
            if (n == 1 || n == 2) {
                return n;
            }
            // 斐波那契数列
            int i = 1;
            int j = 2;
            int count = 0;
            int k =3;
            while(k<=n) {
                count = i + j;
                i = j;
                j = count;
                k ++;
            }
            return count;
             // 利用递归会超时，所以不使用
            //return climbStairs(n-2) + climbStairs(n-1);
            
        }
    }
}