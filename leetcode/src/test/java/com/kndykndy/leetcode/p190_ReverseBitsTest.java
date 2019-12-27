package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p190_ReverseBits.BruteForceSolution;
import com.kndykndy.leetcode.p190_ReverseBits.Solution;
import com.kndykndy.leetcode.p190_ReverseBits.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p190_ReverseBitsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(964176192, solution.reverseBits(43261596));
            assertEquals(-1073741825, solution.reverseBits(-3));
        }
    }
}
