# Pascal's Triangle

## Problem Description

Given an integer `numRows`, return the first `numRows` of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

## Examples

### Example 1:
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

Visual representation:
```
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

### Example 2:
```
Input: numRows = 1
Output: [[1]]
```

Visual representation:
```
1
```

### Example 3:
```
Input: numRows = 6
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1]]
```

Visual representation:
```
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1
1 5 10 10 5 1
```

### Example 4:
```
Input: numRows = 8
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1],[1,6,15,20,15,6,1],[1,7,21,35,35,21,7,1]]
```

Visual representation:
```
       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
  1 5 10 10 5 1
 1 6 15 20 15 6 1
1 7 21 35 35 21 7 1
```

## Constraints

- `1 <= numRows <= 30`

## Interesting Properties of Pascal's Triangle

1. Each number is the sum of the two numbers directly above it
2. The first and last number in each row is always 1
3. Each row represents the coefficients of the binomial expansion (x + y)^n
4. The sum of numbers in row n is 2^n
5. Each row is symmetric

## Task

Implement a solution in Java that generates the first `numRows` of Pascal's triangle.


## Good luck!

Remember, the key insight is understanding how each number in the triangle relates to the numbers in the row above it.