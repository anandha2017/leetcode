package Leet0121_BestTimeToBuyAndSellStock;

import java.util.Arrays;

public class soln {

    class Solution {
        public int maxProfit(int[] prices) {

            return -1;

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

    private static boolean assertSolution(int[] prices, int expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        int output = solution.maxProfit(prices);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Output: " + output +
                        ", Expected: " + expected +
                        ", Input: " + truncateStr(Arrays.toString(prices)));

        return assertPass;
    }

    public static void main(String[] args) {

        assertSolution(new int[] { 7, 1, 5, 3, 6, 4 }, 5);
        assertSolution(new int[] { 7, 6, 4, 3, 1 }, 0);

    }
}
