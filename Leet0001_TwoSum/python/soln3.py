from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}  # value → index
        for i, num in enumerate(nums):
            comp = target - num
            if comp in seen:
                return [seen[comp], i]
            seen[num] = i


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
