package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p021_MergeTwoSortedLists.Solution;
import com.kndykndy.leetcode.p021_MergeTwoSortedLists.Solution1;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p021_MergeTwoSortedListsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final ListNode listNode = solution
                .mergeTwoLists(ListNode.fromValues(1, 2, 4), ListNode.fromValues(1, 3, 4));
            assertTrue(ListNode.fromValues(1, 1, 2, 3, 4, 4).equals(listNode));
        }
    }
}
