package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p822_CardFlippingGame.Solution;
import com.kndykndy.leetcode.p822_CardFlippingGame.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p822_CardFlippingGameTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.flipgame(new int[]{1}, new int[]{1}));
            assertEquals(0, solution.flipgame(new int[]{1, 1}, new int[]{1, 1}));
            assertEquals(0, solution.flipgame(new int[]{1, 2}, new int[]{1, 2}));

            assertEquals(2, solution.flipgame(new int[]{1, 1}, new int[]{2, 1}));
            assertEquals(2, solution.flipgame(new int[]{1, 2}, new int[]{1, 3}));

            // 3 is min element in backs not in fronts
            assertEquals(2, solution.flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
        }
    }
}
