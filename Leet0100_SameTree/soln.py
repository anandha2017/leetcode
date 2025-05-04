from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:

        if p is None and q is None:
            return True

        return self.traverseInorder(p, q)

    def traverseInorder(self, root_p: Optional[TreeNode], root_q: Optional[TreeNode],) -> bool:

        if root_p and root_p.val == root_q and root_q.val:
            return True

        return self.traverseInorder(root_p.left, root_q.left) and self.traverseInorder(root_p.right, root_q.right)


solution = Solution()

# Define some formatting constants
TRUNC = 1000
NULL = -999
PASS_FORMAT = "\033[92m{}\033[0m"  # Green text
FAIL_FORMAT = "\033[91m{}\033[0m"  # Red text

def create_binary_tree(values: List[int]) -> Optional[TreeNode]:
    """Convert a list of integers to a binary tree.

    The input list represents a level-order traversal of the tree,
    where NULL (-999) indicates a missing node.
    """
    if not values:
        return None

    # Create the root node
    root = TreeNode(values[0])

    # Use a queue to keep track of nodes that need children
    queue = [root]
    i = 1  # Start from the second element

    # Process the rest of the values
    while queue and i < len(values):
        # Get the next node that needs children
        current = queue.pop(0)

        # Assign left child if value is not NULL
        if i < len(values) and values[i] != NULL:
            current.left = TreeNode(values[i])
            queue.append(current.left)

        i += 1

        # Assign right child if value is not NULL
        if i < len(values) and values[i] != NULL:
            current.right = TreeNode(values[i])
            queue.append(current.right)

        i += 1

    return root

def truncate_str(s: str, max_length: int = TRUNC) -> str:
    """Truncate a string to max_length characters, adding '...' if truncated."""
    if len(s) <= max_length:
        return s
    return s[:max_length-3] + "..."

def assert_solution(input_list1: List[int], input_list2: List[int], expected: bool):
    """Test solution with given input and expected output."""
    input1_copy = list(input_list1)
    input2_copy = list(input_list2)
    output = solution.isSameTree(create_binary_tree(input1_copy), create_binary_tree(input2_copy))
    assert_pass = output == expected

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input 1: {truncate_str(str(input_list1))}, "
        f"Input 2: {truncate_str(str(input_list2))}, "
        f"Expected: {truncate_str(str(expected))}"
        f"{' , Got: ' + truncate_str(str(output)) if not assert_pass else ''}"
    )

    return assert_pass

# Example 1 from problem statement
assert_solution([1, NULL, 2, 3], [1, 3, 2], False)

# Example 2 from problem statement
assert_solution([1, 2, 3, 4, 5, NULL, 8, NULL, NULL, 6, 7, 9], [4, 2, 6, 5, 7, 1, 3, 9, 8], False)

# Example 3: Empty tree
assert_solution([], [], True)

# Example 4: Single node tree
assert_solution([1], [1], True)

# Left-skewed tree
assert_solution([3, 2, NULL, 1], [1, 2, 3], False)

# Right-skewed tree
assert_solution([1, NULL, 2, NULL, 3], [1, 2, 3], False)

# Perfect binary tree
assert_solution([4, 2, 6, 1, 3, 5, 7], [1, 2, 3, 4, 5, 6, 7], False)

# Tree with negative values
assert_solution([0, -3, 9, -10, NULL, 5], [-10, -3, 0, 5, 9], False)

# Tree with duplicate values
assert_solution([5, 3, 8, 3, 4, 7, 8], [3, 3, 4, 5, 7, 8, 8], False)

# Tree with boundary values
assert_solution([0, -100, 100], [-100, 0, 100], False)

# Complex tree structure
assert_solution([8, 3, 10, 1, 6, NULL, 14, NULL, NULL, 4, 7, 13], [1, 3, 4, 6, 7, 8, 10, 13, 14], False)

# Deep tree - testing nested structure
assert_solution([5, 4, 8, 11, NULL, 13, 4, 7, 2, NULL, NULL, NULL, 1], [7, 11, 2, 4, 5, 13, 8, 4, 1], False)

# Unbalanced tree with multiple levels
assert_solution([10, 5, 15, 3, 7, NULL, 20, NULL, NULL, 6, 8], [3, 5, 6, 7, 8, 10, 15, 20], False)

# Base cases
assert_solution([], [], True)  # Empty trees are identical
assert_solution([1], [1], True)  # Single node trees with same value
assert_solution([1], [2], False)  # Single node trees with different values
assert_solution([1], [], False)  # One empty tree, one non-empty tree

# Simple cases - different structures
assert_solution([1, 2], [1, NULL, 2], False)  # Left child vs right child
assert_solution([1, 2, 3], [1, 3, 2], False)  # Same values but different positions
assert_solution([1, 2, NULL], [1, NULL, 2], False)  # Left child vs right child

# Simple cases - same structure but different values
assert_solution([1, 2, 3], [1, 2, 4], False)  # Difference in right child
assert_solution([1, 2, 3], [1, 4, 3], False)  # Difference in left child
assert_solution([5, 2, 3], [1, 2, 3], False)  # Difference in root

# Same trees with various structures
assert_solution([1, 2, 3], [1, 2, 3], True)  # Complete binary tree of depth 1
assert_solution([1, 2, 3, 4, 5], [1, 2, 3, 4, 5], True)  # Complete left side
assert_solution([1, NULL, 2, NULL, 3], [1, NULL, 2, NULL, 3], True)  # Right-skewed tree

# Complex cases - deep trees
assert_solution([1, 2, 3, 4, 5, 6, 7], [1, 2, 3, 4, 5, 6, 7], True)  # Perfect binary tree of depth 2
assert_solution([1, 2, 3, 4, 5, 6, 7], [1, 2, 3, 4, 5, 7, 6], False)  # One node swapped

# Edge cases using constraint boundaries
assert_solution([-10000], [-10000], True)  # Minimum value allowed
assert_solution([10000], [10000], True)  # Maximum value allowed
assert_solution([-10000], [10000], False)  # Min vs max values

# Large trees (approaching the constraint of 100 nodes)
# Create a balanced tree with many nodes but still readable
assert_solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
               [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], True)  # All nodes match

# Different at leaf level
assert_solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
               [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16], False)  # Last node different

# One tree deeper than the other
assert_solution([1, 2, 3, 4, 5, 6, 7], [1, 2, 3, 4, 5, 6, 7, 8], False)  # Second tree has extra node

# Mixed NULL values in different positions
assert_solution([1, 2, 3, NULL, 4, NULL, 5], [1, 2, 3, NULL, 4, NULL, 5], True)  # Same structure with NULLs
assert_solution([1, 2, 3, NULL, 4, NULL, 5], [1, 2, 3, 4, NULL, 5, NULL], False)  # Different structure with NULLs

# LeetCode fail
assert_solution([2,2,2,NULL,2,NULL,NULL,2], [2,2,2,2,NULL,2,NULL], False)
