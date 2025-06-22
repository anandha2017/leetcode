package Leet0219_ContainsDuplicate2;

import java.util.HashMap;
import java.util.Map;

public class Soln {
    class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {

            // Empty array (length 1): Always `false` since we need distinct indices
            // When k = 0, the result is always false
            if ((nums.length == 1) || (k == 0))
                return false;

            Map<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                // If contains key and i - j <= k, return true.
                if (hashMap.containsKey(num) && (i - hashMap.get(num) <= k))
                    return true;

                // Either put a new <Integer, Index> pair, or update index of existing integer
                // in the HashMap.
                hashMap.put(num, i);
            }

            return false;
        }

        public boolean containsNearbyDuplicateTooSlow(int[] nums, int k) {

            if (nums.length == 1) {
                return false;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        if (nums[i] == nums[j]) {
                            if (Math.abs(i - j) <= k) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        }
    }
}