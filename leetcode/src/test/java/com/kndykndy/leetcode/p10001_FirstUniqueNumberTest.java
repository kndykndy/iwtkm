package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p10001_FirstUniqueNumber.FirstUnique;
import org.junit.jupiter.api.Test;

class p10001_FirstUniqueNumberTest {

    @Test
    void test1() {
        final FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        assertEquals(2, firstUnique.showFirstUnique());
        firstUnique.add(5); // the queue is now [2,3,5,5]
        assertEquals(2, firstUnique.showFirstUnique());
        firstUnique.add(2); // the queue is now [2,3,5,5,2]
        assertEquals(3, firstUnique.showFirstUnique());
        firstUnique.add(3); // the queue is now [2,3,5,5,2,3]
        assertEquals(-1, firstUnique.showFirstUnique());
    }

    @Test
    void test2() {
        final FirstUnique firstUnique = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        assertEquals(17, firstUnique.showFirstUnique());
    }
}
