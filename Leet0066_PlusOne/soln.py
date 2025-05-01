from typing import List

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] != 9:
                digits[i] += 1
                return digits
            elif (i == 0) and digits[i] != 9:
                digits[i] += 1
                return digits
            elif (i == 0) and digits[i] == 9:
                digits[i] = 0
                digits.insert(0,1)
                return digits
            elif digits[i] == 9:
                digits[i] = 0
                digits[i-1] += 1
                return digits

        raise ValueError("Shouldn't get here")
    
solution = Solution()

def assert_solution(digits: List[int], expected_digits:List[int]):
   
    digits_copy = list(digits)                  # avoid mutating the original

    output = solution.plusOne(digits)
   
    assert_pass = True
    for i in range(len(expected_digits)):
        if output[i] != expected_digits[i]:
            assert_pass = False

    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_digits}, "
        f"Input: nums = {digits_copy}"
    )

# Basic test cases from the problem statement
assert_solution([1, 2, 3], [1, 2, 4])
assert_solution([4, 3, 2, 1], [4, 3, 2, 2])
assert_solution([9], [1, 0])

# Edge cases with a single digit
assert_solution([0], [1])
assert_solution([1], [2])
assert_solution([8], [9])

# Cases with consecutive 9s at the end
assert_solution([1, 9], [2, 0])
assert_solution([9, 9], [1, 0, 0])
assert_solution([1, 9, 9], [2, 0, 0])
assert_solution([9, 9, 9], [1, 0, 0, 0])
assert_solution([8, 9, 9], [9, 0, 0])

# Various cases with different digit positions
assert_solution([1, 2, 9], [1, 3, 0])
assert_solution([9, 8, 7], [9, 8, 8])
assert_solution([2, 9, 9], [3, 0, 0])

# Testing minimum and maximum constraints
# Minimum length - single digit (already covered above)
# Let's test a case close to maximum length (100 digits)
assert_solution([9] * 99, [1] + [0] * 99)  # 99 nines becomes 1 followed by 99 zeros

# Cases with no carrying needed
assert_solution([1, 2, 3, 4], [1, 2, 3, 5])
assert_solution([5, 6, 7, 8], [5, 6, 7, 9])

# More complex carry cases
assert_solution([1, 9, 9, 9], [2, 0, 0, 0])
assert_solution([9, 8, 9], [9, 9, 0])