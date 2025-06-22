# Contains Duplicate II

## Problem Statement

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.

### Constraints
- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= k <= 10^5`

## Examples

### Example 1
```
Input: nums = [1,2,3,1], k = 3
Output: true
Explanation: nums[0] == nums[3] and abs(0 - 3) = 3 <= 3
```

### Example 2
```
Input: nums = [1,0,1,1], k = 1
Output: true
Explanation: nums[2] == nums[3] and abs(2 - 3) = 1 <= 1
```

### Example 3
```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
Explanation: 
- nums[0] == nums[3], but abs(0 - 3) = 3 > 2
- nums[1] == nums[4], but abs(1 - 4) = 3 > 2
- nums[2] == nums[5], but abs(2 - 5) = 3 > 2
```

## Additional Examples

### Example 4
```
Input: nums = [99,99], k = 2
Output: true
Explanation: nums[0] == nums[1] and abs(0 - 1) = 1 <= 2
```

### Example 5
```
Input: nums = [1,2,1], k = 0
Output: false
Explanation: nums[0] == nums[2] but abs(0 - 2) = 2 > 0
```

### Example 6
```
Input: nums = [4,1,2,3,1,5], k = 3
Output: true
Explanation: nums[1] == nums[4] and abs(1 - 4) = 3 <= 3
```

### Example 7
```
Input: nums = [5,6,7,5,8,9], k = 2
Output: false
Explanation: nums[0] == nums[3] but abs(0 - 3) = 3 > 2
```

### Example 8
```
Input: nums = [2,2], k = 1
Output: true
Explanation: nums[0] == nums[1] and abs(0 - 1) = 1 <= 1
```

## Visual Examples

### Example 1 Visualisation
```
Array: [1, 2, 3, 1]
Index:  0  1  2  3
        ↑        ↑
        |        |
        Same values: 1 == 1
        Distance: |3 - 0| = 3
        k = 3, so 3 <= 3 ✓
```

### Example 2 Visualisation
```
Array: [1, 0, 1, 1]
Index:  0  1  2  3
              ↑  ↑
              |  |
              Same values: 1 == 1
              Distance: |3 - 2| = 1
              k = 1, so 1 <= 1 ✓
```

### Example 3 Visualisation
```
Array: [1, 2, 3, 1, 2, 3]
Index:  0  1  2  3  4  5
        ↑        ↑
        |        |
        Same values: 1 == 1
        Distance: |3 - 0| = 3
        k = 2, so 3 > 2 ✗

        Also checking:
           ↑        ↑
           |        |
           Same values: 2 == 2
           Distance: |4 - 1| = 3
           k = 2, so 3 > 2 ✗
```

### Sliding Window Concept Visualisation
For `k = 2`, we're essentially looking within a "window" of size `k+1`:

```
Array: [a, b, c, d, e, f]
Index:  0  1  2  3  4  5

When at index 0: check indices [0, 1, 2] (window size = k+1 = 3)
When at index 1: check indices [1, 2, 3]
When at index 2: check indices [2, 3, 4]
And so on...
```

## Key Observations

1. We need to find duplicate values within a specific distance constraint
2. The absolute difference between indices must be at most `k`
3. The indices must be distinct (i ≠ j)
4. Only need to return `true` if such a pair exists, `false` otherwise

## Edge Cases to Consider

- Empty array (length 1): Always `false` since we need distinct indices
- Array with all unique elements: Always `false`
- k = 0: Only adjacent identical elements would qualify
- Large k value (≥ array length): Distance constraint becomes irrelevant
- Duplicate elements at exact distance k
- Multiple duplicate pairs within the constraint

## Java Method Signature

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    // Your implementation here
}
```

## Test Cases

Feel free to test your solution with these additional cases:

```java
// Test Case 1: Basic positive case
nums = [1,2,3,1], k = 3 → Expected: true

// Test Case 2: Adjacent duplicates
nums = [1,0,1,1], k = 1 → Expected: true

// Test Case 3: Duplicates outside range
nums = [1,2,3,1,2,3], k = 2 → Expected: false

// Test Case 4: k = 0, adjacent elements
nums = [1,1], k = 0 → Expected: false

// Test Case 5: k = 0, identical adjacent elements
nums = [1,1], k = 1 → Expected: true

// Test Case 6: Single element
nums = [1], k = 1 → Expected: false

// Test Case 7: All unique elements
nums = [1,2,3,4,5], k = 2 → Expected: false

// Test Case 8: Large k
nums = [1,2,1], k = 100 → Expected: true
```

Good luck with your implementation! 🚀