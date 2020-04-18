package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p092_ReverseLinkedListII.Solution;
import com.kndykndy.leetcode.p092_ReverseLinkedListII.Solution1;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p092_ReverseLinkedListIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(
                solution.reverseBetween(ListNode.fromValues(1, 2, 3, 4, 5), 2, 4)
                    .equals(ListNode.fromValues(1, 4, 3, 2, 5))
            );
        }
    }
}
