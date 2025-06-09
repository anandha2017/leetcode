package Leet0205_IsomorphicStrings;

import java.util.HashMap;

public class Soln {

    class Solution {
        public boolean isIsomorphic(String s, String t) {

            if (s == null || t == null) {
                return s == t; // Both null = true, one null = false
            }

            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Character> sToT = new HashMap<>();
            HashMap<Character, Character> tToS = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (sToT.containsKey(s.charAt(i))) {
                    Character tmp = sToT.get(s.charAt(i));

                    if (!tmp.equals(t.charAt(i))) {
                        return false;
                    }
                } else {
                    sToT.put(s.charAt(i), t.charAt(i));
                }

                if (tToS.containsKey(t.charAt(i))) {
                    Character tmp = tToS.get(t.charAt(i));

                    if (!tmp.equals(s.charAt(i))) {
                        return false;
                    }
                } else {
                    tToS.put(t.charAt(i), s.charAt(i));
                }
            }

            return true;
        }

        /**
         * Optimized version of isIsomorphic with O(1) space complexity for ASCII
         * characters. Eliminates string conversions and uses char arrays for faster
         * lookups.
         *
         * Time Complexity: O(n) where n is the length of the strings Space Complexity:
         * O(1) for ASCII characters (256 fixed size arrays)
         *
         * @param s First string
         * @param t Second string
         * @return true if strings are isomorphic, false otherwise
         */
        public boolean isIsomorphic_sonnet4(String s, String t) {
            // Input validation - defensive programming
            if (s == null || t == null) {
                return s == t; // Both null = true, one null = false
            }

            if (s.length() != t.length()) {
                return false;
            }

            // Use char arrays for O(1) space with ASCII characters
            // Index represents ASCII value, value represents the mapped character
            char[] sToT = new char[256]; // Maps characters from s to t
            char[] tToS = new char[256]; // Maps characters from t to s

            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);

                // Check s -> t mapping
                if (sToT[sChar] == 0) {
                    // First time seeing this character from s
                    sToT[sChar] = tChar;
                } else if (sToT[sChar] != tChar) {
                    // Character from s already mapped to different character
                    return false;
                }

                // Check t -> s mapping (bidirectional check)
                if (tToS[tChar] == 0) {
                    // First time seeing this character from t
                    tToS[tChar] = sChar;
                } else if (tToS[tChar] != sChar) {
                    // Character from t already mapped to different character
                    return false;
                }
            }

            return true;
        }
    }
}
