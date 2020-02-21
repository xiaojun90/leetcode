package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (48.69%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    24.8K
 * Total Submissions: 50.4K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class E345_ReverseVowels {

    public static void main(String[] args) {

        String str = "leetcode";
        System.out.println(new E345_ReverseVowels().new Solution().reverseVowels(str));
    }

    class Solution {
        private final static Set<Character> set = new HashSet<Character>(){
            {
                set.add('a');
                set.add('e');
                set.add('i');
                set.add('o');
                set.add('u');
                set.add('A');
                set.add('E');
                set.add('I');
                set.add('O');
                set.add('U');
            }
        };
        public String reverseVowels(String s) {
            char[] array = s.toCharArray();
            int len = s.length();
            int start = 0;
            int end = len -1;
            while(start < end) {
                int sIndex = getFirstVowel(array, start, end);
                if (sIndex == -1) {
                    break;
                }
                start = sIndex;
                int eIndex = getLastVowel(array, start, end);
                if (eIndex ==  -1) {
                    break;
                } 
                end = eIndex;
                char temp = array[end];
                array[end] = array[start];
                array[start] = temp; 
                start ++;
                end --;
            }
            return String.valueOf(array);
            
        }
    
        /**
         * 获得最后一个元音字母
         * 
         * @param s
         * @param end
         * @return
         */
        private int getLastVowel(char[] array ,int start ,int end) {
            while (start < end) {
                System.out.println("getLast:" + start + "," + end);
                if (set.contains(array[end])) {
                    return end;
                }
                end --;
            }
            return -1;
        }
    
        private int getFirstVowel(char[] array,int start, int end) {
            while (start < end) {
                System.out.println("getLast:" + start + "," + end);
                if (set.contains(array[start])) {
                    return start;
                }
                start ++ ;
            }
            return -1;
        }
    }
}