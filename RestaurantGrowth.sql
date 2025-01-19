-- Write your PostgreSQL query statement below

SELECT 
    visited_on,
    SUM(total_amt) OVER (ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) as amount,
    ROUND(AVG(total_amt) OVER (ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) as average_amount
FROM (
    SELECT 
        visited_on,
    SUM(amount) as total_amt
    FROM Customer
    GROUP BY visited_on
    ORDER BY visited_on
)
OFFSET 6
