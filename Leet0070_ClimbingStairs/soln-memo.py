class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        return self.fib(n, memo)

    def fib(self, n: int, memo:dict) -> int:
        if n in memo:
            return memo[n]

        if n <= 1:
            return 1

        memo[n] = self.fib(n - 1, memo) + self.fib(n - 2, memo)

        return memo[n]


solution = Solution()

def assert_solution(i: int, expected_output: int):

    i_copy = int(i)                  # avoid mutating the original

    output = solution.climbStairs(i_copy)

    assert_pass = output == expected_output

    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_output}, "
        f"Input: {i}"
    )

assert_solution(1, 1)
assert_solution(2, 2)
assert_solution(3, 3)
assert_solution(4, 5)
assert_solution(5, 8)
assert_solution(6, 13)
assert_solution(7, 21)
assert_solution(8, 34)
assert_solution(9, 55)
assert_solution(10, 89)
assert_solution(20, 10946)
assert_solution(30, 1346269)
assert_solution(40, 165580141)
assert_solution(45, 1836311903)  # Maximum constraint value
