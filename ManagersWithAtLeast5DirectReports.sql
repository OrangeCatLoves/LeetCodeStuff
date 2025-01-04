-- Write your PostgreSQL query statement below
-- If the condition is e1.managerId = e2.id
-- Table on the right will be your manager
-- e1.id = e2.managerId means manager on the left, all workers of manager on the right

SELECT e1.name
    FROM Employee e1
    LEFT JOIN Employee e2 ON e1.id = e2.managerId
    GROUP BY e1.id, e1.name
    HAVING COUNT(*) >= 5
