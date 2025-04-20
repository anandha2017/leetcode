# Two Sum

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input has exactly one solution, and you may not use the same element twice. You can return the answer in any order.

## Problem Description

- **Input**:
  - `nums`: an array of integers
  - `target`: an integer
- **Output**: an array of two indices `[i, j]` such that `nums[i] + nums[j] === target`

## Examples

1. **Example 1**
   ```
   Input:  nums = [2, 7, 11, 15]
   Target: 9
   Output: [0, 1]
   Explanation: nums[0] + nums[1] === 9
   ```

2. **Example 2**
   ```
   Input:  nums = [3, 2, 4]
   Target: 6
   Output: [1, 2]
   ```

3. **Example 3**
   ```
   Input:  nums = [3, 3]
   Target: 6
   Output: [0, 1]
   ```

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Exactly one valid answer exists.

## Follow‑up

Can you devise an algorithm with better than O(n²) time complexity?
