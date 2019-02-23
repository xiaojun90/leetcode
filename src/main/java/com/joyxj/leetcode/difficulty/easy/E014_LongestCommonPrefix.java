package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.56%)
 * Total Accepted:    50K
 * Total Submissions: 157.5K
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
        String[] strs = new String[]{"aa","a"};
        System.out.println(new E014_LongestCommonPrefix.Solution().longestCommonPrefix(strs)); 
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
            //定义初始比较的位置，每个循环后增加1
            int index = 0;
            while (index < base.length()) {
                //定义一个标志，用于记录当前字符是否是一个公共字符
                boolean flag = true;
                for (int j=0,len=strs.length; j<len; j++) {
                    //index的值等于基准字符的长度，表示已经比较完了基准字符，退出循环
                    if (base.length() <= index) {
                        flag = false;
                        break;
                    }
                    //如果比较字符的长度小于当前比较字符的位置时，退出循环
                    if (strs[j].length()-1 < index) {
                        flag = false;
                        break;
                    }
                    //如果基准字符的index位置的字符不等于比较字符index位置的字符，后退出循环
                    if (base.charAt(index) != strs[j].charAt(index)) {
                        flag = false;
                        break;
                    }
                    //当j=len-1时，表示已经比较完所有的字符串了，此时当前这个位置的字符应该是一个公共字符
                    if ( j== len -1) {
                        result = result + base.charAt(index);
                    }
                }
                if (flag) {
                    index = index + 1;
                } else {
                    break;
                }
            };
            return result;
        }

        /**
         * 官方解题中的解法一:水平扫描法：LCP(S1..Sn)=LCP(LCP(LCP(S1,S2),S3)..SN)
         * 依次遍历字符串[S1...SN]，当遍历到第i个字符串的时候，找到最长公共前缀LCP(S1...Si)，当LCP(S1...Si)是一个空串的时候算法结束。否则在执行n次遍历后，算法返回最终的答案(S1...SN)
         * 
         */
        public String longestCommonPrefix_01(String[] strs) {
            return null;
        }
    }
}