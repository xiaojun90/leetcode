package com.joyxj.leetcode.difficulty.easy;

/**
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class E122_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        
    }
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int total = 0;
            int min = prices[0];
            int max = 0;
            // 每次在要升的时候买入，要降的时候卖出
            for (int i=1,len=prices.length;i<len;i++) {
                if (max <= prices[i] - min) {
                    // 最大值小于当前卖出的价格
                    max = prices[i] - min;
                } else {
                    // 最大值大于当前卖出的价格
                    total = total + max;
                    max = 0;
                    min = prices[i];
                }
            }
            total = total + max;
            return total;
        }
    }
}