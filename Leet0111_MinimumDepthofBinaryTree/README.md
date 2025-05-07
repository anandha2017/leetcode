# Minimum Depth of Binary Tree

## Problem Description

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:** A leaf is a node with no children.

## Examples

### Example 1:

```
    3
   / \
  9  20
    /  \
   15   7
```

**Input:** root = [3,9,20,null,null,15,7]
**Output:** 2
**Explanation:** The minimum depth is 2, which is the depth of node 9.

### Example 2:

```
    2
     \
      3
       \
        4
         \
          5
           \
            6
```

**Input:** root = [2,null,3,null,4,null,5,null,6]
**Output:** 5
**Explanation:** The minimum depth is 5, which follows the path: 2 → 3 → 4 → 5 → 6.

### Example 3:

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
**Output:** 3
**Explanation:** The minimum depth is 3, which follows the path: 1 → 3 → 5.

### Example 4:

```
       1
      / \
     2   3
    /   / \
   4   5   6
      /
     7
```

**Input:** root = [1,2,3,4,null,5,6,null,null,7]
**Output:** 2
**Explanation:** The minimum depth is 2, which follows the path: 1 → 2 → 4.

### Example 5:

```
      1
     /
    2
   /
  3
 /
4
```

**Input:** root = [1,2,null,3,null,4]
**Output:** 4
**Explanation:** The minimum depth is 4, which follows the path: 1 → 2 → 3 → 4.

## Constraints

- The number of nodes in the tree is in the range [0, 10^5].
- -1000 <= Node.val <= 1000

## Notes

- Remember that the minimum depth is defined as the number of nodes along the shortest path from the root node to the nearest leaf node.
- A leaf node is a node with no children.
- The problem is asking for the shortest path to a leaf node, not just any node.

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