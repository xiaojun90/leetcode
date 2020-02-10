package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 *
 * https://leetcode-cn.com/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (35.84%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    34.7K
 * Total Submissions: 95.4K
 * Testcase Example:  '5\n4'
 *
 * 
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 示例:
 * 
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 
 * 所以，4 是第一个错误的版本。 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class E278_FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(new E278_FirstBadVersion().firstBadVersion(2126753390));
    }

    public boolean isBadVersion(int i) {
        return i >=1702766719;
    }

    public int firstBadVersion(int n) {
        // 对于只有一个元素
        if (n == 1) {
            // 就是一个错误的版本
            return 1;
        }
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int start ,int end) {
        System.out.println("start and end:" + start + "," + end);
        // 利用二分法折半查找
        // 为了防止整数越界，取中位数使用 start + (end - start) / 2
        int centerNum = start + (end - start) / 2;
        boolean current = isBadVersion(centerNum);
        boolean next = isBadVersion(centerNum + 1);
        // 中间版本是错误的，且开始值是中间值，这种情况就是只有二个元素的时候进行的比较
        if (current && start == centerNum) {
            return start;
        }
        // 当前的中间值是 false,下一个值是 true
        if (!current && next) {
            return centerNum + 1;
        }
        if (current) {
            return firstBadVersion(start,centerNum);
        }
        return firstBadVersion(centerNum,end);
    }
}