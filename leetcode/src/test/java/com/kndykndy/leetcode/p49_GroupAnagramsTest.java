package com.kndykndy.leetcode;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.kndykndy.leetcode.p49_GroupAnagrams.Solution;
import com.kndykndy.leetcode.p49_GroupAnagrams.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p49_GroupAnagramsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final List<List<String>> lists = solution
                .groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
            assertEquals(3, lists.size());
            assertIterableEquals(Arrays.asList("eat", "tea", "ate"), lists.get(0));
            assertIterableEquals(Arrays.asList("tan", "nat"), lists.get(2));
            assertIterableEquals(Collections.singletonList("bat"), lists.get(1));
        }
    }
}
