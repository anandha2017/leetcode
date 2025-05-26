-- Test Case 5: All records same email scenario
-- Extreme case where all records have identical email

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (1, 'same@email.com'),
    (2, 'same@email.com'),
    (3, 'same@email.com'),
    (4, 'same@email.com'),
    (5, 'same@email.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 5:' as status;
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
SELECT 'AFTER DELETION - Test Case 5:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Only id 1 remains, ids 2,3,4,5 deleted