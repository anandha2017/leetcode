struct Solution;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let n = nums.len();
        
        for i in 0..n {
            for j in 0..n {
                if i != j && nums[i] + nums[j] == target {
                    return vec![i as i32, j as i32];
                }
            }
        }

        // As per problem constraints, this line should never be reached
        vec![]
    }
}

/*
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        for i, num1 in enumerate(nums):
            for j, num2 in enumerate(nums):
                if (i != j) and (nums[i] + nums[j]) == target:
                    return [i,j]
 */

fn main() {

    println!("{}", Solution::two_sum(vec![2, 7, 11, 15], 9) == vec![0, 1]);
    println!("{}", Solution::two_sum(vec![3, 2, 4], 6) == vec![1, 2]);
    println!("{}", Solution::two_sum(vec![3, 3], 6) == vec![0, 1]);

    // # — Boundary: minimal length (nums.length = 2) —
    println!("{}", Solution::two_sum(vec![1, 1], 2) == vec![0, 1]);
    
    // # — Boundary: including zeros —
    println!("{}", Solution::two_sum(vec![0, 4, 3, 0], 0) == vec![0, 3]);

    // # — Boundary: extreme values (±10^9) —
    println!("{}", Solution::two_sum(vec![1_000_000_000, -1_000_000_000], 0) == vec![0, 1]);

    // # — Mixed negatives —
    println!("{}", Solution::two_sum(vec![-1, -2, -3, -4, -5], -8) == vec![2, 4]);

    // # — Duplicates but only one correct pair —
    println!("{}", Solution::two_sum(vec![1, 5, 5, 2], 10) == vec![1, 2]);
   
    // # — Error scenario (no valid answer; out of LeetCode spec) —
    println!("{}", Solution::two_sum(vec![1, 2, 3], 7).is_empty());

}
