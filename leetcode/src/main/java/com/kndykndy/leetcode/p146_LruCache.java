package com.kndykndy.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class p146_LruCache {

    public static class LRUCache {

        private final int capacity;
        private final Deque<Integer> entries = new LinkedList<>();
        private final Map<Integer, Integer> keyValueMap = new HashMap<>();

        LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int result = -1;

            final Integer value = keyValueMap.get(key);
            if (value != null) {
                result = value;

                Integer tempKey;
                final Iterator<Integer> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    tempKey = iterator.next();
                    if (tempKey == key) {
                        iterator.remove();
                        entries.addLast(tempKey);

                        break;
                    }
                }
            }

            return result;
        }

        public void put(int key, int value) {
            if (get(key) == -1) {
                if (keyValueMap.size() == capacity) { // evict leftmost (less used) item
                    keyValueMap.remove(entries.getFirst());
                    entries.pollFirst();
                }

                entries.addLast(key); // insert new entry at end
            }

            keyValueMap.put(key, value);
        }
    }
}
