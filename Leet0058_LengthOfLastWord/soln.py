class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """

        words = s.split()
        no_of_words = len(words)

        return len(words[no_of_words-1])
        
solution = Solution()

def assert_solution(s: str, expected_output: int):
   
    s_copy = str(s)                  # avoid mutating the original

    output = solution.lengthOfLastWord(s_copy)
   
    assert_pass = output == expected_output

    # Enhanced print statement that shows only first 10 elements if nums_copy is longer than 10
    print(
        f"{'PASS' if assert_pass else 'FAIL'} — "
        f"Output: {output}, Expected: {expected_output}, "
        f"Input:  {s[:20] + '...' if len(s) > 20 else s}"
    )


# Basic test cases (examples from the problem statement)
assert_solution("Hello World", 5)
assert_solution("   fly me   to   the moon  ", 4)
assert_solution("luffy is still joyboy", 6)

# Edge cases - minimal inputs
assert_solution("a", 1)  # Single character
assert_solution(" a", 1)  # Single character with leading space
assert_solution("a ", 1)  # Single character with trailing space
assert_solution(" a ", 1)  # Single character with both leading and trailing spaces

# Edge cases - spaces
assert_solution("word ", 4)  # Trailing spaces
assert_solution("  word", 4)  # Leading spaces
assert_solution("  word  ", 4)  # Both leading and trailing spaces
assert_solution("word   word   word", 4)  # Multiple words with varying spaces

# Edge cases - word patterns
assert_solution("aaa", 3)  # Single word with multiple same characters
assert_solution("a a a a b", 1)  # Multiple single-character words
assert_solution("aaaaa bbbbb ccccc", 5)  # Multiple words with same character pattern

# Boundary test cases (based on constraints)
assert_solution("a" * 10000, 10000)  # Maximum length string with one word
assert_solution("a " + "a" * 9998, 9998)  # Near maximum length with two words

# Mixed patterns
assert_solution("abc def ghi", 3)  # Multiple words of same length
assert_solution("short longer longest", 7)  # Increasing word lengths
assert_solution("longest longer short", 5)  # Decreasing word lengths
assert_solution("   multiple   spaces   between   words   ", 5)  # Many spaces between words