package Leet0191_NumberOf1Bits;

import Leet0191_NumberOf1Bits.Soln.Solution;

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

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        int output = solution.hammingWeight(input);

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
        assertSolution(11, 3);
        assertSolution(128, 1);

        // Basic single bit cases
        assertSolution(1, 1); // 00000001
        assertSolution(2, 1); // 00000010
        assertSolution(4, 1); // 00000100
        assertSolution(8, 1); // 00001000
        assertSolution(16, 1); // 00010000
        assertSolution(32, 1); // 00100000
        assertSolution(64, 1); // 01000000
        assertSolution(128, 1); // 10000000

        // Powers of 2 (larger)
        assertSolution(256, 1); // 100000000
        assertSolution(512, 1); // 1000000000
        assertSolution(1024, 1); // 10000000000
        assertSolution(2048, 1); // 100000000000
        assertSolution(4096, 1); // 1000000000000
        assertSolution(8192, 1); // 10000000000000
        assertSolution(16384, 1); // 100000000000000
        assertSolution(32768, 1); // 1000000000000000
        assertSolution(65536, 1); // 10000000000000000
        assertSolution(131072, 1); // 100000000000000000
        assertSolution(262144, 1); // 1000000000000000000
        assertSolution(524288, 1); // 10000000000000000000
        assertSolution(1048576, 1); // 100000000000000000000
        assertSolution(2097152, 1); // 1000000000000000000000
        assertSolution(4194304, 1); // 10000000000000000000000
        assertSolution(8388608, 1); // 100000000000000000000000
        assertSolution(16777216, 1); // 1000000000000000000000000
        assertSolution(33554432, 1); // 10000000000000000000000000
        assertSolution(67108864, 1); // 100000000000000000000000000
        assertSolution(134217728, 1); // 1000000000000000000000000000
        assertSolution(268435456, 1); // 10000000000000000000000000000
        assertSolution(536870912, 1); // 100000000000000000000000000000
        assertSolution(1073741824, 1); // 1000000000000000000000000000000

        // Multiple consecutive bits
        assertSolution(3, 2); // 00000011
        assertSolution(7, 3); // 00000111
        assertSolution(15, 4); // 00001111
        assertSolution(31, 5); // 00011111
        assertSolution(63, 6); // 00111111
        assertSolution(127, 7); // 01111111
        assertSolution(255, 8); // 11111111
        assertSolution(511, 9); // 111111111
        assertSolution(1023, 10); // 1111111111
        assertSolution(2047, 11); // 11111111111
        assertSolution(4095, 12); // 111111111111
        assertSolution(8191, 13); // 1111111111111
        assertSolution(16383, 14); // 11111111111111
        assertSolution(32767, 15); // 111111111111111
        assertSolution(65535, 16); // 1111111111111111

        // Alternating patterns
        assertSolution(5, 2); // 00000101
        assertSolution(10, 2); // 00001010
        assertSolution(21, 3); // 00010101
        assertSolution(42, 3); // 00101010
        assertSolution(85, 4); // 01010101
        assertSolution(170, 4); // 10101010
        assertSolution(341, 5); // 101010101
        assertSolution(682, 5); // 1010101010
        assertSolution(1365, 6); // 10101010101
        assertSolution(2730, 6); // 101010101010
        assertSolution(5461, 7); // 1010101010101
        assertSolution(10922, 7); // 10101010101010
        assertSolution(21845, 8); // 101010101010101
        assertSolution(43690, 8); // 1010101010101010
        assertSolution(87381, 9); // 10101010101010101
        assertSolution(174762, 9); // 101010101010101010
        assertSolution(349525, 10); // 1010101010101010101
        assertSolution(699050, 10); // 10101010101010101010
        assertSolution(1398101, 11); // 101010101010101010101

        // Sparse patterns
        assertSolution(9, 2); // 00001001
        assertSolution(17, 2); // 00010001
        assertSolution(33, 2); // 00100001
        assertSolution(65, 2); // 01000001
        assertSolution(129, 2); // 10000001
        assertSolution(257, 2); // 100000001
        assertSolution(513, 2); // 1000000001
        assertSolution(1025, 2); // 10000000001
        assertSolution(2049, 2); // 100000000001
        assertSolution(4097, 2); // 1000000000001
        assertSolution(8193, 2); // 10000000000001
        assertSolution(16385, 2); // 100000000000001
        assertSolution(32769, 2); // 1000000000000001
        assertSolution(65537, 2); // 10000000000000001
        assertSolution(131073, 2); // 100000000000000001
        assertSolution(262145, 2); // 1000000000000000001
        assertSolution(524289, 2); // 10000000000000000001
        assertSolution(1048577, 2); // 100000000000000000001
        assertSolution(2097153, 2); // 1000000000000000000001
        assertSolution(4194305, 2); // 10000000000000000000001
        assertSolution(8388609, 2); // 100000000000000000000001
        assertSolution(16777217, 2); // 1000000000000000000000001
        assertSolution(33554433, 2); // 10000000000000000000000001
        assertSolution(67108865, 2); // 100000000000000000000000001
        assertSolution(134217729, 2); // 1000000000000000000000000001
        assertSolution(268435457, 2); // 10000000000000000000000000001
        assertSolution(536870913, 2); // 100000000000000000000000000001
        assertSolution(1073741825, 2); // 1000000000000000000000000000001

        // Mixed density patterns
        assertSolution(11, 3); // 00001011
        assertSolution(13, 3); // 00001101
        assertSolution(14, 3); // 00001110
        assertSolution(19, 3); // 00010011
        assertSolution(22, 3); // 00010110
        assertSolution(25, 3); // 00011001
        assertSolution(26, 3); // 00011010
        assertSolution(28, 3); // 00011100
        assertSolution(35, 3); // 00100011
        assertSolution(37, 3); // 00100101
        assertSolution(38, 3); // 00100110
        assertSolution(41, 3); // 00101001
        assertSolution(44, 3); // 00101100
        assertSolution(49, 3); // 00110001
        assertSolution(50, 3); // 00110010
        assertSolution(52, 3); // 00110100
        assertSolution(56, 3); // 00111000
        assertSolution(67, 3); // 01000011
        assertSolution(69, 3); // 01000101
        assertSolution(70, 3); // 01000110
        assertSolution(73, 3); // 01001001
        assertSolution(76, 3); // 01001100
        assertSolution(81, 3); // 01010001
        assertSolution(82, 3); // 01010010
        assertSolution(84, 3); // 01010100
        assertSolution(88, 3); // 01011000
        assertSolution(97, 3); // 01100001
        assertSolution(98, 3); // 01100010
        assertSolution(100, 3); // 01100100
        assertSolution(104, 3); // 01101000
        assertSolution(112, 3); // 01110000
        assertSolution(131, 3); // 10000011
        assertSolution(133, 3); // 10000101
        assertSolution(134, 3); // 10000110
        assertSolution(137, 3); // 10001001
        assertSolution(140, 3); // 10001100
        assertSolution(145, 3); // 10010001
        assertSolution(146, 3); // 10010010
        assertSolution(148, 3); // 10010100
        assertSolution(152, 3); // 10011000
        assertSolution(161, 3); // 10100001
        assertSolution(162, 3); // 10100010
        assertSolution(164, 3); // 10100100
        assertSolution(168, 3); // 10101000
        assertSolution(176, 3); // 10110000
        assertSolution(193, 3); // 11000001
        assertSolution(194, 3); // 11000010
        assertSolution(196, 3); // 11000100
        assertSolution(200, 3); // 11001000
        assertSolution(208, 3); // 11010000
        assertSolution(224, 3); // 11100000

        // Higher density patterns (4-8 bits)
        assertSolution(23, 4); // 00010111
        assertSolution(27, 4); // 00011011
        assertSolution(29, 4); // 00011101
        assertSolution(30, 4); // 00011110
        assertSolution(39, 4); // 00100111
        assertSolution(43, 4); // 00101011
        assertSolution(45, 4); // 00101101
        assertSolution(46, 4); // 00101110
        assertSolution(51, 4); // 00110011
        assertSolution(53, 4); // 00110101
        assertSolution(54, 4); // 00110110
        assertSolution(57, 4); // 00111001
        assertSolution(58, 4); // 00111010
        assertSolution(60, 4); // 00111100
        assertSolution(71, 4); // 01000111
        assertSolution(75, 4); // 01001011
        assertSolution(77, 4); // 01001101
        assertSolution(78, 4); // 01001110
        assertSolution(83, 4); // 01010011
        assertSolution(86, 4); // 01010110
        assertSolution(89, 4); // 01011001
        assertSolution(90, 4); // 01011010
        assertSolution(92, 4); // 01011100
        assertSolution(99, 4); // 01100011
        assertSolution(101, 4); // 01100101
        assertSolution(102, 4); // 01100110
        assertSolution(105, 4); // 01101001
        assertSolution(106, 4); // 01101010
        assertSolution(108, 4); // 01101100
        assertSolution(113, 4); // 01110001
        assertSolution(114, 4); // 01110010
        assertSolution(116, 4); // 01110100
        assertSolution(120, 4); // 01111000
        assertSolution(135, 4); // 10000111
        assertSolution(139, 4); // 10001011
        assertSolution(141, 4); // 10001101
        assertSolution(142, 4); // 10001110
        assertSolution(147, 4); // 10010011
        assertSolution(149, 4); // 10010101
        assertSolution(150, 4); // 10010110
        assertSolution(153, 4); // 10011001
        assertSolution(154, 4); // 10011010
        assertSolution(156, 4); // 10011100
        assertSolution(163, 4); // 10100011
        assertSolution(165, 4); // 10100101
        assertSolution(166, 4); // 10100110
        assertSolution(169, 4); // 10101001
        assertSolution(172, 4); // 10101100
        assertSolution(177, 4); // 10110001
        assertSolution(178, 4); // 10110010
        assertSolution(180, 4); // 10110100
        assertSolution(184, 4); // 10111000
        assertSolution(195, 4); // 11000011
        assertSolution(197, 4); // 11000101
        assertSolution(198, 4); // 11000110
        assertSolution(201, 4); // 11001001
        assertSolution(202, 4); // 11001010
        assertSolution(204, 4); // 11001100
        assertSolution(209, 4); // 11010001
        assertSolution(210, 4); // 11010010
        assertSolution(212, 4); // 11010100
        assertSolution(216, 4); // 11011000
        assertSolution(225, 4); // 11100001
        assertSolution(226, 4); // 11100010
        assertSolution(228, 4); // 11100100
        assertSolution(232, 4); // 11101000
        assertSolution(240, 4); // 11110000

        // Edge cases - maximum constraint boundaries
        assertSolution(2147483647, 31); // Integer.MAX_VALUE: 01111111111111111111111111111111

        // Negative numbers (32-bit two's complement)
        assertSolution(-1, 32); // 11111111111111111111111111111111
        assertSolution(-2, 31); // 11111111111111111111111111111110
        assertSolution(-3, 31); // 11111111111111111111111111111101
        assertSolution(-4, 30); // 11111111111111111111111111111100
        assertSolution(-5, 31); // 11111111111111111111111111111011
        assertSolution(-8, 29); // 11111111111111111111111111111000
        assertSolution(-16, 28); // 11111111111111111111111111110000
        assertSolution(-32, 27); // 11111111111111111111111111100000
        assertSolution(-64, 26); // 11111111111111111111111111000000
        assertSolution(-128, 25); // 11111111111111111111111110000000
        assertSolution(-256, 24); // 11111111111111111111111100000000
        assertSolution(-512, 23); // 11111111111111111111111000000000
        assertSolution(-1024, 22); // 11111111111111111111110000000000
        assertSolution(-2048, 21); // 11111111111111111111100000000000
        assertSolution(-4096, 20); // 11111111111111111111000000000000
        assertSolution(-8192, 19); // 11111111111111111110000000000000
        assertSolution(-16384, 18); // 11111111111111111100000000000000
        assertSolution(-32768, 17); // 11111111111111111000000000000000
        assertSolution(-65536, 16); // 11111111111111110000000000000000
        assertSolution(-131072, 15); // 11111111111111100000000000000000
        assertSolution(-262144, 14); // 11111111111111000000000000000000
        assertSolution(-524288, 13); // 11111111111110000000000000000000
        assertSolution(-1048576, 12); // 11111111111100000000000000000000
        assertSolution(-2097152, 11); // 11111111111000000000000000000000
        assertSolution(-4194304, 10); // 11111111110000000000000000000000
        assertSolution(-8388608, 9); // 11111111100000000000000000000000
        assertSolution(-16777216, 8); // 11111111000000000000000000000000
        assertSolution(-33554432, 7); // 11111110000000000000000000000000
        assertSolution(-67108864, 6); // 11111100000000000000000000000000
        assertSolution(-134217728, 5); // 11111000000000000000000000000000
        assertSolution(-268435456, 4); // 11110000000000000000000000000000
        assertSolution(-536870912, 3); // 11100000000000000000000000000000
        assertSolution(-1073741824, 2); // 11000000000000000000000000000000
        assertSolution(-2147483648, 1); // Integer.MIN_VALUE: 10000000000000000000000000000000

    }
}
