package com.joyxj.leetcode.difficulty.easy;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.59%)
 * Total Accepted:    17.2K
 * Total Submissions: 37K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
public class E067_AddBinary_1 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        new E067_AddBinary().new Solution().addBinary(a, b);
        System.out.println(new E067_AddBinary().new Solution().addBinary(a, b));
    }

    class Solution {
        public String addBinary(String a, String b) {
            StringBuffer result = new StringBuffer();
            // 定义二个栈存储数据
            Stack<Integer> aStack = new Stack<>();
            Stack<Integer> bStack = new Stack<>();
            for (int i=0,len=a.length();i<len;i++) {
                aStack.push(Integer.valueOf(String.valueOf(a.charAt(i))));
            }
            for (int i=0,len=b.length();i<len;i++) {
                bStack.push(Integer.valueOf(String.valueOf(b.charAt(i))));
            }
            int aInt = 0;
            int bInt = 0;
            int digit = 0;
            while(!aStack.empty() || !bStack.empty()) {
                //
                if (!aStack.empty()) {
                    aInt = aStack.pop();
                } else {
                    aInt = 0;
                }
                if (!bStack.empty()) {
                    bInt = bStack.pop();
                } else {
                    bInt = 0;
                }
                result.append((aInt + bInt + digit)%2);
                digit = (aInt + bInt + digit) / 2;
            }
            // 如果最后的进位为1的话，也要加到结果集中
            if (digit == 1) {
                result.append(String.valueOf(digit));
            }
            return result.reverse().toString();
        }
    }
}