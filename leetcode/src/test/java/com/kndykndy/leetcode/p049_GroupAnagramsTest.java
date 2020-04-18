package com.kndykndy.leetcode;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p049_GroupAnagrams.Solution;
import com.kndykndy.leetcode.p049_GroupAnagrams.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p049_GroupAnagramsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final List<List<String>> result =
                solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
            assertEquals(3, result.size());
            assertTrue(result.contains(Arrays.asList("eat", "tea", "ate")));
//            assertIterableEquals(Arrays.asList("eat", "tea", "ate"), result.get(0));
            assertTrue(result.contains(Arrays.asList("tan", "nat")));
            assertTrue(result.contains(Collections.singletonList("bat")));
        }
    }
}
