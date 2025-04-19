import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class soln3 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {      

            int comp; 
            Map<Integer, Integer> seen = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                comp = target - nums[i];
                if (seen.get(comp) != null) {
                    return new int[]{seen.get(comp),i};
                }
                seen.put(nums[i],i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        soln3 outer = new soln3();

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