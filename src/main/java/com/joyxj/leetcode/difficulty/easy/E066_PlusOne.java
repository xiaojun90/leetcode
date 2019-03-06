package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.54%)
 * Total Accepted:    38.3K
 * Total Submissions: 102.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

 public class E066_PlusOne {

    public static void main(String[] args) {
        new E066_PlusOne().new Solution();

    }

    class Solution {
        public int[] plusOne(int[] digits) {
            // 进位信息
            int carry = 0;
            for (int len= digits.length,i=len-1;i>=0;i--) {
                if (i == len - 1) {
                    //表示最后一位
                    if (digits[i] + 1 == 10) {
                        digits[i] = 0;
                        carry = 1;
                    } else {
                        digits[i] = digits[i] + 1;
                        carry = 0;
                    }
                } else {
                    if (digits[i]  + carry == 10) {
                        digits[i] = 0;
                        carry = 1;
                    } else {
                        digits[i] = digits[i] + carry;
                        carry = 0;
                    }
                }
            }
            //处理完以后，还有进位
            if (carry == 1) {
                //表示第一位需要进位，此时要生成一个新的数组
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for (int j=1,length = newDigits.length;j< length;j++) {
                    newDigits[j] = digits[j-1];
                }
                return newDigits;
            } else {
                return digits;
            }
        }
    }
 }