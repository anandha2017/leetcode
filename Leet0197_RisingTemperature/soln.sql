WITH
-- Test Case 1: Basic example from problem statement
test1_weather AS (
    SELECT 1 as test_case, * FROM (VALUES
        (1, '2015-01-01'::date, 10),
        (2, '2015-01-02'::date, 25),
        (3, '2015-01-03'::date, 20),
        (4, '2015-01-04'::date, 30)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 2: Consecutive decreasing temperatures (should return empty)
test2_weather AS (
    SELECT 2 as test_case, * FROM (VALUES
        (1, '2020-03-01'::date, 15),
        (2, '2020-03-02'::date, 12),
        (3, '2020-03-03'::date, 8),
        (4, '2020-03-04'::date, 5)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 3: Mixed pattern with date gaps
test3_weather AS (
    SELECT 3 as test_case, * FROM (VALUES
        (10, '2021-06-01'::date, 18),
        (15, '2021-06-02'::date, 22),
        (20, '2021-06-04'::date, 19),  -- Note: 03rd June missing
        (25, '2021-06-05'::date, 24)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 4: Same temperatures (equal temps don't count)
test4_weather AS (
    SELECT 4 as test_case, * FROM (VALUES
        (1, '2022-01-01'::date, 20),
        (2, '2022-01-02'::date, 20),
        (3, '2022-01-03'::date, 25),
        (4, '2022-01-04'::date, 25),
        (5, '2022-01-05'::date, 30)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 5: Single record (should return empty)
test5_weather AS (
    SELECT 5 as test_case, * FROM (VALUES
        (100, '2023-01-01'::date, 15)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 6: Non-consecutive IDs but consecutive dates
test6_weather AS (
    SELECT 6 as test_case, * FROM (VALUES
        (100, '2023-05-01'::date, 12),
        (200, '2023-05-02'::date, 18),
        (150, '2023-05-03'::date, 15),
        (300, '2023-05-04'::date, 22)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 7: Large temperature swings
test7_weather AS (
    SELECT 7 as test_case, * FROM (VALUES
        (1, '2024-01-01'::date, -50),
        (2, '2024-01-02'::date, 0),
        (3, '2024-01-03'::date, -20),
        (4, '2024-01-04'::date, 50),
        (5, '2024-01-05'::date, 100)
    ) AS t(id, recordDate, temperature)
),

-- Test Case 8: Weekend gap scenario
test8_weather AS (
    SELECT 8 as test_case, * FROM (VALUES
        (1, '2024-02-01'::date, 10),  -- Thursday
        (2, '2024-02-02'::date, 15),  -- Friday
        (3, '2024-02-05'::date, 20),  -- Monday (weekend gap)
        (4, '2024-02-06'::date, 12),  -- Tuesday
        (5, '2024-02-07'::date, 25)   -- Wednesday
    ) AS t(id, recordDate, temperature)
),

-- Combine all test data
all_weather AS (
    SELECT * FROM test1_weather UNION ALL
    SELECT * FROM test2_weather UNION ALL
    SELECT * FROM test3_weather UNION ALL
    SELECT * FROM test4_weather UNION ALL
    SELECT * FROM test5_weather UNION ALL
    SELECT * FROM test6_weather UNION ALL
    SELECT * FROM test7_weather UNION ALL
    SELECT * FROM test8_weather
),

-- YOUR SOLUTION GOES HERE (just once!)
solution AS (
    SELECT
        w1.test_case,
        w1.id
    FROM all_weather w1
    INNER JOIN all_weather w2
        ON w1.test_case = w2.test_case
        AND w1.recordDate = w2.recordDate + INTERVAL '1 day'
        AND w1.temperature > w2.temperature
)

-- View results by test case with detailed breakdown
SELECT
    test_case,
    CASE
        WHEN test_case = 1 THEN 'Basic example'
        WHEN test_case = 2 THEN 'Consecutive decreasing'
        WHEN test_case = 3 THEN 'Date gaps'
        WHEN test_case = 4 THEN 'Same temperatures'
        WHEN test_case = 5 THEN 'Single record'
        WHEN test_case = 6 THEN 'Non-consecutive IDs'
        WHEN test_case = 7 THEN 'Large temperature swings'
        WHEN test_case = 8 THEN 'Weekend gaps'
    END as description,
    COALESCE(STRING_AGG(id::text, ', ' ORDER BY id), 'No results') as rising_temperature_ids
FROM solution
RIGHT JOIN (
    SELECT DISTINCT test_case FROM all_weather
) tc USING (test_case)
GROUP BY test_case
ORDER BY test_case;

-- Expected Results Summary:
-- Test Case 1: ids 2, 4 (25>10, 30>20)
-- Test Case 2: No results (all decreasing)
-- Test Case 3: ids 15, 25 (22>18, 24>19)
-- Test Case 4: ids 3, 5 (25>20, 30>25)
-- Test Case 5: No results (single record)
-- Test Case 6: ids 200, 300 (18>12, 22>15)
-- Test Case 7: ids 2, 4, 5 (0>-50, 50>-20, 100>50)
-- Test Case 8: ids 2, 5 (15>10, 25>12)