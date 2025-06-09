# Isomorphic Strings

## Problem Statement

Two strings s and t are isomorphic if the characters in s can be replaced to get t. All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Given two strings `s` and `t`, determine if they are isomorphic.

## Key Rules

1. **One-to-One Mapping**: Each character in string `s` must map to exactly one character in string `t`
2. **Consistent Mapping**: All occurrences of a character must map to the same character
3. **Bijective Relationship**: No two different characters can map to the same character
4. **Self-Mapping Allowed**: A character may map to itself
5. **Order Preservation**: The order of characters must be maintained

## Examples

### Example 1: Basic Isomorphic Strings
```
Input: s = "egg", t = "add"
Output: true

Mapping:
e → a
g → d
```

**Visualisation:**
```
s: e g g
   ↓ ↓ ↓
t: a d d
```

### Example 2: Non-Isomorphic - Multiple Mappings
```
Input: s = "foo", t = "bar"
Output: false

Problem:
o would need to map to both 'a' and 'r'
```

**Visualisation:**
```
s: f o o
   ↓ ↓ ↓
t: b a r
     ↑ ↑
   Conflict!
```

### Example 3: Complex Isomorphic Case
```
Input: s = "paper", t = "title"
Output: true

Mapping:
p → t
a → i
e → l
r → e
```

**Visualisation:**
```
s: p a p e r
   ↓ ↓ ↓ ↓ ↓
t: t i t l e

Mappings:
p → t (positions 0, 2)
a → i (position 1)
e → l (position 3)
r → e (position 4)
```

### Example 4: Self-Mapping
```
Input: s = "abccba", t = "xyzxyz"
Output: false

Problem:
'a' maps to 'x' at position 0
'a' maps to 'y' at position 5 (conflict!)
```

### Example 5: Different Lengths
```
Input: s = "abc", t = "ab"
Output: false

Reason: Different string lengths cannot be isomorphic
```

### Example 6: Single Character Strings
```
Input: s = "a", t = "b"
Output: true

Mapping: a → b
```

### Example 7: Repeated Characters - Valid
```
Input: s = "aab", t = "xxy"
Output: true

Mapping:
a → x
b → y
```

**Visualisation:**
```
s: a a b
   ↓ ↓ ↓
t: x x y

Both 'a' consistently map to 'x'
```

### Example 8: Repeated Characters - Invalid
```
Input: s = "aab", t = "xyz"
Output: false

Problem:
First 'a' would map to 'x'
Second 'a' would map to 'y' (conflict!)
```

### Example 9: Palindromic Pattern
```
Input: s = "abba", t = "cddc"
Output: true

Mapping:
a → c
b → d
```

**Visualisation:**
```
s: a b b a
   ↓ ↓ ↓ ↓
t: c d d c

Pattern preserved
```

### Example 10: Collision Case
```
Input: s = "badc", t = "baba"
Output: false

Problem:
b → b (position 0)
d → b (position 2)
Two different characters mapping to same character!
```

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII character

## Test Cases for Consideration

### Edge Cases
```java
// Equal strings
s = "abc", t = "abc" → true

// Empty strings (if allowed)
s = "", t = "" → true

// All same character
s = "aaa", t = "bbb" → true
s = "aaa", t = "abc" → false

// Maximum constraints
s = "a".repeat(50000), t = "b".repeat(50000) → true
```

### Pattern Recognition Cases
```java
// Alternating pattern
s = "abab", t = "cdcd" → true
s = "abab", t = "cdef" → false

// Complex patterns
s = "abcabc", t = "xyzxyz" → true
s = "abcabc", t = "xyztyz" → false
```

## Algorithm Considerations

### Time Complexity Target
- **O(n)** - Single pass through both strings
- Where n is the length of the strings

### Space Complexity Target
- **O(1)** to **O(k)** - Where k is the number of unique characters
- Typically O(1) for ASCII characters (at most 256 unique characters)

### Key Implementation Points

1. **Early Termination**: Check string lengths first
2. **Bidirectional Mapping**: Need to track both s→t and t→s mappings
3. **Conflict Detection**: Identify mapping inconsistencies quickly
4. **Memory Efficiency**: Choose appropriate data structures

## Approach Hints

Consider these strategies:
- **Hash Maps**: Track character mappings
- **Array Indexing**: Use ASCII values for fast lookup
- **Pattern Matching**: Compare character occurrence patterns

## Related Problems

- Word Pattern (LeetCode 290)
- Word Pattern II (LeetCode 291)
- Group Anagrams (LeetCode 49)

## Performance Expectations

For optimal solution:
- **Time**: O(n) single pass
- **Space**: O(1) constant space for ASCII characters
- **Edge Cases**: Handle all constraint boundaries

---

*Challenge yourself to implement multiple approaches and compare their trade-offs!*