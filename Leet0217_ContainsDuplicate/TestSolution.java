package Leet0217_ContainsDuplicate;

import java.util.Arrays;

import Leet0217_ContainsDuplicate.Soln.Solution;

public class TestSolution {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";
    private static final int MAX_STRING_LENGTH = 50;

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static String truncateStr(String s, int maxLength) {
        if (s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength - 3) + "...";
    }

    private static String truncateStr(String s) {
        return truncateStr(s, MAX_STRING_LENGTH);
    }

    private static boolean assertSolution(int[] input, boolean expected, String testName) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        boolean output = solution.containsDuplicate(input);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(formattedResult + ": " + testName + ", Input: " + truncateStr(Arrays.toString(input))
                + ", Output: " + output + ", Expected: " + expected);

        return assertPass;
    }

    public static void main(String[] args) {
        // Minimum size array (constraint: 1 <= nums.length)
        assertSolution(new int[] { 1 }, false, "Single element");

        // Basic duplicate cases
        assertSolution(new int[] { 1, 2, 3, 1 }, true, "Basic duplicate");
        assertSolution(new int[] { 1, 2, 3, 4 }, false, "No duplicates");

        // Minimum duplicate case
        assertSolution(new int[] { 5, 5 }, true, "Two identical elements");
        assertSolution(new int[] { 7, 8 }, false, "Two different elements");

        // Adjacent duplicates
        assertSolution(new int[] { 1, 1 }, true, "Adjacent duplicates");
        assertSolution(new int[] { 3, 3, 4, 5 }, true, "Adjacent duplicates at start");
        assertSolution(new int[] { 1, 2, 3, 3 }, true, "Adjacent duplicates at end");
        assertSolution(new int[] { 1, 2, 2, 3 }, true, "Adjacent duplicates in middle");

        // Non-adjacent duplicates
        assertSolution(new int[] { 1, 2, 3, 1 }, true, "Non-adjacent duplicates");
        assertSolution(new int[] { 1, 3, 5, 7, 3 }, true, "Non-adjacent duplicates far apart");

        // Multiple duplicates
        assertSolution(new int[] { 1, 2, 1, 2 }, true, "Multiple pairs of duplicates");
        assertSolution(new int[] { 1, 1, 2, 2, 3, 3 }, true, "Multiple adjacent pairs");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, true, "Multiple non-adjacent duplicates");

        // All same elements
        assertSolution(new int[] { 7, 7, 7 }, true, "All elements same - three");
        assertSolution(new int[] { 0, 0, 0, 0, 0 }, true, "All elements same - five");

        // Zero values
        assertSolution(new int[] { 0 }, false, "Single zero");
        assertSolution(new int[] { 0, 0 }, true, "Two zeros");
        assertSolution(new int[] { 0, 1, 2, 0 }, true, "Zero duplicates");
        assertSolution(new int[] { 0, 1, 2, 3 }, false, "Zero with no duplicates");

        // Negative numbers (constraint: -10^9 <= nums[i])
        assertSolution(new int[] { -1 }, false, "Single negative");
        assertSolution(new int[] { -1, -1 }, true, "Negative duplicates");
        assertSolution(new int[] { -1, -2, -3, -1 }, true, "Negative with duplicates");
        assertSolution(new int[] { -1, -2, -3, -4 }, false, "Negative without duplicates");

        // Mixed positive and negative
        assertSolution(new int[] { -1, 0, 1, -1 }, true, "Mixed with negative duplicate");
        assertSolution(new int[] { -1, 0, 1, 2 }, false, "Mixed without duplicates");
        assertSolution(new int[] { -5, -3, 0, 3, 5 }, false, "Symmetric without duplicates");
        assertSolution(new int[] { -5, -3, 0, 3, 5, -5 }, true, "Symmetric with duplicate");

        // Boundary values (constraint: -10^9 <= nums[i] <= 10^9)
        assertSolution(new int[] { 1000000000 }, false, "Max value single");
        assertSolution(new int[] { 1000000000, 1000000000 }, true, "Max value duplicate");
        assertSolution(new int[] { -1000000000 }, false, "Min value single");
        assertSolution(new int[] { -1000000000, -1000000000 }, true, "Min value duplicate");
        assertSolution(new int[] { -1000000000, 1000000000 }, false, "Min and max values");
        assertSolution(new int[] { -1000000000, 0, 1000000000, -1000000000 }, true, "Boundary with duplicate");

        // Large arrays (approaching constraint: nums.length <= 10^5)
        // Testing different positions of duplicates in larger arrays
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, false, "Medium array no duplicates");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, true, "Medium array duplicate at end");
        assertSolution(new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9, 10 }, true, "Medium array duplicate at start");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 5, 7, 8, 9, 10 }, true, "Medium array duplicate in middle");

        // Early termination cases (duplicates found early)
        assertSolution(new int[] { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, true, "Early duplicate - position 0,1");
        assertSolution(new int[] { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 }, true, "Early duplicate - position 1,2");

        // Late detection cases (duplicates found late)
        int[] lateArray1 = new int[100];
        for (int i = 0; i < 99; i++)
            lateArray1[i] = i;
        lateArray1[99] = 0; // Duplicate at the very end
        assertSolution(lateArray1, true, "Late duplicate detection");

        int[] lateArray2 = new int[100];
        for (int i = 0; i < 100; i++)
            lateArray2[i] = i;
        assertSolution(lateArray2, false, "Large array no duplicates");

        // Stress test with repeated pattern
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 }, true, "Repeated pattern");

        // Random order duplicates
        assertSolution(new int[] { 5, 1, 9, 3, 7, 5 }, true, "Random order with duplicate");
        assertSolution(new int[] { 5, 1, 9, 3, 7, 2 }, false, "Random order without duplicate");
    }
}
