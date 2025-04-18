import java.util.Arrays;

public class soln {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return new int[]{0, 1};
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        soln outer = new soln();

        // Create an instance of the inner Solution class
        Solution solution = outer.new Solution();

        // Compare the result with the expected output
        System.out.println(Arrays.equals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1})); 
        System.out.println(Arrays.equals(solution.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));      
        System.out.println(Arrays.equals(solution.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));         
  

        // Boundary: minimal length (nums.length = 2) —
        System.out.println(Arrays.equals(solution.twoSum(new int[]{1,1},  2), new int[]{0,1}));

        // Boundary: including zeros —
        System.out.println(Arrays.equals(solution.twoSum(new int[]{0,4,3,0},  0), new int[]{0,3}));


        // Boundary: extreme values (±10^9) —
        System.out.println(Arrays.equals(solution.twoSum(new int[]{10^9,-10^9},  0), new int[]{0,1}));

    }
}