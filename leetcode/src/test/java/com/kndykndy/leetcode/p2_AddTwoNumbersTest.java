package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p2_AddTwoNumbers.BruteForceSolution;
import com.kndykndy.leetcode.p2_AddTwoNumbers.Solution;
import com.kndykndy.leetcode.p2_AddTwoNumbers.Solution2;
import com.kndykndy.leetcode.util.ListNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p2_AddTwoNumbersTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                ListNode.fromValues(7, 0, 8),
                solution.addTwoNumbers(
                    ListNode.fromValues(2, 4, 3), ListNode.fromValues(5, 6, 4)));

            assertEquals(
                ListNode.fromValues(0),
                solution.addTwoNumbers(ListNode.fromValues(0), ListNode.fromValues(0)));

            assertEquals(
                ListNode.fromValues(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                solution.addTwoNumbers(
                    ListNode.fromValues(9),
                    ListNode.fromValues(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)));

            assertEquals(
                ListNode.fromValues(7, 0, 8),
                solution.addTwoNumbers(
                    ListNode.fromValues(2, 4, 3), ListNode.fromValues(5, 6, 4)));

            assertEquals(
                ListNode.fromValues(0),
                solution.addTwoNumbers(ListNode.fromValues(0), ListNode.fromValues(0)));

            assertEquals(
                ListNode.fromValues(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                solution.addTwoNumbers(
                    ListNode.fromValues(9),
                    ListNode.fromValues(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)));

            assertEquals(
                ListNode.fromValues(2, 2, 3),
                solution.addTwoNumbers(ListNode.fromValues(1), ListNode.fromValues(1, 2, 3)));

            assertEquals(
                ListNode.fromValues(0, 3, 3),
                solution.addTwoNumbers(ListNode.fromValues(1, 2, 3), ListNode.fromValues(9)));

            assertEquals(
                ListNode.fromValues(0, 1),
                solution.addTwoNumbers(ListNode.fromValues(5), ListNode.fromValues(5)));
        }
    }
}
