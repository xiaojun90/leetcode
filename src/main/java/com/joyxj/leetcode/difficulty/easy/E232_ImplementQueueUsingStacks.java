package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

public class E232_ImplementQueueUsingStacks {

    public static void main(String[] args) {
        
    }



    class MyQueue {

        private List<Integer> list;

        /** Initialize your data structure here. */
        public MyQueue() {
            list = new ArrayList<>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            list.add(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int front = peek();
            list.remove(0);
            return front;
            
        }
        
        /** Get the front element. */
        public int peek() {
            return list.get(0);
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return list.size() == 0;
        }
    }
}