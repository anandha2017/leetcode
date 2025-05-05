# Convert Sorted Array to Binary Search Tree

## Problem Description

Given an integer array `nums` where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than 1.

## Examples

### Example 1:

**Input:**
```
nums = [-10,-3,0,5,9]
```

**Output:**
```
[0,-3,9,-10,null,5]
```

**Visualisation:**

Input array:
```
[-10, -3, 0, 5, 9]
```
Sorted in ascending order ^

Output tree:
```
      0
     / \
   -3   9
   /    /
 -10   5
```

Alternative valid solution:
```
      0
     / \
   -10  5
     \   \
     -3   9
```

### Example 2:

**Input:**
```
nums = [1,3]
```

**Output:**
```
[3,1]
```

**Visualisation:**

Input array:
```
[1, 3]
```
Sorted in ascending order ^

Output tree:
```
    3
   /
  1
```

Alternative valid solution:
```
    1
     \
      3
```

### Example 3:

**Input:**
```
nums = [-5,-4,-3,-2,-1,0,1,2,3,4,5]
```

**Output:**
```
[0,-3,4,-4,-1,2,5,-5,null,-2,null,1,3]
```

**Visualisation:**

Input array:
```
[-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5]
```
Sorted in ascending order ^

Output tree:
```
           0
         /   \
       -3     4
      /  \   / \
    -4   -1  2  5
   /    /   / \
 -5    -2  1   3
```

### Example 4:

**Input:**
```
nums = [0,1,2,3,4,5]
```

**Output:**
```
[3,1,5,0,2,4]
```

**Visualisation:**

Input array:
```
[0, 1, 2, 3, 4, 5]
```
Sorted in ascending order ^

Output tree:
```
      3
     / \
    1   5
   / \  /
  0  2  4
```

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

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in a strictly increasing order.

## Notes

- A height-balanced tree has a maximum height difference of 1 between any two sibling subtrees.
- Any balanced BST built from a sorted array is valid as long as it satisfies the height balance property.
- There may be multiple valid balanced BSTs that can be built from the same input array.