package com.joyxj.leetcode.difficulty.easy;

public class E191_NumberOfOneBits {

    public static void main(String[] args) {
        new E191_NumberOfOneBits().new Solution() .hammingWeight(1100);

    }

    class Solution {
        // you need to treat n as an unsigned value
        /**
         * 把n转换成字符串，然后判断是否是1
         */
        public int hammingWeight(int n) {
            String str = Integer.toBinaryString(n);
            int count = 0;
            for (char c: str.toCharArray()) {
                if (c == '1') {
                    count ++;
                }
            }
            return count;
        }

        /**
         * 循环加位移的方法
         * 遍历数据的32位，如果是1的话就加1 
         * 通过位掩码来检查数字的第i位，一开始，掩码m=1,因为1的二进制码是0000000000000000000000000000001
         * 显示，任何数据与1进行与运算，都可以获得最低位。检查下一位时，把掩码右移一位。
         */
        public int hammingWeight_1(int n) {
            // 表示1的位数
            int bits = 0;
            // 掩码
            int mask = 1;
            for (int i =0;i<32;i++) {
                if ((n & mask) != 0) {
                    bits ++;
                }
                mask <<= 1;
            }
            return bits;
        }

        /**
         * 更加优雅的解法
         * 是对 hammingWeight_1 的优化，我们不在检查每一位，而是不断把数字的最后一个1进行反转，并把答案加1。
         * 当数据变成 0 时，我们就知道没有1了。
         * 对于任意一个数字n,将 n 和 n -1 进行与运算，会把最后一个 1 变成 0。而其中的高位不会发生改变 
         * 如对于数字 10 来说，其二进制为 1010，10 - 1 = 9 的二进制为 1001 ，对 10 & 9 = 1000。其把最后一个1变成了0，但是其它位未发生改变
         */
        public int hammingWeight_2(int n) {
            int bits = 0;
            while (n != 0) {
                n = n & (n-1);
                bits ++;
            }
            return bits;
        }

    }
}