package com.joyxj.leetcode.difficulty.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。  
 * 
 * 先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈，然后划去2的其他倍数；
 * 第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；
 * 现在既未画圈又没有被划去的第一个数 是5，将它画圈，并划去5的其他倍数……
 * 依次类推，一直到所有小于或等于 n 的各数都画了圈或划去为止。
 * 这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数。
 */
public class E204_CountPrimes {
    public static void main(String[] args) {
        System.out.println("hello world");
        new E204_CountPrimes().new Solution().countPrimes(10);
    }


    class Solution {
        /**
         * 暴力法，遍历
         */
        public int countPrimes(int n) {
            n = n -1;
            // 前二种情况
            if (n == 2) {
                return 1;
            } else if (n == 3) {
                return 2;
            }
            int count = 0;
            int index = 4;
    
            while (index <= n) {
                int mid = index /2;
                int start = 2;
                while (start <= mid) {
                    if (index / start == 0) {
                        index ++;
                        start ++;
                        break;
                    }
                }
                count ++;
                index ++;
            }
            return count;
        }

        public int countPrimes_1(int n) {
            n = n-1;
            if (n <=1) {
                return 0;
            }
            // 定义一个boolean 类型数组，默认值为false,如果值为 false 表示未筛选掉
            // 值为false 表示为非质数
            boolean[] result = new boolean[n-1];
            // 从 2 开始
            int count = 0;
            for (int i =0,len = n -1;i<len ;i++) {
                if (!result[i]) {
                    // 表示是质数
                    count ++;
                    // 步长
                    int step = i + 2;
                    for (int j = i+ step; j < len ; j = j + step) {
                        // 过滤掉 i 的倍数，其均不为质数。
                        result[j] = true;
                    }
                }
            }
            return count;
        }
    }
}