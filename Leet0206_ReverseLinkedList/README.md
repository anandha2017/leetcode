# Reverse Linked List

## Problem Statement

Given the `head` of a singly linked list, reverse the list and return the reversed list.

## Function Signature

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Your implementation here
    }
}
```

## Examples

### Example 1
**Input:** `head = [1,2,3,4,5]`
**Output:** `[5,4,3,2,1]`

**Visual Representation:**
```
Original:  1 -> 2 -> 3 -> 4 -> 5 -> null
Reversed:  5 -> 4 -> 3 -> 2 -> 1 -> null
```

### Example 2
**Input:** `head = [1,2]`
**Output:** `[2,1]`

**Visual Representation:**
```
Original:  1 -> 2 -> null
Reversed:  2 -> 1 -> null
```

### Example 3
**Input:** `head = []`
**Output:** `[]`

**Visual Representation:**
```
Original:  null
Reversed:  null
```

### Example 4
**Input:** `head = [7]`
**Output:** `[7]`

**Visual Representation:**
```
Original:  7 -> null
Reversed:  7 -> null
```

### Example 5
**Input:** `head = [9,8,7,6,5,4,3,2,1]`
**Output:** `[1,2,3,4,5,6,7,8,9]`

**Visual Representation:**
```
Original:  9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
Reversed:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
```

### Example 6
**Input:** `head = [42,17,99,3]`
**Output:** `[3,99,17,42]`

**Visual Representation:**
```
Original:  42 -> 17 -> 99 -> 3 -> null
Reversed:   3 -> 99 -> 17 -> 42 -> null
```

## Constraints

- The number of nodes in the list is in the range `[0, 5000]`
- Node values are in the range `[-5000, 5000]`

## Visual Step-by-Step Process

For a clearer understanding, here's what happens during the reversal of `[1,2,3,4,5]`:

```
Step 0 (Initial):
1 -> 2 -> 3 -> 4 -> 5 -> null

Step 1:
null <- 1    2 -> 3 -> 4 -> 5 -> null

Step 2:
null <- 1 <- 2    3 -> 4 -> 5 -> null

Step 3:
null <- 1 <- 2 <- 3    4 -> 5 -> null

Step 4:
null <- 1 <- 2 <- 3 <- 4    5 -> null

Step 5 (Final):
null <- 1 <- 2 <- 3 <- 4 <- 5
```

## Key Considerations

- Handle edge cases: empty list and single-node list
- Maintain references carefully to avoid losing nodes
- Consider both iterative and recursive approaches
- Think about space complexity implications

## Test Cases for Validation

```java
// Test Case 1: Standard case
ListNode head1 = createList(new int[]{1,2,3,4,5});
// Expected: [5,4,3,2,1]

// Test Case 2: Two nodes
ListNode head2 = createList(new int[]{1,2});
// Expected: [2,1]

// Test Case 3: Empty list
ListNode head3 = null;
// Expected: null

// Test Case 4: Single node
ListNode head4 = createList(new int[]{1});
// Expected: [1]

// Test Case 5: Longer list
ListNode head5 = createList(new int[]{10,20,30,40,50,60});
// Expected: [60,50,40,30,20,10]
```

## Complexity Analysis Goals

Consider these aspects when implementing your solution:

- **Time Complexity:** Aim for O(n) where n is the number of nodes
- **Space Complexity:** Consider both O(1) iterative and O(n) recursive solutions

## Pseudocode

### Iterative Approach
```
FUNCTION reverseList(head):
    SET previous = null
    SET current = head

    WHILE current is not null:
        SET nextTemp = current.next     // Store the next node
        SET current.next = previous     // Reverse the link
        SET previous = current          // Move previous forward
        SET current = nextTemp          // Move current forward

    RETURN previous  // previous is now the new head
END FUNCTION
```

### Recursive Approach
```
FUNCTION reverseList(head):
    // Base case: empty list or single node
    IF head is null OR head.next is null:
        RETURN head

    // Recursively reverse the rest of the list
    SET reversedHead = reverseList(head.next)

    // Reverse the current connection
    SET head.next.next = head
    SET head.next = null

    RETURN reversedHead
END FUNCTION
```

### Pointer Movement Visualisation (Iterative)

For list `[1,2,3]`, here's how the pointers move:

```
Initial state:
prev = null, curr = 1, next = ?
null    1 -> 2 -> 3 -> null

Step 1:
next = 2 (store next)
1.next = null (reverse link)
prev = 1, curr = 2
null <- 1    2 -> 3 -> null

Step 2:
next = 3 (store next)
2.next = 1 (reverse link)
prev = 2, curr = 3
null <- 1 <- 2    3 -> null

Step 3:
next = null (store next)
3.next = 2 (reverse link)
prev = 3, curr = null
null <- 1 <- 2 <- 3    null

Return prev (which is 3, the new head)
```

## Follow-up Question

Can you solve this problem both iteratively and recursively?

---

*LeetCode Problem #206 - Easy*