package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p121_BestTimeBuySellStock.Solution;
import com.kndykndy.leetcode.p121_BestTimeBuySellStock.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p121_BestTimeBuySellStockTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
            assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
            assertEquals(3, solution.maxProfit(new int[]{2, 1, 4}));
        }
    }
}
