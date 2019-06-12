package com.joyxj.leetcode.difficulty.easy;
public class E125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new E125_ValidPalindrome().new Solution().isPalindrome_1("A man, a plan, a canal: Panama"));
        
    }


    class Solution {
        /**
         * 首先去除字符串中的非字母和数字
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            if (s == null || s.equals("")) {
                return true;
            }
            // 转小写去前后空格
            String lower = s.toLowerCase().trim();
            StringBuffer sb = new StringBuffer();
            for (int i =0,len = lower.length();i< len; i++) {
                // 只保留数字和字母
                char c = lower.charAt(i);
                if (('a' <= c && c <= 'z')|| ('0' <= c && c <= '9')) {
                    sb.append(c);
                }
            }
            lower = sb.toString();
            String temp = sb.reverse().toString();
            System.out.println(lower);
            System.out.println(temp);
            // 只需要比较一半即可。
            for (int i =0,len = lower.length();i< len /2; i++) {
                if (lower.charAt(i) != temp.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 利用双指针
         * @param s
         * @return
         */
        public boolean isPalindrome_1(String s) {
            if (s == null || s.equals("")) {
                return true;
            }
            //race a car
            // 转小写，去前后空格
            String lower = s.toLowerCase().trim();
            System.out.println(lower);
            int i = 0,l = lower.length() -1;
            while(i < l) {
                if (!((lower.charAt(i) >= 'a' && lower.charAt(i) <= 'z') || (lower.charAt(i) <= '9' && lower.charAt(i) >= '0'))) {
                    i ++ ;
                    continue;
                }
                if (!((lower.charAt(l) >= 'a' && lower.charAt(l) <= 'z') || (lower.charAt(l) <= '9' && lower.charAt(l) >= '0'))) {
                    l -- ;
                    continue;
                }
                if (lower.charAt(i) != lower.charAt(l)) {
                    return false;
                }
                i ++;
                l --;
            }
            return true;
        }
    }
}