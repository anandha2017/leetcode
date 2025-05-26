-- Test Case 6: Non-sequential IDs with duplicates
-- Real-world scenario with gaps in ID sequence

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (10, 'admin@company.co.uk'),
    (25, 'user@domain.org'),
    (33, 'admin@company.co.uk'),
    (45, 'test@sample.net'),
    (67, 'user@domain.org'),
    (89, 'admin@company.co.uk'),
    (100, 'unique@special.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 6:' as status;
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
SELECT 'AFTER DELETION - Test Case 6:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Keep ids 10, 25, 45, 100 (delete ids 33, 67, 89)