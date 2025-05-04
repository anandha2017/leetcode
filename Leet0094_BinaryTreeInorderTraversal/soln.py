from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        output = []
        self.traverseInorder(root, output)
        return output

    def traverseInorder(self, root: Optional[TreeNode], o: List[int]) -> None:
        if root is None:
            return

        self.traverseInorder(root.left, o)
        o.append(root.val)
        self.traverseInorder(root.right, o)

        return


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

def assert_solution(input_list: List[int], expected: List[int]):
    """Test solution with given input and expected output."""
    input_copy = list(input_list)
    output = solution.inorderTraversal(create_binary_tree(input_copy))
    assert_pass = output == expected

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input: {truncate_str(str(input_list))}, "
        f"Expected: {truncate_str(str(expected))}"
        f"{' , Got: ' + truncate_str(str(output)) if not assert_pass else ''}"
    )

    return assert_pass

# Example 1 from problem statement
assert_solution([1, NULL, 2, 3], [1, 3, 2])

# Example 2 from problem statement
assert_solution([1, 2, 3, 4, 5, NULL, 8, NULL, NULL, 6, 7, 9], [4, 2, 6, 5, 7, 1, 3, 9, 8])

# Example 3: Empty tree
assert_solution([], [])

# Example 4: Single node tree
assert_solution([1], [1])

# Left-skewed tree
assert_solution([3, 2, NULL, 1], [1, 2, 3])

# Right-skewed tree
assert_solution([1, NULL, 2, NULL, 3], [1, 2, 3])

# Perfect binary tree
assert_solution([4, 2, 6, 1, 3, 5, 7], [1, 2, 3, 4, 5, 6, 7])

# Tree with negative values
assert_solution([0, -3, 9, -10, NULL, 5], [-10, -3, 0, 5, 9])

# Tree with duplicate values
assert_solution([5, 3, 8, 3, 4, 7, 8], [3, 3, 4, 5, 7, 8, 8])

# Tree with boundary values
assert_solution([0, -100, 100], [-100, 0, 100])

# Complex tree structure
assert_solution([8, 3, 10, 1, 6, NULL, 14, NULL, NULL, 4, 7, 13], [1, 3, 4, 6, 7, 8, 10, 13, 14])

# Deep tree - testing nested structure
assert_solution([5, 4, 8, 11, NULL, 13, 4, 7, 2, NULL, NULL, NULL, 1], [7, 11, 2, 4, 5, 13, 8, 4, 1])

# Unbalanced tree with multiple levels
assert_solution([10, 5, 15, 3, 7, NULL, 20, NULL, NULL, 6, 8], [3, 5, 6, 7, 8, 10, 15, 20])
