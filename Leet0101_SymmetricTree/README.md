# Symmetric Tree (LeetCode Problem 101)

## Problem Description

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## Examples

### Example 1:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
**Input:** root = [1,2,2,3,4,4,3]
**Output:** true

### Example 2:
```
    1
   / \
  2   2
   \   \
   3    3
```
**Input:** root = [1,2,2,null,3,null,3]
**Output:** false

### Example 3:
```
    5
   / \
  1   1
 /|   |\
2 3   3 2
```
**Input:** root = [5,1,1,2,3,3,2]
**Output:** true

### Example 4:
```
    5
   / \
  1   1
 /     \
2       2
```
**Input:** root = [5,1,1,2,null,null,2]
**Output:** true

### Example 5:
```
      4
     / \
    7   7
   /     \
  9       9
 / \     / \
1   3   3   1
```
**Input:** root = [4,7,7,9,null,null,9,1,3,null,null,null,null,3,1]
**Output:** true

### Example 6:
```
      4
     / \
    7   7
   /     \
  9       9
 / \     / \
1   3   1   3
```
**Input:** root = [4,7,7,9,null,null,9,1,3,null,null,null,null,1,3]
**Output:** false

## Constraints

- The number of nodes in the tree is in the range [1, 1000].
- `-100 <= Node.val <= 100`

## Definition for a Binary Tree Node

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Your implementation here
```

## Notes

- A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.
- Two trees are a mirror reflection of each other if:
  1. Their root values are the same
  2. The right subtree of the first tree is a mirror reflection of the left subtree of the second tree
  3. The left subtree of the first tree is a mirror reflection of the right subtree of the second tree
- Both recursive and iterative solutions are possible for this problem.