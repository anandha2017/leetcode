# PostgreSQL Duplicate Emails Challenge

## Problem Description

Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL. Return the result table in any order.

### Table Structure

```sql
-- Table: Person
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
```

id is the primary key (column with unique values) for this table. Each row of this table contains an email. The emails will not contain uppercase letters.

## Examples

### Example 1: Basic Duplicate Detection

**Input:**
```
Person table:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```

**Expected Output:**
```
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
```

**Explanation:** a@b.com is repeated two times.

### Example 2: Multiple Duplicates

**Input:**
```
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | alice@tech.com   |
| 2  | bob@startup.com  |
| 3  | alice@tech.com   |
| 4  | charlie@web.com  |
| 5  | bob@startup.com  |
| 6  | bob@startup.com  |
+----+------------------+
```

**Expected Output:**
```
+------------------+
| Email            |
+------------------+
| alice@tech.com   |
| bob@startup.com  |
+------------------+
```

### Example 3: No Duplicates

**Input:**
```
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | unique1@test.com |
| 2  | unique2@test.com |
| 3  | unique3@test.com |
+----+------------------+
```

**Expected Output:**
```
Empty result set (no duplicates found)
```

### Example 4: All Same Email

**Input:**
```
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | same@email.com   |
| 2  | same@email.com   |
| 3  | same@email.com   |
| 4  | same@email.com   |
+----+------------------+
```

**Expected Output:**
```
+------------------+
| Email            |
+------------------+
| same@email.com   |
+------------------+
```

## Test Data Setup

Use this PostgreSQL setup to test your solution:

```sql
-- Create the test table
CREATE TABLE IF NOT EXISTS Person (
    id INT PRIMARY KEY,
    email VARCHAR(255)
);

-- Clear any existing data
TRUNCATE TABLE Person;

-- Insert test data for Example 1
INSERT INTO Person (id, email) VALUES
    (1, 'a@b.com'),
    (2, 'c@d.com'),
    (3, 'a@b.com');

-- For testing Example 2, replace with:
-- INSERT INTO Person (id, email) VALUES
--     (1, 'alice@tech.com'),
--     (2, 'bob@startup.com'),
--     (3, 'alice@tech.com'),
--     (4, 'charlie@web.com'),
--     (5, 'bob@startup.com'),
--     (6, 'bob@startup.com');
```

## Visualisation of the Problem

```
Original Data Flow:
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Person Table  │ → │  Your Query     │ → │  Duplicate      │
│                 │    │                 │    │  Emails Only    │
│ id │ email      │    │      ???        │    │                 │
├────┼────────────┤    │                 │    │ Email           │
│ 1  │ a@b.com    │    │                 │    ├─────────────────┤
│ 2  │ c@d.com    │    │                 │    │ a@b.com         │
│ 3  │ a@b.com    │    │                 │    └─────────────────┘
└────┴────────────┘    └─────────────────┘
```

## Analysis Framework

Consider these aspects whilst developing your solution:

### Frequency Analysis
- Email occurrence patterns
- Threshold definition (what constitutes a duplicate?)
- Result formatting requirements

### Performance Considerations
- Index utilisation on email columns
- Query execution plan optimisation
- Memory usage for large datasets

### Edge Cases to Consider
- Empty email strings (though guaranteed not NULL)
- Case sensitivity (emails guaranteed lowercase)
- Very large datasets with millions of records
- Single email appearing hundreds of times

## Your Challenge

Write a PostgreSQL query that identifies all duplicate emails efficiently. Consider different approaches and their trade-offs in terms of:

- **Readability**: How clear is your solution to other developers?
- **Performance**: How will it scale with larger datasets?
- **Maintainability**: How easy is it to modify or extend?

## Testing Your Solution

After writing your query, verify it works with all the provided examples:

1. Run with Example 1 data → Should return `a@b.com`
2. Run with Example 2 data → Should return both duplicated emails
3. Run with Example 3 data → Should return empty result
4. Run with Example 4 data → Should return `same@email.com`

## Performance Benchmarking

Create a larger test dataset to evaluate your solution's performance:

```sql
-- Generate test data with 10,000 records (approximately 30% duplicates)
INSERT INTO Person (id, email)
SELECT
    generate_series(1, 10000) as id,
    'user' || (random() * 7000)::int || '@domain.com' as email;
```

Monitor your query execution time and plan using:
```sql
EXPLAIN ANALYZE [Your Query Here];
```

Good luck solving this challenge! 🚀