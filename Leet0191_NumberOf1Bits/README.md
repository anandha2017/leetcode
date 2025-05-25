# Number of 1 Bits (LeetCode 191)

## Problem Statement

Write a function that takes a positive integer and returns the number of **set bits** (1 bits) in its binary representation. This is also known as the **Hamming weight**.

### Function Signature (Java)
```java
public int hammingWeight(int n)
```

**Note**: In Java, there's no unsigned integer type. The input will be given as a signed integer, which doesn't affect the implementation since the internal binary representation remains the same.

---

## Examples

### Example 1
**Input**: `n = 11`
**Output**: `3`
**Explanation**:
- Binary representation: `00000000000000000000000000001011`
- Number of 1 bits: **3**

### Example 2
**Input**: `n = 128`
**Output**: `1`
**Explanation**:
- Binary representation: `00000000000000000000000010000000`
- Number of 1 bits: **1**

### Example 3
**Input**: `n = 2147483645`
**Output**: `30`
**Explanation**:
- Binary representation: `01111111111111111111111111111101`
- Number of 1 bits: **30**

### Example 4
**Input**: `n = -3` (signed integer representation)
**Output**: `31`
**Explanation**:
- Binary representation: `11111111111111111111111111111101`
- Number of 1 bits: **31**
- This demonstrates two's complement representation for negative numbers

### Example 5
**Input**: `n = 1024`
**Output**: `1`
**Explanation**:
- Binary representation: `00000000000000000000010000000000`
- Number of 1 bits: **1**

### Example 6
**Input**: `n = 255`
**Output**: `8`
**Explanation**:
- Binary representation: `00000000000000000000000011111111`
- Number of 1 bits: **8**

---

## Visual Examples

### Example: n = 11
```
Decimal: 11
Binary:  00000000000000000000000000001011
         ↑                          ↑ ↑↑
         |                          | ||
         Position 31-4              | ||
         (all zeros)                | ||
                                    | |└─ Position 0: 1
                                    | └── Position 1: 1
                                    └──── Position 3: 1

Total 1 bits: 3
```

### Example: n = 128
```
Decimal: 128
Binary:  00000000000000000000000010000000
         ↑                     ↑       ↑
         |                     |       |
         Positions 31-8        |       Positions 6-0
         (all zeros)           |       (all zeros)
                               |
                               └─ Position 7: 1

Total 1 bits: 1
```

### Example: n = -3 (Two's Complement)
```
Decimal: -3
Binary:  11111111111111111111111111111101
         ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ ↑
         ||||||||||||||||||||||||||||||| |
         All positions except 1 are 1s   |
                                         └─ Position 1: 0

Total 1 bits: 31
```

---

## Constraints

- **Input range**: 1 ≤ n ≤ 2³¹ - 1
- **Time complexity target**: O(1) or O(log n)
- **Space complexity target**: O(1)
- The input is a 32-bit integer

---

## Key Concepts to Consider

### Binary Representation
- Each integer has a 32-bit binary representation
- Each bit position can be either 0 or 1
- We need to count the number of positions containing 1

### Bit Manipulation Techniques
- **AND operation (`&`)**: Useful for checking individual bits
- **Right shift (`>>`)**: Moves bits to the right
- **Left shift (`<<`)**: Moves bits to the left
- **Bitwise tricks**: Various optimisations available

### Hamming Weight
The Hamming weight of a string is the number of symbols that are different from the zero-symbol. In binary, it's simply the count of 1 bits.


## Performance Considerations

### Approach Complexity Analysis
Different approaches have varying time complexities:
- **Naive string conversion**: O(log n) time, O(log n) space
- **Bit-by-bit checking**: O(32) = O(1) time, O(1) space
- **Optimised bit manipulation**: O(number of 1 bits) time, O(1) space

### Memory Usage
- Aim for O(1) space complexity
- Avoid string conversions which create temporary objects
- Use primitive operations where possible

---

## Related Problems

- **LeetCode 190**: Reverse Bits
- **LeetCode 338**: Counting Bits
- **LeetCode 201**: Bitwise AND of Numbers Range
- **LeetCode 461**: Hamming Distance

---

## Tags
`Bit Manipulation` `Math` `Easy`