package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p041_FirstMissingPositive.OptimalSolution;
import com.kndykndy.leetcode.p041_FirstMissingPositive.Solution;
import com.kndykndy.leetcode.p041_FirstMissingPositive.Solution1;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p041_FirstMissingPositiveTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new OptimalSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
            assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
            assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
            assertEquals(2, solution.firstMissingPositive(new int[]{1, 1000}));
        }
    }
}
