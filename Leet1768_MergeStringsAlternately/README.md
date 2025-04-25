# 1768. Merge Strings Alternately

## Problem Description

You are given two strings, `word1` and `word2`. The task is to merge these strings by adding letters in alternating order, starting with `word1`. If one string is longer than the other, append the additional letters from the longer string to the end of the merged result.

Return the final merged string.

---

## Examples

### Example 1

- **Input:**  
  `word1 = "abc"`, `word2 = "pqr"`
- **Output:**  
  `"apbqcr"`
- **Explanation:**  
  The merged string alternates characters from each word:  
  `a` (word1), `p` (word2), `b` (word1), `q` (word2), `c` (word1), `r` (word2).

---

### Example 2

- **Input:**  
  `word1 = "ab"`, `word2 = "pqrs"`
- **Output:**  
  `"apbqrs"`
- **Explanation:**  
  After alternating, the remaining characters `"rs"` from `word2` are appended.

---

### Example 3

- **Input:**  
  `word1 = "abcd"`, `word2 = "pq"`
- **Output:**  
  `"apbqcd"`
- **Explanation:**  
  After alternating, the remaining characters `"cd"` from `word1` are appended.

---

## Constraints

- `1 <= word1.length, word2.length <= 100`
- Both `word1` and `word2` consist of lowercase English letters only.

---

## Additional Information

This problem is commonly encountered in coding interviews and tests the ability to work with strings and iteration. The solution involves handling different string lengths and merging them efficiently.
