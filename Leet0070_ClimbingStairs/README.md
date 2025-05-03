# 70. Climbing Stairs

## Difficulty: Easy

## Hints

Hint 1: To reach nth step, what could have been your previous steps? (Think about the step sizes)

Hint 2: If you know the number of ways to reach the (n-1)th step and the number of ways to reach the (n-2)th step, can you find a relationship to the number of ways to reach the nth step?

Hint 3: Try working through small examples and look for a pattern:
- For n = 1, there is 1 way (just take one 1-step)
- For n = 2, there are 2 ways
- For n = 3, there are 3 ways
- For n = 4, there are 5 ways
- For n = 5, there are 8 ways
- For n = 6, there are 13 ways
Does this sequence look familiar?

## Approach
1. Think about how you can reach the nth step:
   - You can reach it by taking a single step from the (n-1)th step
   - OR by taking a 2-step from the (n-2)th step

2. Therefore, the total number of ways to reach the nth step equals:
   - The number of ways to reach the (n-1)th step
   - PLUS the number of ways to reach the (n-2)th step

3. This gives us a recursive formula: f(n) = f(n-1) + f(n-2)

4. Base cases:
   - f(1) = 1 (there is only one way to climb 1 step)
   - f(2) = 2 (there are two ways to climb 2 steps)

5. This forms a Fibonacci sequence, but starting with different values than the classic sequence.

6. You can solve this using:
   - Recursion (but watch out for time complexity issues)
   - Dynamic Programming (bottom-up approach using an array)
   - Or even a simple iterative approach with just two variables

The choice of implementation depends on efficiency requirements and your preference.

## Description

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

## Examples

### Example 1:

```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

### Example 2:

```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

### Example 3:

```
Input: n = 4
Output: 5
Explanation: There are five ways to climb to the top.
1. 1 step + 1 step + 1 step + 1 step
2. 1 step + 1 step + 2 steps
3. 1 step + 2 steps + 1 step
4. 2 steps + 1 step + 1 step
5. 2 steps + 2 steps
```

### Example 4:

```
Input: n = 5
Output: 8
Explanation: There are eight ways to climb to the top.
1. 1 step + 1 step + 1 step + 1 step + 1 step
2. 1 step + 1 step + 1 step + 2 steps
3. 1 step + 1 step + 2 steps + 1 step
4. 1 step + 2 steps + 1 step + 1 step
5. 2 steps + 1 step + 1 step + 1 step
6. 1 step + 2 steps + 2 steps
7. 2 steps + 1 step + 2 steps
8. 2 steps + 2 steps + 1 step
```

### Example 5:

```
Input: n = 6
Output: 13
Explanation: There are thirteen ways to climb to the top.
1. 1 step + 1 step + 1 step + 1 step + 1 step + 1 step
2. 1 step + 1 step + 1 step + 1 step + 2 steps
3. 1 step + 1 step + 1 step + 2 steps + 1 step
4. 1 step + 1 step + 2 steps + 1 step + 1 step
5. 1 step + 2 steps + 1 step + 1 step + 1 step
6. 2 steps + 1 step + 1 step + 1 step + 1 step
7. 1 step + 1 step + 2 steps + 2 steps
8. 1 step + 2 steps + 1 step + 2 steps
9. 1 step + 2 steps + 2 steps + 1 step
10. 2 steps + 1 step + 1 step + 2 steps
11. 2 steps + 1 step + 2 steps + 1 step
12. 2 steps + 2 steps + 1 step + 1 step
13. 2 steps + 2 steps + 2 steps
```

## Constraints

- `1 <= n <= 45`