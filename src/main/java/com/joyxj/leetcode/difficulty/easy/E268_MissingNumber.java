package com.joyxj.leetcode.difficulty.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (53.63%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    47.8K
 * Total Submissions: 88.7K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

public class E268_MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,5,4};
        new E268_MissingNumber().missingNumber_2(nums);
    }

    /**
     * 哈希表方法
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        // 保存所有的数字
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        // 遍历，看集合中是否含有数字
        int i = 0;
        while(i <=nums.length) {
            if (!set.contains(i)) {
                break;
            } 
            i ++;
        }
        return i;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int missingNumber_2(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int i =0;
        // 遍历，数组是否含有数字
        for (int num:nums) {
            if (i != num) {
                break;
            }
            i ++;
        }
        return i;
    }
}