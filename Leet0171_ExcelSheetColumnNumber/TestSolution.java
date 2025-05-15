package Leet0171_ExcelSheetColumnNumber;

import Leet0171_ExcelSheetColumnNumber.Soln.Solution;

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

    private static boolean assertSolution(String columnTitle, int expected) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        int output = solution.titleToNumber(columnTitle);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " +
                        "- Output: " + output +
                        ", Expected: " + expected +
                        ", ColumnTitle: " + columnTitle);

        return assertPass;
    }

    public static void main(String[] args) {
        // Basic single-character cases
        assertSolution("A", 1);
        assertSolution("B", 2);
        assertSolution("Z", 26);

        // Two-character cases
        assertSolution("AA", 27);
        assertSolution("AB", 28);
        assertSolution("AZ", 52);
        assertSolution("BA", 53);
        assertSolution("BZ", 78);
        assertSolution("YZ", 676);
        assertSolution("ZY", 701);
        assertSolution("ZZ", 702);

        // Three-character cases
        assertSolution("AAA", 703);
        assertSolution("AAZ", 728);
        assertSolution("ABA", 729);
        assertSolution("ZZZ", 18278);

        // Four-character cases
        assertSolution("AAAA", 18279);
        assertSolution("ZZZZ", 475254);

        // Five-character cases
        assertSolution("AAAAA", 475255);

        // Boundary cases
        assertSolution("FXSHRXW", Integer.MAX_VALUE); // 2^31 - 1 = 2,147,483,647

        // Edge cases - transitions between character lengths
        assertSolution("Z", 26); // Last 1-char
        assertSolution("AA", 27); // First 2-char
        assertSolution("ZZ", 702); // Last 2-char
        assertSolution("AAA", 703); // First 3-char
        assertSolution("ZZZ", 18278); // Last 3-char
        assertSolution("AAAA", 18279); // First 4-char

        // Additional test cases for better coverage
        assertSolution("C", 3); // Early alphabet
        assertSolution("Y", 25); // Late alphabet
        assertSolution("AC", 29); // Mixed characters
        assertSolution("BX", 76); // Mixed characters
        assertSolution("CZ", 104); // Mixed characters
        assertSolution("DA", 105); // Number after transition
        assertSolution("XYZ", 16900); // Mixed characters, three-digit
        assertSolution("ABC", 731); // Sequential characters
        assertSolution("AZZ", 1378); // Mixed pattern
        assertSolution("RUZL", 331252); // Random mixed pattern

    }
}
