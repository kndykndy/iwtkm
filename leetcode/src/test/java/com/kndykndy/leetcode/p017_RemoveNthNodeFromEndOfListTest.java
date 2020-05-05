package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p017_RemoveNthNodeFromEndOfList.Solution;
import com.kndykndy.leetcode.p017_RemoveNthNodeFromEndOfList.Solution1;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p017_RemoveNthNodeFromEndOfListTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(
                ListNode.fromValues(1).equals(
                    solution.removeNthFromEnd(ListNode.fromValues(1, 2), 1)
                )
            );
            assertTrue(
                ListNode.fromValues(2).equals(
                    solution.removeNthFromEnd(ListNode.fromValues(1, 2), 2)
                )
            );

            assertTrue(
                ListNode.fromValues(1, 2).equals(
                    solution.removeNthFromEnd(ListNode.fromValues(1, 2, 3), 1)
                )
            );
            assertTrue(
                ListNode.fromValues(1, 3).equals(
                    solution.removeNthFromEnd(ListNode.fromValues(1, 2, 3), 2)
                )
            );
            assertTrue(
                ListNode.fromValues(2, 3).equals(
                    solution.removeNthFromEnd(ListNode.fromValues(1, 2, 3), 3)
                )
            );
        }
    }
}
