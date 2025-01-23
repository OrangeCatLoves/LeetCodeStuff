-- Write your PostgreSQL query statement below

SELECT 
    user_id AS buyer_id,
    join_date,
    COUNT(o.buyer_id) as orders_in_2019
FROM Users u LEFT JOIN Orders o
ON o.buyer_id = u.user_id AND EXTRACT(YEAR FROM o.order_date) = 2019
GROUP BY user_id, join_date
