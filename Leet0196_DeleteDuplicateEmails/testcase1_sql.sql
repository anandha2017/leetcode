-- Test Case 1: Basic duplicate scenario (LeetCode example)
-- Input: Two records with same email, keep the one with smaller id

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (1, 'john@example.com'),
    (2, 'bob@example.com'),
    (3, 'john@example.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 1:' as status;
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
SELECT 'AFTER DELETION - Test Case 1:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Keep ids 1 and 2, delete id 3