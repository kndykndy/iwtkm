package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p136_SimpleNumber.OptimalSolution;
import com.kndykndy.leetcode.p136_SimpleNumber.Solution;
import com.kndykndy.leetcode.p136_SimpleNumber.Solution1;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p136_SimpleNumberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new OptimalSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(-2, solution.singleNumber(new int[]{-1, -1, -2}));
            assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
            assertEquals(4, solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
            assertEquals(5, solution.singleNumber(new int[]{2, 1, 3, 5, 3, 1, 2}));
            assertEquals(-1, solution.singleNumber(new int[]{1, 3, 1, -1, 3}));
        }
    }
}
