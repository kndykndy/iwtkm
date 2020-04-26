package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p876_MiddleOfTheLinkedList.Solution;
import com.kndykndy.leetcode.p876_MiddleOfTheLinkedList.Solution1;
import com.kndykndy.leetcode.p876_MiddleOfTheLinkedList.Solution2;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p876_MiddleOfTheLinkedListTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.middleNode(ListNode.fromValues(1, 2, 3, 4, 5)).val);
            assertEquals(4, solution.middleNode(ListNode.fromValues(1, 2, 3, 4, 5, 6)).val);
            assertEquals(4, solution.middleNode(ListNode.fromValues(1, 2, 3, 4, 5, 6, 7)).val);
            assertEquals(6,
                solution.middleNode(ListNode.fromValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).val);
        }
    }
}
