from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        sentinel = ListNode(0)
        current = sentinel

        while list1 or list2:
            if list1:
                current.next = list1
                current = current.next
                list1 = list1.next

            if list2:
                current.next = list2
                current = current.next
                list2 = list2.next

        return sentinel.next


solution = Solution()

def to_list_node(values: list[int]) -> Optional[ListNode]:
    sentinel = ListNode(0)          # temporary first link
    current = sentinel

    for val in values:              # works even when 'values' is empty
        current.next = ListNode(val)
        current = current.next

    return sentinel.next            # real head, or None if list was empty

def copy_list_node(list1: Optional[ListNode]) -> Optional[ListNode]:
    sentinel = ListNode(0)
    current = sentinel

    while list1:
        current.next = ListNode(list1.val)
        current = current.next
        list1 = list1.next

    return sentinel.next 

def are_contents_the_same(list1: Optional[ListNode], list2: Optional[ListNode]) -> bool:
    while list1 and list2:
        if list1.val != list2.val:
            return False
        
        list1 = list1.next
        list2 = list2.next

    if list1 is None and list2 is None:     # both lists are empty
        return True
    
    return False                            # lists are of diffent size


def print_list_node(list1: Optional[ListNode]):

    print(f"list: {list1}")
    while list1:
        print(f"val:  {list1.val}")
        list1 = list1.next


def assert_solution(list1: Optional[ListNode], list2: Optional[ListNode], expected_output: Optional[ListNode]):

    list1_copy = copy_list_node(list1)      # avoid mutating the original
    list2_copy = copy_list_node(list2)      # avoid mutating the original
   
    output = solution.mergeTwoLists(list1_copy, list2_copy)
   
    assert_pass = are_contents_the_same(output, expected_output)

    print(f"{'PASS' if assert_pass else 'FAIL'}")
    if not assert_pass:
        print("got ")
        print_list_node(output)
        print(f"expected ")
        print_list_node(expected_output)
        print(f"list1: ")
        print_list_node(list1)
        print(f"list2: ")
        print_list_node(list2)

# Provided examples
assert_solution(to_list_node([1,2,3]), to_list_node([4,5,6]), to_list_node([1,4,2,5,3,6]))
assert_solution(to_list_node([1,2,3]), to_list_node([4,5,6,7]), to_list_node([1,4,2,5,3,6,7]))
assert_solution(to_list_node([1,2,3,4]), to_list_node([4,5,6]), to_list_node([1,4,2,5,3,6,4]))
assert_solution(to_list_node([]), to_list_node([]), to_list_node([]))
assert_solution(to_list_node([1]), to_list_node([]), to_list_node([1]))
assert_solution(to_list_node([]), to_list_node([1]), to_list_node([1]))
assert_solution(to_list_node([0]), to_list_node([1]), to_list_node([0,1]))

# --- original sanity-check group -------------------------------------------
assert_solution(to_list_node([1, 2, 3]),       to_list_node([4, 5, 6]),       to_list_node([1, 4, 2, 5, 3, 6]))
assert_solution(to_list_node([1, 2, 3]),       to_list_node([4, 5, 6, 7]),    to_list_node([1, 4, 2, 5, 3, 6, 7]))
assert_solution(to_list_node([1, 2, 3, 4]),    to_list_node([4, 5, 6]),       to_list_node([1, 4, 2, 5, 3, 6, 4]))
assert_solution(to_list_node([]),              to_list_node([]),              to_list_node([]))
assert_solution(to_list_node([1]),             to_list_node([]),              to_list_node([1]))
assert_solution(to_list_node([]),              to_list_node([1]),             to_list_node([1]))
assert_solution(to_list_node([0]),             to_list_node([1]),             to_list_node([0, 1]))

# --- extra coverage ---------------------------------------------------------
# 8. duplicates inside each list, equal length
assert_solution(to_list_node([2, 2]),          to_list_node([3, 3]),          to_list_node([2, 3, 2, 3]))

# 9. mix of negatives and positives, equal length
assert_solution(to_list_node([-3, -1, 0]),     to_list_node([1, 2, 3]),       to_list_node([-3, 1, -1, 2, 0, 3]))

# 10. all-negative inputs, first list longer
assert_solution(to_list_node([-100, -50, -50]),to_list_node([-99, -49]),      to_list_node([-100, -99, -50, -49, -50]))

# 11. many duplicates across both lists, first list longer by one
assert_solution(to_list_node([1, 2, 2, 3]),    to_list_node([2, 2, 4]),       to_list_node([1, 2, 2, 2, 2, 4, 3]))

# 12. extreme values at both ends of the range
assert_solution(to_list_node([-100, -99, 0]),  to_list_node([100]),           to_list_node([-100, 100, -99, 0]))

# 13. maximum length on each side (50 + 50)
assert_solution(
    to_list_node(list(range(0, 100, 2))),      # 0, 2, …, 98
    to_list_node(list(range(1, 101, 2))),      # 1, 3, …, 99
    to_list_node(list(range(0, 100)))          # 0, 1, 2, …, 99
)

# 14. first list at max length, second list empty
assert_solution(
    to_list_node(list(range(0, 100, 2))),
    to_list_node([]),
    to_list_node(list(range(0, 100, 2)))
)

# 15. first list empty, second list at max length
assert_solution(
    to_list_node([]),
    to_list_node(list(range(-100, -50))),       # -100 … -51 (50 items)
    to_list_node(list(range(-100, -50)))
)

assert_solution(to_list_node([2,5,7]), to_list_node([1,3,6,8]), to_list_node([1,2,3,5,6,7,8]))