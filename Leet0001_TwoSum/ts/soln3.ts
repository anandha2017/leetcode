import assert from 'assert';

function twoSum(nums: number[], target: number): number[] {
    let seen = new Map<Number, Number>();
    let comp = 0;
    for (let i = 0; i < nums.length; i++){
        comp = target - nums[i];
        if (seen.has(comp)) {
            return [seen.get(comp) as number, i];
        }
        seen.set(nums[i], i);
    }

    throw new Error("No two sum solution");
};

/* 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}  # value → index
        for i, num in enumerate(nums):
            comp = target - num
            if comp in seen:
                return [seen[comp], i]
            seen[num] = i
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
