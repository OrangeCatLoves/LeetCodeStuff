-- Write your PostgreSQL query statement below
-- Could only pass 6/10 testcases
-- SELECT
--     COALESCE(salary, NULL) as SecondHighestSalary
-- FROM Employee
-- ORDER BY salary DESC
-- LIMIT 1 OFFSET 1

SELECT 
    COALESCE(
        (SELECT salary
         FROM Employee
         WHERE salary < (SELECT MAX(salary) FROM Employee)
         ORDER BY salary DESC
         LIMIT 1), 
        NULL
    ) AS SecondHighestSalary;

