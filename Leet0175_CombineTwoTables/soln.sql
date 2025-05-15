-- Solution for LeetCode 175: Combine Two Tables
-- Using PostgreSQL syntax

SELECT
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM
    leet0175_combine_two_tables.Person p
LEFT JOIN
    leet0175_combine_two_tables.Address a
ON
    p.personId = a.personId;