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
    }
}
