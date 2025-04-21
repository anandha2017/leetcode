# Roman Numeral to Integer

## Introduction
Roman numerals are represented by seven distinct symbols. Converting between Roman numerals and modern integers requires understanding both the values of individual symbols and the subtraction rules that govern certain combinations.

## Symbols and Values

| Symbol | Value |
|:------:|:-----:|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

## Subtraction Rules
Roman numerals are generally written from largest to smallest, left to right. Yet in six specific cases a smaller-value symbol precedes a larger one to indicate subtraction:

- **I** may precede **V** (5) and **X** (10) to represent 4 and 9  
- **X** may precede **L** (50) and **C** (100) to represent 40 and 90  
- **C** may precede **D** (500) and **M** (1000) to represent 400 and 900  

## Problem Statement
Write a function that, given a valid Roman numeral string, returns its integer value.

### Function Signature
```python
def roman_to_int(s: str) -> int:
    pass
```

## Examples

1. **Input:**  
   ```  
   s = "III"  
   ```  
   **Output:**  
   ```  
   3  
   ```  
   **Explanation:**  
   III = 1 + 1 + 1 = 3

2. **Input:**  
   ```  
   s = "LVIII"  
   ```  
   **Output:**  
   ```  
   58  
   ```  
   **Explanation:**  
   L = 50, V = 5, III = 3 → 50 + 5 + 3 = 58

3. **Input:**  
   ```  
   s = "MCMXCIV"  
   ```  
   **Output:**  
   ```  
   1994  
   ```  
   **Explanation:**  
   M = 1000, CM = 900, XC = 90, IV = 4 → 1000 + 900 + 90 + 4 = 1994

## Constraints

- `1 <= s.length <= 15`  
- `s` contains only the characters `I, V, X, L, C, D, M`  
- It is guaranteed that `s` represents a number in the range 1 to 3 999  
