from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        """ 
        for outerWord in strs:
            wordLength = len(outerWord)
            for x in range(wordLength):
                print(outerWord[x])
            
            for x in range(wordLength-1):
                print(outerWord[x:x+2])
                
            for x in range(wordLength-2):
                print(outerWord[x:x+3])
                
            for x in range(wordLength-3):
                print(outerWord[x:x+4])

            for x in range(wordLength-4):
                print(outerWord[x:x+5])

            for x in range(wordLength-5):
                print(outerWord[x:x+6])

        """
        # longestCommonPrefix = 0

        # for outerWord in strs:
        #     wordLength = len(outerWord)
        #     for x in range(wordLength):
        #         for y in range(wordLength-x):
        #             for w in strs:
        #                 c = outerWord[x:x+y+1]
        #                 print(f"outerWord: {outerWord}, w: {w}, c: {c}")

        longestPrefix = ""

        if not strs:
            return ""
        
        # Short-circuit if only one string exists
        if len(strs) == 1:
            return strs[0]

        for outerWord in strs:
            for x in range(len(outerWord)):
                prefix = outerWord[0:x+1]
                prefixFound = True

                for innerWord in strs:
                    if innerWord != outerWord and prefixFound:
                        prefixFound = innerWord.startswith(prefix)
                        # print(f"outerWord: {outerWord}, prefix: {prefix}, innerWord: {innerWord}, prefixFound: {prefixFound}, longestPefix {longestPrefix}")

                if prefixFound and len(prefix) > len(longestPrefix):
                    longestPrefix = prefix

                prefixFound = False 

        return longestPrefix        


solution = Solution()

def assertLongestCommonPrefix(strs: List[str], expected_output):
   
    strs_copy = list(strs)               # avoid mutating the original

    output = solution.longestCommonPrefix(strs_copy)
   
    assertPass = output == expected_output

    print(f"{'PASS' if assertPass else 'FAIL'} — got {output}, expected {expected_output}, for {strs}")
 

assertLongestCommonPrefix(["dog","racecar","car"], "")
assertLongestCommonPrefix(["flower","flow","flight"], "fl")

# Edge Cases
assertLongestCommonPrefix([""], "")                  # Single empty string
assertLongestCommonPrefix(["a"], "a")                # Single non-empty string
assertLongestCommonPrefix(["", "", ""], "")          # All empty strings

# Partial Matches
assertLongestCommonPrefix(["apple", "ape", "april"], "ap")   # Shared prefix shorter than all strings
assertLongestCommonPrefix(["abcd", "abx", "aby"], "ab")      # Divergence after 2 characters
assertLongestCommonPrefix(["flow", "flower", "flown"], "flow") # Prefix ends at shortest string

# No Common Prefix
assertLongestCommonPrefix(["cat", "car", "cable"], "ca")     # Partial match (not a full prefix)
assertLongestCommonPrefix(["xyz", "123", "αβγ"], "")         # No overlap

# Varying Lengths
assertLongestCommonPrefix(["abc", "ab", "a"], "a")           # Shortest string determines prefix
assertLongestCommonPrefix(["ab", "abc", "abcd"], "ab")       # First string is shortest

# First Character Matches Only
assertLongestCommonPrefix(["dog", "dance", "dome"], "d")     # Only first character shared

# Mixed Empty Strings
assertLongestCommonPrefix(["", "abc", "ab"], "")             # Empty string in input

# Full Match
assertLongestCommonPrefix(["test", "test", "test"], "test")  # All identical strings

# Max Constraints (simplified)
assertLongestCommonPrefix(["a"*200, "a"*200], "a"*200)       # Maximum allowed string length
