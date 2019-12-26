package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p45_JumpGameII.BruteForceSolution;
import com.kndykndy.leetcode.p45_JumpGameII.DpMemoizationSolution;
import com.kndykndy.leetcode.p45_JumpGameII.GreedySolution;
import com.kndykndy.leetcode.p45_JumpGameII.Solution;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p45_JumpGameIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(
            new BruteForceSolution(), new DpMemoizationSolution(), new GreedySolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
            assertEquals(2, solution.jump(new int[]{1, 2, 3}));
            assertEquals(2, solution.jump(new int[]{2, 3, 0, 1, 4}));
            assertEquals(3, solution.jump(new int[]{1, 2, 1, 1, 1}));
        }
    }
}
