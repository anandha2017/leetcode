from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        if root is None:
            return True

        return self.mirroCheck(root.left, root.right)

    def mirroCheck(self, leftnode: Optional[TreeNode], rightnode: Optional[TreeNode],) -> bool:
        if leftnode is None and rightnode is None:
            return True

        if leftnode is None and rightnode is not None:
            return False

        if leftnode is not None and rightnode is None:
            return False

        if leftnode.val != rightnode.val:
            return False

        return (
            self.mirroCheck(leftnode.left, rightnode.right) and
            self.mirroCheck(leftnode.right, rightnode.left)
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
    output = solution.isSymmetric(create_binary_tree(input_copy))
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

# Test cases for Symmetric Tree (LeetCode Problem 101)

# Test examples from the problem description
assert_solution([1,2,2,3,4,4,3], True)
assert_solution([1,2,2,None,3,None,3], False)

# Additional examples from the README
assert_solution([5,1,1,2,3,3,2], True)
assert_solution([5,1,1,2,None,None,2], True)
assert_solution([4,7,7,9,None,None,9,1,3,None,None,None,None,3,1], True)
assert_solution([4,7,7,9,None,None,9,1,3,None,None,None,None,1,3], False)

# Edge cases
assert_solution([1], True)  # Single node is always symmetric
assert_solution([], True)  # Empty tree is symmetric
assert_solution([1,2,3], False)  # Different values in left and right subtrees
assert_solution([1,2,2,2,None,2,None], False)  # Structurally different left and right subtrees
assert_solution([1,2,2,None,3,3,None], True)  # Symmetric with missing leaves
assert_solution([1,2,2,3,None,None,3], True)  # Symmetric with missing inner nodes

# More complex examples
assert_solution([1,2,2,3,4,4,3,5,6,7,8,8,7,6,5], True)  # Deeply nested symmetric tree
assert_solution([1,2,2,3,4,4,3,5,6,7,8,8,7,6,9], False)  # Deep tree with asymmetry at leaf level
assert_solution([1,2,2,None,3,3,None,4,5,5,4], False)  # Irregular but symmetric tree
assert_solution([1,2,2,None,3,4,None,None,None,5,None,6,None,None,7], False)  # Complex asymmetric structure

# Testing with negative values
assert_solution([0,-8,-8,7,9,9,7], True)  # Symmetric tree with negative values
assert_solution([0,-8,-8,7,9,7,9], False)  # Asymmetric tree with negative values

# Testing with repeated values but different structure
assert_solution([1,1,1,1,1,1,1], True)  # All values same, symmetric structure
assert_solution([1,1,1,1,1,None,1], False)  # All values same, asymmetric structure

# Testing larger values within constraints
assert_solution([100,42,42,-100,-100,-100,-100], True)  # Values at constraint boundaries, symmetric
assert_solution([100,42,42,-100,99,99,-100], True)  # Large values, symmetric
