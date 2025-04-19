struct Solution;
use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut seen = HashMap::new();
        for (i, &num) in nums.iter().enumerate() {
            if let Some(&j) = seen.get(&(target - num)) {
                return vec![j as i32, i as i32];
            }
            seen.insert(num, i);
        }
        vec![]
    }
}


/*
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut seen: HashMap<i32, usize> = HashMap::new();
        for (i, &num) in nums.iter().enumerate() {
            let comp = target - num;
            if let Some(&j) = seen.get(&comp) {
                return vec![j as i32, i as i32];
            }
            seen.insert(num, i);
        }
        vec![]
    }
}
*/

/*
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}  # value → index
        for i, num in enumerate(nums):
            comp = target - num
            if comp in seen:
                return [seen[comp], i]
            seen[num] = i
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
