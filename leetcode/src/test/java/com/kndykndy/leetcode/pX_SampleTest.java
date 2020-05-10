package com.kndykndy.leetcode;

import com.kndykndy.leetcode.pX_Sample.Solution;
import com.kndykndy.leetcode.pX_Sample.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;

class pX_SampleTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
//        solutions = Arrays.asList(new BruteForceSolution(), new Solution1(), new Solution2());
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            //assertEquals(, );
            //assertTrue();
            //assertFalse();
        }
    }
}
