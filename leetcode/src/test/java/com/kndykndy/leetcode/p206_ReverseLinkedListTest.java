package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p206_ReverseLinkedList.Solution;
import com.kndykndy.leetcode.p206_ReverseLinkedList.Solution1;
import com.kndykndy.leetcode.p206_ReverseLinkedList.Solution2;
import com.kndykndy.leetcode.p206_ReverseLinkedList.Solution3;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p206_ReverseLinkedListTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2(), new Solution3());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertNull(solution.reverseList(ListNode.fromValues()));
        }
    }

    @Test
    void test2() {
        for (Solution solution : solutions) {
            assertTrue(solution.reverseList(ListNode.fromValues(1))
                .equals(ListNode.fromValues(1)));
            assertTrue(solution.reverseList(ListNode.fromValues(1, 2, 3, 4, 5))
                .equals(ListNode.fromValues(5, 4, 3, 2, 1)));
            assertTrue(solution.reverseList(ListNode.fromValues(5, 3, 1))
                .equals(ListNode.fromValues(1, 3, 5)));
        }
    }
}
