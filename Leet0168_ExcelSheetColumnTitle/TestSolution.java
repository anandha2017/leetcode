package Leet0168_ExcelSheetColumnTitle;

import Leet0168_ExcelSheetColumnTitle.Soln.Solution;

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

    private static boolean assertSolution(int columnNumber, String expected) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        String output = solution.convertToTitle(columnNumber);

        boolean assertPass = output.equals(expected);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " +
                        "- Output: " + (output == null ? "null" : output) +
                        ", Expected: " + expected +
                        ", ColumnNumber: " + columnNumber);

        return assertPass;
    }

    public static void main(String[] args) {
        // Basic single-character cases
        assertSolution(1, "A");
        assertSolution(2, "B");
        assertSolution(26, "Z");

        // Two-character cases
        assertSolution(27, "AA");
        assertSolution(28, "AB");
        assertSolution(52, "AZ");
        assertSolution(53, "BA");
        assertSolution(78, "BZ");
        assertSolution(676, "YZ");
        assertSolution(701, "ZY");
        assertSolution(702, "ZZ");

        // Three-character cases
        assertSolution(703, "AAA");
        assertSolution(728, "AAZ");
        assertSolution(729, "ABA");
        assertSolution(18278, "ZZZ");

        // Four-character cases
        assertSolution(18279, "AAAA");
        assertSolution(475254, "ZZZZ");

        // Five-character cases
        assertSolution(475255, "AAAAA");

        // Boundary cases
        assertSolution(Integer.MAX_VALUE, "FXSHRXW"); // 2^31 - 1 = 2,147,483,647

        // Edge cases - transitions between character lengths
        assertSolution(26, "Z"); // Last 1-char
        assertSolution(27, "AA"); // First 2-char
        assertSolution(702, "ZZ"); // Last 2-char
        assertSolution(703, "AAA"); // First 3-char
        assertSolution(18278, "ZZZ"); // Last 3-char
        assertSolution(18279, "AAAA"); // First 4-char

        // testing Leet0171 Excel Sheet Column Number
       assertSolution(1378, "AZZ");
       assertSolution(331252, "RUZL");
    }
}
