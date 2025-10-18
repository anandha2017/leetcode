# Count Complete Tree Nodes

## Problem Description

Given the `root` of a **complete binary tree**, return the number of nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

**LeetCode Link:** [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

## Complete Binary Tree Properties

### Definition
A **complete binary tree** is a binary tree where:
- All levels are fully filled except possibly the last level
- The last level is filled from left to right
- Nodes are added level by level, left to right

### Key Characteristics
- Height h has between 2^h and 2^(h+1) - 1 nodes
- Perfect binary tree: exactly 2^(h+1) - 1 nodes
- Last level can have 1 to 2^h nodes

## Visual Examples

### Example 1: Perfect Complete Binary Tree
```
        1
       / \
      2   3
     / \ / \
    4  5 6  7
```
- **Height:** 2 (0-indexed from root)
- **Nodes:** 7
- **Formula:** 2^3 - 1 = 7 nodes

### Example 2: Incomplete Last Level
```
        1
       / \
      2   3
     / \ /
    4  5 6
```
- **Height:** 2
- **Nodes:** 6
- **Last level:** 3 out of 4 possible nodes

### Example 3: Single Node
```
    1
```
- **Height:** 0
- **Nodes:** 1

### Example 4: Two Levels
```
    1
   / \
  2   3
```
- **Height:** 1
- **Nodes:** 3

## Java TreeNode Definition

```java
/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

## Method Signature

```java
public class Solution {
    public int countNodes(TreeNode root) {
        // Your implementation here
    }
}
```

## Test Cases

### Test Case 1
```java
// Tree: [1,2,3,4,5,6]
//         1
//        / \
//       2   3
//      / \ /
//     4  5 6
TreeNode root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);

// Expected output: 6
```

### Test Case 2
```java
// Tree: []
TreeNode root = null;

// Expected output: 0
```

### Test Case 3
```java
// Tree: [1]
TreeNode root = new TreeNode(1);

// Expected output: 1
```

### Test Case 4
```java
// Tree: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
//             1
//           /   \
//          2     3
//         / \   / \
//        4   5 6   7
//       / \ / \ / \ / \
//      8 9 10 11 12 13 14 15
// Perfect complete binary tree

// Expected output: 15
```

## Approach Considerations

### Naive Approach: O(n)
- Simple traversal counting all nodes
- Visits every node once
- Doesn't utilise complete tree properties

### Optimised Approaches: O(log²n)
Consider these properties of complete binary trees:
- Left subtree height vs right subtree height
- Perfect subtrees have predictable node counts
- Binary search on the last level

### Key Insights
1. **Height Calculation:** Find left and right heights efficiently
2. **Perfect Detection:** Identify when subtrees are perfect
3. **Recursive Division:** Split problem into smaller subproblems
4. **Mathematical Formula:** Use 2^h - 1 for perfect trees

## Algorithm Hints

### Hint 1: Height Calculation
```java
// How might you calculate the height of left and right paths?
private int getLeftHeight(TreeNode node) {
    // Calculate height going only left
}

private int getRightHeight(TreeNode node) {
    // Calculate height going only right
}
```

### Hint 2: Perfect Tree Detection
```java
// What does it mean when left height equals right height?
if (leftHeight == rightHeight) {
    // This subtree is perfect - use formula
} else {
    // This subtree is not perfect - recurse
}
```

### Hint 3: Mathematical Formula
```java
// For a perfect binary tree of height h:
// Number of nodes = 2^h - 1
// Or using bit shifting: (1 << h) - 1
```

## Complexity Requirements

- **Time Complexity:** Less than O(n)
- **Space Complexity:** Consider recursion stack
- **Target:** O(log²n) time complexity

## Edge Cases to Consider

1. **Empty tree:** root = null
2. **Single node:** Only root exists
3. **Perfect tree:** All levels completely filled
4. **Minimal last level:** Only leftmost node in last level
5. **Maximum last level:** All nodes present in last level

## Testing Your Solution

```java
public class TestCountNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test empty tree
        assert solution.countNodes(null) == 0;

        // Test single node
        TreeNode single = new TreeNode(1);
        assert solution.countNodes(single) == 1;

        // Test example from problem
        TreeNode example = buildExampleTree();
        assert solution.countNodes(example) == 6;

        System.out.println("All tests passed!");
    }

    private static TreeNode buildExampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root;
    }
}
```

## Additional Resources

- **Complete Binary Tree Properties:** Study level-order filling patterns
- **Binary Tree Traversals:** Understand different traversal methods
- **Bit Manipulation:** Learn about powers of 2 and bit shifting
- **Recursion:** Practice with tree recursive patterns

---

**Difficulty:** Medium
**Topics:** Binary Tree, Tree, Binary Search
**Companies:** Amazon, Microsoft, Google, Facebook