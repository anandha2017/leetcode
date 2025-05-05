# Maximum Depth of Binary Tree

## LeetCode Problem 104

### Problem Description

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of levels from the root node down to the farthest leaf node.

### Examples

**Example 1:**
```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

Tree Visualisation:
```
    3
   / \
  9  20
    /  \
   15   7
```

Explanation: The tree has 3 levels - level 1: node with value 3, level 2: nodes with values 9 and 20, level 3: nodes with values 15 and 7. Hence, the maximum depth is 3.

**Example 2:**
```
Input: root = [1,null,2]
Output: 2
```

Tree Visualisation:
```
  1
   \
    2
```

Explanation: The tree has 2 levels - level 1: node with value 1, level 2: node with value 2. Hence, the maximum depth is 2.

**Example 3:**
```
Input: root = [1,2,3,4,5]
Output: 3
```

Tree Visualisation:
```
    1
   / \
  2   3
 / \
4   5
```

Explanation: The tree has 3 levels - level 1: node with value 1, level 2: nodes with values 2 and 3, level 3: nodes with values 4 and 5. Hence, the maximum depth is 3.

**Example 4:**
```
Input: root = []
Output: 0
```

Explanation: An empty tree has 0 depth.

**Example 5:**
```
Input: root = [7,8,9,10,null,11,12,13,14,null,null,15,16]
Output: 4
```

Tree Visualisation:
```
       7
     /   \
    8     9
   / \   / \
  10    11  12
 / \      \
13  14     15
           /
          16
```

Explanation: The tree has 4 levels, with the longest path going from node 7 → node 9 → node 11 → node 15 → node 16.

### Constraints

* The number of nodes in the tree is in the range [0, 10⁴].
* -100 <= Node.val <= 100

### Class Definition for Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
```

### Function Signature (Java)

```java
public int maxDepth(TreeNode root) {
    // Your solution here
}
```

### Notes

* A leaf node is a node with no children.
* The depth is defined as the number of nodes along the longest path.
* Remember to handle the case where the tree is empty (root is null).

## Instructions

1. Implement the `maxDepth` method in Java to solve this problem.
2. Test your solution with various test cases.
3. Analyse the time and space complexity of your solution.

