from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:

        return ListNode(0)

solution = Solution()

def create_linked_list(values: list[int]) -> Optional[ListNode]:
    """
    Convert a list of integers to a linked list.

    Args:
        values: A list of integers to convert into a linked list.
                Can be empty, which will return None.

    Returns:
        The head of the newly created linked list, or None if the input list is empty.

    Example:
        >>> to_list_node([1, 2, 3])
        # Returns a linked list: 1 -> 2 -> 3 -> None
    """

    sentinel = ListNode(0)          # temporary first link
    current = sentinel

    for val in values:              # works even when 'values' is empty
        current.next = ListNode(val)
        current = current.next

    return sentinel.next            # real head, or None if list was empty

def deep_copy_linked_list(head: Optional[ListNode]) -> Optional[ListNode]:
    """
    Create a deep copy of a linked list.

    Args:
        list1: The head of the linked list to copy.
              Can be None, which will return None.

    Returns:
        A new linked list with the same values as the original,
        or None if the input list is None.

    Note:
        This performs a deep copy - the new list contains new nodes
        with the same values, not references to the original nodes.
    """

    sentinel = ListNode(0)
    current = sentinel
    source = head

    while source:
        current.next = ListNode(source.val)
        current = current.next
        source = source.next

    return sentinel.next

def compare_linked_lists(list1: Optional[ListNode], list2: Optional[ListNode]) -> bool:
    """
    Compare two linked lists to check if they contain the same values in the same order.

    Args:
        list1: Head of the first linked list
        list2: Head of the second linked list

    Returns:
        True if both lists have identical values in the same order and same length,
        False otherwise

    Examples:
        >>> are_contents_the_same(to_list_node([1, 2, 3]), to_list_node([1, 2, 3]))
        True
        >>> are_contents_the_same(to_list_node([1, 2]), to_list_node([1, 2, 3]))
        False
        >>> are_contents_the_same(to_list_node([1, 2, 3]), to_list_node([1, 3, 2]))
        False
    """

    current1 = list1
    current2 = list2

    while current1 and current2:
        if current1.val != current2.val:
            return False

        current1 = current1.next
        current2 = current2.next

    # If both lists are exhausted simultaneously, they're equal
    # Otherwise, one list is longer than the other
    return current1 is None and current2 is None

def print_list_node(list1: Optional[ListNode]):

    print(f"list: {list1}")
    while list1:
        print(f"val:  {list1.val}")
        list1 = list1.next


def assert_solution(input_list: Optional[ListNode], expected: Optional[ListNode]):
    """
    Test the deleteDuplicates solution against expected output.

    Args:
        input_list: Input linked list to be processed
        expected: Expected result after removing duplicates

    Prints:
        PASS/FAIL status and details on failure
    """


    input_copy = deep_copy_linked_list(input_list)
    output = solution.deleteDuplicates(input_copy)
    assert_pass = compare_linked_lists(output, expected)

    print(f"{'PASS' if assert_pass else 'FAIL'}")

    if not assert_pass:
        separator = "-" * 40
        print(separator)
        print(separator)
        print("FAILURE DETAILS:")
        print(separator)
        print("Input:")
        print_list_node(input_list)
        print(separator)
        print("Expected Output:")
        print_list_node(expected)
        print(separator)
        print("Actual Output:")
        print_list_node(output)

    return assert_pass

# Provided examples
assert_solution(create_linked_list([1,1,2]), create_linked_list([1,2]))
assert_solution(create_linked_list([1,1,2,3,3]), create_linked_list([1,2,3]))