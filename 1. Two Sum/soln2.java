import java.util.Arrays;

public class soln2 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {           
            
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }

            throw new IllegalArgumentException("No two sum solution");
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

    }
}