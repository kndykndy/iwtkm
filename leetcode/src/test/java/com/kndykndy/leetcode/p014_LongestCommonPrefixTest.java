package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p014_LongestCommonPrefix.Solution;
import com.kndykndy.leetcode.p014_LongestCommonPrefix.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p014_LongestCommonPrefixTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                "fl",
                solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
            assertEquals("", solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        }
    }
}
