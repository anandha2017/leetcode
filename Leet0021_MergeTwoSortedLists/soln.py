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

        current = sentinel.next
        if current is None:
            return None
        
        vals = []
        while current:
            vals.append(current.val)
            current = current.next

        vals.sort()

        current = to_list_node(vals)
                
        return current


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
assert_solution(to_list_node([2,5,7]), to_list_node([1,3,6,8]), to_list_node([1,2,3,5,6,7,8]))
assert_solution(to_list_node([]), to_list_node([]), to_list_node([]))
assert_solution(to_list_node([1]), to_list_node([]), to_list_node([1]))
assert_solution(to_list_node([]), to_list_node([1]), to_list_node([1]))
assert_solution(to_list_node([0]), to_list_node([1]), to_list_node([0,1]))

# 1. both empty
assert_solution(to_list_node([]),
                to_list_node([]),
                to_list_node([]))

# 2. first empty, second size 1
assert_solution(to_list_node([]),
                to_list_node([0]),
                to_list_node([0]))

# 3. second empty, first size 1
assert_solution(to_list_node([0]),
                to_list_node([]),
                to_list_node([0]))

# 4. fully interleaved ranges of equal length
assert_solution(to_list_node([1, 3, 5]),
                to_list_node([2, 4, 6]),
                to_list_node([1, 2, 3, 4, 5, 6]))

# 5. all elements of list 1 precede those of list 2
assert_solution(to_list_node([1, 2, 3]),
                to_list_node([4, 5, 6]),
                to_list_node([1, 2, 3, 4, 5, 6]))

# 6. all elements of list 2 precede those of list 1
assert_solution(to_list_node([4, 5, 6]),
                to_list_node([1, 2, 3]),
                to_list_node([1, 2, 3, 4, 5, 6]))

# 7. duplicates across the two lists
assert_solution(to_list_node([1, 2, 4]),
                to_list_node([1, 3, 4]),
                to_list_node([1, 1, 2, 3, 4, 4]))

# 8. duplicates within each list
assert_solution(to_list_node([1, 1, 1]),
                to_list_node([1, 1]),
                to_list_node([1, 1, 1, 1, 1]))

# 9. mix of negatives and positives
assert_solution(to_list_node([-3, -1, 2, 4]),
                to_list_node([-2, 2, 3]),
                to_list_node([-3, -2, -1, 2, 2, 3, 4]))

# 10. extremes and repeated mid-range value
assert_solution(to_list_node([-100, -50, -10]),
                to_list_node([-99, -50]),
                to_list_node([-100, -99, -50, -50, -10]))

# 11. single identical element in each list
assert_solution(to_list_node([0]),
                to_list_node([0]),
                to_list_node([0, 0]))

# 12. list 1 at maximum allowed length (50), list 2 empty
assert_solution(to_list_node(list(range(0, 100, 2))),      # 0, 2, … , 98
                to_list_node([]),
                to_list_node(list(range(0, 100, 2))))

# 13. list 2 at maximum length, list 1 empty (all negative odd numbers)
assert_solution(to_list_node([]),
                to_list_node(list(range(-99, 1, 2))),       # –99, –97, … , –1
                to_list_node(list(range(-99, 1, 2))))

# 14. both lists at maximum length (evens then odds)
assert_solution(to_list_node(list(range(0, 100, 2))),      # 50 even numbers
                to_list_node(list(range(1, 101, 2))),       # 50 odd numbers
                to_list_node(list(range(0, 100))))          # 0 … 100

# 15. heavy duplication at extremes
assert_solution(to_list_node([-100, -100, 100]),
                to_list_node([-100, 100, 100]),
                to_list_node([-100, -100, -100, 100, 100, 100]))
