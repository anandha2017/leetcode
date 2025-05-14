# Excel Sheet Column Title

## Problem Description

Given an integer `columnNumber`, return its corresponding column title as it appears in an Excel spreadsheet.

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
Input: columnNumber = 1
Output: "A"
```

### Example 2:
```
Input: columnNumber = 28
Output: "AB"
```

### Example 3:
```
Input: columnNumber = 701
Output: "ZY"
```

### Additional Examples:
```
Input: columnNumber = 52
Output: "AZ"

Input: columnNumber = 53
Output: "BA"

Input: columnNumber = 2147
Output: "BYQ"

Input: columnNumber = 18278
Output: "ZZZ"

Input: columnNumber = 18279
Output: "AAAA"
```

## Visual Representation

Here's a visual representation of how Excel column titles work:

```
    1  2  3  4  ...  26
    A  B  C  D  ...  Z

   27 28 29 30  ...  52
   AA AB AC AD  ...  AZ

   53 54 55 56  ...  78
   BA BB BC BD  ...  BZ

  ...

  703 704 705
  AAA AAB AAC
```

Think of this as a 26-base number system (instead of our usual decimal system which is base 10), but with a twist!

## Constraints

- 1 <= columnNumber <= 2^31 - 1

## Task

Implement a solution in Java that converts a given integer to its corresponding Excel column title.

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        // Your implementation here
    }
}
```

## Test Cases

You can test your solution with these test cases:

1. Input: `1` → Expected Output: `"A"`
2. Input: `28` → Expected Output: `"AB"`
3. Input: `701` → Expected Output: `"ZY"`
4. Input: `52` → Expected Output: `"AZ"`
5. Input: `53` → Expected Output: `"BA"`
6. Input: `2147` → Expected Output: `"BYQ"`
7. Input: `18278` → Expected Output: `"ZZZ"`
8. Input: `18279` → Expected Output: `"AAAA"`

Good luck with your solution!
