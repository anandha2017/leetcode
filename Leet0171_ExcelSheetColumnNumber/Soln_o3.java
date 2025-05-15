package Leet0171_ExcelSheetColumnNumber;

public class Soln_o3 {
    class Solution {
        /**
         * Converts an Excel column title (e.g. "AB") to its corresponding number (e.g.
         * 28).
         *
         * @param columnTitle the uppercase column title consisting of letters A–Z
         * @return the numerical equivalent of the title
         * @throws IllegalArgumentException if any character is outside A–Z
         */
        public int titleToNumber(String columnTitle) {
            int result = 0;
            for (char c : columnTitle.toCharArray()) {
                if (c < 'A' || c > 'Z') {
                    throw new IllegalArgumentException("Input must be uppercase A–Z");
                }
                result = result * 26 + (c - 'A' + 1);
            }
            return result;
        }
    }
}
