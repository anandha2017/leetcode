from typing import List

class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        i = 0
        for i in range(len(nums)):
            if nums[i] == target:
                return i
            elif nums[i] > target:
                return i

        return i + 1

solution = Solution()

def assert_solution(nums: List[int], target: int, expected_output: int):
   
    nums_copy = list(nums)                  # avoid mutating the original
    target_copy = target                    # avoid mutating the original

    output = solution.searchInsert(nums_copy, target_copy)
   
    assert_pass = output == expected_output

    # Enhanced print statement that shows only first 10 elements if nums_copy is longer than 10
    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_output}, "
        f"Input: nums = {nums_copy[:10] + ['...'] if len(nums_copy) > 10 else nums_copy}, target = {target}"
    )

# Test cases for Search Insert Position problem

# Basic examples from the problem statement
assert_solution([1, 3, 5, 6], 5, 2)     # Target found in array
assert_solution([1, 3, 5, 6], 2, 1)     # Target not found, should be inserted in middle
assert_solution([1, 3, 5, 6], 7, 4)     # Target not found, should be inserted at end

# Edge cases for insertion positions
assert_solution([1, 3, 5, 6], 0, 0)     # Target smaller than all elements (insert at beginning)
assert_solution([1, 3, 5, 6], 8, 4)     # Target larger than all elements (insert at end)

# Single element arrays
assert_solution([1], 1, 0)              # Target found in single element array
assert_solution([1], 0, 0)              # Target smaller than single element
assert_solution([1], 2, 1)              # Target larger than single element

# Extreme values within constraints
assert_solution([-10000], -10000, 0)    # Minimum value found
assert_solution([-10000], 10000, 1)     # Max value in min value array
assert_solution([10000], -10000, 0)     # Min value in max value array
assert_solution([10000], 10000, 0)      # Maximum value found

# Larger arrays with target found
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 7, 3)     # Found in middle
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 1, 0)     # Found at beginning
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 15, 7)    # Found at end

# Larger arrays with target not found
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 8, 4)     # Not found, middle insertion
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 0, 0)     # Not found, beginning insertion
assert_solution([1, 3, 5, 7, 9, 11, 13, 15], 16, 8)    # Not found, end insertion

# Arrays with widely spaced elements
assert_solution([-100, 0, 100], 50, 2)                 # Insert between values
assert_solution([-1000, 1000], 0, 1)                   # Insert between distant values

# Arrays with negative values
assert_solution([-5, -3, 0, 2, 5], -4, 1)              # Insert between negative values
assert_solution([-5, -3, 0, 2, 5], -6, 0)              # Insert before all negative values
assert_solution([-5, -3, 0, 2, 5], 3, 4)               # Insert between positive values

# Testing boundary conditions
assert_solution([1, 2, 3, 4, 5], 3, 2)                 # Found exact middle
assert_solution([1, 2, 4, 5, 6], 3, 2)                 # Not found, exact middle

# Edge case: very large array (approaching constraint limit)
large_array = list(range(-5000, 5000, 1))              # 10,000 elements
assert_solution(large_array, 0, 5000)                  # Find middle element
assert_solution(large_array, -5001, 0)                 # Insert at beginning
assert_solution(large_array, 5000, 10000)              # Insert at end
assert_solution(large_array, 2500, 7500)               # Find element in second half

# Testing with duplicated target value (even though array has distinct values)
assert_solution([10, 20, 30, 40, 50], 30, 2)           # Target matches an existing value
assert_solution([10, 20, 40, 50], 30, 2)               # Target would be inserted between values

# Special cases
assert_solution([1, 3], 2, 1)                          # Two elements, insert in middle
assert_solution([1, 3, 5], 4, 2)                       # Three elements, insert in middle

