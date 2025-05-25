# Employees Earning More Than Their Managers

## Problem Description

You are given a table named `Employee` that holds information about all employees in a company, including their managers. The table has the following structure:

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
```

- `id` is the primary key (column with unique values) for this table.
- Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.
- If an employee doesn't have a manager, the `managerId` will be NULL.

Your task is to write a SQL query to find the employees who earn more than their managers.

## Example

### Original Example

**Input:**
Employee table:
```
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
```

**Output:**
```
+----------+
| Employee |
+----------+
| Joe      |
+----------+
```

**Explanation:** Joe is the only employee who earns more than his manager. Joe's salary is £70,000, and his manager Sam (id = 3) earns £60,000.

### Additional Examples

#### Example 2

**Input:**
Employee table:
```
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Alice | 80000  | 2         |
| 2  | Bob   | 75000  | 3         |
| 3  | Carol | 90000  | 4         |
| 4  | Dave  | 85000  | NULL      |
| 5  | Eve   | 80000  | 2         |
+----+-------+--------+-----------+
```

**Output:**
```
+----------+
| Employee |
+----------+
| Bob      |
+----------+
```

**Explanation:** Bob's manager is Carol (id = 3), and Bob earns £75,000 while Carol earns £90,000. Bob does not earn more than his manager. Alice's manager is Bob, and Alice earns £80,000 while Bob earns £75,000, so Alice earns more than her manager.

#### Example 3

**Input:**
Employee table:
```
+----+---------+--------+-----------+
| id | name    | salary | managerId |
+----+---------+--------+-----------+
| 1  | John    | 50000  | 3         |
| 2  | Sarah   | 75000  | 3         |
| 3  | Michael | 65000  | 4         |
| 4  | Laura   | 80000  | 5         |
| 5  | Robert  | 95000  | NULL      |
| 6  | Emma    | 85000  | 4         |
+----+---------+--------+-----------+
```

**Output:**
```
+----------+
| Employee |
+----------+
| Sarah    |
| Emma     |
+----------+
```

**Explanation:** Sarah earns £75,000 while her manager Michael earns £65,000. Emma earns £85,000 while her manager Laura earns £80,000.

## Visualisations

### Company Hierarchy Diagram for Example 1

```
            +-------+
            |  Max  |
            | 90000 |
            +---+---+
                |
                v
            +-------+        +-------+
            | Henry |        |  Sam  |
            | 80000 |        | 60000 |
            +-------+        +---+---+
                                 |
                                 v
                             +-------+
                             |  Joe  |
                             | 70000 |
                             +-------+
```

In this diagram, arrows point from managers to their direct reports. You can see that Joe reports to Sam, and Joe's salary (£70,000) is higher than Sam's salary (£60,000).

### Company Hierarchy Diagram for Example 2

```
            +-------+
            | Dave  |
            | 85000 |
            +---+---+
                |
                v
            +-------+
            | Carol |
            | 90000 |
            +---+---+
                |
                v
            +-------+        +-------+        +-------+
            |  Bob  | <----- | Alice | and    |  Eve  |
            | 75000 |        | 80000 |        | 80000 |
            +-------+        +-------+        +-------+
```

Here, both Alice and Eve report to Bob, and both earn more than Bob.

## Notes

1. The problem requires you to write a PostgreSQL query that identifies employees earning more than their managers.
2. Remember that managers are also employees in the table.
3. The solution should return the names of employees who earn more than their managers.
4. The result can be returned in any order.

## Challenge

Try to solve this problem using:
1. Self-join approach
2. Subquery approach

Good luck with solving this problem!