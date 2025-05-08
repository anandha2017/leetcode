# LeetCode 112: Path Sum

## Problem Description

Given the root of a binary tree and an integer `targetSum`, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the `targetSum`.

**Note**: A leaf is a node with no children.

## Examples

### Example 1:

```
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1
```

**Input**: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
**Output**: true
**Explanation**: The root-to-leaf path with the target sum is shown below:
5 -> 4 -> 11 -> 2 = 22

### Example 2:

```
    1
   / \
  2   3
```

**Input**: root = [1,2,3], targetSum = 5
**Output**: false
**Explanation**: There are two root-to-leaf paths in the tree:
- 1 -> 2: Sum = 3
- 1 -> 3: Sum = 4
There is no root-to-leaf path with sum = 5.

### Example 3:

```
    1
   /
  2
```

**Input**: root = [1,2], targetSum = 1
**Output**: false
**Explanation**: The only root-to-leaf path is 1 -> 2 with sum = 3, which is not equal to 1.

### Example 4:

```
    -2
      \
       -3
```

**Input**: root = [-2,null,-3], targetSum = -5
**Output**: true
**Explanation**: There is one root-to-leaf path -2 -> -3 with sum = -5.

### Example 5:

```
    10
   /  \
  5   -3
 / \    \
3   2    11
   / \
  3  -2
```

**Input**: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
**Output**: true
**Explanation**: The path 10 -> 5 -> 2 -> -2 sums to 8, which is equal to the target sum.

## Constraints

- The number of nodes in the tree is in the range [0, 5000].
- -1000 <= Node.val <= 1000
- -1000 <= targetSum <= 1000

## Understanding the Problem

A valid path for this problem has the following characteristics:
- Must start at the root node
- Must end at a leaf node (a node with no children)
- The sum of all node values along this path should be equal to the given targetSum

## Problem Visualization

Here are visualisations of how paths are evaluated for Example 1:

Path 1: 5 -> 4 -> 11 -> 7 = 27 ≠ 22 (Not a match)
```
       5
      /
     4
    /
   11
  /
 7
```

Path 2: 5 -> 4 -> 11 -> 2 = 22 = 22 (Match! This is why the answer is true)
```
       5
      /
     4
    /
   11
    \
     2
```

Path 3: 5 -> 8 -> 13 = 26 ≠ 22 (Not a match)
```
       5
        \
         8
        /
       13
```

Path 4: 5 -> 8 -> 4 -> 1 = 18 ≠ 22 (Not a match)
```
       5
        \
         8
          \
           4
            \
             1
```

## Task

Implement the `hasPathSum` function in Java which takes the root of a binary tree and a target sum as parameters and returns a boolean indicating whether there exists a path from root to leaf that sums to the target.

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
public boolean hasPathSum(TreeNode root, int targetSum) {
    // Your implementation here
}
```

## Tips

- Think about how you can track the running sum as you traverse down each path.
- Consider what happens when you reach a leaf node.
- Don't forget to handle edge cases (e.g., an empty tree).
- Remember that the path must end at a leaf node (a node with no children).

Good luck with your solution!