-- SQL for creating tables and test data for LeetCode 175: Combine Two Tables

-- Drop schema if it exists and create it from scratch
DROP SCHEMA IF EXISTS leet0175_combine_two_tables CASCADE;
CREATE SCHEMA leet0175_combine_two_tables;

-- Create the Person table
CREATE TABLE leet0175_combine_two_tables.Person (
    personId INT PRIMARY KEY,
    lastName VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL
);

-- Create the Address table
CREATE TABLE leet0175_combine_two_tables.Address (
    addressId INT PRIMARY KEY,
    personId INT,
    city VARCHAR(255),
    state VARCHAR(255),
    FOREIGN KEY (personId) REFERENCES leet0175_combine_two_tables.Person(personId)
);

-- Insert test data into Person table
INSERT INTO leet0175_combine_two_tables.Person (personId, lastName, firstName)
VALUES
    -- Basic test cases from examples
    (1, 'Wang', 'Allen'),
    (2, 'Alice', 'Bob'),

    -- Additional test cases to cover different scenarios
    (3, 'Smith', 'John'),         -- Person with address
    (4, 'Jones', 'Emma'),         -- Person with multiple addresses
    (5, 'Brown', 'Michael'),      -- Person with no address
    (6, 'Wilson', 'Olivia'),      -- Person with address containing NULL city
    (7, 'Taylor', 'Daniel'),      -- Person with address containing NULL state
    (8, 'Adams', 'Sophie'),       -- Person with address containing NULL city and state
    (9, 'Miller', 'James'),       -- Person with multiple addresses including NULLs
    (10, 'Davis', 'Emily');       -- Person with multiple complete addresses

-- Insert test data into Address table
INSERT INTO leet0175_combine_two_tables.Address (addressId, personId, city, state)
VALUES
    -- Basic test cases from examples
    (1, 2, 'New York City', 'New York'),   -- Address for Bob Alice

    -- Additional test cases
    (2, 3, 'London', 'England'),           -- Normal address for John Smith
    (3, 4, 'Manchester', 'England'),       -- First address for Emma Jones
    (4, 4, 'Edinburgh', 'Scotland'),       -- Second address for Emma Jones
    (5, 6, NULL, 'Wales'),                 -- Address with NULL city
    (6, 7, 'Bristol', NULL),               -- Address with NULL state
    (7, 8, NULL, NULL),                    -- Address with NULL city and state
    (8, 9, 'Glasgow', 'Scotland'),         -- First address for James Miller
    (9, 9, NULL, 'Northern Ireland'),      -- Second address with NULL city
    (10, 10, 'Cardiff', 'Wales'),          -- First address for Emily Davis
    (11, 10, 'Belfast', 'Northern Ireland'); -- Second address for Emily Davis

-- Note: personId 5 (Michael Brown) has no address entry to test that case