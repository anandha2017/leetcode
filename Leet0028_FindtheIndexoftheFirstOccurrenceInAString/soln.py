class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        return haystack.find(needle)
    

solution = Solution()

def assertSolution(word1: str, word2: str, expected_output: int):
   
    word1_copy = str(word1)               # avoid mutating the original
    word2_copy = str(word2)               # avoid mutating the original

    output = solution.strStr(word1_copy, word2_copy)
   
    assertPass = output == expected_output

    print(f"{'PASS' if assertPass else 'FAIL'} — got {output}, expected {expected_output}, for {word1} and {word2}")
 


# Provided examples
assertSolution("sadbutsad", "sad", 0)
assertSolution("leetcode", "leeto", -1)

# Needle at the start
assertSolution("hello world", "hello", 0)

# Needle at the end
assertSolution("findmefind", "find", 6)

# Needle in the middle
assertSolution("abcde", "cd", 2)

# Needle is the entire haystack
assertSolution("complete", "complete", 0)

# Needle is longer than haystack
assertSolution("short", "longerneedle", -1)

# Needle is not present
assertSolution("abcdefgh", "xyz", -1)

# Multiple occurrences, should return first
assertSolution("repeatrepeat", "peat", 2)

# Needle is a single character, present
assertSolution("abcde", "c", 2)

# Needle is a single character, not present
assertSolution("abcde", "z", -1)

# Haystack and needle are both single characters and equal
assertSolution("a", "a", 0)

# Haystack and needle are both single characters and not equal
assertSolution("a", "b", -1)

# Needle is empty (if allowed by constraints)
# assertSolution("abc", "", 0)  # Uncomment if empty needle is valid

# Haystack is empty, needle is not
assertSolution("", "a", -1)
