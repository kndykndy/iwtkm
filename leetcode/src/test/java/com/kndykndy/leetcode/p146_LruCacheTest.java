package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p146_LruCache.LRUCache;
import org.junit.jupiter.api.Test;

class p146_LruCacheTest {

    @Test
    void test1() {
        final LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3); // evicts key 2
        assertEquals(-1, cache.get(2)); // -1 not found
        cache.put(4, 4); // evicts key 1
        assertEquals(-1, cache.get(1)); // -1 not found
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}
