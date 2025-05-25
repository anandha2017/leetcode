WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'a@b.com'),
        (2, 'c@d.com'),
        (3, 'a@b.com'),
        (4, 'Max')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p;

WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'a@b.com'),
        (2, 'c@d.com'),
        (3, 'a@b.com'),
        (4, 'Max')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p
GROUP BY p.email
HAVING COUNT(p.email) > 1;



WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'a@b.com'),
        (2, 'c@d.com'),
        (3, 'a@b.com')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p
GROUP BY p.email
HAVING COUNT(p.email) > 1;

WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'alice@tech.com'),
        (2, 'bob@startup.com'),
        (3, 'alice@tech.com'),
        (4, 'charlie@web.com'),
        (5, 'bob@startup.com'),
        (6, 'bob@startup.com')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p
GROUP BY p.email
HAVING COUNT(p.email) > 1;

WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'unique1@test.com'),
        (2, 'unique2@test.com'),
        (3, 'unique3@test.com')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p
GROUP BY p.email
HAVING COUNT(p.email) > 1;

WITH Email AS (
    SELECT * FROM (VALUES
        (1, 'same@email.com'),
        (2, 'same@email.com'),
        (3, 'same@email.com'),
        (4, 'same@email.com')
    ) AS t(id, email)
)
SELECT p.email AS Email
FROM person p
GROUP BY p.email
HAVING COUNT(p.email) > 1;