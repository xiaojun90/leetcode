package com.joyxj.leetcode.difficulty.easy;

import java.util.Map;
import java.util.HashMap;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 函数应该返回这两个下标值 index1 和 index2，其中 index1
 * 必须小于 index2。
 */
public class E167_TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        
    }

    class Solution {

        /**
         * 官方解法，充分利用有序数组这个特点
         * 
         * 定义二个指针，一个指向数组的第一个元素，一个指向数组的最后一个元素。
         * 比较这二个元素之和与目标值的大小，如果相等，则找到了。
         * 如果大于目标值，则将较大的指针减一，如果小于目标值，则将较小的指针加一
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null) {
                return null;
            }
            int first = 1;
            int last = numbers.length;
            while(( numbers[first -1] + numbers [last -1]) != target) {
                if (( numbers[first -1] + numbers [last -1]) > target) {
                    // 二元素之和大小目标值，较大值减1
                    last --;
                } else {
                    // 二元素之和小小目标值，较小值加1
                    first ++;
                }
                if (first >= last) {
                    // 表示没有找到
                    return null;
                }
            }
            return new int[] {first,last};
        }

        /**
         * 利用Hash Map 的方式
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum_1(int[] numbers, int target) {
            if (numbers == null) {
                return null;
            }
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0 ; i < numbers.length;i ++ ) {
                int a = target - numbers[i];
                if (map.containsKey(a)) {
                    return new int[]{map.get(a) + 1,i + 1};
                } else {
                    map.put(numbers[i], i);
                }
            }
            return null;
        }
    }
}