# Linked List Cycle

## Problem Description

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

## Examples

### Example 1:

```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
```

Visual representation:
```
3 → 2 → 0 → -4
    ↑     ↓
    └─────┘
```

### Example 2:

```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
```

Visual representation:
```
1 → 2
↑   ↓
└───┘
```

### Example 3:

```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

Visual representation:
```
1 → null
```

### Example 4 (Additional):

```
Input: head = [5,8,3,1,4,7,2], pos = 3
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to node at index 3 (value 1).
```

Visual representation:
```
5 → 8 → 3 → 1 → 4 → 7 → 2
            ↑           ↓
            └───────────┘
```

### Example 5 (Additional):

```
Input: head = [9,4,7,2,1,3,5], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

Visual representation:
```
9 → 4 → 7 → 2 → 1 → 3 → 5 → null
```

## Constraints

- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a valid index in the linked-list.

## Further Understanding

Consider these questions to help you think about the problem:

1. What happens if you try to traverse a linked list with a cycle? Will you ever reach the end?
2. How would you know if you've already visited a node before?
3. Can you solve this problem with O(1) extra space?
4. What are the implications of modifying the original linked list structure?

## Problem Definition in Java

The problem uses the following definition for a linked list node:

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
```

Your task is to implement this method:

```java
public boolean hasCycle(ListNode head) {
    // Your solution here
}
```