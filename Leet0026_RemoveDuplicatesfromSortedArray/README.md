# 26. Remove Duplicates from Sorted Array

**Difficulty:** Easy  
**Topics:** Two Pointers, Array

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements must be preserved. Return the number of unique elements in `nums`.

After removal, the first `k` elements of `nums` should contain the unique elements, and the remaining elements beyond `k` are not important.

## Custom Judge

The judge will run:

```java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer

int k = removeDuplicates(nums);

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

## Examples

```text
Input:  nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input:  nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```
