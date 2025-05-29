package Leet0171_ExcelSheetColumnNumber;

public class SecureSoln {

    public class Solution {

        // Security constants
        private static final int MAX_COLUMN_LENGTH = 7; // Excel max is 3 letters, but allow some buffer
        private static final long MAX_SAFE_RESULT = Integer.MAX_VALUE;

        /**
         * Securely converts Excel column title to column number.
         * Implements comprehensive input validation and overflow protection.
         *
         * @param columnTitle Excel column title (e.g., "A", "AB", "ZY")
         * @return corresponding column number
         * @throws IllegalArgumentException for invalid input
         * @throws ArithmeticException for overflow conditions
         */
        public int titleToNumber(String columnTitle) {
            // Input validation - prevent null pointer exceptions
            if (columnTitle == null) {
                throw new IllegalArgumentException("Column title cannot be null");
            }

            // Prevent empty string issues
            if (columnTitle.isEmpty()) {
                throw new IllegalArgumentException("Column title cannot be empty");
            }

            // Prevent resource exhaustion attacks
            if (columnTitle.length() > MAX_COLUMN_LENGTH) {
                throw new IllegalArgumentException("Column title too long");
            }

            // Validate all characters before processing to fail fast
            for (char c : columnTitle.toCharArray()) {
                if (c < 'A' || c > 'Z') {
                    throw new IllegalArgumentException("Invalid character in column title");
                }
            }

            long result = 0; // Use long to detect overflow

            for (char c : columnTitle.toCharArray()) {
                // Safe arithmetic - no floating point precision issues
                int letterValue = c - 'A' + 1;

                // Check for overflow before performing operation
                if (result > (MAX_SAFE_RESULT - letterValue) / 26) {
                    throw new ArithmeticException("Column number overflow");
                }

                result = result * 26 + letterValue;
            }

            // Final overflow check before casting
            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException("Result exceeds integer range");
            }

            return (int) result;
        }

        /**
         * Validates if a string is a valid Excel column title.
         * Provides safe validation without exceptions.
         *
         * @param columnTitle the string to validate
         * @return true if valid, false otherwise
         */
        public boolean isValidColumnTitle(String columnTitle) {
            try {
                if (columnTitle == null || columnTitle.isEmpty()) {
                    return false;
                }

                if (columnTitle.length() > MAX_COLUMN_LENGTH) {
                    return false;
                }

                for (char c : columnTitle.toCharArray()) {
                    if (c < 'A' || c > 'Z') {
                        return false;
                    }
                }

                return true;
            } catch (Exception e) {
                // Defensive programming - catch any unexpected exceptions
                return false;
            }
        }
    }
}
