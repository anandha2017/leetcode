""" 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity? 
"""

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n-1):
            for j in range(i+1,n):
                if nums[i] + nums[j] == target:
                    return [i,j]


solution = Solution()

# — Normal scenarios —
print(solution.twoSum([2, 7, 11, 15], 9)    == [0, 1])   # example 1
print(solution.twoSum([3, 2, 4], 6)         == [1, 2])   # example 2
print(solution.twoSum([3, 3], 6)            == [0, 1])   # example 3

# — Boundary: minimal length (nums.length = 2) —
print(solution.twoSum([1, 1], 2)            == [0, 1])

# — Boundary: including zeros —
print(solution.twoSum([0, 4, 3, 0], 0)      == [0, 3])

# — Boundary: extreme values (±10^9) —
print(solution.twoSum([10**9, -10**9], 0)   == [0, 1])

# — Mixed negatives —
print(solution.twoSum([-1, -2, -3, -4, -5], -8) == [2, 4])

# — Duplicates but only one correct pair —
print(solution.twoSum([1, 5, 5, 2], 10)     == [1, 2])

# — Error scenario (no valid answer; out of LeetCode spec) —
print(solution.twoSum([1, 2, 3], 7)         is None)
