package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p322_CoinChange.Solution;
import com.kndykndy.leetcode.p322_CoinChange.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p322_CoinChangeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11)); // 11 = 5 + 5 + 1
            assertEquals(-1, solution.coinChange(new int[]{2}, 3));
            assertEquals(4, solution.coinChange(new int[]{2, 5}, 11)); // 11 = 5+2+2+2
        }
    }
}
