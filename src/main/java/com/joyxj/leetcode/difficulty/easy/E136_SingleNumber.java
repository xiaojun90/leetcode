package com.joyxj.leetcode.difficulty.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外， 其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class E136_SingleNumber {

    public static void main(String[] args) {
        
    }

    /**
     * 采用HashMap方法，但空间复杂度为O(N)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i: nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, i);
            }
        }
        return map.entrySet().iterator().next().getValue();
        
    }

    /**
     * 采用异或的方法，相个相同的数异或为0，不同为1，原数不变
     * @param nums
     * @return
     */
    public int singleNumber_1(int[] nums) {
        int result = 0;
        for (int num:nums) {
            result ^= num;
        }
        return result;
    }
}