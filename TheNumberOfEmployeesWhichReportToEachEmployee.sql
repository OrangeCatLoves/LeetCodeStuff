-- Write your PostgreSQL query statement below
-- Left side of table are all the managers, right side are the employees

SELECT
    e1.employee_id,
    e1.name,
    count(*) as reports_count,
    round(avg(e2.age)) as average_age
FROM Employees e1
INNER JOIN Employees e2
ON e1.employee_id = e2.reports_to
GROUP BY e1.employee_id, e1.name
ORDER BY employee_id
