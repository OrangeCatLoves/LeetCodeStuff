-- Write your PostgreSQL query statement below

SELECT
    product_id,
    10 as price
FROM Products
GROUP BY product_id
HAVING min(change_date) > '2019-08-16'

UNION

SELECT
    product_id,
    new_price as price
FROM Products
WHERE (product_id, change_date) in (
    SELECT product_id, max(change_date)
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
    --HAVING max(change_date) <= '2019-08-16'
)
