# Pascal's Triangle II

## Problem Description

Given an integer `rowIndex`, return the `rowIndex`th (0-indexed) row of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

![Pascal's Triangle Animation](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

## Examples

### Example 1:
```
Input: rowIndex = 3
Output: [1,3,3,1]
```

### Example 2:
```
Input: rowIndex = 0
Output: [1]
```

### Example 3:
```
Input: rowIndex = 1
Output: [1,1]
```

### Example 4:
```
Input: rowIndex = 4
Output: [1,4,6,4,1]
```

### Example 5:
```
Input: rowIndex = 5
Output: [1,5,10,10,5,1]
```

## Constraints

* `0 <= rowIndex <= 33`

## Visual Representation of Pascal's Triangle

```
Row 0:                    1
Row 1:                  1   1
Row 2:                1   2   1
Row 3:              1   3   3   1
Row 4:            1   4   6   4   1
Row 5:          1   5  10  10   5   1
Row 6:        1   6  15  20  15   6   1
Row 7:      1   7  21  35  35  21   7   1
Row 8:    1   8  28  56  70  56  28   8   1
```

## More Detailed Visualisation

Each number in a row is formed by adding the two numbers above it from the previous row:

```
    1
   / \
  1   1
 / \ / \
1  2  1
```

```
    1
   / \
  1   1
 / \ / \
1  2  1
/ \/ \/ \
1 3  3  1
```

## Challenge

You are given the task of implementing a solution in Java that returns the `rowIndex`th row of Pascal's triangle.

Follow-up: Could you optimize your algorithm to use only O(rowIndex) extra space?

## Notes

- Remember that Pascal's Triangle is 0-indexed in this problem, so rowIndex = 0 refers to the first row [1].
- Each row starts and ends with 1.
- The value at position `j` in row `i` is equal to the sum of values at positions `j-1` and `j` in row `i-1`.

Good luck!