# Happy Number Problem

## Problem Statement

Write an algorithm to determine if a number `n` is "happy".

A **happy number** is defined by the following process:
- Starting with any positive integer, replace the number by the sum of the squares of its digits
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1
- Those numbers for which this process ends in 1 are happy

**Return:** `true` if n is a happy number, `false` otherwise

## Examples

### Example 1: Happy Number
```
Input: n = 19
Output: true

Process:
19 → 1² + 9² = 1 + 81 = 82
82 → 8² + 2² = 64 + 4 = 68
68 → 6² + 8² = 36 + 64 = 100
100 → 1² + 0² + 0² = 1 + 0 + 0 = 1
```
Since we reached 1, **19 is happy** ✓

### Example 2: Unhappy Number
```
Input: n = 2
Output: false

Process:
2 → 2² = 4
4 → 4² = 16
16 → 1² + 6² = 1 + 36 = 37
37 → 3² + 7² = 9 + 49 = 58
58 → 5² + 8² = 25 + 64 = 89
89 → 8² + 9² = 64 + 81 = 145
145 → 1² + 4² + 5² = 1 + 16 + 25 = 42
42 → 4² + 2² = 16 + 4 = 20
20 → 2² + 0² = 4 + 0 = 4  ← Back to 4 (cycle detected!)
```
Since we detected a cycle (4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4), **2 is unhappy** ✗

### Example 3: Single Digit Happy Number
```
Input: n = 7
Output: true

Process:
7 → 7² = 49
49 → 4² + 9² = 16 + 81 = 97
97 → 9² + 7² = 81 + 49 = 130
130 → 1² + 3² + 0² = 1 + 9 + 0 = 10
10 → 1² + 0² = 1 + 0 = 1
```
Since we reached 1, **7 is happy** ✓

### Example 4: Three Digit Unhappy Number
```
Input: n = 145
Output: false

Process:
145 → 1² + 4² + 5² = 1 + 16 + 25 = 42
42 → 4² + 2² = 16 + 4 = 20
20 → 2² + 0² = 4 + 0 = 4
4 → 4² = 16
16 → 1² + 6² = 1 + 36 = 37
37 → 3² + 7² = 9 + 49 = 58
58 → 5² + 8² = 25 + 64 = 89
89 → 8² + 9² = 64 + 81 = 145  ← Back to 145 (cycle detected!)
```

## Additional Test Cases

| Input | Output | Reasoning |
|-------|--------|-----------|
| 1 | true | Already equals 1 |
| 10 | true | 1² + 0² = 1 |
| 23 | true | Eventually reaches 1 |
| 4 | false | Enters cycle: 4→16→37→58→89→145→42→20→4 |
| 20 | false | Part of the common unhappy cycle |

## Process Visualisation

```
Happy Number (n=19):
    19
     ↓ (1² + 9² = 82)
    82
     ↓ (8² + 2² = 68)
    68
     ↓ (6² + 8² = 100)
   100
     ↓ (1² + 0² + 0² = 1)
     1  ← HAPPY! ✓

Unhappy Number (n=4):
     4
     ↓ (4² = 16)
    16
     ↓ (1² + 6² = 37)
    37
     ↓ (3² + 7² = 58)
    58
     ↓ (5² + 8² = 89)
    89
     ↓ (8² + 9² = 145)
   145
     ↓ (1² + 4² + 5² = 42)
    42
     ↓ (4² + 2² = 20)
    20
     ↓ (2² + 0² = 4)
     4  ← CYCLE DETECTED! ✗
```

## Key Insights

1. **Cycle Detection**: Unhappy numbers will eventually enter a cycle and never reach 1
2. **Common Unhappy Cycle**: Most unhappy numbers eventually enter the cycle: 4→16→37→58→89→145→42→20→4
3. **Single Digit Analysis**:
   - Happy single digits: 1, 7
   - Unhappy single digits: 2, 3, 4, 5, 6, 8, 9
4. **Sum Calculation**: For number 'n', sum = Σ(digit²) for each digit in n

## Java Method Signatures

```java
public boolean isHappy(int n) {
    // Your implementation here
}

// Helper method for calculating sum of squares
private int getSumOfSquares(int n) {
    // Your implementation here
}
```

## Constraints

- 1 ≤ n ≤ 2³¹ - 1

## Follow-up Questions

1. Can you solve this with O(1) space complexity?
2. What patterns do you notice in unhappy numbers?
3. How would you optimise for multiple queries?

## Time & Space Complexity Analysis

Consider the trade-offs between different approaches:
- Using a HashSet vs Floyd's Cycle Detection
- Space vs Time complexity implications
- Early termination conditions

---

*This problem tests cycle detection algorithms and mathematical sequence analysis. Consider both iterative and mathematical approaches to solving it.*