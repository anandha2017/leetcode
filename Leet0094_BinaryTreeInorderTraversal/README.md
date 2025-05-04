# 94. Binary Tree Inorder Traversal

## Problem Description

Given the `root` of a binary tree, return *the inorder traversal of its nodes' values*.

## Difficulty Level
Easy

## Examples

### Example 1:
```
Input: root = [1,null,2,3]
Output: [1,3,2]
```

Visualization:
```
    1
     \
      2
     /
    3
```

### Example 2:
```
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
```

Visualization:
```
        1
       / \
      2   3
     / \   \
    4   5   8
       / \  /
      6  7 9
```

### Example 3:
```
Input: root = []
Output: []
```

Visualization: Empty tree (no nodes)

### Example 4:
```
Input: root = [1]
Output: [1]
```

Visualization:
```
    1
```

### Example 5 (Additional):
```
Input: root = [5,3,6,2,4,null,null,1]
Output: [1,2,3,4,5,6]
```

Visualization:
```
      5
     / \
    3   6
   / \
  2   4
 /
1
```

### Example 6 (Additional):
```
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: [1,3,4,6,7,8,10,13,14]
```

Visualization:
```
       8
     /   \
    3     10
   / \      \
  1   6      14
     / \    /
    4   7  13
```

## Constraints

* The number of nodes in the tree is in the range `[0, 100]`.
* `-100 <= Node.val <= 100`

## Challenge

Recursive solution is trivial, could you do it iteratively?

## Definition for a Binary Tree Node

```python
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```

## Function Signature

```python
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # Your solution here
        pass
```