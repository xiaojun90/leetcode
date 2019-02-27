package com.joyxj.leetcode.difficulty.easy;


/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (52.51%)
 * Total Accepted:    44.2K
 * Total Submissions: 84.2K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 * 
 * 备注：题目有一个隐藏条件：生成的新链表也要是有序的。
 */


public class E021_MergeTwoSortedLists {
    public static void main(String[] args) {
        
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {            
            ListNode resultNode = new ListNode(0); //定义一个哨兵元素
            ListNode temp = resultNode;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    //大于的情况，把l2的元素加到temp中
                    temp.next = new ListNode(l2.val);  
                    l2 = l2.next;
                } else if (l1.val == l2.val){
                    // 等于的情况，l1和l2的元素都加到temp中
                    temp.next = new ListNode(l1.val); 
                    temp = temp.next;
                    temp.next = new ListNode(l2.val);
                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    //小于的情况
                    temp.next = new ListNode(l1.val); 
                    l1 = l1.next;
                }
                temp = temp.next;
            }
            if (l1!= null) {
                temp.next = l1;
            }
            if (l2!= null) {
                temp.next = l2;
            }
            return resultNode.next;
            }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}