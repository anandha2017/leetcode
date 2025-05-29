package Leet0202_HappyNumber;

import Leet0202_HappyNumber.Soln.Solution;

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

    private static boolean assertSolution(int input, boolean expected) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        boolean output = solution.isHappy(input);

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
        assertSolution(1, true);
        assertSolution(7, true);
        assertSolution(2, false);
        assertSolution(19, true);

        // === BASIC TEST CASES ===
        assertSolution(1, true); // Base case - already 1
        assertSolution(7, true); // Single digit happy
        assertSolution(10, true); // Power of 10
        assertSolution(19, true); // Classic example

        // === SINGLE DIGIT COMPREHENSIVE ===
        assertSolution(1, true);
        assertSolution(2, false);
        assertSolution(3, false);
        assertSolution(4, false);
        assertSolution(5, false);
        assertSolution(6, false);
        assertSolution(7, true);
        assertSolution(8, false);
        assertSolution(9, false);

        // === SMALL HAPPY NUMBERS ===
        assertSolution(13, true);
        assertSolution(19, true);
        assertSolution(23, true);
        assertSolution(28, true);
        assertSolution(31, true);
        assertSolution(32, true);
        assertSolution(44, true);
        assertSolution(49, true);
        assertSolution(68, true);
        assertSolution(70, true);
        assertSolution(79, true);
        assertSolution(82, true);
        assertSolution(86, true);
        assertSolution(91, true);
        assertSolution(94, true);
        assertSolution(97, true);
        assertSolution(100, true);

        // === SMALL UNHAPPY NUMBERS ===
        assertSolution(11, false);
        assertSolution(12, false);
        assertSolution(14, false);
        assertSolution(15, false);
        assertSolution(16, false);
        assertSolution(17, false);
        assertSolution(18, false);
        assertSolution(20, false);
        assertSolution(21, false);
        assertSolution(22, false);
        assertSolution(24, false);
        assertSolution(25, false);
        assertSolution(26, false);
        assertSolution(27, false);
        assertSolution(29, false);
        assertSolution(30, false);

        // === POWERS OF 10 (Always Happy) ===
        assertSolution(1000, true);
        assertSolution(10000, true);
        assertSolution(100000, true);
        assertSolution(1000000, true);
        assertSolution(1000000000, true);

        // === LARGER HAPPY NUMBERS ===
        assertSolution(130, true);
        assertSolution(133, true);
        assertSolution(139, true);
        assertSolution(167, true);
        assertSolution(176, true);
        assertSolution(188, true);
        assertSolution(190, true);
        assertSolution(193, true);
        assertSolution(203, true);
        assertSolution(208, true);
        assertSolution(219, true);
        assertSolution(226, true);
        assertSolution(230, true);
        assertSolution(236, true);
        assertSolution(239, true);
        assertSolution(262, true);
        assertSolution(263, true);
        assertSolution(280, true);
        assertSolution(291, true);
        assertSolution(293, true);

        // === NUMBERS FROM MAIN UNHAPPY CYCLE ===
        assertSolution(4, false); // 4→16→37→58→89→145→42→20→4
        assertSolution(16, false);
        assertSolution(37, false);
        assertSolution(58, false);
        assertSolution(89, false);
        assertSolution(145, false);
        assertSolution(42, false);
        assertSolution(20, false);

        // === REPEATED DIGIT PATTERNS ===
        assertSolution(11, false);
        assertSolution(22, false);
        assertSolution(33, false);
        assertSolution(44, true); // Interesting exception!
        assertSolution(55, false);
        assertSolution(66, false);
        assertSolution(77, false); // 7 is happy but 77 isn't
        assertSolution(88, false);
        assertSolution(99, false);
        assertSolution(111, false);
        assertSolution(222, false);
        assertSolution(333, false);
        assertSolution(444, false);
        assertSolution(555, false);
        assertSolution(777, false);
        assertSolution(999, false);

        // === LARGE NUMBERS ===
        assertSolution(123456, true);
        assertSolution(654321, true);
        assertSolution(999999, false);
        assertSolution(1000001, false);
        assertSolution(9999999, false);
        assertSolution(10000001, false);

        // === CONSTRAINT BOUNDARY ===
        assertSolution(2147483647, false); // Maximum 32-bit integer
        assertSolution(2000000000, false); // Near maximum
    }
}
