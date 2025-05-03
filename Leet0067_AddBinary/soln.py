class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        carry = 0
        c = ""
        len_a = len(a)
        len_b = len(b)

        while len_a and len_b:
            if a[len_a - 1] == "0" and b[len_b - 1] == "0":
                if carry:
                    c = "1" + c
                    carry = 0
                else:
                    c = "0" + c
                    carry = 0
            elif a[len_a - 1] == "0" or b[len_b - 1] == "0":
                if carry:
                    c = "0" + c
                    carry = 1
                else:
                    c = "1" + c
                    carry = 0
            elif a[len_a - 1] == "1" and b[len_b - 1] == "1":
                if carry:
                    c = "1" + c
                    carry = 1
                else:
                    c = "0" + c
                    carry = 1
            else:
                raise ValueError("Shouldn't get here")

            len_a -= 1
            len_b -= 1

        while len_a:
            if a[len_a - 1] == "1":
                if carry:
                    c = "0" + c
                else:
                    c = "1" + c
            else:
                if carry:
                    c = "1" + c
                    carry = 0
                else:
                    c = "0" + c

            len_a -= 1

        while len_b:
            if b[len_b - 1] == "1":
                if carry:
                    c = "0" + c
                else:
                    c = "1" + c
            else:
                if carry:
                    c = "1" + c
                    carry = 0
                else:
                    c = "0" + c

            len_b -= 1

        if carry:
            c = "1" + c

        return c

solution = Solution()

def assert_solution(s1: str, s2: str, expected_output: str):

    s1_copy = str(s1)                  # avoid mutating the original
    s2_copy = str(s2)                  # avoid mutating the original

    output = solution.addBinary(s1_copy, s2_copy)

    assert_pass = output == expected_output

    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output[:20] + '...' if len(output) > 20 else output}, "
        f"Expected: {expected_output[:20] + '...' if len(expected_output) > 20 else expected_output}, "
        f"Input s1: {s1[:20] + '...' if len(s1) > 20 else s1}, "
        f"Input s2: {s2[:20] + '...' if len(s2) > 20 else s2}"
    )

# Basic test cases (from problem description)
assert_solution("11", "1", "100")
assert_solution("1010", "1011", "10101")

# Edge cases: One or both inputs are zero
assert_solution("0", "0", "0")
assert_solution("0", "1", "1")
assert_solution("1", "0", "1")

# Different length inputs
assert_solution("1", "11", "100")
assert_solution("111", "1", "1000")
assert_solution("1111", "1", "10000")
assert_solution("1", "1111", "10000")

# Carry propagation tests
assert_solution("11", "11", "110")
assert_solution("111", "111", "1110")
assert_solution("1111", "1111", "11110")

# Long strings close to constraints
assert_solution("1111111111", "1", "10000000000")
assert_solution("1", "1111111111", "10000000000")
assert_solution("1111111111", "1111111111", "11111111110")

# Binary strings with alternating bits
assert_solution("101010", "101010", "1010100")
assert_solution("10101010", "01010101", "11111111")

# Maximum length inputs (based on constraints)
assert_solution("1" + "0" * 9999, "1", "1" + "0" * 9998 + "1")

# 2^9 999 + 2^9 999 = 2 × 2^9 999 = 2^10 000
# In binary, 2^10 000 is a single 1 followed by 10 000 zeros.
assert_solution(
    "1" + "0" * 9999,          # first addend  (2^9 999)
    "1" + "0" * 9999,          # second addend (2^9 999)
    "1" + "0" * 10000          # expected sum  (2^10 000)
)

# Inputs with different patterns
assert_solution("10101010101010", "1111111111", "10111010101001")
assert_solution("11001100110011", "10101010101010", "101110111011101")
