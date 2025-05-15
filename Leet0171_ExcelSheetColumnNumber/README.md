# Excel Sheet Column Number

## Problem Statement

Given a string `columnTitle` that represents the column title as it appears in an Excel sheet, return its corresponding column number.

For example:
```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
```

## Examples

### Example 1:
```
Input: columnTitle = "A"
Output: 1
```

### Example 2:
```
Input: columnTitle = "AB"
Output: 28
```

### Example 3:
```
Input: columnTitle = "ZY"
Output: 701
```

### Example 4:
```
Input: columnTitle = "BCD"
Output: 1434
```

### Example 5:
```
Input: columnTitle = "AAA"
Output: 703
```

## Visualisation

Here's a visual representation of how Excel column titles map to numbers:

```
| Column Title | Column Number | Calculation                          |
|--------------|---------------|--------------------------------------|
| A            | 1             | A = 1                                |
| B            | 2             | B = 2                                |
| Z            | 26            | Z = 26                               |
| AA           | 27            | AA = (1 × 26¹) + (1 × 26⁰) = 26 + 1  |
| AB           | 28            | AB = (1 × 26¹) + (2 × 26⁰) = 26 + 2  |
| BA           | 53            | BA = (2 × 26¹) + (1 × 26⁰) = 52 + 1  |
| ZA           | 677           | ZA = (26 × 26¹) + (1 × 26⁰) = 676 + 1|
| ZZ           | 702           | ZZ = (26 × 26¹) + (26 × 26⁰) = 676 + 26|
| AAA          | 703           | AAA = (1 × 26²) + (1 × 26¹) + (1 × 26⁰) = 676 + 26 + 1|
```

## Excel Column System

Think of the Excel column system as a base-26 numbering system, but with a twist: instead of starting at 0, it starts at 1 (A=1, B=2, ..., Z=26).

## Your Task

Implement a solution in Java that converts the Excel column title to its corresponding column number.

## Constraints

- `1 <= columnTitle.length <= 7`
- `columnTitle` consists only of uppercase English letters.
- `columnTitle` is in the range ["A", "FXSHRXW"].

## Notes

- The problem asks for a solution that converts from column title to column number, not the other way around.
- You do not need to handle invalid inputs.
- Your solution should work for all valid Excel column titles up to "FXSHRXW".