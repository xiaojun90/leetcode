package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 *
 * https://leetcode-cn.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (54.38%)
 * Likes:    153
 * Dislikes: 0
 * Total Accepted:    26.8K
 * Total Submissions: 48.7K
 * Testcase Example:  '19'
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到
 * 1。如果可以变为 1，那么这个数就是快乐数。
 * 
 * 示例: 
 * 
 * 输入: 19
 * 输出: true
 * 解释: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * 解法1：关键点在于需要存储之前已经计算过的数字，如果一个数字被重复计算，
 * 则说明已经进入循环。
 * 解法2：用快慢指针的方式，同时也不使用递归，而使用循环
 * 
 */
public class HappyNumber {

    public static void main(String[] args) {
        new HappyNumber().new Solution().isHappy(45);
        
    }
    class Solution {
        private List<Integer> list = new ArrayList<>();
        public boolean isHappy(int n) {
            list.add(n);
            int sum = 0;
            do {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            } while(n!=0);
            if (sum == 1) {
                return true;
            } else if (list.contains(sum)) {
                return false;
            }else {
                return isHappy(sum);
            }
        }

        public boolean isHappy_2(int n) {
            int fast = 0;
            fast = getHapply(n);
            fast = getHapply(fast);
            return true;
        }

        public int getHapply(int n) {
            int sum = 0;
            do {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            } while(n!=0);
            return sum;
        }
    }
}