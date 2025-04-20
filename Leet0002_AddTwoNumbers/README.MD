# Add Two Numbers

## Description

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contains a single digit. Your task is to add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

---

## Examples

**Example 1**
```
Input:  l1 = [2,4,3]
        l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
```

**Example 2**
```
Input:  l1 = [0]
        l2 = [0]
Output: [0]
```

**Example 3**
```
Input:  l1 = [9,9,9,9,9,9,9]
        l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```
**Explanation:**
1. Add the first digits: 9 + 9 = 18 → digit 8, carry 1
2. Next: 9 + 9 + carry 1 = 19 → digit 9, carry 1
3. Repeat for the next two pairs: each sum is 19 → digit 9, carry 1
4. For the remaining three digits of l1: 9 + 0 + carry 1 = 10 → digit 0, carry 1 (three times)
5. No more nodes but carry 1 remains → append 1
6. Final list: [8,9,9,9,0,0,0,1] (represents 9 999 999 + 9 999 = 10 009 998)

---

## Additional Examples

1. **Different lengths, no final carry**
   ```
   Input:  l1 = [1,0,0]
           l2 = [9,9]
   Output: [0,0,1]  # 1 + 99 = 100
   ```

2. **Single-digit lists, with carry**
   ```
   Input:  l1 = [7]
           l2 = [8]
   Output: [5,1]    # 7 + 8 = 15
   ```

3. **Multiple carries throughout**
   ```
   Input:  l1 = [5,5,9]
           l2 = [5,4,2]
   Output: [0,0,2,1]  # 955 + 245 = 1200
   ```

4. **One list much longer**
   ```
   Input:  l1 = [2,3,4,5]
           l2 = [6,7]
   Output: [8,0,5,5]  # 5432 + 76 = 5508
   ```

---

## Constraints

- The number of nodes in each linked list is in the range [1, 100].
- 0 ≤ Node.val ≤ 9
- It is guaranteed that the list represents a number that does not have leading zeros.
