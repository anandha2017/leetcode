# Majority Element

## Problem Statement

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `⌊n/2⌋` times. You may assume that the majority element always exists in the array.

## Examples

### Example 1:
```
Input: nums = [3,2,3]
Output: 3
```

### Example 2:
```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

### Example 3:
```
Input: nums = [8,8,7,7,7,7,7]
Output: 7
```
In this example, the array has 7 elements, so the majority element must appear at least ⌊7/2⌋ + 1 = 4 times. 7 appears 5 times, making it the majority element.

### Example 4:
```
Input: nums = [1,1,1,1,2,2,3]
Output: 1
```
Here, 1 appears 4 times in an array of length 7, which is more than ⌊7/2⌋.

## Visualisation

Let's visualise Example 2: `[2,2,1,1,1,2,2]`

Frequency of each element:
```
Element | Frequency
--------|----------
1       | 3
2       | 4
```

Visualising the array:
```
Index:  0 1 2 3 4 5 6
Array: [2,2,1,1,1,2,2]
       ^ ^     ^ ^
       | |     | |
       Elements that are 2
```

As we can see, 2 appears 4 times, which is greater than ⌊7/2⌋ = 3, making it the majority element.

## Constraints

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

## Challenge

Implement a solution in Java that finds the majority element in the given array.

**Extra Challenge:** Can you solve it in:
1. O(n) time and O(1) space? (without using extra space proportional to the input size)
2. O(n log n) time complexity?

## Hints (Optional)

<details>
<summary>Hint 1</summary>
Consider how you might solve this if you sorted the array first.
</details>

<details>
<summary>Hint 2</summary>
There's a well-known algorithm for finding the majority element in linear time and constant space.
</details>

Good luck solving the problem!