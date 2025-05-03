from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """Given the `head` of a sorted linked list, delete all duplicates
            such that each element appears only once. Return the linked list
            sorted as well."""

        current = head

        while current and current.next:
            if current.val == current.next.val:
                # Skip the duplicate
                current.next = current.next.next
            else:
                # Move to next node
                current = current.next

        return head


solution = Solution()

# Define some formatting constants
SEPARATOR = "=" * 50
TRUNC = 20
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
    """Compare two linked lists to check if they contain the same values in the same order."""

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

def linked_list_to_array(head: Optional[ListNode]) -> list:
    """Convert a linked list to an array for easier visualization."""
    result = []
    current = head
    while current:
        result.append(current.val)
        current = current.next
    return result

def truncate_str(s: str, max_length: int = TRUNC) -> str:
    """Truncate a string to max_length characters, adding '...' if truncated."""
    if len(s) <= max_length:
        return s
    return s[:max_length-3] + "..."

def assert_solution(input_list: Optional[ListNode], expected: Optional[ListNode]):
    """Test solution with given input and expected output."""
    input_copy = deep_copy_linked_list(input_list)
    output = solution.deleteDuplicates(input_copy)
    assert_pass = compare_linked_lists(output, expected)

    result = "PASS" if assert_pass else "FAIL"
    formatted_result = PASS_FORMAT.format(result) if assert_pass else FAIL_FORMAT.format(result)

    print(
        f"{formatted_result}: "
        f"Input: {truncate_str(str(linked_list_to_array(input_list)))}, "
        f"Expected: {truncate_str(str(linked_list_to_array(expected)))}"
        f"{' , Got: ' + truncate_str(str(linked_list_to_array(output))) if not assert_pass else ''}"
    )

    return assert_pass

# Provided examples
assert_solution(create_linked_list([1,1,2,2,2,2]), create_linked_list([1,2]))
assert_solution(create_linked_list([1,1,2]), create_linked_list([1,2]))
assert_solution(create_linked_list([1,1,2,3,3]), create_linked_list([1,2,3]))

# Edge cases
assert_solution(create_linked_list([]), create_linked_list([]))
assert_solution(create_linked_list([5]), create_linked_list([5]))
assert_solution(create_linked_list([1,1,1,1,1]), create_linked_list([1]))
assert_solution(create_linked_list([1,2,3,4,5]), create_linked_list([1,2,3,4,5]))

# Boundary value tests
assert_solution(create_linked_list([-100,-100,-50]), create_linked_list([-100,-50]))
assert_solution(create_linked_list([50,100,100]), create_linked_list([50,100]))
assert_solution(create_linked_list([-100,-100,0,100,100]), create_linked_list([-100,0,100]))
assert_solution(create_linked_list([0,0,0]), create_linked_list([0]))

# Complex patterns
assert_solution(create_linked_list([1,1,2,2,3,3,4,4]), create_linked_list([1,2,3,4]))
assert_solution(create_linked_list([1,1,1,2,2,3,4,4,4,4]), create_linked_list([1,2,3,4]))
assert_solution(create_linked_list([-10,-10,-5,0,0,5,10,10]), create_linked_list([-10,-5,0,5,10]))

# Long sequence test
long_sequence = list(range(-100, 101))
long_sequence_with_duplicates = []
for val in long_sequence:
    long_sequence_with_duplicates.extend([val, val])  # Add each value twice
assert_solution(create_linked_list(long_sequence_with_duplicates), create_linked_list(long_sequence))

# Mixed pattern test
mixed_test = []
for i in range(-50, 51, 10):
    # Add each value i times (creating variable numbers of duplicates)
    count = abs(i) % 5 + 1  # 1 to 5 duplicates
    mixed_test.extend([i] * count)
expected_mixed = list(range(-50, 51, 10))
assert_solution(create_linked_list(mixed_test), create_linked_list(expected_mixed))