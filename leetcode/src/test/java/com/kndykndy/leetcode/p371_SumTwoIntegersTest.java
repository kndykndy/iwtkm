package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p371_SumTwoIntegers.Solution;
import com.kndykndy.leetcode.p371_SumTwoIntegers.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p371_SumTwoIntegersTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2, solution.getSum(1, 1));
            assertEquals(0, solution.getSum(0, 0));
            assertEquals(1, solution.getSum(-1, 2));
            assertEquals(0, solution.getSum(-1, 1));
            assertEquals(-3, solution.getSum(-1, -2));
        }
    }
}
