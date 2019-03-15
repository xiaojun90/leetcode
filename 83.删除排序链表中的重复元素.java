/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (44.33%)
 * Total Accepted:    19K
 * Total Submissions: 42.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 特殊情况处理
        if (null == head) {
            return null;
        }
        ListNode current = head;
        ListNode next = head.next;
        while(next != null) {
            if (current.val == next.val) {
                // 如果相等的情况，
                next = next.next;
                current.next = next;
            } else {
                // 不相等的情况下需要移动当前节点到next节点
                current = next;
                next = next.next;
            }
        }
        return head;
    }
}

