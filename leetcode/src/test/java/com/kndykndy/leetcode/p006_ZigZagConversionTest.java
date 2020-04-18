package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kndykndy.leetcode.p006_ZigZagConversion.Solution;
import com.kndykndy.leetcode.p006_ZigZagConversion.Solution1;
import com.kndykndy.leetcode.p006_ZigZagConversion.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p006_ZigZagConversionTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertNull(solution.convert(null, 0));
            assertNull(solution.convert("whatever", 0));

            assertEquals(solution.convert("", 1), "");
            assertEquals(solution.convert("a", 1), "a");

            assertEquals(solution.convert("PAYPAL", 2), "PYAAPL");
            assertEquals(solution.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
            assertEquals(solution.convert("KNDYLOLOMYRABMBL", 4), "KLBNOOAMDLMRBYYL");
            assertEquals(solution.convert("KNDYKNDYKNDYKNDY", 4), "KDKNNYYNDKKDDYNY");
            assertEquals(solution.convert("ABCDEF", 4), "ABFCED");
        }
    }
}
