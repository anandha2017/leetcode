-- SQL for creating tables and test data for LeetCode 181: Employees Earning More Than Their Managers

-- Drop schema if it exists and create it from scratch
DROP SCHEMA IF EXISTS leet0181_employees_earning_more_than_their_managers CASCADE;
CREATE SCHEMA leet0181_employees_earning_more_than_their_managers;

-- Create the Employee table
CREATE TABLE leet0181_employees_earning_more_than_their_managers.Employee (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary INT NOT NULL,
    managerId INT,
    CONSTRAINT fk_manager
        FOREIGN KEY (managerId)
        REFERENCES leet0181_employees_earning_more_than_their_managers.Employee(id)
);

-- Alternatively, you can add the constraint after creating the table:
-- ALTER TABLE leet0181_employees_earning_more_than_their_managers.Employee
-- ADD CONSTRAINT fk_manager
-- FOREIGN KEY (managerId) REFERENCES leet0181_employees_earning_more_than_their_managers.Employee(id);