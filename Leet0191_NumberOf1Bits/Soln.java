package Leet0191_NumberOf1Bits;

public class Soln {

    class Solution {
        public int hammingWeight(int n) {

            int result = 0;
            int count = 0;

            for (int i = 0; i < 32; i++) {
                int bit = n & 1;
                if (bit == 1) {
                    count++;
                }
                result = result << 1;
                result = result | bit;
                n = n >>> 1;
            }
            return count;
        }

        public int hammingWeightClaude(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>>= 1;
            }
            return count;
        }
    }
}