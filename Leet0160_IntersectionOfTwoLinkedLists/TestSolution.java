package Leet0160_IntersectionOfTwoLinkedLists;

/**
 * Test class for the LinkedListCycle problem.
 * This file contains test cases and utility methods for testing your solution.
 */
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

    private static boolean assertSolution(
            int intersectVal,
            int[] listA,
            int[] listB,
            int skipA, int skipB,
            int expected) {

        Solution solution = new Solution();
        boolean output = solution.hasCycle(head);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " + testName +
                        " - Output: " + output +
                        ", Expected: " + expected +
                        ", List: " + truncateStr(linkedListToString(head)));

        return assertPass;
    }

    public static void main(String[] args) {
        assertSolution(
                8,
                new int[] { 4, 1, 8, 4, 5 },
                new int[] { 5, 6, 1, 8, 4, 5 },
                2,
                3,
                8);

    }
}
