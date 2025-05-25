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
SELECT c.name AS Customers
FROM Customers c
WHERE c.id not in (
        SELECT o.customerId
        from Orders o
    );



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
SELECT c.name AS Customers
FROM Customers c
WHERE c.id not in (
        SELECT o.customerId
        from Orders o
    );


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
SELECT c.name AS Customers
FROM Customers c
WHERE c.id not in (
        SELECT o.customerId
        from Orders o
    );
