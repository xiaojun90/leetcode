package com.joyxj.leetcode.difficulty.easy;

public class E053_MaximumSubarray {

    public static void main(String[] args) {
        
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int num:nums) {
                if (sum >= 0) {
                    // 如果求和大于0的话，就加上当前值
                    sum = sum + num;
                } else {
                    // 否则的话，就把num赋值给sum。因为如果sum小于0的话，加上当前的值肯定更小
                    sum = num;
                }
                res = Math.max(res, sum);
            }
            return res;
        }
    }

}