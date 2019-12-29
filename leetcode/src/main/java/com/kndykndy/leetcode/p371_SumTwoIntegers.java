package com.kndykndy.leetcode;

public class p371_SumTwoIntegers {

    interface Solution {

        int getSum(int a, int b);
    }

    public static class Solution1 implements Solution {

        @Override
        public int getSum(int a, int b) {
            int result = 0;

            int abit, bbit, carry = 0, bitIdx = 0;
            while (a != 0 || b != 0 || carry != 0) {
                abit = a & 1;
                bbit = b & 1;

                if (abit == 1 && bbit == 1) {
                    if (carry == 1) {
                        result |= (1 << bitIdx);
                    } else {
                        result &= ~(1 << bitIdx);
                    }
                    carry = 1;
                } else if (abit == 0 && bbit == 0) {
                    if (carry == 1) {
                        result |= (1 << bitIdx);
                    } else {
                        result &= ~(1 << bitIdx);
                    }
                    carry = 0;
                } else { // only one is set
                    if (carry == 1) {
                        result &= ~(1 << bitIdx);
                        carry = 1;
                    } else {
                        result |= (1 << bitIdx);
                        carry = 0;
                    }
                }

                a >>>= 1;
                b >>>= 1;
                bitIdx++;
                if (bitIdx > 31) { // for case like -1+X
                    break;
                }
            }

            return result;
        }
    }
}
