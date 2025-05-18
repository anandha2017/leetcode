WITH Employee AS (
    SELECT * FROM (VALUES
        (1, 'Joe', 70000, 3),
        (2, 'Henry', 80000, 4),
        (3, 'Sam', 60000, NULL),
        (4, 'Max', 90000, NULL)
    ) AS t(id, name, salary, managerId)
)
SELECT e1.name AS Employee
FROM Employee e1
JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;

WITH Employee AS (
    SELECT * FROM (VALUES
        (1, 'Alice', 80000, 2),
        (2, 'Bob', 75000, 3),
        (3, 'Carol', 90000, 4),
        (4, 'Dave', 85000, NULL),
        (5, 'Eve', 80000, 2)
    ) AS t(id, name, salary, managerId)
)
SELECT e1.name AS Employee
FROM Employee e1
JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;