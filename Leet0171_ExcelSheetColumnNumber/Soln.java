package Leet0171_ExcelSheetColumnNumber;

public class Soln {

    class Solution {

        /**
         * A utility class that provides a constant-time (O(1)) lookup for mapping Excel
         * column letters to their numerical values.
         * Contains mappings for uppercase letters A-Z, where A=1, B=2, ..., Z=26.
         */
        public class ColumnLetterMap {

            /**
             * A static map that stores the mapping of each uppercase letter to its
             * corresponding value.
             * This enables O(1) lookup of letter values.
             */
            private static final java.util.Map<Character, Integer> letterToValue = new java.util.HashMap<>();

            // Static initializer block to populate the map with letter-to-value mappings
            static {
                letterToValue.put('A', 1);
                letterToValue.put('B', 2);
                letterToValue.put('C', 3);
                letterToValue.put('D', 4);
                letterToValue.put('E', 5);
                letterToValue.put('F', 6);
                letterToValue.put('G', 7);
                letterToValue.put('H', 8);
                letterToValue.put('I', 9);
                letterToValue.put('J', 10);
                letterToValue.put('K', 11);
                letterToValue.put('L', 12);
                letterToValue.put('M', 13);
                letterToValue.put('N', 14);
                letterToValue.put('O', 15);
                letterToValue.put('P', 16);
                letterToValue.put('Q', 17);
                letterToValue.put('R', 18);
                letterToValue.put('S', 19);
                letterToValue.put('T', 20);
                letterToValue.put('U', 21);
                letterToValue.put('V', 22);
                letterToValue.put('W', 23);
                letterToValue.put('X', 24);
                letterToValue.put('Y', 25);
                letterToValue.put('Z', 26);
            }

            /**
             * Gets the numerical value for a given Excel column letter.
             *
             * @param letter the uppercase letter to look up (A-Z)
             * @return the numerical value of the letter (1-26)
             * @throws IllegalArgumentException if the input is not an uppercase letter A-Z
             */
            public static int getValue(char letter) {
                if (!letterToValue.containsKey(letter)) {
                    throw new IllegalArgumentException("Input must be an uppercase letter A-Z");
                }
                return letterToValue.get(letter);
            }

            /**
             * Checks if the given character is a valid Excel column letter (A-Z).
             *
             * @param letter the character to check
             * @return true if the character is a valid uppercase Excel column letter, false
             *         otherwise
             */
            public static boolean isValidLetter(char letter) {
                return letterToValue.containsKey(letter);
            }
        }

        public int titleToNumber(String columnTitle) {
            int base = 26;
            int results = 0;
            int length = columnTitle.length();

            for (int i = 0; i < length; i++) {
                char currentChar = columnTitle.charAt(i);
                double t1 = Math.pow(base, length - i - 1);
                int t2 = ColumnLetterMap.getValue(currentChar);
                results += (int) (t1 * t2);
            }

            return results;
        }
    }
}