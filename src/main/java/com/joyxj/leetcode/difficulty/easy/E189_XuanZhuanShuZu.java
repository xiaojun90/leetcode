package com.joyxj.leetcode.difficulty.easy;

/**
 * 旋转数组
 */
public class E189_XuanZhuanShuZu {

    public static void main(String[] args) {
        
    }

    class Solution {
        
        /**
         * 我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
         * 假设 n=7n=7 且 k=3k=3 
         * 原始数组                  : 1 2 3 4 5 6 7
         * 反转所有数字后             : 7 6 5 4 3 2 1
         * 反转前 k 个数字后          : 5 6 7 4 3 2 1
         * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int len = nums.length;
            // 反转整个数组
            reverse(nums,0,len-1);
            // 求余，防止 k 大于 数组长度
            k = k % len;
            reverse(nums, 0, k - 1);
            reverse(nums, k, len-1);
        }

        /**
         * 反转数组
         * @param nums 需要反转的数组
         * @param start 数组起始位置
         * @param end 数组结束位置
         */
        private void reverse(int[] nums,int start ,int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start ++;
                end --;
            }
        }
        
        /**
         * 暴力法
         * @param nums
         * @param k
         */
        public void rotate_1(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int len = nums.length;
            // 求余，防止 k 大于数组的长度
            k = k % len;
            // count 表示旋转次数
            int count = 1;
            while (count <= k) {
                int last = nums[len-1];
                for (int i = len-1;i>0;i--) {
                    nums[i] = nums[i-1];
                }
                nums[0] = last;
                count ++;
            }
        }
    }
}