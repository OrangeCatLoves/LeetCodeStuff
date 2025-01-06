-- Write your PostgreSQL query statement below

SELECT 
customer_id
FROM (SELECT DISTINCT customer_id, product_key FROM Customer)
GROUP BY customer_id
HAVING count(*) = (SELECT count(product_key) FROM Product)
