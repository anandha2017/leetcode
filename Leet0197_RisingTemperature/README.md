# Rising Temperature - PostgreSQL Challenge

## Problem Statement

Write a PostgreSQL query to find all dates' `id` with higher temperatures compared to their previous dates (yesterday).

**Return the result table in any order.**

## Schema

### Weather Table
```sql
CREATE TABLE Weather (
    id INTEGER PRIMARY KEY,
    recordDate DATE,
    temperature INTEGER
);
```

| Column Name | Type    | Description |
|-------------|---------|-------------|
| id          | int     | Primary key |
| recordDate  | date    | Date of temperature recording |
| temperature | int     | Temperature in degrees |

## Example Dataset

### Input: Weather table
| id | recordDate | temperature |
|----|------------|-------------|
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |

### Expected Output
| id |
|----|
| 2  |
| 4  |

### Explanation
- **2015-01-02**: Temperature (25°) was higher than previous day 2015-01-01 (10°)
- **2015-01-04**: Temperature (30°) was higher than previous day 2015-01-03 (20°)

## Additional Test Cases

### Test Case 2: Consecutive Decreasing Temperatures
```sql
-- Input
| id | recordDate | temperature |
|----|------------|-------------|
| 1  | 2020-03-01 | 15          |
| 2  | 2020-03-02 | 12          |
| 3  | 2020-03-03 | 8           |
| 4  | 2020-03-04 | 5           |

-- Expected Output: Empty result set (no temperature increases)
```

### Test Case 3: Mixed Pattern with Gaps
```sql
-- Input
| id | recordDate | temperature |
|----|------------|-------------|
| 10 | 2021-06-01 | 18          |
| 15 | 2021-06-02 | 22          |
| 20 | 2021-06-04 | 19          |  -- Note: 03rd June missing
| 25 | 2021-06-05 | 24          |

-- Expected Output
| id |
|----|
| 15 |  -- 22° > 18° (previous day)
| 25 |  -- 24° > 19° (previous day)
```

### Test Case 4: Same Temperatures
```sql
-- Input
| id | recordDate | temperature |
|----|------------|-------------|
| 1  | 2022-01-01 | 20          |
| 2  | 2022-01-02 | 20          |
| 3  | 2022-01-03 | 25          |

-- Expected Output
| id |
|----|
| 3  |  -- Only 25° > 20°, same temperatures don't count
```

## Visual Representation

```
Temperature Trend Analysis
==========================

Example 1: Rising Temperature Pattern
-------------------------------------
Date        | Temp | Previous | Rising?
2015-01-01  | 10°  | -        | -
2015-01-02  | 25°  | 10°      | ✓ (id: 2)
2015-01-03  | 20°  | 25°      | ✗
2015-01-04  | 30°  | 20°      | ✓ (id: 4)

Graph:
  30° |           ●
      |          /
  25° |     ●   /
      |    / \ /
  20° |   /   ●
      |  /
  15° |
      |
  10° | ●
      |____________
        01  02  03  04
```

## Key Considerations

### Date Continuity
- Records may **not** be consecutive dates
- You need to find the **actual** previous day, not just the previous record
- Handle missing dates appropriately

### Temperature Comparison
- Only consider **strictly greater** temperatures
- Equal temperatures don't qualify as "rising"

### Data Types
- `recordDate` is a DATE type - use appropriate date functions
- `temperature` is INTEGER - standard comparison operators apply

### Edge Cases to Consider
1. **Single record**: Should return empty result
2. **Non-consecutive dates**: Find actual previous calendar day
3. **Duplicate dates**: Shouldn't occur based on problem constraints
4. **Same temperatures**: Don't count as rising

## PostgreSQL Functions That Might Be Useful

| Function | Purpose | Example |
|----------|---------|---------|
| `DATE` functions | Date arithmetic | `recordDate - INTERVAL '1 day'` |
| `LAG()` | Window function | Access previous row values |
| `EXTRACT()` | Date parts | Extract day, month, year |
| `DATEADD()/DATESUB()` | Date calculation | Add/subtract days |

## Setup Script

```sql
-- Create and populate test table
DROP TABLE IF EXISTS Weather;

CREATE TABLE Weather (
    id INTEGER PRIMARY KEY,
    recordDate DATE,
    temperature INTEGER
);

INSERT INTO Weather (id, recordDate, temperature) VALUES
(1, '2015-01-01', 10),
(2, '2015-01-02', 25),
(3, '2015-01-03', 20),
(4, '2015-01-04', 30);

-- Your solution query goes here
-- SELECT ...
```

## Challenge Constraints

- `1 <= Weather.id <= 100`
- `'2000-01-01' <= recordDate <= '2021-12-31'`
- `-100 <= temperature <= 100`

## Success Criteria

Your query should:
1. ✅ Return correct IDs for rising temperatures
2. ✅ Handle non-consecutive dates properly
3. ✅ Work with all provided test cases
4. ✅ Use efficient PostgreSQL syntax
5. ✅ Return results in any order (as specified)

---

**Good luck with your PostgreSQL solution! 🚀**