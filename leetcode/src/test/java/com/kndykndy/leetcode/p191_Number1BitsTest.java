package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p191_Number1Bits.Solution;
import com.kndykndy.leetcode.p191_Number1Bits.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p191_Number1BitsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.hammingWeight(0b00000000000000000000000000001011));
            assertEquals(1, solution.hammingWeight(0b00000000000000000000000010000000));
            assertEquals(31, solution.hammingWeight(0b11111111111111111111111111111101));
        }
    }
}
