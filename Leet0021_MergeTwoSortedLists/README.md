# 21. Merge Two Sorted Lists

Given the heads of two sorted linked lists `list1` and `list2`, merge them into a single sorted linked list. The new list should be created by splicing together the nodes of the original two lists.

Return the head of the merged linked list.

---

## Examples

### Example 1

**Input:**  
`list1 = [1,2,4]`  
`list2 = [1,3,4]`  

**Output:**  
`[1,1,2,3,4,4]`

---

### Example 2

**Input:**  
`list1 = []`  
`list2 = []`  

**Output:**  
`[]`

---

### Example 3

**Input:**  
`list1 = []`  
`list2 = [0]`  

**Output:**  
`[0]`

---

### Example 4

**Input:**  
`list1 = [2,5,7]`  
`list2 = [1,3,6,8]`  

**Output:**  
`[1,2,3,5,6,7,8]`

---

### Example 5

**Input:**  
`list1 = [1,1,1]`  
`list2 = [1,1,1]`  

**Output:**  
`[1,1,1,1,1,1]`

---

### Example 6

**Input:**  
`list1 = [-3,-1,2]`  
`list2 = [-2,0,4]`  

**Output:**  
`[-3,-2,-1,0,2,4]`

---

## Constraints

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 ≤ Node.val ≤ 100`
- Both `list1` and `list2` are sorted in non-decreasing order.
