package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (45.56%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    17.6K
 * Total Submissions: 38.3K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 
 * 示例 1:
 * 
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * 
 */

public class E205_IsomorphicStrings {
    public static void main(String[] args) {
        
    }


    class Solution {
        public boolean isIsomorphic(String s, String t) {
            // 存储映射关系
            Map<Character,Character> map = new HashMap<>();
            if (null == s || "".equals(s)) {
                return true;
            }
            List<Character> list = new ArrayList<>();
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            for (int i=0,len=sc.length;i<len;i++) {
                if (null == map.get(sc[i])) {
                    // map对象中不存在，表示该字符是第一次出现
                    // 判断当前被映射的值是否已经被映射过
                    if (list.contains(tc[i])) {
                        return false;
                    }
                    map.put(sc[i], tc[i]);
                    list.add(tc[i]);
                } else {
                    // 存在
                    // 判断字符是否是map中对应的值
                    if (tc[i] != map.get(sc[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}