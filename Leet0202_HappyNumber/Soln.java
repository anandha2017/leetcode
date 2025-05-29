package Leet0202_HappyNumber;

import java.util.HashSet;

public class Soln {

    class Solution {
        public boolean isHappy(int n) {

            HashSet<Integer> seen = new HashSet<Integer>();
            int sum = 0;

            if (n == 1) {
                return true;
            }

            while (n != 0) {
                int t = n % 10;
                sum += t * t;
                n = n / 10;
                // System.out.println("digit: " + t + ", running tot: " + sum + ", new n: " + n);
                if (n == 0) {
                    if (sum == 1) {
                        return true;
                    }

                    if (seen.contains(Integer.valueOf(sum))) {
                        return false;
                    } else {
                        seen.add(Integer.valueOf(sum));
                        n = sum;
                        sum = 0;
                    }
                }
            }

            if (sum == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}