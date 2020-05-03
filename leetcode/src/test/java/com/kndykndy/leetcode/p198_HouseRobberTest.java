package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p198_HouseRobber.Solution;
import com.kndykndy.leetcode.p198_HouseRobber.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p198_HouseRobberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
            assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
        }
    }
}
