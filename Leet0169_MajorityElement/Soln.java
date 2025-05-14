package Leet0169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Soln {
    class SolutionOld {
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

    // Boyer-Moore Voting Algorithm
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }

}