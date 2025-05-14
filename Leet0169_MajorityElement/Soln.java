package Leet0169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Soln {
    class Solution {
        public int majorityElement(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            }

            HashMap<Integer, Integer> counter = new HashMap<>();

            for (int i : nums) {
                counter.put(i, counter.getOrDefault(i, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }
}