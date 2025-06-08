package Leet205_IsomorphicStrings;

import java.util.HashMap;

public class Soln {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            if ((s.length() == 1) && (t.length() == 1)) {
                return true;
            }

            HashMap<String, String> seen = new HashMap<String, String>();

            for (int i = 0; i < s.length(); i++) {
                if (seen.containsKey(String.valueOf(s.charAt(i)))) {
                    String tmp = seen.get(String.valueOf(s.charAt(i)));

                    if (!tmp.equals(String.valueOf(t.charAt(i)))) {
                        return false;
                    }
                } else {
                    seen.put(String.valueOf(s.charAt(i)), String.valueOf(t.charAt(i)));
                }

            }
            return true;
        }
    }

}
