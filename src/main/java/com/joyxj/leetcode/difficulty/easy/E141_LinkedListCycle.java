package com.joyxj.leetcode.difficulty.easy;

/**
 * [141] 环形链表
 */
public class E141_LinkedListCycle {
    public static void main(String[] args) {
        
    }

    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            // 定义二个节点，p节点每次走一步，q节点每次走二步
            ListNode p = head;
            ListNode q = head;
            while(p != null && q != null && p.next != null && q.next != null && q.next.next != null) {
               if (p.next == q.next.next) {
                   return true;
               } 
               p = p.next;
               q = q.next.next;
            }
            return false;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}