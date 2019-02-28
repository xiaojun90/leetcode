package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (42.61%)
 * Total Accepted:    85.5K
 * Total Submissions: 200.7K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2], 
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 * 快慢指针方法的分析：
 * 
 * 假定有一个有序的数组：[1,2,2,4,5,5,6,7]
 * 定义二个指针，i初始值为0,为慢指针;j为快指针，用于循环。
 * 循环数组，如果nums[i]!=nums[j]时，表示不是重复的，i加1,把Num[j]赋值给nums[i];
 * 
 * 整个流程：
 * 1.初始时：i=0
 * 2.开始循环: j=1时，a[i]= 1 ,a[j]=2，此时1!=2，慢指针i应该加1，并且把a[j]赋值给a[i]。数组为:[1,2,2,4,5,5,6,7],i=1,j=1;
 * 3.j=2时，a[1]=a[2],直接跳过。数组为[1,2,2,4,5,5,6,7],i=1,j=2
 * 4.j=3时，a[1]!=a[3],i加1，a[i]=a[j]。数组为[1,2,4,4,5,5,6,7],i=2,j=3
 * 5.j=4时，a[2]!=a[4], i加1,a[i]=a[j]。数组为[1,2,4,5,5,5,6,7],i=3,j=4
 * 6.j=5时，数组为：[1,2,4,5,5,5,6,7],i=3,j=5
 * 7.j=6时，数组为：[1,2,4,5,6,5,6,7],i=4,j=6
 * 8.j=7时，数组为：[1,2,4,5,6,7,6,7],i=5,j=6
 * 9.最后返回有序数组长度：应该是i+1。
 * 
 */

public class E026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        new Solution().removeDuplicates(null);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {

        //数组为空的情况
        if (nums.length == 0) {
            return 0;
        }
        // 采用快慢指针的方式实现，这可以做到只要额外O(1)的空间复杂度
        int i= 0;
        for (int j=1,len=nums.length;j<len;j++) {
            // 比较nums[j]和nums[j++]的大小，如果不相同的话，则第i个位置的数据等于nums[j]。
            // 相同的情况下，只需要增加j即可
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
        }
    }
}