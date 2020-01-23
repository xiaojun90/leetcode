package com.joyxj.leetcode.difficulty.easy;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * @author xiaoj
 * @version 1.0
 * @date 2019-9-25
 */
public class E203_RemoveLinkedListElements {

    class Solution {
        /**
         * 解法一：在原先的链表中操作
         */
        public ListNode removeElements(ListNode head, int val) {
            if (null == head) {
                return head;
            }
            // 前驱结点
            ListNode pre = null;
            ListNode current = head;
            while(null != current) {
                if (current.val == val) {
                    // 相等，删除
                    if (null == pre) {
                        // 没有前驱结点，表示删除的是头结点
                        head = head.next;
                    } else {
                        pre.next = current.next;
                    }
                    current = current.next;

                } else {
                    // 不相等的情况，往后移一位
                    pre = current;
                    current = current.next;
                }
            }
            return head;
        }

        /**
         * 解法二：在新的链表上操作
         */
        public ListNode removeElements_2(ListNode head, int val) {
            if (null == head) {
                return head;
            }
            // 构造一个新的链表，生成一个哨兵结点，方便对头节点的处理
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode current = pre;
            while (current.next != null) {
                if (current.next.val == val) {
                    // 相等
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return pre.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}