from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode(0)

        while list1 and list2:
            temp = list1.next
            list1.next = list2
            list2.next = temp

        return list1


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
