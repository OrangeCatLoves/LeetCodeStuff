# Write your MySQL query statement below
# Self-join is used here since you're establishing a relationship
# With the same table

SELECT e2.name as Employee
FROM employee e1
INNER JOIN employee e2 ON e1.id = e2.managerID
WHERE e1.salary < e2.salary
