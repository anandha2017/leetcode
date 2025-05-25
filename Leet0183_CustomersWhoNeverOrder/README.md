# Customers Who Never Order

## Problem Statement

Write a solution to find all customers who never place any orders.

Return the result table in **any order**.

## Database Schema

### Table: `Customers`
```sql
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
```
- `id` is the primary key (column with unique values) for this table
- This table contains information about customers

### Table: `Orders`
```sql
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| customerId  | int  |
+-------------+------+
```
- `id` is the primary key (column with unique values) for this table
- `customerId` is a foreign key (reference columns) of the ID from the Customers table
- This table contains information about orders made by customers

## Examples

### Example 1

**Input:**

Customers table:
```
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

Orders table:
```
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

**Expected Output:**
```
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

**Explanation:** Joe (id=1) has order id=2, Sam (id=3) has order id=1. Henry and Max have no orders.

### Example 2

**Input:**

Customers table:
```
+----+---------+
| id | name    |
+----+---------+
| 1  | Alice   |
| 2  | Bob     |
| 3  | Charlie |
| 4  | Diana   |
| 5  | Eve     |
+----+---------+
```

Orders table:
```
+----+------------+
| id | customerId |
+----+------------+
| 1  | 2          |
| 2  | 4          |
| 3  | 2          |
| 4  | 1          |
+----+------------+
```

**Expected Output:**
```
+-----------+
| Customers |
+-----------+
| Charlie   |
| Eve       |
+-----------+
```

**Explanation:**
- Alice (id=1) has order id=4
- Bob (id=2) has orders id=1 and id=3
- Diana (id=4) has order id=2
- Charlie and Eve have no orders

### Example 3 (Edge Case - All Customers Have Orders)

**Input:**

Customers table:
```
+----+--------+
| id | name   |
+----+--------+
| 1  | John   |
| 2  | Sarah  |
+----+--------+
```

Orders table:
```
+----+------------+
| id | customerId |
+----+------------+
| 1  | 1          |
| 2  | 2          |
| 3  | 1          |
+----+------------+
```

**Expected Output:**
```
+-----------+
| Customers |
+-----------+
+-----------+
```

**Explanation:** Both customers have placed orders, so the result is empty.

### Example 4 (Edge Case - No Orders Exist)

**Input:**

Customers table:
```
+----+----------+
| id | name     |
+----+----------+
| 1  | Michael  |
| 2  | Emma     |
| 3  | Oliver   |
+----+----------+
```

Orders table:
```
+----+------------+
| id | customerId |
+----+------------+
+----+------------+
```

**Expected Output:**
```
+-----------+
| Customers |
+-----------+
| Michael   |
| Emma      |
| Oliver    |
+-----------+
```

**Explanation:** No orders exist, so all customers are returned.

## Visual Representation

### Example 1 Visualisation

```
Customers Table          Orders Table
┌────┬───────┐           ┌────┬────────────┐
│ id │ name  │           │ id │ customerId │
├────┼───────┤           ├────┼────────────┤
│ 1  │ Joe   │ ◄─────────┤ 2  │ 1          │
│ 2  │ Henry │           └────┴────────────┘
│ 3  │ Sam   │ ◄─────────┐
│ 4  │ Max   │           │ ┌────┬────────────┐
└────┴───────┘           └─┤ 1  │ 3          │
                           └────┴────────────┘

Result: Henry, Max (customers with no connecting lines)
```

### Data Relationship Diagram

```
┌─────────────┐         ┌─────────────┐
│ Customers   │         │ Orders      │
├─────────────┤         ├─────────────┤
│ id (PK)     │◄────────┤ customerId  │
│ name        │         │ id (PK)     │
└─────────────┘         └─────────────┤
                                      │
The goal is to find customers         │
with NO corresponding records    ─────┘
in the Orders table
```

## PostgreSQL Test Data Setup

### Example 1 - Using CTEs with VALUES
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'Joe'),
        (2, 'Henry'),
        (3, 'Sam'),
        (4, 'Max')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (1, 3),
        (2, 1)
    ) AS t(id, customerId)
)
-- Your solution query goes here
SELECT name AS Customers FROM Customers WHERE ...;
```

