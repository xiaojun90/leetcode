package com.joyxj.leetcode.difficulty.easy;

public class E231_PowerOfTwo {

    public static void main(String[] args) {
        
    }

    class Solution {
        /**
         * 解法一：不断的除以2，看最后是否等于 1 
         */
        public boolean isPowerOfTwo(int n) {
            while(n > 1) {
                if (n % 2 != 0) {
                    return false;
                }
                // 除以2 
                n = n >> 1;
            }
            if (n==1) 
            {
                return true;
            }
            return false;
        }

        /**
         * 解法二：
         * 若 n = 2^x 且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件
         * 1. n & (n -1) = 0,因为 n 的二进制最高位为 1，其余位为 0。
         *  n-1 的二进制位的最高位为 0，其余位为 1
         * 2. n > 0
         */
        public boolean isPowerOfTwo_2(int n) {
            return n > 0 && (n & (n -1)) == 0;
        }
    }
}