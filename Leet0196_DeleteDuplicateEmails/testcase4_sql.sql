-- Test Case 4: Single record scenario
-- Edge case with only one record in table

-- Clear and insert test data
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

INSERT INTO leet0196_delete_duplicate_emails.Person VALUES
    (1, 'single@email.com');

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 4:' as status;
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
SELECT 'AFTER DELETION - Test Case 4:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Single record remains unchanged