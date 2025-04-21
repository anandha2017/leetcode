
class Solution:
    def romanToInt(self, s: str) -> int:
        
        num = 0
        prev = ''

        # | Symbol | Value |
        # |:------:|:-----:|
        # | I      | 1     |
        # | V      | 5     |
        # | X      | 10    |
        # | L      | 50    |
        # | C      | 100   |
        # | D      | 500   |
        # | M      | 1000  |
        # - **I** may precede **V** (5) and **X** (10) to represent 4 and 9  
        # - **X** may precede **L** (50) and **C** (100) to represent 40 and 90  
        # - **C** may precede **D** (500) and **M** (1000) to represent 400 and 900  

        for c in s:
            if c == 'I':
                num += 1
            elif c == 'V':
                num += 5
            elif c == 'X':
                num += 10
            elif c == 'L':
                num += 50
            elif c == 'C':
                num += 100
            elif c == 'D':
                num += 500
            elif c == 'M':
                num += 1000
            
            if prev == 'I' and (c == 'V' or c == 'X'):
                num += -2
            elif prev == 'X' and (c == 'L' or c == 'C'):
                num += -20
            elif prev == 'C' and (c == 'D' or c == 'M'):
                num += -200

            prev = c
        
        return num
    
solution = Solution()

# Minimal values
print(solution.romanToInt("I") == 1)
print(solution.romanToInt("II") == 2)
print(solution.romanToInt("III") == 3)

# Subtraction cases
print(solution.romanToInt("IV") == 4)
print(solution.romanToInt("IX") == 9)
print(solution.romanToInt("XL") == 40)
print(solution.romanToInt("XC") == 90)
print(solution.romanToInt("CD") == 400)
print(solution.romanToInt("CM") == 900)

# Typical cases
print(solution.romanToInt("LVIII") == 58)
print(solution.romanToInt("MCMXCIV") == 1994)
print(solution.romanToInt("XXVII") == 27)

# Edge cases
print(solution.romanToInt("MMMCMXCIX") == 3999)  # largest valid numeral