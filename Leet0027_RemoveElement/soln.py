from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:

        new_nums = []

        for i in range(len(nums)):
            if nums[i] != val:
                new_nums.append(nums[i]) 

        if len(new_nums) == 0:
            nums.clear()
        else:    
            for i in range(len(new_nums)):
                nums[i] = new_nums[i]
            
        return len(new_nums)
    

solution = Solution()

def assert_solution(nums: List[int], val: int, expected_output: int, expected_nums:List[int]):
   
    nums_copy = list(nums)                  # avoid mutating the original
    val_copy = val                          # avoid mutating the original

    output = solution.removeElement(nums, val_copy)
   
    assert_pass = output == expected_output
    for i in range(expected_output):
        if nums[i] != expected_nums[i]:
            assert_pass = False

    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_output}, "
        f"Input: nums = {nums_copy}, val = {val}, "
        f"Output: nums = {nums} "
        f"Expected nums after removal: {expected_nums}"
    )

assert_solution([3,2,2,3], 3, 2, [2,2])
assert_solution([0,1,2,2,3,0,4,2], 2, 5, [0,1,3,0,4])

# Empty array
assert_solution([], 1, 0, [])

# Single-element arrays
assert_solution([5], 5, 0, [])
assert_solution([7], 5, 1, [7])

# All elements equal to val
assert_solution([2, 2, 2, 2], 2, 0, [])
assert_solution([0, 0, 0], 0, 0, [])

# No element equal to val
assert_solution([4, 5, 6], 3, 3, [4, 5, 6])

# val only at the start or only at the end
assert_solution([2, 3, 4, 5], 2, 3, [3, 4, 5])
assert_solution([3, 4, 5, 2], 2, 3, [3, 4, 5])

# Alternating val and non-val elements
assert_solution([2, 1, 2, 1, 2, 1], 2, 3, [1, 1, 1])

# Mixed duplicates with scattered val
assert_solution([4, 4, 1, 4, 2, 3, 4], 4, 3, [1, 2, 3])

# Negative values (signed input permitted by constraints)
assert_solution([-1, -2, -3, -1], -1, 2, [-2, -3])

# Balanced large sample (even length)
assert_solution([1, 0, 1, 0, 1, 0, 1, 0], 1, 4, [0, 0, 0, 0])
