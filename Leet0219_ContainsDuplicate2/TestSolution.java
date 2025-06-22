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
        assertSolution(new int[] { 1, 2, 3, 1 }, 3, true, "0");
        assertSolution(new int[] { 1, 0, 1, 1 }, 3, true, "1");
        assertSolution(new int[] { 1, 2, 3, 1, 2, 3 }, 2, false, "2");
    }
}
