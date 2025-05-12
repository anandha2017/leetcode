# Binary Tree Postorder Traversal

## Problem Description

Given the `root` of a binary tree, return the postorder traversal of its nodes' values.

## Problem Link
[LeetCode - Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

## Definition for a Binary Tree Node

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

## Postorder Traversal Explained

In a postorder traversal of a binary tree, for each node:
1. First, visit all nodes in the left subtree
2. Then, visit all nodes in the right subtree
3. Finally, visit the root node itself

The pattern is: **Left → Right → Root**

## Examples

### Example 1:
```
Input: root = [1,null,2,3]
Output: [3,2,1]
```

Visual representation:
```
    1
     \
      2
     /
    3
```

Traversal process:
- Start at root (1)
- No left subtree for root
- Visit right subtree (2)
  - Visit left subtree of 2 (which is 3)
    - No subtrees for 3
    - Visit 3 → [3]
  - Visit 2 → [3,2]
- Visit root (1) → [3,2,1]

### Example 2:
```
Input: root = []
Output: []
```

### Example 3:
```
Input: root = [1]
Output: [1]
```

### Example 4 (Additional):
```
Input: root = [5,3,7,2,4,6,8]
Output: [2,4,3,6,8,7,5]
```

Visual representation:
```
        5
       / \
      3   7
     / \ / \
    2  4 6  8
```

Traversal process:
- Start at root (5)
- Visit left subtree (3)
  - Visit left subtree of 3 (which is 2)
    - No subtrees for 2
    - Visit 2 → [2]
  - Visit right subtree of 3 (which is 4)
    - No subtrees for 4
    - Visit 4 → [2,4]
  - Visit 3 → [2,4,3]
- Visit right subtree (7)
  - Visit left subtree of 7 (which is 6)
    - No subtrees for 6
    - Visit 6 → [2,4,3,6]
  - Visit right subtree of 7 (which is 8)
    - No subtrees for 8
    - Visit 8 → [2,4,3,6,8]
  - Visit 7 → [2,4,3,6,8,7]
- Visit root (5) → [2,4,3,6,8,7,5]

### Example 5 (Additional):
```
Input: root = [10,5,15,3,7,null,18]
Output: [3,7,5,18,15,10]
```

Visual representation:
```
       10
      /  \
     5    15
    / \     \
   3   7     18
```

## Constraints

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

## Task

Implement the `postorderTraversal` method:

```java
public List<Integer> postorderTraversal(TreeNode root) {
    // Your implementation here
}
```

Return the postorder traversal of the binary tree as a list of integers.

## Notes

- Think about how you can explore a tree recursively following the left-right-root pattern
- Consider if there's an iterative approach as well
- Think about edge cases (empty tree, single node tree)

Good luck with your implementation!