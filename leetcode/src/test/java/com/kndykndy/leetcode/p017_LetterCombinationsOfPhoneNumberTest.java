package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p017_LetterCombinationsOfPhoneNumber.Solution;
import com.kndykndy.leetcode.p017_LetterCombinationsOfPhoneNumber.Solution1;
import com.kndykndy.leetcode.p017_LetterCombinationsOfPhoneNumber.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p017_LetterCombinationsOfPhoneNumberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = List.of(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            List<String> strings = solution.letterCombinations("23");
            assertTrue(strings.containsAll(
                Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
        }
    }
}
