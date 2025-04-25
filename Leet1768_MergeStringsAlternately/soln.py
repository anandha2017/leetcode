class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        maxLen = max(len(word1),len(word2))
        output = ""

        for i in range(maxLen):
            if i < len(word1):
                output = f"{output}{word1[i]}"
            if i < len(word2):
                output = f"{output}{word2[i]}"

        return output
    
solution = Solution()

def assertSolution(word1: str, word2: str, expected_output: str):
   
    word1_copy = str(word1)               # avoid mutating the original
    word2_copy = str(word2)               # avoid mutating the original

    output = solution.mergeAlternately(word1_copy, word2_copy)
   
    assertPass = output == expected_output

    print(f"{'PASS' if assertPass else 'FAIL'} — got {output}, expected {expected_output}, for {word1} and {word2}")
 


# Provided examples
assertSolution("abc", "pqr", "apbqcr")
assertSolution("ab", "pqrs", "apbqrs")
assertSolution("abcd", "pq", "apbqcd")

# Both strings have length 1 (minimum length)
assertSolution("a", "b", "ab")

# word1 length 1, word2 longer
assertSolution("a", "xyz", "axyz")

# word2 length 1, word1 longer
assertSolution("xyz", "a", "xayz")

# Both strings are the same and maximum length (100)
assertSolution("a"*100, "b"*100, "".join("ab" for _ in range(100)))

# word1 is length 100, word2 is length 1
assertSolution("a"*100, "z", "az" + "a"*99)

# word2 is length 100, word1 is length 1
assertSolution("z", "b"*100, "zb" + "b"*99)

# Both strings are different lengths, sum to 100
assertSolution("x"*30, "y"*70, "".join("xy" for _ in range(30)) + "y"*40)
assertSolution("x"*70, "y"*30, "".join("xy" for _ in range(30)) + "x"*40)

# Both strings are the same and palindromic
assertSolution("abcba", "xyzzy", "axbyczbzay")

# Both strings have alternating characters
assertSolution("ababab", "cdcdcd", "acbdacbdacbd")

# Both strings have completely different characters
assertSolution("qwerty", "asdfgh", "qawsedrftgyh")

# Both strings are single repeated characters
assertSolution("m"*50, "n"*50, "".join("mn" for _ in range(50)))
