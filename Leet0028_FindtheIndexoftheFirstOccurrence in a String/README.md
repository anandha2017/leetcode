# Find the Index of the First Occurrence in a String

## Problem Statement

Given two strings, `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

---

## Examples

### Example 1

- **Input:**  
  `haystack = "sadbutsad"`, `needle = "sad"`
- **Output:**  
  `0`
- **Explanation:**  
  `"sad"` occurs at index 0 and 6. The first occurrence is at index 0, so the function returns 0.

---

### Example 2

- **Input:**  
  `haystack = "leetcode"`, `needle = "leeto"`
- **Output:**  
  `-1`
- **Explanation:**  
  `"leeto"` does not occur in `"leetcode"`, so the function returns -1.

---

## Constraints

- Both `haystack` and `needle` are non-empty strings.
- The function should return the index of the first occurrence of `needle` in `haystack`, or `-1` if not found.
