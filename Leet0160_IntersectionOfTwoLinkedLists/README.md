# Intersection of Two Linked Lists

## Problem Description

Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

**Note** that the linked lists must retain their original structure after the function returns.

## Custom Judge

The inputs to the **judge** are given as follows (your program is not given these inputs):

- `intersectVal` - The value of the node where the intersection occurs. This is 0 if there is no intersection.
- `listA` - The first linked list.
- `listB` - The second linked list.
- `skipA` - The number of nodes to skip ahead in `listA` (starting from the head) to get to the intersected node.
- `skipB` - The number of nodes to skip ahead in `listB` (starting from the head) to get to the intersected node.

The judge will then create the linked lists based on these inputs and pass the two heads, `headA` and `headB` to your program. If you correctly return the intersected node, then your solution will be accepted.

## Constraints

- The number of nodes of `listA` is in the `m`.
- The number of nodes of `listB` is in the `n`.
- `1 <= m, n <= 3 * 10^4`
- `1 <= Node.val <= 10^5`
- `0 <= skipA < m`
- `0 <= skipB < n`
- `intersectVal` is 0 if `listA` and `listB` do not intersect.
- `intersectVal == listA[skipA] == listB[skipB]` if `listA` and `listB` intersect.

## Examples

### Example 1:

```
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
```

Visual representation:
```
     4 → 1 ↘
             8 → 4 → 5
5 → 6 → 1 ↗
```

Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads [4,1,8,4,5]. From the head of B, it reads [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

### Example 2:

```
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
```

Visual representation:
```
1 → 9 → 1 ↘
           2 → 4
      3 ↗
```

Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads [1,9,1,2,4]. From the head of B, it reads [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

### Example 3:

```
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
```

Visual representation:
```
2 → 6 → 4
1 → 5
```

Explanation: From the head of A, it reads [2,6,4]. From the head of B, it reads [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values. The two lists do not intersect, so return null.

### Example 4:

```
Input: intersectVal = 11, listA = [1,3,5,7,9,11,13,15], listB = [2,4,6,8,10,11,13,15], skipA = 5, skipB = 5
Output: Intersected at '11'
```

Visual representation:
```
1 → 3 → 5 → 7 → 9 ↘
                     11 → 13 → 15
2 → 4 → 6 → 8 → 10 ↗
```

Explanation: The lists intersect at node with value 11. Both lists have 5 nodes before reaching the intersection point.

### Example 5:

```
Input: intersectVal = 1, listA = [1], listB = [1], skipA = 0, skipB = 0
Output: Intersected at '1'
```

Visual representation:
```
1
↑↓
1
```

Explanation: Both lists consist of a single node with value 1, and they intersect at this node. This is a special case where both lists are identical.

## Follow-up Questions

- Can you solve it using O(n) time and O(1) memory?
- How would your approach change if the lists had different lengths?
- Would your solution still work if there were duplicate values in the lists?

## Your Task

Implement the following method in Java:

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Your solution here
    }
}
```

Where `ListNode` is defined as:

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
```

Good luck!