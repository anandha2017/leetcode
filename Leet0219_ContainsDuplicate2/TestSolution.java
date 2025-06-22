package Leet0219_ContainsDuplicate2;

import java.util.Arrays;

import Leet0219_ContainsDuplicate2.Soln.Solution;

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

    private static boolean assertSolution(int[] input, int k, boolean expected, String testName) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        boolean output = solution.containsNearbyDuplicate(input, k);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(formattedResult + ": " + testName + ", Input: " + truncateStr(Arrays.toString(input))
                + ", k: " + k + ", Output: " + output + ", Expected: " + expected);

        return assertPass;
    }

    public static void main(String[] args) {
        // Basic examples from problem statement
        assertSolution(new int[] { 1, 2, 3, 1 }, 3, true, "example_1_basic_case");
        assertSolution(new int[] { 1, 0, 1, 1 }, 1, true, "example_2_adjacent_duplicates");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, 2, false, "example_3_distance_too_far");

        // Edge case: Single element
        assertSolution(new int[] { 1 }, 1, false, "single_element_k1");
        assertSolution(new int[] { 1 }, 0, false, "single_element_k0");

        // Edge case: Two identical elements
        assertSolution(new int[] { 1, 1 }, 0, false, "two_identical_k0_fail");
        assertSolution(new int[] { 1, 1 }, 1, true, "two_identical_k1_pass");
        assertSolution(new int[] { 1, 1 }, 2, true, "two_identical_k2_pass");

        // Edge case: Two different elements
        assertSolution(new int[] { 1, 2 }, 0, false, "two_different_k0");
        assertSolution(new int[] { 1, 2 }, 1, false, "two_different_k1");

        // k = 0 cases (only adjacent identical elements qualify)
        assertSolution(new int[] { 1, 2, 1 }, 0, false, "k0_non_adjacent_duplicates");
        assertSolution(new int[] { 2, 2 }, 0, false, "k0_adjacent_identical_fail");
        assertSolution(new int[] { 3, 3, 3 }, 0, false, "k0_three_identical_fail");

        // Adjacent duplicates with various k values
        assertSolution(new int[] { 5, 5 }, 1, true, "adjacent_duplicates_k1");
        assertSolution(new int[] { 7, 8, 7 }, 1, false, "gap_one_k1_fail");
        assertSolution(new int[] { 7, 8, 7 }, 2, true, "gap_one_k2_pass");

        // Multiple duplicates within range
        assertSolution(new int[] { 1, 2, 1, 3, 1 }, 2, true, "multiple_duplicates_within_range");
        assertSolution(new int[] { 1, 2, 3, 1, 2 }, 3, true, "multiple_pairs_valid");

        // Multiple duplicates outside range
        assertSolution(new int[] { 1, 2, 3, 4, 1 }, 3, false, "duplicate_at_distance_4_k3");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 1 }, 4, false, "duplicate_at_distance_5_k4");

        // All unique elements
        assertSolution(new int[] { 1, 2, 3, 4, 5 }, 2, false, "all_unique_small_k");
        assertSolution(new int[] { 1, 2, 3, 4, 5 }, 10, false, "all_unique_large_k");

        // All same elements
        assertSolution(new int[] { 5, 5, 5, 5 }, 1, true, "all_same_k1");
        assertSolution(new int[] { 5, 5, 5, 5 }, 2, true, "all_same_k2");
        assertSolution(new int[] { 5, 5, 5, 5 }, 0, false, "all_same_k0");

        // Large k values (larger than array length)
        assertSolution(new int[] { 1, 2, 1 }, 100, true, "large_k_with_duplicates");
        assertSolution(new int[] { 1, 2, 3 }, 100, false, "large_k_no_duplicates");

        // Negative numbers
        assertSolution(new int[] { -1, -2, -1 }, 2, true, "negative_numbers_valid");
        assertSolution(new int[] { -1, -2, -3, -1 }, 2, false, "negative_numbers_invalid");
        assertSolution(new int[] { -5, -5 }, 1, true, "negative_adjacent");

        // Mixed positive and negative
        assertSolution(new int[] { -1, 0, 1, -1 }, 3, true, "mixed_signs_valid");
        assertSolution(new int[] { -1, 0, 1, 2, -1 }, 3, false, "mixed_signs_invalid");

        // Zero values
        assertSolution(new int[] { 0, 1, 0 }, 2, true, "zeros_valid_distance");
        assertSolution(new int[] { 0, 1, 2, 0 }, 2, false, "zeros_invalid_distance");
        assertSolution(new int[] { 0, 0 }, 1, true, "adjacent_zeros");

        // Boundary distance cases (exactly at k)
        assertSolution(new int[] { 1, 2, 3, 1 }, 3, true, "exact_distance_k3_valid");
        assertSolution(new int[] { 1, 2, 3, 4, 1 }, 3, false, "exact_distance_k3_invalid");
        assertSolution(new int[] { 1, 2, 3, 4, 1 }, 4, true, "exact_distance_k4_valid");

        // Multiple pairs, some valid some invalid
        assertSolution(new int[] { 1, 2, 1, 3, 2 }, 2, true, "mixed_valid_invalid_pairs");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, 3, true, "multiple_pairs_at_limit");

        // Larger arrays
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 5, false, "larger_array_invalid");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 6, true, "larger_array_valid");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, 8, false, "large_array_boundary_fail");
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, 9, true, "large_array_boundary_pass");

        // Pattern with alternating values
        assertSolution(new int[] { 1, 2, 1, 2, 1 }, 2, true, "alternating_pattern_valid");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, 2, false, "repeating_pattern_invalid");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, 3, true, "repeating_pattern_valid");

        // Edge case with maximum constraints
        assertSolution(new int[] { 1000000000, -1000000000, 1000000000 }, 2, true, "max_values_valid");
        assertSolution(new int[] { 1000000000, -1000000000, 0, 1000000000 }, 2, false, "max_values_invalid");

        // Three identical elements with different k values
        assertSolution(new int[] { 7, 7, 7 }, 0, false, "three_identical_k0");
        assertSolution(new int[] { 7, 7, 7 }, 1, true, "three_identical_k1");
        assertSolution(new int[] { 7, 8, 7, 7 }, 1, true, "three_with_gap_k1");

        // Complex pattern
        assertSolution(new int[] { 1, 3, 5, 7, 9, 1, 3 }, 4, false, "complex_pattern_invalid");
        assertSolution(new int[] { 1, 3, 5, 7, 9, 1, 3 }, 5, true, "complex_pattern_valid_k5");
        assertSolution(new int[] { 1, 3, 5, 7, 9, 1, 3 }, 6, true, "complex_pattern_valid_k6");

        // k = 0 with various patterns
        assertSolution(new int[] { 1, 1, 2, 2 }, 0, false, "k0_non_adjacent_pairs");
        assertSolution(new int[] { 1, 2, 2, 3 }, 0, false, "k0_middle_adjacent");
        assertSolution(new int[] { 1, 2, 3, 3 }, 0, false, "k0_end_adjacent");

        // Large array test cases from uploaded data - tests adjacency boundary conditions
        assertSolution(new int[] { 695, 924, 678, 851, 955, 250, 250 }, 0, false, "large_array_adjacent_k0_fail");
        assertSolution(new int[] { 695, 924, 678, 851, 955, 250, 250 }, 1, true, "large_array_adjacent_k1_pass");

    }
}
