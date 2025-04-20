import assert from 'assert';

function twoSum(nums: number[], target: number): number[] {
    let n = nums.length;

    for (let i = 0; i < n-1; i++) {
        for (let j = i+1; j < n; j++) {
            if (nums[i] + nums[j] == target)
                return [i,j];
        }            
    }

    throw new Error("No two sum solution");
};

/* 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n-1):
            for j in range(i+1,n):
                if nums[i] + nums[j] == target:
                    return [i,j]
 */

assert.deepStrictEqual(
  twoSum([2, 7, 11, 15], 9),
  [0, 1],
  'Test case 1 failed'
);
assert.deepStrictEqual(
  twoSum([3, 2, 4], 6),
  [1, 2],
  'Test case 2 failed'
);
assert.deepStrictEqual(
  twoSum([3, 3], 6),
  [0, 1],
  'Test case 3 failed'
);
// Boundary: minimal length
 assert.deepStrictEqual(
    twoSum([1, 1], 2),
    [0, 1],
    'Minimal length case failed'
);

 // Boundary: including zeros
assert.deepStrictEqual(
   twoSum([0, 4, 3, 0], 0),
   [0, 3],
   'Zeros inclusion case failed'
);

// Boundary: extreme values (±10^9)
assert.deepStrictEqual(
    twoSum([10009, -10009], 0),
    [0, 1],
    'Extreme values case failed'
);

// Mixed negatives
assert.deepStrictEqual(
    twoSum([-1, -2, -3, -4, -5], -8),
    [2, 4],
    'Mixed negatives case failed'
);

// Duplicates but only one correct pair
assert.deepStrictEqual(
    twoSum([1, 5, 5, 2], 10),
    [1, 2],
    'Duplicate elements case failed'
);

// Error scenario: no valid answer
assert.throws(
    () => twoSum([1, 2, 3], 7),
    /No two sum solution/,  // matches thrown error message
    'Error scenario case failed'
);

console.log('All tests passed');
