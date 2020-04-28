package com.kndykndy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class p155_MinStack {

    public static class MinStack {

        final Deque<Integer> dataQueue = new ArrayDeque<>();
        final Deque<Integer> minStack = new ArrayDeque<>();

        public void push(int x) {
            dataQueue.addFirst(x);
            if (!minStack.isEmpty()) {
                if (x <= getMin()) {
                    minStack.addFirst(x);
                }
            } else {
                minStack.addFirst(x);
            }
        }

        public void pop() {
            if (!dataQueue.isEmpty()) {
                final Integer integer = dataQueue.removeFirst();
                if (getMin() == integer) {
                    minStack.removeFirst();
                }
            }
        }

        public int top() {
            return dataQueue.getFirst();
        }

        public int getMin() {
            return minStack.getFirst();
        }
    }
}
