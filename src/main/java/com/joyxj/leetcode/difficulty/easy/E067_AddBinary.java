package com.joyxj.leetcode.difficulty.easy;

public class E067_AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        new E067_AddBinary().new Solution().addBinary(a, b);
        System.out.println(new E067_AddBinary().new Solution().addBinary(a, b));
    }

    class Solution {
        public String addBinary(String a, String b) {
            int max = Math.max(a.length(), b.length());
            // 补齐空缺的位
            if (a.length() > b.length()) {
                StringBuffer s1 = new StringBuffer();
                for (int i=0;i<a.length() - b.length();i++) {
                    s1.append("0");
                }
                b = s1.toString() + b;
            }
            if (a.length() < b.length()) {
                StringBuffer s1 = new StringBuffer();
                for (int i=0;i<b.length() - a.length();i++) {
                    s1.append("0");
                }
                a = s1.toString() + a;
            } 
            // 存储进位
            int digit = 0;
            // 存储返回结果
            StringBuffer result = new StringBuffer();
            // 存储a字符串中的某个字符的数字
            int aInt = 0;
            // 存储b字符串中的某个字符的数字
            int bInt = 0;
            for (int i=max-1;i>=0;i--) {
                aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
                bInt = Integer.parseInt(String.valueOf(b.charAt(i)));
                result.append(String.valueOf((aInt + bInt + digit)%2));
                digit = (aInt + bInt + digit)/2;
            }
            // 如果最后的进位为1的话，也要加到结果集中
            if (digit == 1) {
                result.append(String.valueOf(digit));
            }
            return result.reverse().toString();
        }
    }
}