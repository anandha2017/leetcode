-- SQL for creating tables and test data for LeetCode 196: Delete Duplicate Emails

-- Drop schema if it exists and create it from scratch
DROP SCHEMA IF EXISTS leet0196_delete_duplicate_emails CASCADE;
CREATE SCHEMA leet0196_delete_duplicate_emails;

-- Create the Person table
CREATE TABLE leet0196_delete_duplicate_emails.Person (
    id INT PRIMARY KEY,
    email VARCHAR(255) NOT NULL
);

-- Create index on email for better performance
CREATE INDEX idx_person_email ON leet0196_delete_duplicate_emails.Person(email);