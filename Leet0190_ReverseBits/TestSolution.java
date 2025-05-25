package Leet0190_ReverseBits;

public class TestSolution {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static boolean assertSolution(int input, int expected) {

        Solution solution = new Solution();

        int output = solution.reverseBits(input);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " +
                        "- Output: " + output +
                        ", Expected: " + expected +
                        ", input: " + input);

        return assertPass;
    }

    public static void main(String[] args) {
        assertSolution(12, 805306368);
        assertSolution(43261596, 964176192);

        // Edge Cases - Special Values
        assertSolution(0, 0); // All zeros
        assertSolution(-1, -1); // All ones (0xFFFFFFFF)
        assertSolution(1, -2147483648); // Only LSB set -> Only MSB set
        assertSolution(-2147483648, 1); // Only MSB set -> Only LSB set

        // Powers of 2 - Single Bit Set
        assertSolution(2, 1073741824); // Bit 1 -> Bit 30
        assertSolution(4, 536870912); // Bit 2 -> Bit 29
        assertSolution(8, 268435456); // Bit 3 -> Bit 28
        assertSolution(16, 134217728); // Bit 4 -> Bit 27
        assertSolution(32, 67108864); // Bit 5 -> Bit 26
        assertSolution(64, 33554432); // Bit 6 -> Bit 25
        assertSolution(128, 16777216); // Bit 7 -> Bit 24
        assertSolution(256, 8388608); // Bit 8 -> Bit 23
        assertSolution(512, 4194304); // Bit 9 -> Bit 22
        assertSolution(1024, 2097152); // Bit 10 -> Bit 21
        assertSolution(2048, 1048576); // Bit 11 -> Bit 20
        assertSolution(4096, 524288); // Bit 12 -> Bit 19
        assertSolution(8192, 262144); // Bit 13 -> Bit 18
        assertSolution(16384, 131072); // Bit 14 -> Bit 17
        assertSolution(32768, 65536); // Bit 15 -> Bit 16
        assertSolution(65536, 32768); // Bit 16 -> Bit 15
        assertSolution(1073741824, 2); // Bit 30 -> Bit 1

        // Pattern Testing - Regular Numbers
        assertSolution(12, 805306368); // 1100 -> 00110000...
        assertSolution(43261596, 964176192); // LeetCode example 1
        assertSolution(-3, -1073741825); // LeetCode example 2 (0xFFFFFFFD)

        // Alternating Patterns
        assertSolution(170, 1426063360); // 10101010 pattern
        assertSolution(85, -1442840576); // 01010101 pattern

        // Small Numbers
        assertSolution(3, -1073741824); // 11 -> 11000000...
        assertSolution(5, -1610612736); // 101 -> 10100000...
        assertSolution(7, -536870912); // 111 -> 11100000...
        assertSolution(9, -1879048192); // 1001 -> 10010000...
        assertSolution(15, -268435456); // 1111 -> 11110000...

        // Byte Boundaries
        assertSolution(255, -16777216); // 0xFF -> 0xFF000000
        assertSolution(65535, -65536); // 0xFFFF -> 0xFFFF0000
        assertSolution(16777215, -256); // 0xFFFFFF -> 0xFFFFFF00

        // High-Value Positive Numbers
        assertSolution(2147483647, -2); // Max int (0x7FFFFFFF) -> 0xFFFFFFFE
        assertSolution(1073741823, -4); // 0x3FFFFFFF -> 0xFFFFFFFC
        assertSolution(536870911, -8); // 0x1FFFFFFF -> 0xFFFFFFF8

        // Negative Numbers (Two's Complement)
        assertSolution(-2, 2147483647); // 0xFFFFFFFE -> 0x7FFFFFFF
        assertSolution(-4, 1073741823); // 0xFFFFFFFC -> 0x3FFFFFFF
        assertSolution(-8, 536870911); // 0xFFFFFFF8 -> 0x1FFFFFFF
        assertSolution(-256, 16777215); // 0xFFFFFF00 -> 0x00FFFFFF
        assertSolution(-65536, 65535); // 0xFFFF0000 -> 0x0000FFFF
        assertSolution(-16777216, 255); // 0xFF000000 -> 0x000000FF

        // Mixed Bit Patterns
        assertSolution(291, -998244352); // 100100011
        assertSolution(547, -1002438656); // 1000100011
        assertSolution(1365, -1432354816); // 10101010101
        assertSolution(2730, 1431306240); // 101010101010
    }
}
