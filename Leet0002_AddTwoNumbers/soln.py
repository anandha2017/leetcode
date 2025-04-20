from typing import Optional

class ListNode:
    def __init__(self, val: int = 0, next: Optional['ListNode'] = None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        
        current = l1
        while current:
            print(current.val)
            current = current.next

        current = l2
        while current:
            print(current.val)
            current = current.next
        
        node1 = ListNode(7)
        node2 = ListNode(0)
        node3 = ListNode(8)
        node1.next = node2
        node2.next = node3
        # node1 is now the head of [7 → 0 → 8]
        return node1
    
# helper functions
def to_pylist(head: Optional[ListNode]) -> list[int]:
    arr = []
    while head:
        arr.append(head.val)
        head = head.next
    return arr

def to_ListNode(values: list[int]) -> Optional[ListNode]:
    """
    Converts a list of integers into a linked list and returns its head.

    :param values: List of non-negative integers.
    :return: Head of the constructed ListNode chain, or None if input is empty.
    """
    if not values:
        return None
    
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next

    return head

solution = Solution()

# Given examples
print(to_pylist(solution.addTwoNumbers(to_ListNode([2,4,3]),       to_ListNode([5,6,4])))       == [7,0,8])            # Expecting [7,0,8]
""" 
print(to_pylist(solution.addTwoNumbers([0],           [0]))           == [0])                # Expecting [0]
print(to_pylist(solution.addTwoNumbers([9,9,9,9,9,9,9], [9,9,9,9]))   == [8,9,9,9,0,0,0,1])  # Expecting [8,9,9,9,0,0,0,1]

# Additional examples
print(to_pylist(solution.addTwoNumbers([1,0,0],       [9,9]))         == [0,0,1])            # Expecting [0,0,1]
print(to_pylist(solution.addTwoNumbers([7],           [8]))           == [5,1])              # Expecting [5,1]
print(to_pylist(solution.addTwoNumbers([5,5,9],       [5,4,2]))       == [0,0,2,1])          # Expecting [0,0,2,1]
print(to_pylist(solution.addTwoNumbers([2,3,4,5],     [6,7]))         == [8,0,5,5])          # Expecting [8,0,5,5]

# ── Normal cases ────────────────────────────────────────────────────────────
print(to_pylist(solution.addTwoNumbers([1,2,3],     [4,5,6]))     == [5,7,9])                # 321+654=975
print(to_pylist(solution.addTwoNumbers([2,0,7],     [3,9,1]))     == [5,9,8])                # 702+193=895

# ── Boundary cases ──────────────────────────────────────────────────────────
print(to_pylist(solution.addTwoNumbers([9],         [9]))         == [8,1])                  # 9+9=18
print(to_pylist(solution.addTwoNumbers([0],         [9,9,9]))     == [9,9,9])                # 0+999=999

# ── Edge cases ─────────────────────────────────────────────────────────────
print(to_pylist(solution.addTwoNumbers([9]*10,      [1]))         == [0]*10 + [1])           # carry across all 10 digits
print(to_pylist(solution.addTwoNumbers([9,9,1],     [1]))         == [0,0,2])                # 199+1=200

# ── Quirky / odd cases ──────────────────────────────────────────────────────
print(to_pylist(solution.addTwoNumbers([9,0,9],     [1,0,1]))     == [0,1,0,1])              # 909+101=1010
print(to_pylist(solution.addTwoNumbers([5,0,0,4],   [5]))         == [0,1,0,5])              # 4005+5=4010
print(to_pylist(solution.addTwoNumbers([0,1,0,1],   [1,0,1,0]))   == [1,1,1,1])              # 1010+0101=1111

# ── Random patterns ─────────────────────────────────────────────────────────
print(to_pylist(solution.addTwoNumbers([1,3,5,7,9], [9,7,5,3,1])) == [0,1,1,1,1,1])          # 97531+13579=111110

# Large‑numbers example
print(to_pylist(solution.addTwoNumbers([9,9,9,9],     [9,9,9,9,9,9,9])) == [8,9,9,9,0,0,0,1])  # Expecting [8,9,9,9,0,0,0,1]
 """