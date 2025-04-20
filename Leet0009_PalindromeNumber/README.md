# Palindrome Number

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

A **palindrome** is a number that reads the same forward and backward.

## Problem Description

- **Input**:  
  - `x`: an integer
- **Output**:  
  - A boolean: `true` if `x` is a palindrome, otherwise `false`.

## Examples

1. **Example 1**
   ```
   Input:  x = 121
   Output: true
   Explanation: 121 reads as 121 from left to right and from right to left.
   ```

2. **Example 2**
   ```
   Input:  x = -121
   Output: false
   Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
   Therefore it is not a palindrome.
   ```

3. **Example 3**
   ```
   Input:  x = 10
   Output: false
   Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
   ```

## Constraints

- `-2^31 <= x <= 2^31 - 1`

## Follow‑up

Could you solve it **without** converting the integer to a string?
