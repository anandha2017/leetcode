package Leet0125_ValidPalindrome;

public class soln {

    class Solution {
        public boolean isPalindrome(String s) {

            String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (cleanString.length() <= 1) {
                return true;
            }

            for (int i = 0; i < cleanString.length() / 2; i++) {
                if (cleanString.charAt(i) != cleanString.charAt(cleanString.length() - i - 1)) {
                    return false;
                }
            }

            return true;
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

    private static boolean assertSolution(String s, boolean expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        boolean output = solution.isPalindrome(s);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Output: " + output +
                        ", Expected: " + expected +
                        ", Input: " + truncateStr(s));

        return assertPass;
    }

    public static void main(String[] args) {

        // Standard cases from the problem description
        assertSolution("A man, a plan, a canal: Panama", true);
        assertSolution("race a car", false);
        assertSolution(" ", true);

        // Single character cases
        assertSolution("a", true);
        assertSolution("A", true);
        assertSolution("1", true);

        // Multi-character simple cases
        assertSolution("aa", true);
        assertSolution("ab", false);
        assertSolution("aba", true);
        assertSolution("abba", true);
        assertSolution("abbc", false);

        // Case sensitivity check
        assertSolution("Aba", true);
        assertSolution("AbBa", true);

        // Cases with non-alphanumeric characters
        assertSolution("a,b,a", true);
        assertSolution("a,b,c", false);
        assertSolution("a!!a", true);
        assertSolution("a!!b", false);
        assertSolution("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal: Panama!", true);
        assertSolution("Coding,? is 101 si gnidoc!", true);

        // Cases with numbers
        assertSolution("121", true);
        assertSolution("123", false);
        assertSolution("a1a", true);
        assertSolution("a1b", false);
        assertSolution("0P0", true);

        // Edge cases
        assertSolution("", true); // Empty string is a palindrome
        assertSolution(".,;", true); // Only non-alphanumeric characters become empty string
        assertSolution(".,;a.,;", true); // Single alphanumeric with non-alphanumeric

        // Mixed alphanumeric with special characters
        assertSolution("ab_a", true);
        assertSolution("ab_c", false);
        assertSolution("A1b,B1a", true);
        assertSolution("A1b,B2a", false);

        // Long palindromes to test length constraints
        assertSolution("a".repeat(100000) + "a".repeat(100000), true);
        assertSolution("a".repeat(10) + "b" + "a".repeat(10), true);

        // Unicode characters (only ASCII is considered alphanumeric)
        assertSolution("A£$%^&B£$%^&A", true);
        assertSolution("A£$%^&B£$%^&C", false);

        // White space handling
        assertSolution("race  a car", false);
        assertSolution("race a ecar", true);
        assertSolution("\t\n\r a \t\n\r a \t\n\r", true);
    }
}
