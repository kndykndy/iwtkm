package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p155_MinStack.MinStack;
import org.junit.jupiter.api.Test;

class p155_MinStackTest {

    @Test
    void test1() {
        final MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

    @Test
    void test2() {
        final MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(-3, minStack.top());
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }
}
