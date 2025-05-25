WITH
-- Test Case 1: Basic example
test1_customers AS (
    SELECT 1 as test_case, * FROM (VALUES
        (1, 'Joe'), (2, 'Henry'), (3, 'Sam'), (4, 'Max')
    ) AS t(id, name)
),
test1_orders AS (
    SELECT 1 as test_case, * FROM (VALUES
        (1, 3), (2, 1)
    ) AS t(id, customerId)
),

-- Test Case 2: Multiple customers
test2_customers AS (
    SELECT 2 as test_case, * FROM (VALUES
        (1, 'Alice'), (2, 'Bob'), (3, 'Charlie'), (4, 'Diana'), (5, 'Eve')
    ) AS t(id, name)
),
test2_orders AS (
    SELECT 2 as test_case, * FROM (VALUES
        (1, 2), (2, 4), (3, 2), (4, 1)
    ) AS t(id, customerId)
),

-- Test Case 3: All customers have orders
test3_customers AS (
    SELECT 3 as test_case, * FROM (VALUES
        (1, 'John'), (2, 'Sarah')
    ) AS t(id, name)
),
test3_orders AS (
    SELECT 3 as test_case, * FROM (VALUES
        (1, 1), (2, 2), (3, 1)
    ) AS t(id, customerId)
),

-- Test Case 4: No orders exist
test4_customers AS (
    SELECT 4 as test_case, * FROM (VALUES
        (1, 'Michael'), (2, 'Emma'), (3, 'Oliver')
    ) AS t(id, name)
),
test4_orders AS (
    SELECT 4 as test_case, id, customerId FROM (VALUES (1, 1)) AS t(id, customerId)
    WHERE FALSE  -- Creates empty set
),

-- Combine all test data
all_customers AS (
    SELECT * FROM test1_customers UNION ALL
    SELECT * FROM test2_customers UNION ALL
    SELECT * FROM test3_customers UNION ALL
    SELECT * FROM test4_customers
),
all_orders AS (
    SELECT * FROM test1_orders UNION ALL
    SELECT * FROM test2_orders UNION ALL
    SELECT * FROM test3_orders UNION ALL
    SELECT * FROM test4_orders
),

-- YOUR SOLUTION GOES HERE (just once!)
solution AS (
    SELECT
        c.test_case,
        c.name AS customers
    FROM all_customers c
    WHERE c.id NOT IN (
        SELECT o.customerId
        FROM all_orders o
        WHERE o.customerId IS NOT NULL AND o.test_case = c.test_case
    )
)

-- View results by test case
SELECT
    test_case,
    STRING_AGG(customers, ', ' ORDER BY customers) as result
FROM solution
GROUP BY test_case
ORDER BY test_case;