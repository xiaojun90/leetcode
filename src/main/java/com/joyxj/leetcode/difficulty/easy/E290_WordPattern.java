package com.joyxj.leetcode.difficulty.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (41.53%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    17K
 * Total Submissions: 40.7K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

public class E290_WordPattern {

    public static void main(String[] args) {
        System.out.println(new E290_WordPattern()
        .new Solution().
        wordPattern("abba", "dog cat cat dog"));

    }

    class Solution {
        public boolean wordPattern(String pattern, String str) {
            // 把 str 分隔成一个数组
            String[] strs = str.split(" ");
            // 长度不一致的情况，肯定不匹配
            if (pattern.length() != strs.length) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            Map<String,Character> map = new HashMap<>(strs.length);
            for (int i=0,len=strs.length;i<len;i++) {
                Character c;
                String word = strs[i];
                if (map.containsKey(word)) {
                    // 表示map中包含元素,
                    // 表示之前出现过这个单词，其对应的字符应该之前该单词出现对应的字符一致
                    c = map.get(word);
                    if (c != pattern.charAt(i)) {
                        return false;
                    }
                } else {
                    // 表示该单词是第一次出现，那么其对应的字符也应该是第一次出现
                    c = pattern.charAt(i);
                    if (pattern.indexOf(c)!=i) {
                        return false;
                    }
                    map.put(word, c);
                }
                sb.append(c);
            }
            return pattern.equals(sb.toString());
        }
    }

}