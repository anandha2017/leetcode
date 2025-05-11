# Best Time to Buy and Sell Stock

## Problem Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximise your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Constraints

- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

## Examples

### Example 1

```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

### Example 2

```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

### Example 3

```
Input: prices = [3,2,6,5,0,3]
Output: 4
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
```

### Example 4

```
Input: prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
```

### Example 5

```
Input: prices = [3,3,5,0,0,3,1,4]
Output: 4
Explanation: Buy on day 4 or 5 (price = 0) and sell on day 8 (price = 4), profit = 4-0 = 4.
```

## Visual Representations

### Example 1: [7,1,5,3,6,4]

```
Price
7 |   *
6 |               *
5 |       *
4 |                   *
3 |           *
2 |
1 |       *
0 +-------------------
    1  2  3  4  5  6    Day
```

Maximum profit: Buy at 1 (day 2), Sell at 6 (day 5) → Profit = 5

### Example 2: [7,6,4,3,1]

```
Price
7 |   *
6 |       *
5 |
4 |           *
3 |               *
2 |
1 |                   *
0 +-------------------
    1  2  3  4  5        Day
```

Maximum profit: No profit possible since prices only decrease → Profit = 0

### Example 3: [3,2,6,5,0,3]

```
Price
6 |           *
5 |               *
4 |
3 |   *                   *
2 |       *
1 |
0 |                   *
  +------------------------
    1  2  3  4  5  6        Day
```

Maximum profit: Buy at 2 (day 2), Sell at 6 (day 3) → Profit = 4

## Problem Statement in Layman's Terms

Imagine you have a list of stock prices for a specific stock over several consecutive days. Your goal is to determine the best day to buy the stock and the best day to sell it to maximise your profit.

Rules:
- You can only buy once and sell once
- You must buy before you sell
- If no profit is possible, return 0

## Terminology

When discussing this problem, it's helpful to use consistent terminology:

- **Buy price**: The price at which you purchase the stock (should be as low as possible)
- **Sell price**: The price at which you sell the stock (should be as high as possible)
- **Profit**: The difference between the sell price and buy price (sell price - buy price)
- **Local minimum**: A price that is lower than its adjacent prices, potentially a good buy point
- **Local maximum**: A price that is higher than its adjacent prices, potentially a good sell point
- **Global maximum profit**: The largest possible profit achievable given the constraints

## Template for Java Solution

```java
class Solution {
    public int maxProfit(int[] prices) {
        // Your solution here
        // Remember: You need to buy before you sell!
    }
}
```

Good luck with your Java implementation!