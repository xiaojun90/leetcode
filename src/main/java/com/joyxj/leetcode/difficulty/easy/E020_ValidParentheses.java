package com.joyxj.leetcode.difficulty.easy;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.17%)
 * Total Accepted:    46.3K
 * Total Submissions: 127.4K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
public class E020_ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(new Solution().isValid(s));       
    }


    static class Solution {
        public boolean isValid(String s) {
            // 特殊情况处理：空字符串认为有效字符
            if (null == s || s.length() == 0) {
                return true;
            }
            String left = "({[";
            String right = ")}]";
            // 利用栈的后进先出进行处理
            Stack<Character> stack = new Stack<>();
            // 遍历字符中的每个字符，如果是左括号则入栈，
            //如果是右括号则和栈点元素匹配，如果匹配的上的话，栈点元素出栈，如果无法匹配的话，则退出循环。
            for (char c:s.toCharArray()) {
                if (left.indexOf(c) >=0) {
                    //左括号入栈，继续下一个循环
                    stack.push(c);
                    continue;
                }
                //表示是右括号
                if (stack.empty()) {
                    // 栈中没有元素，而当前字符是右括号，肯定无法匹配
                    return false;
                }
                char top = stack.peek();
                if (right.indexOf(c) == left.indexOf(top)) {
                    //如果栈点元素与当前元素匹配的,移除栈点元素
                    stack.pop();
                    continue;
                }
                // 下面表示的是不匹配的，后面元素都不需要循环了，可以直接返回
                return false;
            }
            // 遍历完以后，如果栈中没有元素了，则完全匹配，否则就是不匹配
            if (stack.empty()) {
                return true;
            }
            return false;
        }
    }
}