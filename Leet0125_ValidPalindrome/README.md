# Valid Palindrome

## Problem Description

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, determine if it is a palindrome.

## Examples

### Example 1:

**Input:** `s = "A man, a plan, a canal: Panama"`
**Output:** `true`
**Explanation:** After removing non-alphanumeric characters and converting to lowercase, `s` becomes `"amanaplanacanalpanama"`. This reads the same forward and backward, so it is a palindrome.

### Example 2:

**Input:** `s = "race a car"`
**Output:** `false`
**Explanation:** After removing non-alphanumeric characters and converting to lowercase, `s` becomes `"raceacar"`. This does not read the same forward and backward, so it is not a palindrome.

### Example 3:

**Input:** `s = " "`
**Output:** `true`
**Explanation:** After removing non-alphanumeric characters, `s` becomes an empty string `""`. An empty string reads the same forward and backward, so it is a palindrome.

### Example 4:

**Input:** `s = "Coding,? is 101 si gnidoc!"`
**Output:** `true`
**Explanation:** After cleaning, `s` becomes `"codingis101signidoc"`, which is a palindrome.

### Example 5:

**Input:** `s = "0P0"`
**Output:** `true`
**Explanation:** After converting to lowercase, `s` becomes `"0p0"`, which is a palindrome.

### Example 6:

**Input:** `s = "ab_a"`
**Output:** `true`
**Explanation:** After removing non-alphanumeric characters, `s` becomes `"aba"`, which is a palindrome.

## Visualisation

To better understand the problem, let's visualise how we process a string to check if it's a palindrome:

### Processing the string: "A man, a plan, a canal: Panama"

Original string:
```
A man, a plan, a canal: Panama
```

Step 1: Convert to lowercase
```
a man, a plan, a canal: panama
```

Step 2: Remove non-alphanumeric characters
```
amanaplanacanalpanama
```

Step 3: Check if it reads the same forward and backward
```
Forward:  amanaplanacanalpanama
Backward: amanaplanacanalpanama
```

They match, so it's a palindrome.

### Processing the string: "race a car"

Original string:
```
race a car
```

Step 1: Convert to lowercase
```
race a car
```

Step 2: Remove non-alphanumeric characters
```
raceacar
```

Step 3: Check if it reads the same forward and backward
```
Forward:  raceacar
Backward: racaecar
```

They don't match, so it's not a palindrome.

## Constraints

- 1 <= s.length <= 2 * 10^5
- The string `s` consists only of printable ASCII characters.

## Task

Implement the `boolean isPalindrome(String s)` method in Java to solve this problem.

## Note

Remember that:
- You need to convert uppercase letters to lowercase
- You need to remove all non-alphanumeric characters
- A one-character or empty string is always a palindrome
- The comparison is case-insensitive

Good luck!