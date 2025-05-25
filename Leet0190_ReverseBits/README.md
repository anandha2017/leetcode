# 190. Reverse Bits

## Problem Description

Reverse bits of a given 32 bits unsigned integer.

**Important Notes:**
- In some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type.
- The integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation.

## Examples

### Example 1
```
Input:  n = 00000010100101000001111010011100
Output: 964176192 (00111001011110000010100101000000)

Explanation:
The input binary string 00000010100101000001111010011100
represents the unsigned integer 43261596.
Return 964176192 which binary representation is
00111001011110000010100101000000.
```

### Example 2
```
Input:  n = 11111111111111111111111111111101
Output: 3221225471 (10111111111111111111111111111111)

Explanation:
The input binary string 11111111111111111111111111111101
represents the unsigned integer 4294967293.
Return 3221225471 which binary representation is
10111111111111111111111111111111.
```

### Example 3
```
Input:  n = 00000000000000000000000000000001
Output: 2147483648 (10000000000000000000000000000000)

Explanation:
Single bit at position 0 gets moved to position 31.
```

### Example 4
```
Input:  n = 10000000000000000000000000000000
Output: 1 (00000000000000000000000000000001)

Explanation:
Single bit at position 31 gets moved to position 0.
```

### Example 5
```
Input:  n = 00000000000000000000000010101010
Output: 1431655680 (01010101000000000000000000000000)

Explanation:
Alternating pattern gets reversed.
```

## Visual Representation

### Binary Bit Reversal Process

```
Original:  0 0 0 0 0 0 1 0 1 0 0 1 0 1 0 0 0 0 0 1 1 1 1 0 1 0 0 1 1 1 0 0
Position: 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0

                                    ↓ Reverse ↓

Reversed:  0 0 1 1 1 0 0 1 0 1 1 1 1 0 0 0 0 0 1 0 1 0 0 1 0 1 0 0 0 0 0 0
Position:  31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
```

### Step-by-Step Bit Extraction

```
Step 1: Extract LSB (Least Significant Bit)
n = 43261596 = ...1100 (LSB = 0)
result = 0

Step 2: Shift result left, add extracted bit
result = (0 << 1) + 0 = 0
n = n >> 1 = ...0110

Step 3: Continue for all 32 bits
...

Final: result = 964176192
```

## Key Concepts

### Bit Manipulation Operations

1. **Extract LSB**: `n & 1`
   - Gets the rightmost bit of n
   - Result is either 0 or 1

2. **Left Shift**: `result << 1`
   - Shifts all bits in result one position to the left
   - Equivalent to multiplying by 2

3. **Right Shift**: `n >> 1` (signed) or `n >>> 1` (unsigned)
   - Shifts all bits in n one position to the right
   - Equivalent to dividing by 2

4. **Bitwise OR**: `result | bit`
   - Sets specific bit positions

### Java-Specific Considerations

- Java uses **signed 32-bit integers** (-2³¹ to 2³¹-1)
- Use **`>>>` (unsigned right shift)** instead of `>>` to handle negative numbers correctly
- The most significant bit (MSB) represents the sign in two's complement

## Test Cases

### Edge Cases
```java
// All zeros
input:  0 (00000000000000000000000000000000)
output: 0 (00000000000000000000000000000000)

// All ones
input:  -1 (11111111111111111111111111111111)
output: -1 (11111111111111111111111111111111)

// Only MSB set
input:  -2147483648 (10000000000000000000000000000000)
output: 1 (00000000000000000000000000000001)

// Only LSB set
input:  1 (00000000000000000000000000000001)
output: -2147483648 (10000000000000000000000000000000)
```

### Regular Cases
```java
// Powers of 2
input:  8 (00000000000000000000000000001000)
output: 268435456 (00010000000000000000000000000000)

// Mixed pattern
input:  171 (00000000000000000000000010101011)
output: -806354944 (11010101010000000000000000000000)
```

## Function Signature

```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // Your implementation here

    }
}
```

## Constraints

- The input must be a **binary string of length 32**
- **Time Complexity Target**: O(1) - since we always process exactly 32 bits
- **Space Complexity Target**: O(1) - only using constant extra space

## Follow-up Question

**If this function is called many times, how would you optimise it?**

Consider techniques like:
- **Memoisation**: Cache results for previously computed values
- **Lookup Table**: Pre-compute results for byte-sized chunks (256 entries)
- **Bit Manipulation Tricks**: Use divide-and-conquer approach with bit masks

## Related Problems

- **191. Number of 1 Bits** - Count set bits
- **338. Counting Bits** - Count bits for range of numbers
- **461. Hamming Distance** - Compare bit differences
- **7. Reverse Integer** - Reverse decimal digits (similar concept)

## Difficulty
**Easy** ⭐

## Tags
`Bit Manipulation` `Divide and Conquer` `Math`