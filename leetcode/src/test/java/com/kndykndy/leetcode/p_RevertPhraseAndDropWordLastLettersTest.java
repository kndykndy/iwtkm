package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p_RevertPhraseAndDropWordLastLetters.Solution;
import com.kndykndy.leetcode.p_RevertPhraseAndDropWordLastLetters.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_RevertPhraseAndDropWordLastLettersTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals("", solution.revert(""));
            assertEquals("csid", solution.revert("disco"));
            assertEquals("csid", solution.revert("disco "));
            assertEquals("csid ol", solution.revert("disco lol"));
            assertEquals("csid of epus eoreh -:", solution.revert("disco for super heroes :-)"));
        }
    }
}
