package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p070_ClimbingStairs.Solution;
import com.kndykndy.leetcode.p070_ClimbingStairs.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p070_ClimbingStairsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2, solution.climbStairs(2));
            assertEquals(3, solution.climbStairs(3));
            assertEquals(5, solution.climbStairs(4));
            assertEquals(8, solution.climbStairs(5));
        }
    }
}
