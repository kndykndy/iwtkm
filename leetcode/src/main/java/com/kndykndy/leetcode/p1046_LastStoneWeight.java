package com.kndykndy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p1046_LastStoneWeight {

    interface Solution {

        int lastStoneWeight(int[] stones);
    }

    public static class Solution1 implements Solution {

        @Override
        public int lastStoneWeight(int[] stones) {
            if (stones == null || stones.length == 0) {
                return 0;
            }
            if (stones.length == 1) {
                return stones[0];
            }

            final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                pq.add(stone);
            }

            int s1, s2;
            while (pq.size() > 1) {
                s1 = pq.poll();
                s2 = pq.poll();
                if (s1 != s2) {
                    pq.add(s1 - s2);
                }
            }

            return pq.size() == 1 ? pq.poll() : 0;
        }
    }
}
