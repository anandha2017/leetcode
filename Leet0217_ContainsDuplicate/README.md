# Contains Duplicate (LeetCode #217)

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Function Signature (Java)

```java
public boolean containsDuplicate(int[] nums)
```

## Examples

### Example 1

**Input:** `nums = [1,2,3,1]`
**Output:** `true`
**Explanation:** The element 1 occurs at indices 0 and 3

### Example 2

**Input:** `nums = [1,2,3,4]`
**Output:** `false`
**Explanation:** All elements are distinct

### Example 3

**Input:** `nums = [1,1,1,3,3,4,3,2,4,2]`
**Output:** `true`
**Explanation:** Multiple elements repeat (1, 3, 4, and 2)

### Example 4

**Input:** `nums = [7]`
**Output:** `false`
**Explanation:** Single element array cannot contain duplicates

### Example 5

**Input:** `nums = [5,5]`
**Output:** `true`
**Explanation:** Both elements are identical

### Example 6

**Input:** `nums = [-1,-2,-3,-1]`
**Output:** `true`
**Explanation:** Negative numbers can also be duplicates (-1 appears twice)

### Example 7

**Input:** `nums = [0,0,0,0,0]`
**Output:** `true`
**Explanation:** All elements are the same (zero repeated 5 times)

## Visual Representation

### Example 1 Breakdown:

```
Array: [1, 2, 3, 1]
Index:  0  1  2  3

Comparison Table:
Index | Value | Previously Seen?
------|-------|----------------
  0   |   1   |       No
  1   |   2   |       No
  2   |   3   |       No
  3   |   1   |      Yes! ← Duplicate found
```

### Example 3 Visualisation:

```
Array: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Index:  0  1  2  3  4  5  6  7  8  9

Duplicate Analysis:
Value 1: appears at indices [0, 1, 2] ✓
Value 3: appears at indices [3, 4, 6] ✓
Value 4: appears at indices [5, 8]    ✓
Value 2: appears at indices [7, 9]    ✓
```

### Edge Cases Visualisation:

**Empty Array:**

```
Array: []
Result: false (no elements to compare)
```

**Single Element:**

```
Array: [42]
Result: false (need at least 2 elements for a duplicate)
```

**Two Identical Elements:**

```
Array: [7, 7]
Index:  0  1
Result: true (minimum case for duplicate)
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Key Considerations

1. **Performance Requirements:** Consider the trade-offs between time and space complexity
2. **Edge Cases:** Handle empty arrays, single elements, and arrays with all identical values
3. **Data Range:** Elements can be negative, zero, or positive integers
4. **Array Size:** Arrays can contain up to 100,000 elements

## Test Cases for Your Solution

```java
// Basic test cases
int[] test1 = {1,2,3,1};           // Expected: true
int[] test2 = {1,2,3,4};           // Expected: false
int[] test3 = {1,1,1,3,3,4,3,2,4,2}; // Expected: true

// Edge cases
int[] test4 = {7};                 // Expected: false
int[] test5 = {5,5};               // Expected: true
int[] test6 = {};                  // Expected: false (if allowed)

// Negative numbers
int[] test7 = {-1,-2,-3,-1};       // Expected: true

// All same elements
int[] test8 = {0,0,0,0,0};         // Expected: true

// Large array with no duplicates
int[] test9 = {1,2,3,4,5,6,7,8,9,10}; // Expected: false

// Large array with one duplicate at the end
int[] test10 = {1,2,3,4,5,6,7,8,9,1}; // Expected: true
```

## Notes

- Think about different approaches and their time/space complexity trade-offs
- Consider what happens when you find the first duplicate - do you need to continue checking?
- Pay attention to the problem constraints when choosing your approach

Good luck with your implementation!
