package Leet0121_BestTimeToBuyAndSellStock;

import java.util.Arrays;

public class soln {

    class Solution {
        public int maxProfit(int[] prices) {

            int buyPrice = 10000;
            int sellPrice = -1;
            boolean bought = false;
            boolean sold = false;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < buyPrice) {
                    bought = true;
                    buyPrice = prices[i];
                }

                if (prices[i] > buyPrice && bought) {
                    if (prices[i] > sellPrice) {
                        sold = true;
                        sellPrice = prices[i];
                    }
                }
            }

            if (sold) {
                return sellPrice - buyPrice;
            }

            return 0;
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

        // Original examples
        assertSolution(new int[] { 7, 1, 5, 3, 6, 4 }, 5);
        assertSolution(new int[] { 7, 6, 4, 3, 1 }, 0);

        // Edge cases
        assertSolution(new int[] { 1 }, 0); // Only one price - can't both buy and sell
        assertSolution(new int[] { 1, 1 }, 0); // Same prices - no profit
        assertSolution(new int[] { 1, 2 }, 1); // Minimal positive case
        assertSolution(new int[] { 2, 1 }, 0); // Minimal negative case

        // Additional test cases
        assertSolution(new int[] { 3, 2, 6, 5, 0, 3 }, 4); // Buy at 2, sell at 6
        assertSolution(new int[] { 2, 4, 1 }, 2); // Buy at 2, sell at 4
        assertSolution(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }, 4); // Buy at 0, sell at 4

        // Valley-peak scenarios
        assertSolution(new int[] { 9, 0, 10 }, 10); // Big dip and rise
        assertSolution(new int[] { 1, 2, 3, 4, 5 }, 4); // Continuously rising
        assertSolution(new int[] { 5, 4, 3, 2, 1, 10 }, 9); // Falling then sharp rise

        // Multiple valleys and peaks
        assertSolution(new int[] { 5, 1, 5, 1, 10 }, 9); // Multiple opportunities
        assertSolution(new int[] { 10, 1, 7, 2, 11 }, 10); // Test competing profits

        // Boundary conditions
        assertSolution(new int[] { 0, 10000 }, 10000); // Min to max price (constraints)
        assertSolution(new int[] { 10000, 0 }, 0); // Max to min price
        assertSolution(new int[] { 5000, 10000, 0, 5000 }, 5000); // Mixed high-low

        // Flat sections
        assertSolution(new int[] { 5, 5, 5, 5, 5 }, 0); // All flat
        assertSolution(new int[] { 5, 5, 5, 5, 6 }, 1); // Flat then rise
        assertSolution(new int[] { 6, 5, 5, 5, 5 }, 0); // Fall then flat

        // Oscillating patterns
        assertSolution(new int[] { 1, 2, 1, 2, 1, 2 }, 1); // Regular oscillation
        assertSolution(new int[] { 2, 1, 3, 2, 4, 3, 5 }, 4); // Upward oscillation
        assertSolution(new int[] { 5, 4, 3, 2, 3, 2, 1 }, 1); // Downward oscillation

    }
}
