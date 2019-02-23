package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.71%)
 * Total Accepted:    49.7K
 * Total Submissions: 156.8K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

public class E014_LongestCommonPrefix { 

    public static void main(String[] args) {
        System.out.println(new E014_LongestCommonPrefix.Solution().longestCommonPrefix(args)); 
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            //先做一个判断处理
            if (strs.length == 0) {
                return "";
            }
            //以第一个字符串作为基准，每次从第一个字符串中取出一个字符，然后跟其它的字符串做比较
            if (strs.length == 1) {
                return strs[0];
            }
            String base = strs[0];
            //返回结果字符串，初始值为""
            String result = "";
            for (int j=0,len=strs.length; j<len; j++) {

            }
            return null;
        }
    }
}