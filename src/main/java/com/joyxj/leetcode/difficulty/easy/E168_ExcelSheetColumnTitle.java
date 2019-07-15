package com.joyxj.leetcode.difficulty.easy;

public class E168_ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(new E168_ExcelSheetColumnTitle().new Solution().convertToTitle(26));
    }

    class Solution {
        public String convertToTitle(int n) {
            // 余数
            int m; 
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                m = (n-1) % 26;
                n = (n-1) / 26;
                char c = (char)('A' + m);
                sb.append(c);

            }
            return sb.reverse().toString();
        }
    }
}