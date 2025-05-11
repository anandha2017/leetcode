package Leet0136_SingleNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class soln {
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> numbers = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (numbers.contains((nums[i]))) {
                    numbers.remove(nums[i]);
                } else {
                    numbers.add(nums[i]);
                }
            }

            return numbers.stream().findFirst().orElse(null);
        }
    }

    private static final int MAX_STRING_LENGTH = 50;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";

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

    private static boolean assertSolution(int[] nums, int expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        int output = solution.singleNumber(nums);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Output: " + output +
                        ", Expected: " + expected +
                        ", Input: " + truncateStr(Arrays.toString(nums)));

        return assertPass;
    }

    public static void main(String[] args) {

        // Basic examples from the problem description
        assertSolution(new int[] { 2, 2, 1 }, 1);
        assertSolution(new int[] { 4, 1, 2, 1, 2 }, 4);
        assertSolution(new int[] { 1 }, 1);

        // Additional examples with different patterns
        assertSolution(new int[] { 7, 3, 7, 1, 3, 6, 6 }, 1);
        assertSolution(new int[] { 9, 5, 9, 4, 5, 8, 4 }, 8);

        // Edge cases - minimum and maximum array length
        assertSolution(new int[] { 999 }, 999); // Minimum length array (1 element)

        // Large array with the single number at the beginning
        assertSolution(new int[] { 42, 10, 10, 20, 20, 30, 30, 40, 40, 50, 50 }, 42);

        // Large array with the single number in the middle
        assertSolution(new int[] { 10, 10, 20, 20, 30, 42, 30, 40, 40, 50, 50 }, 42);

        // Large array with the single number at the end
        assertSolution(new int[] { 10, 10, 20, 20, 30, 30, 40, 40, 50, 50, 42 }, 42);

        // Testing with negative numbers
        assertSolution(new int[] { -1, 2, 2, -10, -10 }, -1);
        assertSolution(new int[] { -55, -55, 4, 4, -22 }, -22);

        // Testing with a mix of positive and negative numbers
        assertSolution(new int[] { -1, 1, 2, 2, -1 }, 1);
        assertSolution(new int[] { 10, -10, 10, 20, 20 }, -10);

        // Testing with zeros
        assertSolution(new int[] { 0, 5, 5 }, 0);
        assertSolution(new int[] { 1, 1, 0, 2, 2 }, 0);

        // Testing with boundary values
        assertSolution(new int[] { Integer.MAX_VALUE, 5, 5 }, Integer.MAX_VALUE);
        assertSolution(new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, 42 }, 42);

        // Testing with alternating patterns
        assertSolution(new int[] { 1, 2, 1, 3, 2, 5, 3 }, 5);
        assertSolution(new int[] { 9, 8, 7, 8, 9, 6, 7 }, 6);

        // Testing with repeated numbers in sequence
        assertSolution(new int[] { 5, 5, 4, 4, 3, 3, 2 }, 2);
        assertSolution(new int[] { 1, 1, 2, 2, 3 }, 3);

        // Testing with larger values within constraints
        assertSolution(new int[] { 30000, -30000, 30000 }, -30000);
        assertSolution(new int[] { -30000, 20000, -30000 }, 20000);

    }
}