### Example 2 - Multiple Customers and Orders
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'Alice'),
        (2, 'Bob'),
        (3, 'Charlie'),
        (4, 'Diana'),
        (5, 'Eve')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (1, 2),
        (2, 4),
        (3, 2),
        (4, 1)
    ) AS t(id, customerId)
)
-- Your solution query goes here
SELECT name AS Customers FROM Customers WHERE ...;
```

### Example 3 - All Customers Have Orders
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'John'),
        (2, 'Sarah')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (1, 1),
        (2, 2),
        (3, 1)
    ) AS t(id, customerId)
)
-- Your solution query goes here
SELECT name AS Customers FROM Customers WHERE ...;
```

### Example 4 - No Orders Exist
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'Michael'),
        (2, 'Emma'),
        (3, 'Oliver')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (NULL, NULL)
    ) AS t(id, customerId)
    WHERE id IS NOT NULL  -- This creates an empty result set
)
-- Your solution query goes here
SELECT name AS Customers FROM Customers WHERE ...;
```

### Large Dataset Example
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'Customer_001'), (2, 'Customer_002'), (3, 'Customer_003'),
        (4, 'Customer_004'), (5, 'Customer_005'), (6, 'Customer_006'),
        (7, 'Customer_007'), (8, 'Customer_008'), (9, 'Customer_009'),
        (10, 'Customer_010'), (11, 'Customer_011'), (12, 'Customer_012')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (1, 2), (2, 4), (3, 6), (4, 8), (5, 10), (6, 2),
        (7, 4), (8, 6), (9, 8), (10, 10)
    ) AS t(id, customerId)
)
-- Expected result: Customer_001, Customer_003, Customer_005,
--                  Customer_007, Customer_009, Customer_011, Customer_012
SELECT name AS Customers FROM Customers WHERE ...;
```

## Expected Output Format

The result should have exactly one column named `Customers` containing the names of customers who have never placed an order.

```sql
-- Expected column structure
+-----------+
| Customers |
+-----------+
| name1     |
| name2     |
| ...       |
+-----------+
```

## Testing Your Solution

### Quick Test Template
```sql
WITH Customers AS (
    SELECT * FROM (VALUES
        (1, 'Joe'),
        (2, 'Henry'),
        (3, 'Sam'),
        (4, 'Max')
    ) AS t(id, name)
),
Orders AS (
    SELECT * FROM (VALUES
        (1, 3),
        (2, 1)
    ) AS t(id, customerId)
)
-- Replace this comment with your solution
-- Expected output: Henry, Max
SELECT name AS Customers FROM Customers
WHERE id NOT IN (SELECT customerId FROM Orders WHERE customerId IS NOT NULL);
```

### Benefits of Using CTEs with VALUES

- **No table creation required** - Perfect for testing and development
- **Self-contained queries** - Everything needed is in one script
- **Easy to modify** - Change test data by editing VALUES clauses
- **PostgreSQL optimised** - CTEs are well-optimised in PostgreSQL
- **Portable** - Can be run in any PostgreSQL environment
- **Version control friendly** - Easy to store test cases in code repositories

### Alternative CTE Patterns

#### Using UNION ALL for larger datasets:
```sql
WITH Customers AS (
    SELECT 1 as id, 'Alice' as name
    UNION ALL SELECT 2, 'Bob'
    UNION ALL SELECT 3, 'Charlie'
    UNION ALL SELECT 4, 'Diana'
    UNION ALL SELECT 5, 'Eve'
),
Orders AS (
    SELECT 1 as id, 2 as customerId
    UNION ALL SELECT 2, 4
    UNION ALL SELECT 3, 2
    UNION ALL SELECT 4, 1
)
-- Your solution here
SELECT name AS Customers FROM Customers WHERE ...;
```

## Performance Notes

- Ensure proper indexing on `Customers.id` and `Orders.customerId`
- Consider the dataset size when choosing between different SQL approaches
- Test with larger datasets to validate performance characteristics

## Constraints

- `1 ≤ Customers.id, Orders.id ≤ 10^4`
- `1 ≤ Orders.customerId ≤ 10^4`
- All `Orders.customerId` values are valid references to `Customers.id`