package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p518_CoinChangeII.Solution;
import com.kndykndy.leetcode.p518_CoinChangeII.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p518_CoinChangeIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(4, solution.change(5, new int[]{1, 2, 5}));
            assertEquals(1, solution.change(11, new int[]{2, 5}));
            assertEquals(0, solution.change(3, new int[]{2}));
            assertEquals(1, solution.change(10, new int[]{10}));
        }
    }
}
