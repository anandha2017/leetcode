package Leet0217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Soln {
    public class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> numbers = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (numbers.contains((nums[i]))) {
                    return true;
                } else {
                    numbers.add(nums[i]);
                }
            }
            return false;
        }
    }
}