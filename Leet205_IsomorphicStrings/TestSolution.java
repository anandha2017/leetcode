package Leet205_IsomorphicStrings;

import Leet205_IsomorphicStrings.Soln.Solution;

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

        private static boolean assertSolution(String s, String t, boolean expected, String testName) {

                Soln outer = new Soln();
                Solution solution = outer.new Solution();

                boolean output = solution.isIsomorphic(s, t);
                boolean assertPass = (output == expected);

                String result = assertPass ? "PASS" : "FAIL";
                String formattedResult = assertPass ? greenText(result) : redText(result);

                System.out.println(formattedResult + ": " + testName + ", s: " + truncateStr(s) + ", t: "
                                + truncateStr(t) + ", output: " + output + ", Expected: " + expected);

                return assertPass;
        }

        public static void main(String[] args) {

                // Basic isomorphic cases
                assertSolution("egg", "add", true, "Example 1 - Basic isomorphic");

                assertSolution("foo", "bar", false, "Example 2 - Multiple mappings conflict");

                assertSolution("paper", "title", true, "Example 3 - Complex isomorphic");

                // Single character cases
                assertSolution("a", "b", true, "Single character mapping");

                assertSolution("x", "x", true, "Single character self-mapping");

                // Two character cases
                assertSolution("ab", "aa", false, "Two chars mapping to same char");

                assertSolution("aa", "ab", false, "Same char mapping to different chars");

                assertSolution("ab", "ba", true, "Two char swap");

                assertSolution("ab", "cc", false, "Different chars to same char");

                // Repeated character patterns
                assertSolution("aab", "xxy", true, "Repeated chars - valid");

                assertSolution("aab", "xyz", false, "Repeated chars - invalid");

                assertSolution("aaa", "bbb", true, "All same chars");

                assertSolution("aaa", "abc", false, "Same to different chars");

                assertSolution("abc", "aaa", false, "Different to same chars");

                // Palindromic patterns
                assertSolution("abba", "cddc", true, "Palindromic pattern");

                assertSolution("abba", "cdde", false, "Broken palindromic pattern");

                assertSolution("racecar", "xyzzyzx", true, "Long palindrome");

                // Alternating patterns
                assertSolution("abab", "cdcd", true, "Alternating pattern");

                assertSolution("abab", "cdef", false, "Broken alternating pattern");

                assertSolution("ababab", "xyzxyz", false, "Alternating to sequential");

                // Self-mapping cases
                assertSolution("abc", "abc", true, "Identical strings");

                assertSolution("abcabc", "abcabc", true, "Identical repeated pattern");

                assertSolution("a", "a", true, "Self-mapping single char");

                // Collision detection
                assertSolution("badc", "baba", false, "Multiple chars to same target");

                assertSolution("abcd", "aabb", false, "Different chars to same targets");

                assertSolution("ab", "aa", false, "Simple collision");

                assertSolution("aa", "ab", false, "Reverse collision");

                // Complex patterns
                assertSolution("abcabc", "xyzxyz", true, "Repeated triple pattern");

                assertSolution("abcabc", "xyztyz", false, "Broken repeated pattern");

                assertSolution("abcdef", "uvwxyz", true, "Sequential mapping");

                assertSolution("fedcba", "zyxwvu", true, "Reverse sequential mapping");

                // Edge cases with special characters
                assertSolution("a b", "x y", true, "Mapping with spaces");

                assertSolution("a1b2", "x9y8", true, "Alphanumeric mapping");

                assertSolution("a!b@", "x#y$", true, "Special character mapping");

                // Longer strings
                assertSolution("abcdefghijklmnop", "qrstuvwxyzabcdef", true, "Long unique mapping");

                assertSolution("abcdefghijklmnop", "qqrstuvwxyzabcde", false, "Long mapping with collision");

                // Pattern with mixed repetitions
                assertSolution("aabbcc", "xxyyzz", true, "Double char pattern");

                assertSolution("aabbcc", "xxyyza", false, "Broken double char pattern");

                assertSolution("aaabbbccc", "xxxyyyyy", false, "Unequal length groups");

                assertSolution("aaabbbccc", "xxxyyyzzz", true, "Triple char groups");

                // Boundary cases
                assertSolution("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", true,
                                "Full alphabet reverse");

                assertSolution("abcdefghijklmnopqrstuvwxyza", "zyxwvutsrqponmlkjihgfedcbaz", true,
                                "Alphabet with repeat");

                // Complex conflict scenarios
                assertSolution("abcabc", "xyztuv", false, "Pattern break in repetition");

                assertSolution("abccba", "xyzxyz", false, "Palindrome to non-palindrome");

                assertSolution("abccba", "xyzzyx", true, "Palindrome mapping");

                // Empty-like minimal cases (given constraint is >= 1)
                assertSolution("z", "a", true, "Minimal case z->a");

                assertSolution("9", "1", true, "Numeric char mapping");

                // Cases testing both directions
                assertSolution("ab", "ca", true, "Bidirectional unique mapping");

                assertSolution("abc", "def", true, "Simple sequential unique");

                assertSolution("bbbaaaba", "aaabbbab", false, "Complex pattern mismatch");

                // Maximum length considerations (substring of max constraint)
                assertSolution("a".repeat(100), "b".repeat(100), true, "Long single char mapping");

                assertSolution("ab".repeat(50), "xy".repeat(50), true, "Long alternating pattern");

                assertSolution("ab".repeat(50), "xx".repeat(50), false, "Long pattern with collision");

                // Unicode/ASCII boundary
                assertSolution("~!@#$%^&*()", "1234567890", true, "Special chars to numbers");

                assertSolution("AaBbCc", "XxYyZz", true, "Mixed case mapping");

                assertSolution("AaBbCc", "XxYyZx", false, "Mixed case with collision");

                // Pattern recognition edge cases
                assertSolution("abcdefg", "hijklmn", true, "Sequential shift");

                assertSolution("abcdefg", "abcdefg", true, "No transformation needed");

                assertSolution("abcdefg", "abcdefh", false, "Single char difference");

                // Final comprehensive cases
                assertSolution("abcabcabc", "xyzxyzxyz", true, "Triple repetition");

                assertSolution("abcabcabc", "xyzxyztuv", false, "Broken triple repetition");

                assertSolution("aabbccddee", "xxyyzzvvww", true, "Paired character mapping");

                assertSolution("aabbccddee", "xxyyzzvvwx", false, "Broken paired mapping");

        }
}
