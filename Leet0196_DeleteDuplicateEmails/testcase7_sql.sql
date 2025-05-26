-- Test Case 7: Empty table scenario
-- Edge case with no records

-- Clear table
TRUNCATE TABLE leet0196_delete_duplicate_emails.Person;

-- Show initial state
SELECT 'BEFORE DELETION - Test Case 7:' as status;
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
SELECT 'AFTER DELETION - Test Case 7:' as status;
SELECT * FROM leet0196_delete_duplicate_emails.Person ORDER BY id;

-- Expected result: Table remains empty