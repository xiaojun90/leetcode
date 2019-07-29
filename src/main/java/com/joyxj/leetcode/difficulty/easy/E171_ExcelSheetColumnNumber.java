package com.joyxj.leetcode.difficulty.easy;

public class E171_ExcelSheetColumnNumber {

    class Solution {
        public int titleToNumber(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            int result = 0;
            for (char c : s.toCharArray()) {
                result = result * 26 + (c - 'A' + 1);
            }
            return result;
        }
    }
}