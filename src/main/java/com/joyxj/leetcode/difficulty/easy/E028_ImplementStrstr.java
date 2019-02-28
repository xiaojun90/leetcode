package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.64%)
 * Total Accepted:    36.9K
 * Total Submissions: 98.2K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 * 
 * 备注：这题可以直接使用indexOf方法实现，这里提供使用BF算法实现的算法
 * 
 * BF是Brute Force的缩写，中文也叫暴力匹配算法
 */
public class E028_ImplementStrstr {
    public static void main(String[] args) {
        
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            // 可以直接使用haystack.indexOf(needle)就可以实现功能
            // 这里使用BF算法实现
            // 特殊情况处理
            if (null == haystack) {
                return -1;
            }
            if (null == needle || needle.length() == 0) {
                return 0;
            }
            if (haystack.length() < needle.length()) {
                return -1;
            }
            for (int i=0,len= haystack.length() - needle.length(); i<=len; i ++) {
                if (needle.equals(haystack.substring(i, i+needle.length()))) {
                    return i;
                }
            }
            //未匹配的情况
            return -1;
        }
    }
}