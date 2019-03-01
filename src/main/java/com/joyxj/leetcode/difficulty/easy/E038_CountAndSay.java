package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (48.06%)
 * Total Accepted:    21.3K
 * Total Submissions: 44.4K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
public class E038_CountAndSay {

    public static void main(String[] args) {
        new Solution().countAndSay(6);
    }

    static class Solution {
        public String countAndSay(int n) {
            if (1 == n) {
                return "1";
            }
            String str = countAndSay(n-1);
            
            // 用于记录结果
            StringBuffer sb = new StringBuffer();
            // 采用快慢指针的方式
            int i=0;
            int j = 1;
            while (j < str.length()) {
                if (str.charAt(i) == str.charAt(j)) {
                    // 如果相等的话，表示是相同的数字，则j加1
                    j ++;
                } else {
                    //如果不相同的话，则需要计算出前面相同的数字的个数
                    sb.append((j-i)).append(str.charAt(i));
                    i = j;
                    j++;
                }
            }
            if (i < str.length()) {
                // 如果i指针还在str的某个位置时还需要统一最后一次。
                sb.append((str.length()-i)).append(str.charAt(i));
            }
            return sb.toString();
        }
    }
}