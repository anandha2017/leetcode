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

            HashMap<String, String> seenS = new HashMap<String, String>();
            HashMap<String, String> seenT = new HashMap<String, String>();

            for (int i = 0; i < s.length(); i++) {
                if (seenS.containsKey(String.valueOf(s.charAt(i)))) {
                    String tmp = seenS.get(String.valueOf(s.charAt(i)));

                    if (!tmp.equals(String.valueOf(t.charAt(i)))) {
                        return false;
                    }
                } else {
                    seenS.put(String.valueOf(s.charAt(i)), String.valueOf(t.charAt(i)));
                }

                if (seenT.containsKey(String.valueOf(t.charAt(i)))) {
                    String tmp = seenT.get(String.valueOf(t.charAt(i)));

                    if (!tmp.equals(String.valueOf(s.charAt(i)))) {
                        return false;
                    }
                } else {
                    seenT.put(String.valueOf(t.charAt(i)), String.valueOf(s.charAt(i)));
                }
            }

            return true;
        }
    }
}
