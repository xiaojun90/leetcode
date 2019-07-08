package com.joyxj.leetcode.difficulty.easy;

/**
 * 编写一个程序，找到两个单链表相交的起始节点
 * 解决这个问题的关键是消除二个单链表的长度差
 * 下面是具体步骤：假定 headA 的长度比 headB 长。 
 * 1. 定义二个指针 pA、pB 分别指向 headA 和 headB。
 * 2. 指针 pA 、pB 分别依次往后遍头部时，
 * 3. 如果 pA 到达了尾部，则指向 headB 的头部
 * 4. 如果 pB 到达了尾部，则指向 headA 的头部
 * 5. 比较长的链表指针指向了比较短的链表指针的头部时，此时则消除了长度差，会同时到达尾部
 * 
 * 
 * 以下面这个例子来解释上面的步骤：headA = [0,9,1,2,4], headB = [3,2,4]，2 为其相交点。
 * 为了减小理解偏差，链表的值使用了不同的值。
 * 
 * 1. 初始时，pA 指向 headA 的头结点 0 ,pB 指向 headB 的头结点 3.
 * 2. pB 到达 headB 尾结点时，pA 指向 headA 的 值为 1 的节点。此时 pB 开始指向 headA 的头节点。
 * 3. pA 到达 headA 尾结点时，pB 指向 headA 的 值为 9 的节点。此时 pA 开始指向 headB 的头节点。
 * 4. 此时，pA 指向了 headB 的值为 3 的头结点，pB 指向了 headA 的值为 1 的结点。此时已经消除了长度差。
 * 
 */
public class E160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        
    }

    class Solution {
        
        /**
         * 解决的关键是消除二个单链表的长度差，然后开始往后遍历，会一起到达相交点。
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA;
            ListNode pB = headB;
            while (pA != pB) {
                pA = pA != null ? pA.next : headB;
                pB = pB != null ? pB.next : headA;
            }
            return pA;
        }

        /**
         * 比较傻的方法，双层遍历
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
            // 判空
            if (headA == null || headB == null) {
                return null;
            }
            ListNode p = headA;
            ListNode q = headB;
            // 利用双层遍历的方法
            while (p != null) {
                q = headB;
                while(q != null) {
                    if (p == q) {
                        return q;
                    }
                    q = q.next;
                }
                p = p.next;
            }
            // 表示 while　循环中没有找到相聚的结点，返回null;
            return null;
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