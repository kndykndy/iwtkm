package com.kndykndy.leetcode;

public class p_LoadBalancer {

    interface Solution {

        /**
         * N is 5..100000
         * N[i] 1..10000 ~ i>0
         */
        boolean solution(int[] A);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean solution(int[] A) {
            int len = A.length;

            int idxLeft = 1, idxRight = len - 2;

            // partial sums for group 1, 2 and 3
            int[] pS = new int[]{A[0], 0, A[len - 1]};
            for (int i = idxLeft + 1; i < idxRight; i++) {
                pS[1] += A[i];
            }

            // check right now, e.g. 5 items in total
            if (pS[0] == pS[1] && pS[1] == pS[2]) {
                return true;
            }

            while (idxLeft < idxRight - 1) {
                if (pS[0] < pS[2]) {
                    pS[0] += A[idxLeft];
                    pS[1] -= A[idxLeft + 1];

                    ++idxLeft;
                } else { // ps[2] >= pS[0]
                    pS[2] += A[idxRight];
                    pS[1] -= A[idxRight - 1];

                    --idxRight;
                }

                if (pS[0] == pS[1] && pS[1] == pS[2]) {
                    return true;
                }
            }

            return false;
        }
    }
}
