# Write your MySQL query statement below
# Self-join is used here since you're establishing a relationship
# With the same table

SELECT e1.name as Employee
FROM employee e1
INNER JOIN employee e2 ON e1.managerID = e2.id
WHERE e2.salary < e1.salary
