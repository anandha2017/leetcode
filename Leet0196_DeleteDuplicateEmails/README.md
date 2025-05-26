# Delete Duplicate Emails - PostgreSQL Challenge

## Problem Statement

Given a table `Person` with duplicate email entries, write a PostgreSQL query to delete all duplicate records keeping only the one with the smallest `id` for each email.

### Table Schema

```sql
CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL
);
```

## Examples

### Example 1: Basic Duplicates

**Input:**
```
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
```

**Expected Output:**
```
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
```

### Example 2: Multiple Duplicates

**Input:**
```
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | alice@mail.com   |
| 2  | bob@example.com  |
| 3  | alice@mail.com   |
| 4  | charlie@test.com |
| 5  | bob@example.com  |
| 6  | alice@mail.com   |
| 7  | david@work.com   |
+----+------------------+
```

**Expected Output:**
```
+----+------------------+
| id | email            |
+----+------------------+
| 1  | alice@mail.com   |
| 2  | bob@example.com  |
| 4  | charlie@test.com |
| 7  | david@work.com   |
+----+------------------+
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
+----+------------------+
| id | email            |
+----+------------------+
| 1  | unique1@test.com |
| 2  | unique2@test.com |
| 3  | unique3@test.com |
+----+------------------+
```

### Example 4: Large Dataset with Mixed Patterns

**Input:**
```
Person table:
+----+----------------------+
| id | email                |
+----+----------------------+
| 1  | admin@company.co.uk  |
| 2  | user1@domain.org     |
| 3  | admin@company.co.uk  |
| 4  | test@sample.net      |
| 5  | user1@domain.org     |
| 6  | admin@company.co.uk  |
| 7  | unique@special.com   |
| 8  | test@sample.net      |
| 9  | final@end.gov        |
| 10 | user1@domain.org     |
+----+----------------------+
```

**Expected Output:**
```
+----+----------------------+
| id | email                |
+----+----------------------+
| 1  | admin@company.co.uk  |
| 2  | user1@domain.org     |
| 4  | test@sample.net      |
| 7  | unique@special.com   |
| 9  | final@end.gov        |
+----+----------------------+
```

## Visual Representation

### Before Deletion Process
```
Email Groups by Duplicate Count:
┌─────────────────────┬───────────────┬─────────────┐
│ Email               │ IDs           │ Count       │
├─────────────────────┼───────────────┼─────────────┤
│ admin@company.co.uk │ [1, 3, 6]     │ 3 (delete)  │
│ user1@domain.org    │ [2, 5, 10]    │ 3 (delete)  │
│ test@sample.net     │ [4, 8]        │ 2 (delete)  │
│ unique@special.com  │ [7]           │ 1 (keep)    │
│ final@end.gov       │ [9]           │ 1 (keep)    │
└─────────────────────┴───────────────┴─────────────┘
```

### After Deletion Process
```
Kept Records (Minimum ID per Email):
┌─────────────────────┬─────────────┬────────────────┐
│ Email               │ Kept ID     │ Deleted IDs    │
├─────────────────────┼─────────────┼────────────────┤
│ admin@company.co.uk │ 1          │ [3, 6]         │
│ user1@domain.org    │ 2          │ [5, 10]        │
│ test@sample.net     │ 4          │ [8]            │
│ unique@special.com  │ 7          │ []             │
│ final@end.gov       │ 9          │ []             │
└─────────────────────┴─────────────┴────────────────┘
```

## Test Data Setup

```sql
-- Create and populate test table
DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL
);

-- Insert test data for comprehensive testing
INSERT INTO Person (email) VALUES
    ('admin@company.co.uk'),
    ('user1@domain.org'),
    ('admin@company.co.uk'),
    ('test@sample.net'),
    ('user1@domain.org'),
    ('admin@company.co.uk'),
    ('unique@special.com'),
    ('test@sample.net'),
    ('final@end.gov'),
    ('user1@domain.org');

-- View initial state
SELECT * FROM Person ORDER BY id;
```

## Key Considerations

### Performance Factors
- **Index Usage**: Ensure proper indexing on email column for efficient lookups
- **Transaction Size**: Consider batch processing for very large datasets
- **Lock Duration**: Minimise lock time during deletion operations

### Edge Cases
- Empty table
- Single record
- All records unique
- All records duplicates of same email
- NULL email values (if allowed)
- Case sensitivity in email comparison

### Validation Queries

```sql
-- Check for remaining duplicates after deletion
SELECT email, COUNT(*) as count
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;

-- Verify kept records have minimum IDs
WITH min_ids AS (
    SELECT email, MIN(id) as min_id
    FROM Person
    GROUP BY email
)
SELECT p.*
FROM Person p
JOIN min_ids m ON p.email = m.email AND p.id = m.min_id
ORDER BY p.id;
```

## Challenge Requirements

Write a **single DELETE statement** that removes all duplicate email records whilst preserving the record with the smallest `id` for each unique email address.

**Constraints:**
- Use PostgreSQL syntax
- Must be a DELETE operation (not CREATE TABLE AS or similar)
- Preserve referential integrity
- Efficient execution for large datasets
- Handle edge cases gracefully

---

*Ready to tackle this challenge? Remember to test your solution with the provided examples and edge cases!*