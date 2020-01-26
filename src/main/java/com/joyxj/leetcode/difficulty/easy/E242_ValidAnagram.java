package com.joyxj.leetcode.difficulty.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.83%)
 * Likes:    149
 * Dislikes: 0
 * Total Accepted:    68.6K
 * Total Submissions: 118.4K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */


 /**
  * 备注：异位词是指两个单词包含相同的字母，但是次序不同
  */
public class E242_ValidAnagram {

    public static void main(String[] args) {
        String s = new E242_ValidAnagram().new Solution().sorted("nagaram");
        System.out.println(s);
    }

    class Solution {
        /**
         * 使用排序的方式
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            // 长度不相等，直接返回 false
            if (s.length() != t.length()) {
                return false;
            }
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(tt);
            return Arrays.equals(ss, tt);
        }

        /**
         * 使用 哈希表的方式 
         * 用哈希表记录每个字母出现的次数，比较二个字符串中各个字母出现的次数是否一致，如果不一致，则不是异构词
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram_2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character,Integer> counter = new HashMap<>();
            for (int i=0 ,len = s.length() ;i <len;i++) {
                // s 字符串的字母让累加器加一
                if (counter.get(s.charAt(i)) == null) {
                     counter.put(s.charAt(i), 1);
                } else {
                    counter.put(s.charAt(i), counter.get(s.charAt(i)) + 1);
                } 
                // t 字符串的字母让累加器减一
                if (counter.get(t.charAt(i)) == null) {
                    counter.put(t.charAt(i),-1);
                } else {
                    counter.put(t.charAt(i), counter.get(t.charAt(i)) - 1);
                }
            }
            // 最后判断累加器各个字母的数量是否是0
            for (Integer i : counter.values()) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }


    }

}