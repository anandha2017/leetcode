package Leet0169_MajorityElement;

import Leet0169_MajorityElement.Soln.Solution;

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

    private static boolean assertSolution(int[] nums, int expected) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        int output = solution.majorityElement(nums);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " +
                        "- Output: " + output +
                        ", Expected: " + expected +
                        ", Input: " + nums.toString());

        return assertPass;
    }

    public static void main(String[] args) {
        assertSolution(new int[] { 3, 2, 3 }, 3);
        assertSolution(new int[] { 2, 2, 1, 1, 1, 2, 2 }, 2);
        assertSolution(new int[] { 8, 8, 7, 7, 7, 7, 7, 7 }, 7);
    }
}