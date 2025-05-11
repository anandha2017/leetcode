# Single Number

## Problem Description

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

## Examples

### Example 1:
```
Input: nums = [2,2,1]
Output: 1
```

### Example 2:
```
Input: nums = [4,1,2,1,2]
Output: 4
```

### Example 3:
```
Input: nums = [1]
Output: 1
```

### Example 4 (Additional):
```
Input: nums = [7,3,7,1,3,6,6]
Output: 1
```

### Example 5 (Additional):
```
Input: nums = [9,5,9,4,5,8,4]
Output: 8
```

## Visualisation

Let's visualise what's happening in Example 2:

```
nums = [4,1,2,1,2]
```

If we group the same numbers together:

```
[4] [1,1] [2,2]
```

We can see that 4 is the only element without a pair.

Similarly, for Example 4:

```
nums = [7,3,7,1,3,6,6]
```

Grouping the same numbers:

```
[7,7] [3,3] [1] [6,6]
```

Here, 1 is the element that appears only once.

## Constraints

- 1 <= nums.length <= 3 * 10^4
- -3 * 10^4 <= nums[i] <= 3 * 10^4
- Each element in the array appears twice except for one element which appears only once.

## Challenge

Implement a Java solution that finds the single number in the array.

Remember the key requirements:
- Linear time complexity O(n)
- Constant space complexity O(1)

Good luck!