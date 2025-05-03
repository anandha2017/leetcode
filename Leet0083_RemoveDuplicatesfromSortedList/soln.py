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

# Define some formatting constants
SEPARATOR = "=" * 50
PASS_FORMAT = "\033[92m{}\033[0m"  # Green text
FAIL_FORMAT = "\033[91m{}\033[0m"  # Red text

def create_linked_list(values: list[int]) -> Optional[ListNode]:
    """Convert a list of integers to a linked list."""

    sentinel = ListNode(0)          # temporary first link
    current = sentinel

    for val in values:              # works even when 'values' is empty
        current.next = ListNode(val)
        current = current.next

    return sentinel.next            # real head, or None if list was empty

def deep_copy_linked_list(head: Optional[ListNode]) -> Optional[ListNode]:
    """Create a deep copy of a linked list."""

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
    Compare two linked lists to check if they contain the same values in the same order."""

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
    print (linked_list_to_array(list1))

def linked_list_to_array(head: Optional[ListNode]) -> list:
    """Convert a linked list to an array for easier visualization."""
    result = []
    current = head
    while current:
        result.append(current.val)
        current = current.next
    return result

def assert_solution(input_list: Optional[ListNode], expected: Optional[ListNode]):
    """Test solution with given input and expected output."""
    input_copy = deep_copy_linked_list(input_list)
    output = solution.deleteDuplicates(input_copy)
    assert_pass = compare_linked_lists(output, expected)

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input: {linked_list_to_array(input_list)}, "
        f"Expected: {linked_list_to_array(expected)}"
        f"{' , Got: ' + str(linked_list_to_array(output)) if not assert_pass else ''}"
    )

    return assert_pass




# Provided examples
assert_solution(create_linked_list([1,1,2]), create_linked_list([1,2]))
assert_solution(create_linked_list([1,1,2,3,3]), create_linked_list([1,2,3]))