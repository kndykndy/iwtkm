package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p122_BestTimeToBuyAndSellStockII.BruteForceSolution;
import com.kndykndy.leetcode.p122_BestTimeToBuyAndSellStockII.Solution;
import com.kndykndy.leetcode.p122_BestTimeToBuyAndSellStockII.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p122_BestTimeToBuyAndSellStockIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(7, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
            assertEquals(11, solution.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7}));
            assertEquals(13, solution.maxProfit(new int[]{1, 3, 5, 4, 3, 7, 6, 9, 2, 4}));
            assertEquals(0, solution.maxProfit(new int[]{100, 99, 98, 97, 0, 0, 0}));
            assertEquals(18, solution.maxProfit(new int[]{5, 5, 4, 9, 3, 8, 5, 5, 1, 6, 8, 3, 4}));
            assertEquals(12, solution.maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
        }
    }
}
