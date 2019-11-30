package com.kndykndy.epi.primitivetypes;

import static com.kndykndy.epi.primitivetypes.BootCamp.binarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BootCampTest {

    @Test
    void testBinarySearch() {
        // odd amount

        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertEquals(0, binarySearch(ints, 1));
        assertEquals(1, binarySearch(ints, 2));
        assertEquals(2, binarySearch(ints, 3));
        assertEquals(3, binarySearch(ints, 4));
        assertEquals(4, binarySearch(ints, 5));
        assertEquals(5, binarySearch(ints, 6));
        assertEquals(6, binarySearch(ints, 7));
        assertEquals(-1, binarySearch(ints, 0));

        assertEquals(4, binarySearch(new int[]{1, 4, 6, 8, 9, 13, 15, 17, 25, 27, 29}, 9));

        ints = new int[]{1, 3, 5};
        assertEquals(0, binarySearch(ints, 1));
        assertEquals(1, binarySearch(ints, 3));
        assertEquals(2, binarySearch(ints, 5));

        ints = new int[]{2, 7, 8, 9, 20};
        assertEquals(0, binarySearch(ints, 2));
        assertEquals(1, binarySearch(ints, 7));
        assertEquals(2, binarySearch(ints, 8));
        assertEquals(3, binarySearch(ints, 9));
        assertEquals(4, binarySearch(ints, 20));
        assertEquals(-1, binarySearch(ints, 0));

        // even amounts

        ints = new int[]{1, 2, 3, 4, 5, 6};
        assertEquals(0, binarySearch(ints, 1));
        assertEquals(1, binarySearch(ints, 2));
        assertEquals(2, binarySearch(ints, 3));
        assertEquals(3, binarySearch(ints, 4));
        assertEquals(4, binarySearch(ints, 5));
        assertEquals(5, binarySearch(ints, 6));
        assertEquals(-1, binarySearch(ints, 0));

        assertEquals(4, binarySearch(new int[]{1, 4, 6, 8, 9, 13, 15, 17, 25, 27}, 9));

        ints = new int[]{1, 3, 5, 8};
        assertEquals(0, binarySearch(ints, 1));
        assertEquals(1, binarySearch(ints, 3));
        assertEquals(2, binarySearch(ints, 5));
        assertEquals(3, binarySearch(ints, 8));
        assertEquals(-1, binarySearch(ints, 0));
    }

    @Test
    void testPartialBinarySearch() {
        // odd amount

        int[] ints = new int[]{1, 2, 3};
        assertEquals(0, binarySearch(ints, 1, 0, 2));
        assertEquals(1, binarySearch(ints, 2, 0, 2));
        assertEquals(2, binarySearch(ints, 3, 0, 2));

        ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertEquals(0, binarySearch(ints, 1, 0, 6));
        assertEquals(2, binarySearch(ints, 3, 1, 5));
        assertEquals(4, binarySearch(ints, 5, 2, 4));
        assertEquals(3, binarySearch(ints, 4, 3, 3));
        assertEquals(-1, binarySearch(ints, 0, 0, 6));

        // even amounts

        ints = new int[]{1, 2, 3, 4, 5, 6};
        assertEquals(0, binarySearch(ints, 1, 0, 5));
        assertEquals(5, binarySearch(ints, 6, 0, 5));
        assertEquals(1, binarySearch(ints, 2, 1, 4));
        assertEquals(4, binarySearch(ints, 5, 1, 4));
        assertEquals(2, binarySearch(ints, 3, 2, 3));
        assertEquals(3, binarySearch(ints, 4, 2, 3));

        assertEquals(-1, binarySearch(ints, 0, 0, 5));
    }
}
