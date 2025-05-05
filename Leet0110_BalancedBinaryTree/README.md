# Balanced Binary Tree

## Problem Description

Given a binary tree, determine if it is height-balanced.

A **height-balanced** binary tree is defined as:

> A binary tree in which the left and right subtrees of *every* node differ in height by no more than 1.

## Examples

### Example 1:

```
    3
   / \
  9  20
     / \
    15  7
```

**Input:** root = [3,9,20,null,null,15,7]
**Output:** true
**Explanation:** The left subtree has a height of 1, and the right subtree has a height of 2. The difference is no more than 1, so the tree is balanced.

### Example 2:

```
        1
       / \
      2   2
     / \
    3   3
   / \
  4   4
```

**Input:** root = [1,2,2,3,3,null,null,4,4]
**Output:** false
**Explanation:** The left subtree of the node with value 2 has a height of 2, but the right subtree has a height of 0. The difference is 2, which is greater than 1, so the tree is not balanced.

### Example 3:

```
    1
```

**Input:** root = [1]
**Output:** true
**Explanation:** A tree with only one node is balanced since both its left and right subtrees have heights of 0.

### Example 4:

```
    1
   /
  2
 /
3
```

**Input:** root = [1,2,null,3]
**Output:** false
**Explanation:** The left subtree has a height of 2, and the right subtree has a height of 0. The difference is 2, which is greater than 1, so the tree is not balanced.

### Example 5:

```
      1
     / \
    2   3
   /     \
  4       5
 /         \
6           7
```

**Input:** root = [1,2,3,4,null,null,5,6,null,null,7]
**Output:** false
**Explanation:** The tree is not balanced because the left subtree of node 1 has a height of 3, while the right subtree has a height of 2.

## Constraints

- The number of nodes in the tree is in the range [0, 5000].
- -10^4 <= Node.val <= 10^4

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

## Task

Implement the `isBalanced` function:

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        // Your implementation here
    }
}
```

## Understanding Height of a Binary Tree

The height of a binary tree is the length of the longest path from the root node to any leaf node.

- An empty tree has a height of -1 (some implementations use 0)
- A tree with just a root node has a height of 0
- For all other trees, the height is 1 + max(height of left subtree, height of right subtree)

## Visualizing Balanced vs Unbalanced Trees

### Balanced Tree Examples:

```
    3           1           1          Empty Tree
   / \         / \           \
  9  20       2   3           2
     / \                       \
    15  7                       3
```

### Unbalanced Tree Examples:

```
      1             1             1
     /             /               \
    2             2                 2
   /               \                 \
  3                 3                 3
 /                   \                 \
4                     4                 4
```

## Notes

- The key lies in understanding the definition of a height-balanced tree.
- Think about how to efficiently determine the height of a tree.
- Consider how to avoid redundant calculations.