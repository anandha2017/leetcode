# 83. Remove Duplicates from Sorted List

## Problem Description

Given the `head` of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

## Examples

### Example 1:
```
Input: head = [1,1,2]
Output: [1,2]
```

Visualisation:
- Initial linked list:
  ```
  1 -> 1 -> 2 -> None
  ```

- After removing duplicates:
  ```
  1 -> 2 -> None
  ```

### Example 2:
```
Input: head = [1,1,2,3,3]
Output: [1,2,3]
```

Visualisation:
- Initial linked list:
  ```
  1 -> 1 -> 2 -> 3 -> 3 -> None
  ```

- After removing duplicates:
  ```
  1 -> 2 -> 3 -> None
  ```

## Constraints:
- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted** in ascending order.

## Definition for singly-linked list
```
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
```

## Python Definition
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Your implementation here
```