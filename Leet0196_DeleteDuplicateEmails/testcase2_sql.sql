-- Test Case 2: Multiple emails with multiple duplicates each
-- Complex scenario with various duplicate patterns

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (1, 'alice@mail.com'),
    (2, 'bob@example.com'),
    (3, 'alice@mail.com'),
    (4, 'charlie@test.com'),
    (5, 'bob@example.com'),
    (6, 'alice@mail.com'),
    (7, 'david@work.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 2:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Execute deletion
DELETE FROM leet0196_delete_duplicate_emails.Person p1
WHERE EXISTS (
    SELECT 1
    FROM leet0196_delete_duplicate_emails.Person p2
    WHERE p2.email = p1.email
    AND p2.id < p1.id
);

-- Show final state
SELECT 'AFTER DELETION - Test Case 2:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Keep ids 1, 2, 4, 7 (delete ids 3, 5, 6)