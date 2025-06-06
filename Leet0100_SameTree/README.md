# Same Tree

## Problem Description

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Examples

### Example 1:

```
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

Tree p:
```
    1
   / \
  2   3
```

Tree q:
```
    1
   / \
  2   3
```

### Example 2:

```
Input: p = [1,2], q = [1,null,2]
Output: false
```

Tree p:
```
    1
   /
  2
```

Tree q:
```
  1
   \
    2
```

### Example 3:

```
Input: p = [1,2,1], q = [1,1,2]
Output: false
```

Tree p:
```
    1
   / \
  2   1
```

Tree q:
```
    1
   / \
  1   2
```

## Constraints

- The number of nodes in both trees is in the range `[0, 100]`.
- `-10^4 <= Node.val <= 10^4`

## Problem Category

- Data Structure: Binary Tree
- Difficulty: Easy
- LeetCode Problem #100