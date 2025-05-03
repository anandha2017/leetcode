# Merge Sorted Array

## Problem Description

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be *stored inside the array* `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

## Examples

### Example 1
```
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
```

### Example 2
```
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```

### Example 3
```
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
```

### Example 4
```
Input: nums1 = [-10,-5,1,3,0,0,0], m = 4, nums2 = [-20,6,8], n = 3
Output: [-20,-10,-5,1,3,6,8]
Explanation: The arrays we are merging are [-10,-5,1,3] and [-20,6,8].
The result of the merge is [-20,-10,-5,1,3,6,8].
```

### Example 5
```
Input: nums1 = [1,1,1,0,0,0], m = 3, nums2 = [2,2,2], n = 3
Output: [1,1,1,2,2,2]
Explanation: The arrays we are merging are [1,1,1] and [2,2,2], where all elements in nums2 are greater than all elements in nums1.
```

### Example 6
```
Input: nums1 = [4,5,6,0,0,0], m = 3, nums2 = [1,2,3], n = 3
Output: [1,2,3,4,5,6]
Explanation: The arrays we are merging are [4,5,6] and [1,2,3], where all elements in nums2 are smaller than all elements in nums1.
```

### Example 7
```
Input: nums1 = [-1,0,0,0,3,0,0,0,0,0,0], m = 5, nums2 = [-3,-2,1,2,5,6], n = 6
Output: [-3,-2,-1,0,0,0,1,2,3,5,6]
Explanation: The arrays we are merging contain duplicates and negative numbers across both arrays.
```

## Constraints
* `nums1.length == m + n`
* `nums2.length == n`
* `0 <= m, n <= 200`
* `1 <= m + n <= 200`
* `-10^9 <= nums1[i], nums2[j] <= 10^9`

## Follow-up
Can you come up with an algorithm that runs in `O(m + n)` time?

## Notes
* The problem requires in-place modification of `nums1`
* Both arrays are already sorted in non-decreasing order
* You need to handle edge cases where one array might be empty
* Remember that the last `n` elements of `nums1` are placeholders (zeros) that should be overwritten