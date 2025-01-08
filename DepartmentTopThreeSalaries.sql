-- Write your PostgreSQL query statement below
-- For the current employee im inspecting in the row of outer query
-- I am checking to see if the current salary of the employee falls in the top 3 of the salaries for that
-- Specific department (From the inner query)

SELECT d.name AS Department, e.name AS Employee, salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE salary IN (
    SELECT DISTINCT(salary)
    FROM Employee
    WHERE Employee.departmentId = e.departmentId
    ORDER BY salary DESC
    LIMIT 3
)
