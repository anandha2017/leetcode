package Leet0190_ReverseBits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        // Process all 32 bits
        for (int i = 0; i < 32; i++) {
            // Extract the rightmost bit of n
            int bit = n & 1;

            // Shift result left to make room for new bit
            result = result << 1;

            // Add the extracted bit to result
            result = result | bit;

            // Move to next bit by shifting n right
            n = n >>> 1;  // unsigned right shift
        }

        return result;
    }

    // Alternative more concise version
    // public int reverseBitsAlternative(int n) {
    //     int result = 0;
    //     for (int i = 0; i < 32; i++) {
    //         result = (result << 1) | (n & 1);
    //         n >>>= 1;
    //     }
    //     return result;
    // }
}