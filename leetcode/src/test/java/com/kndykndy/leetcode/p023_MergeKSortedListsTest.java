package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p023_MergeKSortedLists.Solution;
import com.kndykndy.leetcode.p023_MergeKSortedLists.Solution1;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p023_MergeKSortedListsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final ListNode result = solution.mergeKLists(
                new ListNode[]{
                    ListNode.fromValues(1, 4, 5),
                    ListNode.fromValues(1, 3, 4),
                    ListNode.fromValues(2, 6)
                }
            );

            assertTrue(result.equals(ListNode.fromValues(1, 1, 2, 3, 4, 4, 5, 6)));
        }
    }
}
