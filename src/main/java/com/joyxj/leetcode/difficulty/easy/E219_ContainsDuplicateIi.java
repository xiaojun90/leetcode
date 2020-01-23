package com.joyxj.leetcode.difficulty.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (35.48%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 63.6K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
 * 的差的绝对值最大为 k。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */
public class E219_ContainsDuplicateIi {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        new Solution().containsNearbyDuplicate(nums, 1);
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums == null || nums.length == 0 ) {
                return false;
            }
            //存储 数组的值和索引
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int i =0,len = nums.length; i<len; i++) {
                if (map.get(nums[i]) == null) {
                    // 不存在
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                    continue;
                }
                List<Integer> list = map.get(nums[i]);
                for (int index : list) {
                    if (i - index <= k) {
                        return true;
                    }
                }
                list.add(i);
            }
            return false;
        }
    }
}