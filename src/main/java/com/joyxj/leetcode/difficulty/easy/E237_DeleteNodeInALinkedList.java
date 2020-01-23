package com.joyxj.leetcode.difficulty.easy;

/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/
 *
 * algorithms
 * Easy (79.40%)
 * Likes:    586
 * Dislikes: 0
 * Total Accepted:    72.5K
 * Total Submissions: 91.2K
 * Testcase Example:  '[4,5,1,9]\n5'
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 
 * 
 * 示例 2:
 * 
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * 
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

public class E237_DeleteNodeInALinkedList {

    public static void main(String[] args) {
        
    }

    /**
     * 由于无法获得当前节点的前一个节点，我们无法使用常规的节点删除方法
     * 使用把下一个节点的值赋值给当前节点，然后把下一个节点删除的方式进行删除
     */
    class Solution {
        public void deleteNode(ListNode node) {
            ListNode next = node.next;
            // 把下一个节点的值赋值给当前节点
            node.val = next.val;
            // 下一个节点是尾节点
            if (next.next == null) {
                node.next = null;
                return;
            }
            // 下一个节点不是尾节点
            node.next = next.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



}