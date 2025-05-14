package Leet0169_MajorityElement;

import java.util.Arrays;

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
                        ", Input: " + Arrays.toString(nums));

        return assertPass;
    }

    public static void main(String[] args) {
        // Basic examples from problem statement
        assertSolution(new int[] { 3, 2, 3 }, 3);
        assertSolution(new int[] { 2, 2, 1, 1, 1, 2, 2 }, 2);

        // Edge cases with minimum array size
        assertSolution(new int[] { 5 }, 5);
        assertSolution(new int[] { -1 }, -1);

        // Even-length arrays
        assertSolution(new int[] { 1, 1 }, 1);
        assertSolution(new int[] { 2, 2, 2, 1 }, 2);
        assertSolution(new int[] { 8, 8, 7, 7, 7, 7, 7, 7 }, 7);

        // Odd-length arrays
        assertSolution(new int[] { 1, 1, 2 }, 1);
        assertSolution(new int[] { 8, 8, 8, 7, 7 }, 8);

        // Boundary value tests
        assertSolution(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, Integer.MAX_VALUE);
        assertSolution(new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, 0 }, Integer.MIN_VALUE);

        // Majority exactly at n/2 + 1 (minimum requirement)
        assertSolution(new int[] { 1, 1, 1, 2, 2 }, 1); // 3 out of 5
        // assertSolution(new int[] { 3, 3, 3, 2, 2, 1 }, 3); // 3 out of 6

        // Larger arrays
        assertSolution(new int[] { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3 }, 1);
        assertSolution(new int[] { 4, 5, 4, 5, 4, 5, 4, 5, 4, 5, 4, 5, 4 }, 4);

        // Negative numbers
        assertSolution(new int[] { -1, -1, -1, 2, 3 }, -1);
        assertSolution(new int[] { -19, -19, -19, -19, 10, 9 }, -19);

        // Mixed positive/negative
        // assertSolution(new int[] { -8, -8, -8, -8, 1, 2, 3, 4 }, -8);
        assertSolution(new int[] { 5, 5, 5, -5, -5, -5, -5, -5 }, -5);

        // All elements are the same
        assertSolution(new int[] { 6, 6, 6, 6, 6 }, 6);

        // Majority with repetitive pattern
        assertSolution(new int[] { 9, 8, 9, 8, 9, 8, 9 }, 9);
    }
}