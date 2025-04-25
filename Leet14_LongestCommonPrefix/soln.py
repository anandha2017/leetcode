from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        """ 
        for eachWord in strs:
            wordLength = len(eachWord)
            for x in range(wordLength):
                print(eachWord[x])
            
            for x in range(wordLength-1):
                print(eachWord[x:x+2])
                
            for x in range(wordLength-2):
                print(eachWord[x:x+3])
                
            for x in range(wordLength-3):
                print(eachWord[x:x+4])

            for x in range(wordLength-4):
                print(eachWord[x:x+5])

            for x in range(wordLength-5):
                print(eachWord[x:x+6])

        """        
        for eachWord in strs:
            wordLength = len(eachWord)
            for x in range(wordLength):
                for y in range(wordLength-x):
                    print(eachWord[x:x+y+1])
            

        return "x"        

solution = Solution()

def assertLongestCommonPrefix(strs: List[str], expected_output):
   
    strs_copy = list(strs)               # avoid mutating the original

    output = solution.longestCommonPrefix(strs_copy)
   
    assertPass = output == expected_output

    print(f"{'PASS' if assertPass else 'FAIL'} — got {output}, expected {expected_output}")
 

assertLongestCommonPrefix(["flower"], "fl")
# assertLongestCommonPrefix(["flower","flow","flight"], "fl")