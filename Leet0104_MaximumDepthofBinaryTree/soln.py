from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

        return self.traverseInorder(root, 0)

    def traverseInorder(self, root: Optional[TreeNode], depth: int) -> int:
        maxdepth = depth

        if root is None:
            return maxdepth

        depth += 1

        return max(
            self.traverseInorder(root.left, depth),
            self.traverseInorder(root.right, depth)
        )


solution = Solution()

# Define some formatting constants
TRUNC = 50
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

def assert_solution(input_list: List[int],  expected: bool):
    """Test solution with given input and expected output."""
    input_copy = list(input_list)
    output = solution.maxDepth(create_binary_tree(input_copy))
    assert_pass = output == expected

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input 1: {truncate_str(str(input_list))}, "
        f"Expected: {truncate_str(str(expected))}"
        f"{' , Got: ' + truncate_str(str(output)) if not assert_pass else ''}"
    )

    return assert_pass

assert_solution([3, 9, 20, NULL, NULL, 15, 7], 3)
assert_solution([1, NULL, 2], 2)
assert_solution([], 0)

# Base cases
assert_solution([], 0)  # Empty tree
assert_solution([1], 1)  # Single node tree

# Basic cases from examples
assert_solution([3, 9, 20, NULL, NULL, 15, 7], 3)
assert_solution([1, NULL, 2], 2)

# Left-skewed trees
assert_solution([1, 2, NULL, 3, NULL, 4], 4)
assert_solution([1, 2, NULL, 3], 3)

# Right-skewed trees
assert_solution([1, NULL, 2, NULL, 3, NULL, 4], 4)
assert_solution([1, NULL, 2, NULL, 3], 3)

# Balanced trees
assert_solution([1, 2, 3, 4, 5, 6, 7], 3)
assert_solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], 4)

# Unbalanced trees
assert_solution([1, 2, 3, 4, 5, NULL, NULL, 6], 4)
assert_solution([1, 2, 3, NULL, NULL, 4, 5, NULL, NULL, 6], 4)

# Trees with gaps
assert_solution([1, 2, NULL, 3, 4], 3)
assert_solution([1, NULL, 2, 3, NULL, NULL, 4], 4)

# Complex cases
assert_solution([5, 4, 7, 3, NULL, 2, NULL, -1, NULL, 9], 4)
assert_solution([7, 8, 9, 10, NULL, 11, 12, 13, 14, NULL, NULL, 15, 16], 4)