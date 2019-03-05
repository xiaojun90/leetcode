package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.79%)
 * Total Accepted:    18K
 * Total Submissions: 62.7K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */

public class E058_LengthOfLastWord {

    public static void main(String[] args) {
        
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            //先去掉前后空格，取巧的作法
            s = s.trim();
            //定义索引位置
            int index = -1;
            for (int i =0,len = s.length();i<len;i++) {
                if (s.charAt(i) == ' ') {
                    index = i;
                } 
            }
            return (s.length()-1) - index;
        }
    }
}