package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class E225_ImplementStackUsingQueues {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int top = top();
        list.remove(list.size() - 1);
        return top;
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public boolean empty() {
        return list.size() == 0;
    }

}