# Combine Two Tables
## LeetCode Problem 175

This repository contains my exploration of the "Combine Two Tables" problem from LeetCode.

## Problem Description

You are given two tables: `Person` and `Address`.

**Table: Person**
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| personId    | int     |
| lastName    | varchar |
| firstName   | varchar |
+-------------+---------+
```
* `personId` is the primary key column for this table.
* This table contains information about the ID of some persons and their first and last names.

**Table: Address**
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| addressId   | int     |
| personId    | int     |
| city        | varchar |
| state       | varchar |
+-------------+---------+
```
* `addressId` is the primary key column for this table.
* Each row of this table contains information about the city and state of one person with ID = `personId`.

**Task**: Write an SQL query to report the first name, last name, city, and state of each person in the Person table. If the address of a `personId` is not present in the Address table, report `null` instead.

Return the result table in any order.

## Examples

### Example 1

**Input:**
Person table:
```
+----------+----------+-----------+
| personId | lastName | firstName |
+----------+----------+-----------+
| 1        | Wang     | Allen     |
| 2        | Alice    | Bob       |
+----------+----------+-----------+
```

Address table:
```
+-----------+----------+---------------+------------+
| addressId | personId | city          | state      |
+-----------+----------+---------------+------------+
| 1         | 2        | New York City | New York   |
| 2         | 3        | Leetcode      | California |
+-----------+----------+---------------+------------+
```

**Output:**
```
+-----------+----------+---------------+----------+
| firstName | lastName | city          | state    |
+-----------+----------+---------------+----------+
| Allen     | Wang     | Null          | Null     |
| Bob       | Alice    | New York City | New York |
+-----------+----------+---------------+----------+
```

**Explanation:** There is no address in the address table for the `personId = 1` so we return null in their city and state.

### Example 2 (Additional)

**Input:**
Person table:
```
+----------+----------+-----------+
| personId | lastName | firstName |
+----------+----------+-----------+
| 1        | Smith    | John      |
| 2        | Jones    | Emma      |
| 3        | Brown    | Michael   |
| 4        | Wilson   | Olivia    |
+----------+----------+-----------+
```

Address table:
```
+-----------+----------+--------------+------------+
| addressId | personId | city         | state      |
+-----------+----------+--------------+------------+
| 1         | 1        | London       | England    |
| 2         | 3        | Manchester   | England    |
| 3         | 5        | Birmingham   | England    |
+-----------+----------+--------------+------------+
```

**Output:**
```
+-----------+----------+--------------+------------+
| firstName | lastName | city         | state      |
+-----------+----------+--------------+------------+
| John      | Smith    | London       | England    |
| Emma      | Jones    | Null         | Null       |
| Michael   | Brown    | Manchester   | England    |
| Olivia    | Wilson   | Null         | Null       |
+-----------+----------+--------------+------------+
```

**Explanation:** `personId` 2 and 4 don't have addresses in the Address table, so their city and state values are Null. `personId` 5 has an address but doesn't exist in the Person table, so that address isn't included in the output.

### Example 3 (Additional)

**Input:**
Person table:
```
+----------+----------+-----------+
| personId | lastName | firstName |
+----------+----------+-----------+
| 1        | Johnson  | Sarah     |
| 2        | Miller   | James     |
+----------+----------+-----------+
```

Address table:
```
+-----------+----------+-------------+------------+
| addressId | personId | city        | state      |
+-----------+----------+-------------+------------+
| 1         | 1        | Edinburgh   | Scotland   |
| 2         | 1        | Glasgow     | Scotland   |
| 3         | 2        | Cardiff     | Wales      |
+-----------+----------+-------------+------------+
```

**Output:** (Since the problem doesn't specify how to handle multiple addresses, this is one possible interpretation)
```
+-----------+----------+-------------+------------+
| firstName | lastName | city        | state      |
+-----------+----------+-------------+------------+
| Sarah     | Johnson  | Edinburgh   | Scotland   |
| Sarah     | Johnson  | Glasgow     | Scotland   |
| James     | Miller   | Cardiff     | Wales      |
+-----------+----------+-------------+------------+
```

**Note:** In this example, Sarah Johnson has two addresses. A real solution might need to consider how to handle such cases.

## Data Relationships Visualisation

Below is a visualisation of the relationship between the Person and Address tables:

```
Person Table                  Address Table
+---------------+             +----------------+
| personId (PK) | <---+       | addressId (PK) |
| lastName      |     |       | personId (FK)--+
| firstName     |     +-------+                |
+---------------+             | city           |
                              | state          |
                              +----------------+
```

This is a one-to-many relationship between Person and Address, meaning:
- One person can have multiple addresses (or none)
- Each address belongs to exactly one person

## Notes for PostgreSQL Solution

When solving this problem in PostgreSQL, here are some things to consider:

1. PostgreSQL syntax for table joins
2. How to handle NULL values
3. Column ordering in the final output
4. Handling potential duplicate results in more complex scenarios
5. Performance considerations for larger datasets

## Submission Instructions

To submit your solution:
1. Write your PostgreSQL query
2. Test with the provided examples
3. Submit your solution through the LeetCode interface

Good luck!