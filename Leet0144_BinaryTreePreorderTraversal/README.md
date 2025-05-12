# Binary Tree Preorder Traversal

## Problem Description

Given the root of a binary tree, return the preorder traversal of its nodes' values.

In a **preorder traversal**, nodes are visited in the following order:
1. Visit the root node
2. Recursively traverse the left subtree
3. Recursively traverse the right subtree

## Examples

### Example 1:
```
Input: root = [1,null,2,3]
Output: [1,2,3]
```

Visualisation:
```
    1
     \
      2
     /
    3
```

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

### Example 4:
```
Input: root = [1,2,3,4,5,null,6]
Output: [1,2,4,5,3,6]
```

Visualisation:
```
        1
       / \
      2   3
     / \   \
    4   5   6
```

### Example 5:
```
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: [8,3,1,6,4,7,10,14,13]
```

Visualisation:
```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13
```

## Constraints

- The number of nodes in the tree is in the range [0, 100]
- -100 <= Node.val <= 100

## TreeNode Definition

```java
// Definition for a binary tree node.
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

## Understanding Preorder Traversal

In preorder traversal (also known as "Root-Left-Right" traversal), we:
1. Process the current node first ("Pre" means "before")
2. Then process the left subtree
3. Then process the right subtree

For example, in our Example 4 tree:
```
        1
       / \
      2   3
     / \   \
    4   5   6
```

The preorder traversal visits the nodes in this order:
1. Visit 1 (root)
2. Visit 2 (left child of 1)
3. Visit 4 (left child of 2)
4. Visit 5 (right child of 2)
5. Visit 3 (right child of 1)
6. Visit 6 (right child of 3)

So the output is [1,2,4,5,3,6].

## Your Task

Implement the `preorderTraversal` method in Java:

```java
public List<Integer> preorderTraversal(TreeNode root) {
    // Your solution here
}
```

Good luck!