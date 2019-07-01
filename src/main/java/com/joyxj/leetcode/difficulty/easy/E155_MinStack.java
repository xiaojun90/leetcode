package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈
 */
public class E155_MinStack {
    public static void main(String[] args) {
        MinStack minStack = new E155_MinStack().new  MinStack();
        minStack.push(-1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    class MinStack {

        /** initialize your data structure here. */
        private List<Integer> data = new ArrayList<>(16);
        private int min = 0;
        private int index = 0;
        public MinStack() {
            
        }
        
        public void push(int x) {
            data.add(x);
            if (index == 0) {
                min = data.get(0);
            }
            if (min > x) {
                min = x;
            }
            index ++ ;
        }
        
        public void pop(){
            if (index == 0) {
                min = 0;
                return;
            }
            int top = data.remove(--index);
            updateMin(top);
        }
        
        public int top() {
            if (index == 0) {
                min = 0;
                return 0;
            }
            return data.get(index -1);
        }
        
        public int getMin() {
            return min;
        }

        private void updateMin(int top) {
            // 表示栈点元素是最小值元素
            if (index == 0) {
                // 表示没有元素了
                min = 0;
                return;
            }
            if (min == top) {
                min = data.get(0);
                for (Integer i : data) {
                    if (min > i) {
                        min = i;
                    }
                }
            }
        }
    }
}