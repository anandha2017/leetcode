-- Test Case 3: No duplicates scenario
-- All emails are unique, nothing should be deleted

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (1, 'unique1@test.com'),
    (2, 'unique2@test.com'),
    (3, 'unique3@test.com'),
    (4, 'unique4@test.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 3:' as status;
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
SELECT 'AFTER DELETION - Test Case 3:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: All 4 records remain unchanged