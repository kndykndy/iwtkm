package com.kndykndy.epi.primitivetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.epi.primitivetypes.p41_WordParity.Solution;
import com.kndykndy.epi.primitivetypes.p41_WordParity.Solution1;
import com.kndykndy.epi.primitivetypes.p41_WordParity.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p41_WordParityTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.getParity(0b0));
            assertEquals(1, solution.getParity(0b1));
            assertEquals(1, solution.getParity(0b1011));
            assertEquals(0, solution.getParity(0b10001000));
        }
    }
}
