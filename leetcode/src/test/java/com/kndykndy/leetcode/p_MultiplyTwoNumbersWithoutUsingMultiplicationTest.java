package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p_MultiplyTwoNumbersWithoutUsingMultiplication.Solution;
import com.kndykndy.leetcode.p_MultiplyTwoNumbersWithoutUsingMultiplication.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_MultiplyTwoNumbersWithoutUsingMultiplicationTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.multiply(0, 0));
            assertEquals(0, solution.multiply(5, 0));
            assertEquals(0, solution.multiply(0, 5));
            assertEquals(5, solution.multiply(5, 1));
            assertEquals(5, solution.multiply(1, 5));
            assertEquals(10, solution.multiply(2, 5));
            assertEquals(16, solution.multiply(4, 4));
            assertEquals(-5, solution.multiply(-5, 1));
            assertEquals(-5, solution.multiply(1, -5));
            assertEquals(25, solution.multiply(-5, -5));
        }
    }
}
