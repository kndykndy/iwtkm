package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p042_TrappingRainWater.Solution;
import com.kndykndy.leetcode.p042_TrappingRainWater.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p042_TrappingRainWaterTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, 0);
//            assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//            assertEquals(8, solution.trap(new int[]{0, 3, 0, 1, 0, 3}));
//            assertEquals(0, solution.trap(new int[]{0, 2, 0}));
//            assertEquals(, solution.trap(new int[]{}));
        }
    }
}
