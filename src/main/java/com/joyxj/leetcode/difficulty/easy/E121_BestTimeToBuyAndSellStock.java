package com.joyxj.leetcode.difficulty.easy;

public class E121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        
    }

    class Solution {
        /**
         * 暴力解法
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int max = 0;
            for (int i =0 ,len = prices.length; i<len; i++) {
                for (int j = i+1;j < len;j ++) {
                    if (max > (prices[j] - prices[i])) {
                        max = prices[j] - prices[i];
                    }
                }
            }
            return max;
        }

        /**
         * 动态规划思想解法
         * 
         * 1、今天卖出的最大利润是在今天前最小值买入。
         * 2、比较每天卖出的最大利润的最大值即可。
         * @param prices
         * @return
         */
        public int maxProfit_1(int[] prices) {
            if (prices.length == 0 ) {
                return 0;
            }
            int min = prices[0],max = 0;
            for (int i=0,len=prices.length; i<len ; i ++) {
                max = Math.max(prices[i] - min, max);
                min = Math.min(prices[i], min);
            }
            return max;
        }
    }
}