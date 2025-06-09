# Remove Linked List Elements

## Problem Description

Given the head of a linked list and an integer `val`, remove all the nodes of the linked list that have `Node.val == val`, and return the new head.

**Difficulty:** Easy
**Topics:** Linked List, Recursion
**Similar Questions:** Remove Duplicates from Sorted List, Delete Node in a Linked List

## Problem Constraints

- The number of nodes in the list is in the range `[0, 10^4]`
- `1 <= Node.val <= 50`
- `0 <= val <= 50`

## Examples

### Example 1
**Input:** `head = [1,2,6,3,4,5,6], val = 6`
**Output:** `[1,2,3,4,5]`

**Visualisation:**
```
Before: [1] -> [2] -> [6] -> [3] -> [4] -> [5] -> [6] -> null
                 ↑                                   ↑
            remove this                        remove this

After:  [1] -> [2] -> [3] -> [4] -> [5] -> null
```

### Example 2
**Input:** `head = [], val = 1`
**Output:** `[]`

**Visualisation:**
```
Before: null
After:  null
```

### Example 3
**Input:** `head = [7,7,7,7], val = 7`
**Output:** `[]`

**Visualisation:**
```
Before: [7] -> [7] -> [7] -> [7] -> null
         ↑      ↑      ↑      ↑
    remove  remove remove remove

After:  null
```

### Example 4 (Additional)
**Input:** `head = [1,2,3,4,5], val = 3`
**Output:** `[1,2,4,5]`

**Visualisation:**
```
Before: [1] -> [2] -> [3] -> [4] -> [5] -> null
                       ↑
                  remove this

After:  [1] -> [2] -> [4] -> [5] -> null
```

### Example 5 (Additional)
**Input:** `head = [2,1,1,1], val = 1`
**Output:** `[2]`

**Visualisation:**
```
Before: [2] -> [1] -> [1] -> [1] -> null
                ↑      ↑      ↑
           remove  remove remove

After:  [2] -> null
```

### Example 6 (Additional)
**Input:** `head = [1,1,2,1], val = 1`
**Output:** `[2]`

**Visualisation:**
```
Before: [1] -> [1] -> [2] -> [1] -> null
         ↑      ↑              ↑
    remove  remove        remove

After:  [2] -> null
```

### Example 7 (Additional - Single Node)
**Input:** `head = [1], val = 1`
**Output:** `[]`

**Visualisation:**
```
Before: [1] -> null
         ↑
    remove this

After:  null
```

### Example 8 (Additional - No Matches)
**Input:** `head = [1,2,3,4,5], val = 6`
**Output:** `[1,2,3,4,5]`

**Visualisation:**
```
Before: [1] -> [2] -> [3] -> [4] -> [5] -> null
        (no nodes with value 6 to remove)

After:  [1] -> [2] -> [3] -> [4] -> [5] -> null
```

## ListNode Definition

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

## Method Signature

```java
public ListNode removeElements(ListNode head, int val) {
    // Your implementation here
}
```

## Key Considerations

1. **Edge Cases to Handle:**
   - Empty list (head is null)
   - Single node list (head.next is null)
   - All nodes need to be removed
   - Target value appears at the beginning
   - Target value appears at the end
   - Target value appears consecutively
   - Target value doesn't exist in the list

2. **Memory Complexity:**
   - Consider space-efficient solutions
   - Think about iterative vs recursive approaches

3. **Pointer Management:**
   - Handle head pointer updates carefully
   - Maintain proper connections between remaining nodes
   - Avoid memory leaks or dangling pointers

## Test Cases Summary

| Input | Val | Expected Output | Scenario |
|-------|-----|----------------|----------|
| `[1,2,6,3,4,5,6]` | 6 | `[1,2,3,4,5]` | Multiple occurrences |
| `[]` | 1 | `[]` | Empty list |
| `[7,7,7,7]` | 7 | `[]` | All nodes removed |
| `[1,2,3,4,5]` | 3 | `[1,2,4,5]` | Middle node |
| `[2,1,1,1]` | 1 | `[2]` | Consecutive at end |
| `[1,1,2,1]` | 1 | `[2]` | Head and tail |
| `[1]` | 1 | `[]` | Single node removal |
| `[1,2,3,4,5]` | 6 | `[1,2,3,4,5]` | No matches |

## Complexity Goals

- **Time Complexity:** Aim for O(n) where n is the number of nodes
- **Space Complexity:** Consider both O(1) iterative and O(n) recursive solutions