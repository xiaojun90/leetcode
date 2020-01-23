package com.joyxj.leetcode.difficulty.easy;
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (38.20%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    46.3K
 * Total Submissions: 118.3K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class E234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode hNode = new ListNode(1);
        hNode.next = new ListNode(2);
        hNode.next.next = new ListNode(2);
        hNode.next.next.next = new ListNode(1);
        System.out.println(new E234_PalindromeLinkedList().new Solution().isPalindrome(hNode));
    }

    class Solution {
        /**
         * 通过快慢指针的方式找到中间结点，
         * 对前半部分数据进行反转。然后对后半部分数据比较
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            ListNode left = null; //反转的左半部分数据
            ListNode pre = null;
            // 边遍历，边反转
            while(fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                pre.next = left;
                left = pre;
                
            } 
            // 通过快指针判断链表的奇偶性         
            if (fast != null) {
                // 表示链表是奇数个元素
                slow = slow.next;
            }
            while (slow != null) {
                if (slow.val != left.val) {
                    return false;
                }
                slow = slow.next;
                left = left.next;
            }
            return true;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}