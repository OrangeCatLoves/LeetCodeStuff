-- Write your PostgreSQL query statement below

SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e INNER JOIN Department d
ON e.departmentId = d.id
WHERE (e.departmentId, Salary) IN (
    SELECT
        d1.id AS Department,
        MAX(salary) AS Salary
        FROM Employee e1 INNER JOIN Department d1
        ON e1.departmentId = d1.id
        GROUP BY d1.id
)
