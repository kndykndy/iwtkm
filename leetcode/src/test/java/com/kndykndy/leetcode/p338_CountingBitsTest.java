package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.kndykndy.leetcode.p338_CountingBits.Solution;
import com.kndykndy.leetcode.p338_CountingBits.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p338_CountingBitsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
            assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits(5));
        }
    }
}
