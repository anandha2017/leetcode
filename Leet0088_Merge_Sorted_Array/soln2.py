from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1[m:] = nums2
        nums1.sort()

solution = Solution()

# Define some formatting constants
TRUNC = 30
PASS_FORMAT = "\033[92m{}\033[0m"  # Green text
FAIL_FORMAT = "\033[91m{}\033[0m"  # Red text

def truncate_str(s: str, max_length: int = TRUNC) -> str:
    """Truncate a string to max_length characters, adding '...' if truncated."""
    if len(s) <= max_length:
        return s
    return s[:max_length-3] + "..."

def assert_solution(input1: List[int], m: int, input2: List[int], n: int, expected: List[int]):
    """Test solution with given inputs and expected output."""
    input1_copy, input2_copy = list(input1), list(input2)
    m_copy, n_copy = m, n

    solution.merge(input1_copy, m_copy, input2_copy, n_copy)
    assert_pass = input1_copy == expected

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input 1: {m}, {truncate_str(str((input1)))}, "
        f"Input 2: {n}, {truncate_str(str((input2)))}, "
        f"Expected: {truncate_str(str((expected)))}"
        f"{' , Got: ' + truncate_str(str((input1_copy))) if not assert_pass else ''}"
    )

    return assert_pass


# Basic examples from the problem
assert_solution([1,2,3,0,0,0], 3, [2,5,6], 3, [1,2,2,3,5,6])
assert_solution([1], 1, [], 0, [1])
assert_solution([0], 0, [1], 1, [1])

# Edge cases
# Empty first array
assert_solution([0,0,0], 0, [1,2,3], 3, [1,2,3])
# Empty second array
assert_solution([1,2,3], 3, [], 0, [1,2,3])
# Both arrays single element
assert_solution([1,0], 1, [2], 1, [1,2])
# Both arrays empty
assert_solution([], 0, [], 0, [])

# Different sizes
assert_solution([1,2,3,0,0,0,0,0], 3, [4,5,6,7,8], 5, [1,2,3,4,5,6,7,8])
assert_solution([1,0,0,0,0,0], 1, [2,3,4,5,6], 5, [1,2,3,4,5,6])

# Duplicate elements
assert_solution([1,1,1,0,0,0], 3, [1,1,1], 3, [1,1,1,1,1,1])
assert_solution([2,2,0,0], 2, [1,2], 2, [1,2,2,2])

# Negative numbers
assert_solution([-3,-1,0,0,0], 2, [-2,-1,3], 3, [-3,-2,-1,-1,3])
assert_solution([-10,-5,-3,0,0,0], 3, [-8,-6,-4], 3, [-10,-8,-6,-5,-4,-3])

# Extreme values based on constraints
# Maximum array sizes
large_nums1 = [1] * 100 + [0] * 100
large_nums2 = [2] * 100
expected_large = [1] * 100 + [2] * 100
assert_solution(large_nums1, 100, large_nums2, 100, expected_large)

# Minimum and maximum values
assert_solution([-(10**9), 0, 0], 1, [-(10**9), 10**9], 2, [-(10**9), -(10**9), 10**9])

# First array elements all smaller
assert_solution([1,2,3,0,0,0], 3, [4,5,6], 3, [1,2,3,4,5,6])

# Second array elements all smaller
assert_solution([4,5,6,0,0,0], 3, [1,2,3], 3, [1,2,3,4,5,6])

# Interleaved elements
assert_solution([1,3,5,0,0,0], 3, [2,4,6], 3, [1,2,3,4,5,6])

# All elements from both arrays are the same
assert_solution([5,5,5,0,0,0], 3, [5,5,5], 3, [5,5,5,5,5,5])

# Arrays with very different ranges
assert_solution([1,10,100,0,0,0], 3, [2,20,200], 3, [1,2,10,20,100,200])

# LeetCode fail
assert_solution([-1,0,0,3,3,3,0,0,0], 6, [1,2,2], 3, [-1,0,0,1,2,2,3,3,3])
