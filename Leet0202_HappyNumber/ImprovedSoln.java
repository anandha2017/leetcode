package Leet0202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class ImprovedSoln {

    class Solution {
        /**
         * Determines if a number is happy using HashSet for cycle detection
         * Time: O(log n), Space: O(log n)
         */
        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();

            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getSumOfSquares(n);
            }

            return n == 1;
        }

        /**
         * Calculates sum of squares of digits
         * @param n the number to process
         * @return sum of squares of all digits
         */
        private int getSumOfSquares(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }
    }

    /**
     * Alternative O(1) space solution using Floyd's Cycle Detection
     */
    class OptimizedSolution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = getSumOfSquares(slow);
                fast = getSumOfSquares(getSumOfSquares(fast));
            } while (slow != fast);

            return slow == 1;
        }

        private int getSumOfSquares(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }
    }
}
