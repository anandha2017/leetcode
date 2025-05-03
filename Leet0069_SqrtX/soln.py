class Solution:
    def mySqrt(self, x: int) -> int:

        """
        :type x: int
        :rtype: int
        """
        """
        The Binary Search Method
        This method uses the fact that if y² < x, then y is smaller than √x, and if y² > x, then y is larger than √x.

        The process involves:

        Set a search range: low = 0, high = x
        Find the middle point: mid = (low + high) / 2
        If mid² is close enough to x, return mid
        If mid² < x, set low = mid
        If mid² > x, set high = mid
        Repeat until you reach desired precision

        This is efficient because it halves the search space in each iteration.
        """

        xlow = 0
        xhigh = x
        mid = (xlow + xhigh) / 2

        while int(mid * mid) != x:
            if (mid * mid) < x:
                xlow = mid
            else:
                xhigh = mid

            mid = (xlow + xhigh) / 2

        return int(mid)

solution = Solution()

def assert_solution(i: int, expected_output: int):

    i_copy = int(i)                  # avoid mutating the original

    output = solution.mySqrt(i_copy)

    assert_pass = output == expected_output

    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_output}, "
        f"Input: {i}"
    )

# Basic test cases
assert_solution(4, 2)
assert_solution(8, 2)
assert_solution(9, 3)
assert_solution(16, 4)
assert_solution(25, 5)

# Edge cases
assert_solution(0, 0)
assert_solution(1, 1)
assert_solution(2, 1)
assert_solution(3, 1)

# Perfect squares
assert_solution(36, 6)
assert_solution(49, 7)
assert_solution(64, 8)
assert_solution(81, 9)
assert_solution(100, 10)
assert_solution(10000, 100)
assert_solution(1000000, 1000)

# Non-perfect squares
assert_solution(5, 2)
assert_solution(10, 3)
assert_solution(15, 3)
assert_solution(24, 4)
assert_solution(26, 5)
assert_solution(99, 9)
assert_solution(101, 10)

# Large numbers (within the constraint)
assert_solution(2147395600, 46340)  # Largest perfect square < 2^31
assert_solution(2147483647, 46340)  # Maximum possible value (2^31 - 1)
assert_solution(2147483646, 46340)  # One less than maximum

# Numbers near perfect squares
assert_solution(15, 3)  # Between 9 and 16
assert_solution(24, 4)  # Just below 25
assert_solution(26, 5)  # Just above 25
assert_solution(35, 5)  # Just below 36
assert_solution(37, 6)  # Just above 36

# Medium-sized numbers
assert_solution(529, 23)    # Perfect square
assert_solution(530, 23)    # Just above a perfect square
assert_solution(528, 22)    # Just below a perfect square
assert_solution(1000, 31)   # Common value
assert_solution(10001, 100) # Just above a perfect square
