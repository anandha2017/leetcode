from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for item in nums:
            while(nums.count(item)) > 1:
                nums.remove(item)

        return len(nums)


def assert_remove_duplicates(nums, expected_list, expected_k):
    """
    Runs removeDuplicates on a copy of nums, then compares:
      • the resulting list slice nums[:k]  
      • the returned count k  
    Prints PASS/FAIL for each.
    """
    nums_copy = list(nums)               # avoid mutating the original
    k = solution.removeDuplicates(nums_copy)
    actual_list = nums_copy[:k]

    list_pass = actual_list == expected_list
    count_pass = k == expected_k

    print(f"List:  {'PASS' if list_pass else 'FAIL'} — got {actual_list}, expected {expected_list}")
    print(f"Count: {'PASS' if count_pass else 'FAIL'} — got {k}, expected {expected_k}")


solution = Solution()

assert_remove_duplicates([1,1,2], [1,2], 2)
assert_remove_duplicates([0,0,1,1,1,2,2,3,3,4], [0,1,2,3,4], 5)
assert_remove_duplicates([1,1,1], [1], 1)
assert_remove_duplicates([1], [1], 1)
assert_remove_duplicates([], [], 0)

